package cn.edu.hezeu.jsj.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.hezeu.jsj.Dao.Teacher_CourseDao;
import cn.edu.hezeu.jsj.Utils.HibernateUtils;
import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Student;
import cn.edu.hezeu.jsj.pojo.Teacher;
import cn.edu.hezeu.jsj.pojo.Teacher_Course;

public class Teacher_CourseDaoImpl implements Teacher_CourseDao {

	private HibernateTemplate hibernateTemplate = null;
	@Override
	public void addTeacher_Course(Teacher teacher, Course course) {
		hibernateTemplate.save(new Teacher_Course(teacher,course));

	}

	/**
	 * 可以得到学生的选择的课程和教师信息
	 */
	@Override
	public List<Teacher_Course> getHasSelectedTeacher_Course(Student student) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		String hql="from cn.edu.hezeu.jsj.pojo.Teacher_Course tc where tc.course in (select sc.course from cn.edu.hezeu.jsj.pojo.Student_Course sc where sc.student = (from cn.edu.hezeu.jsj.pojo.Student s where s.id = ?))";
		//from cn.edu.hezeu.jsj.pojo.Student s where s.id = ?
		//select sc.course from cn.edu.hezeu.jsj.pojo.Student_Course sc where sc.student = (from cn.edu.hezeu.jsj.pojo.Student s where s.id = ?)
		Query query = session.createQuery(hql);
		query.setInteger(0,student.getId());
		List<Teacher_Course> tcl = null;
		if(!query.list().isEmpty()){
			tcl = query.list();
		}
		session.clear();
		session.close();
		return tcl;
	}


	@Override
	public List<Teacher_Course> getNoSelectedTeacher_Course(Student student) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		String hql="from cn.edu.hezeu.jsj.pojo.Teacher_Course tc where tc.course not in (select sc.course from cn.edu.hezeu.jsj.pojo.Student_Course sc where sc.student = (from cn.edu.hezeu.jsj.pojo.Student s where s.id = ?))";
		//from cn.edu.hezeu.jsj.pojo.Student s where s.id = ?
		//select sc.course from cn.edu.hezeu.jsj.pojo.Student_Course sc where sc.student = (from cn.edu.hezeu.jsj.pojo.Student s where s.id = ?)
		Query query = session.createQuery(hql);
		query.setInteger(0,student.getId());
		List<Teacher_Course> tcl = null;
		if(!query.list().isEmpty()){
			tcl = query.list();
		}
		session.clear();
		session.close();
		return tcl;
	}
	
	public static void main(String[] args) {
		Teacher_CourseDao tcd = new Teacher_CourseDaoImpl();
//		Student student =new Student();
//		student.setId(2);
//		for(Teacher_Course tc:tcd.getNoSelectedTeacher_Course(student)){
//			System.out.println(tc);
//		}
		//tcd.deleteTeacher_CourseByCourseId(7);
		//tcd.deleteTeacher_CourseByTeacherId(3);
		System.out.println(tcd.getTeacher_CourseByStudentId(2));
		tcd.getTeacher_CourseByStudentId(2);
	}

	@Override
	public void deleteTeacher_CourseByCourseId(int courseid) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		String hql = "delete from cn.edu.hezeu.jsj.pojo.Teacher_Course tc where tc.course = (from cn.edu.hezeu.jsj.pojo.Course c where c.id = ?)";
		//from cn.edu.hezeu.jsj.pojo.Course c where c.id = ?
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery(hql).setInteger(0,courseid);
		query.executeUpdate();
		trans.commit();
		session.close();
		
	}

	/**根据教师ID删除Teacher_Course的信息
	 * 删除教师教授课程的关系
	 * */
	@Override
	public void deleteTeacher_CourseByTeacherId(int teacherid) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		
		Transaction trans = session.beginTransaction();
		String hql="delete from cn.edu.hezeu.jsj.pojo.Teacher_Course tc where tc.teacher = (from cn.edu.hezeu.jsj.pojo.Teacher t where t.id = ?)";
		//from cn.edu.hezeu.jsj.pojo.Teacher t where t.id = ?
		Query query = session.createQuery(hql);
		query.setInteger(0,teacherid);
		query.executeUpdate();
		trans.commit();
		session.close();
		
		
	}
	/**
	 * 得到某个学生所有的选课情况
	 */
	@Override
	public List<Teacher_Course> getTeacher_CourseByStudentId(int studentid) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		String hql="from cn.edu.hezeu.jsj.pojo.Teacher_Course tc where tc.course in (select sc.course  from cn.edu.hezeu.jsj.pojo.Student_Course sc where sc.student = (from cn.edu.hezeu.jsj.pojo.Student s where s.id = ?))";
		// from cn.edu.hezeu.jsj.pojo.Teacher_Course tc where tc.course in ()
		//select sc.course  from cn.edu.hezeu.jsj.pojo.Student_Course sc where sc.student = ()
		//from cn.edu.hezeu.jsj.pojo.Student s where s.id = ?
		Query query = session.createQuery(hql);
		query.setInteger(0,studentid);
		List<Teacher_Course> ltc = null;
		if(!query.list().isEmpty()){
			ltc = query.list();
		}
		session.close();
		return ltc;
	}

	@Override
	public List<Teacher_Course> getNoSelectTeacher_CourseByStudentId(
			int studentid) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		String hql="from cn.edu.hezeu.jsj.pojo.Teacher_Course tc where tc.course not in (select sc.course  from cn.edu.hezeu.jsj.pojo.Student_Course sc where sc.student = (from cn.edu.hezeu.jsj.pojo.Student s where s.id = ?))";
		// from cn.edu.hezeu.jsj.pojo.Teacher_Course tc where tc.course in ()
		//select sc.course  from cn.edu.hezeu.jsj.pojo.Student_Course sc where sc.student = ()
		//from cn.edu.hezeu.jsj.pojo.Student s where s.id = ?
		Query query = session.createQuery(hql);
		query.setInteger(0,studentid);
		List<Teacher_Course> ltc = null;
		if(!query.list().isEmpty()){
			ltc = query.list();
		}
		session.close();
		return ltc;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
