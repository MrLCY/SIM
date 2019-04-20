
package cn.edu.hezeu.jsj.Dao.Impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.hezeu.jsj.Dao.StudentDao;
import cn.edu.hezeu.jsj.Utils.HibernateUtils;
import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Student;

public class StudentDaoImpl implements StudentDao {

	private HibernateTemplate hibernateTemplate = null;
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(student);
	}
	/***
	 * 删除学生会删除学生的所有信息
	 * 包括学生所选课程  和 学生的个人信息
	 * Hibernate: delete from student_course where id=?
	 * Hibernate: delete from student where id=?
	 */
	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(getOneStudent(id));
		
	}

	@Override
	public Student getOneStudent(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Student.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudentList() {
		// TODO Auto-generated method stub
		
		return hibernateTemplate.find("from cn.edu.hezeu.jsj.pojo.Student");
	}

	@Override
	public void updateStudent(Student student) {
		hibernateTemplate.update(student);

	}
	
	

	@Override
	public Student getOneStudent(String studentno) {
		String hql = "from Student where studentno=?";
		
		return (Student) hibernateTemplate.find(hql,new Object[]{studentno}).get(0);
	}

	/**分页查询**/
	public List<Student> getStudentByPage(int pageno, int num) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Criteria criteria =session.createCriteria(Student.class);
		criteria.setMaxResults(num);//设定每页显示的记录数
		criteria.setFirstResult((pageno-1)*num);//从第几条记录开始查询
		List<Student> list = criteria.list();
		session.clear();
		session.close();
		return list;
	}

	@Override
	public int getStudentCount() {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		String hql="select count(*) from Student";
		Query query = session.createQuery(hql);
		int  a = Integer.parseInt(query.list().get(0).toString()) ;
		session.close();
		return (int) a;
	}
	
	public static void main(String args[]){
		StudentDao studentdao = new StudentDaoImpl();
		studentdao.getStudentInCourse(1);
		//studentdao.deleteStudent(1);
		//studentdao.getStudentNoInCourse((Course)HibernateUtils.getOneObject(Course.class, 1));
		//System.out.println(studentdao.getStudentCount());
		//Session session = HibernateUtils.getSession();
		//System.out.println("je\n"+studentdao.getStudentList());
		/**添加学生表*/
//		for(int i = 1;i<=20;i++){
//			Student stu = new Student(i,"password"+i,"Mr.Li"+i,"2016001"+i,"湖北"+i,i+"1368898",new Date(),i+"234@qq.com",i+"c:image");
//			studentdao.addStudent(stu);
//		}
		//System.out.println(studentdao.getOneStudent("20160011"));
		
		
		/**使用HQL语句进行查询**/
		//String hql = "from Student where tel=?";
		//System.out.println(HibernateUtils.getObjects(hql,new String[]{"11368898"}));
		
		//String hql="from Student s where s.tel=11368898";
		//Query query = session.createQuery(hql);
		
		
		/**使用QBC进行条件查询*/
		/*Criteria criteria =session.createCriteria(Student.class);
		Student student = (Student) criteria.add(Restrictions.eq("tel","11368898")).list().get(0);
		System.out.println(student);*/
		
		/**使用HQL语句进行查询并排序 desc 降序查询  asc升序查询  字符串按ASCI码排序*/
		/*String hql = "select nativeplace from Student order by nativeplace desc";
		Query query = session.createQuery(hql);
		List<Student> ustu = query.list();
		System.out.println(ustu);*/
		
		/**使用QBC完成查询语句的排序，*/
//		Criteria cirteria = session.createCriteria(Student.class);
//		cirteria.addOrder(Order.asc("tel"));
//		List<Student> ustulist = cirteria.list();
//		System.out.println(ustulist);
//		
//		HibernateUtils.closeSession();
	}

	/**
	 * 得到不在某门课程的之内的学生列表
	 */
	@Override
	public List<Student> getStudentNoInCourse(Course course) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		//String hql="from cn.edu.hezeu.jsj.pojo.Student where select"
		String hql="from cn.edu.hezeu.jsj.pojo.Student s where s not in (select student from cn.edu.hezeu.jsj.pojo.Student_Course sc where sc.course = (from cn.edu.hezeu.jsj.pojo.Course c where c.id=?))";
		Query query = session.createQuery(hql);
		query.setString(0,course.getId()+"");
		List<Student> sl = null;
		if(!query.list().isEmpty()){
			sl = query.list();
		}
		session.close();
		return sl;
	}
	/**
	 * 根据课程id获得选取此课程的学生
	 * 
	 */
	@Override
	public List<Student> getStudentInCourse(int courseid) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		String hql="select sc.student from cn.edu.hezeu.jsj.pojo.Student_Course sc where sc.course in (from cn.edu.hezeu.jsj.pojo.Course c where c.id=?)order by sc.student.id";
		Query query = session.createQuery(hql);
		query.setString(0,""+courseid);
		List<Student> list = null;
		if(!query.list().isEmpty()){
			list = query.list();
		}
		session.clear();
		session.close();
		return list;
	}
	@Override
	public Student getOneStudent(String studentno, String password) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		String hql = "from cn.edu.hezeu.jsj.pojo.Student s where s.studentno=? and s.password=?";
		Query query = session.createQuery(hql);
		query.setString(0,studentno);
		query.setString(1,password);
		Student stu = null;
		if(!query.list().isEmpty()){
			stu = (Student) query.uniqueResult();
		}
		session.clear();
		session.close();
		return stu;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
