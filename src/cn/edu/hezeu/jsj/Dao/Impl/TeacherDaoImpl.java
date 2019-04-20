package cn.edu.hezeu.jsj.Dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.hezeu.jsj.Dao.TeacherDao;
import cn.edu.hezeu.jsj.Utils.HibernateUtils;
import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Teacher;
import cn.edu.hezeu.jsj.pojo.Teacher_Course;

public class TeacherDaoImpl implements TeacherDao {
	private HibernateTemplate hibernateTemplate = null;
	@Override
	public void addTeacher(Teacher teacher) {
		hibernateTemplate.save(teacher);

	}

	@Override
	public Teacher getOneTeacher(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Teacher.class, id);
	}
	
	
	public static void main(String args[]){
		TeacherDao teacherdao = new TeacherDaoImpl();
//		Teacher teacher  = new Teacher("MRLI","1234","02","LIHENG");
//		teacherdao.addTeacher(teacher);
//		System.out.println(teacherdao.getOneTeacher("MRLI", "1234"));
//		System.out.println(teacherdao.getCourseByTeacherId(1));
		teacherdao.deleteTeacher(1);
	}

	@Override
	public List<Teacher> getTeachers() {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Teacher.class);
		List<Teacher> tl = criteria.list();
		session.close();
		return tl;
	}

	@Override
	public void deleteTeacher(int id) {
		hibernateTemplate.delete(getOneTeacher(id));
		
	}

	@Override
	public Teacher getOneTeacher(String username, String password) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		String hql = "from cn.edu.hezeu.jsj.pojo.Teacher t where t.username=? and t.password=?";
		Query query = session.createQuery(hql);
		query.setString(0,username);
		query.setString(1, password);
		Teacher teacher = null;
		if(!query.list().isEmpty()){
			teacher = (Teacher) query.uniqueResult();
		}
		session.close();
		return teacher;
	}

	@Override
	public List<Teacher_Course> getCourseByTeacherId(int id) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		String hql = "select t.teacher_course from cn.edu.hezeu.jsj.pojo.Teacher t where t.id="+id;
		Query query = session.createQuery(hql);
		List<Teacher_Course> tl = null;
		if(!query.list().isEmpty()){
			
			tl = query.list();
			
		}
		session.close();
		return tl;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
}
