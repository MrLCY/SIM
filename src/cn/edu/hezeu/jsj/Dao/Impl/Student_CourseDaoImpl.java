package cn.edu.hezeu.jsj.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.hezeu.jsj.Dao.Student_CourseDao;
import cn.edu.hezeu.jsj.Utils.HibernateUtils;
import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Student;
import cn.edu.hezeu.jsj.pojo.Student_Course;

public class Student_CourseDaoImpl implements Student_CourseDao {
	private HibernateTemplate hibernateTemplate = null;
	/**
	 * 教师可以使用此方法为自己的课程添加学生
	 */
	@Override
	public void addStudent_Course(Student student, Course course) {
		hibernateTemplate.save(new Student_Course(student,course));

	}
	/**
	 * 用户教师在课程中删除某个学生
	 * 根据课程id和学生id删除Student_Course的唯一一条信息*/

	@Override
	public void deleteStudent_Course(Student student,Course course) {
		hibernateTemplate.delete(getStudent_Course(student, course));
	}
	
	/**
	 * 根据学生和课程得到一条Student_Course
	 */
	@Override
	public Student_Course getStudent_Course(Student student, Course course) {
		Session session  = hibernateTemplate.getSessionFactory().openSession();
		String hql="from cn.edu.hezeu.jsj.pojo.Student_Course sc where sc.student=(from cn.edu.hezeu.jsj.pojo.Student s where s.id = ?)and sc.course=(from cn.edu.hezeu.jsj.pojo.Course c where c.id = ?)";
		//from cn.edu.hezeu.jsj.pojo.Student s where s.id = ?
		//from cn.edu.hezeu.jsj.pojo.Course c where c.id = ?
		Query query = session.createQuery(hql);
		query.setInteger(0,student.getId());
		query.setInteger(1,course.getId());
		Student_Course sc = null;
		
		if(!query.list().isEmpty()){
			sc = (Student_Course) query.uniqueResult();
		}
		session.clear();
		session.close();
		return sc;
	}
	/***
	 * 根据课程id删除Student_Course某些信息
	 */
	@Override
	public void deleteStudent_CourseByCourse(int courseid) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		String sql = "delete from cn.edu.hezeu.jsj.pojo.Student_Course sc where sc.course = (from cn.edu.hezeu.jsj.pojo.Course where id = ?)";
		//from cn.edu.hezeu.jsj.pojo.Course where id = ?
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery(sql);
		query.setInteger(0,courseid);
		query.executeUpdate();
		trans.commit();
		session.clear();
		session.close();
	}
		

	public static void main(String[] args) {
		Student_CourseDao sc = new Student_CourseDaoImpl();
		//sc.deleteStudent_Course(10,1);
		//sc.deleteStudent_CourseByCourse(7);
		sc.deleteStudent_CourseByTeacher(3);
	}
	/*删除某位教师的全部Student_Course,三重查询*/
	@Override
	public void deleteStudent_CourseByTeacher(int teacherid) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		String hql="delete from cn.edu.hezeu.jsj.pojo.Student_Course sc where sc.course in (select tc.course from cn.edu.hezeu.jsj.pojo.Teacher_Course tc where tc.teacher =(from cn.edu.hezeu.jsj.pojo.Teacher t where t.id = ?))";
		//select from cn.edu.hezeu.jsj.pojo.Course c where c.id in()//
		//select tc.course from cn.edu.hezeu.jsj.pojo.Teacher_Course tc where tc.teacher =()
		//from cn.edu.hezeu.jsj.pojo.Teacher t where t.id = ?
		//总select tc.course from cn.edu.hezeu.jsj.pojo.Teacher_Course tc where tc.teacher =(from cn.edu.hezeu.jsj.pojo.Teacher t where t.id = ?)
		Query query = session.createQuery(hql);
		query.setInteger(0,teacherid);
		query.executeUpdate();
		trans.commit();
		session.clear();
		session.close();
		
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
