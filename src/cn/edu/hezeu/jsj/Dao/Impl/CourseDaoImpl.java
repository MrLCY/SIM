package cn.edu.hezeu.jsj.Dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.hezeu.jsj.Dao.CourseDao;
import cn.edu.hezeu.jsj.Utils.HibernateUtils;
import cn.edu.hezeu.jsj.pojo.Course;

public class CourseDaoImpl implements CourseDao {
	private HibernateTemplate hibernateTemplate=null;
	@Override
	public void addCourse(Course course) {
	HibernateUtils.add(course);

	}
	
	/**
	 * 删除某门课程
	 * 同时会删除Student_Course 和 Teacher_Course
	 * 
	 */
	@Override
	public void deleteCourse(int id) {
		
		hibernateTemplate.delete(getOneCourse(id));

	}

	public static void main(String[] args) {
		CourseDao coursedao = new CourseDaoImpl();
		//coursedao.deleteCourse(8);
		coursedao.deleteCourseByTeacher();
	}

	@Override
	public Course getOneCourse(int id) {
		
		return hibernateTemplate.get(Course.class, id);
	}

	@Override
	public void deleteCourseByTeacher() {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		String hql="delete from cn.edu.hezeu.jsj.pojo.Course c where c not in (select tc.course from cn.edu.hezeu.jsj.pojo.Teacher_Course tc )";
		//select tc.course from cn.edu.hezeu.jsj.pojo.Teacher_Course tc 
		
		Query query = session.createQuery(hql);
		query.executeUpdate();
		trans.commit();
		session.close();
		
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
