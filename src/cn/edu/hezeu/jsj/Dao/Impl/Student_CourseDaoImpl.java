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
	 * ��ʦ����ʹ�ô˷���Ϊ�Լ��Ŀγ����ѧ��
	 */
	@Override
	public void addStudent_Course(Student student, Course course) {
		hibernateTemplate.save(new Student_Course(student,course));

	}
	/**
	 * �û���ʦ�ڿγ���ɾ��ĳ��ѧ��
	 * ���ݿγ�id��ѧ��idɾ��Student_Course��Ψһһ����Ϣ*/

	@Override
	public void deleteStudent_Course(Student student,Course course) {
		hibernateTemplate.delete(getStudent_Course(student, course));
	}
	
	/**
	 * ����ѧ���Ϳγ̵õ�һ��Student_Course
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
	 * ���ݿγ�idɾ��Student_CourseĳЩ��Ϣ
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
	/*ɾ��ĳλ��ʦ��ȫ��Student_Course,���ز�ѯ*/
	@Override
	public void deleteStudent_CourseByTeacher(int teacherid) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		String hql="delete from cn.edu.hezeu.jsj.pojo.Student_Course sc where sc.course in (select tc.course from cn.edu.hezeu.jsj.pojo.Teacher_Course tc where tc.teacher =(from cn.edu.hezeu.jsj.pojo.Teacher t where t.id = ?))";
		//select from cn.edu.hezeu.jsj.pojo.Course c where c.id in()//
		//select tc.course from cn.edu.hezeu.jsj.pojo.Teacher_Course tc where tc.teacher =()
		//from cn.edu.hezeu.jsj.pojo.Teacher t where t.id = ?
		//��select tc.course from cn.edu.hezeu.jsj.pojo.Teacher_Course tc where tc.teacher =(from cn.edu.hezeu.jsj.pojo.Teacher t where t.id = ?)
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
