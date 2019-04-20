
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
	 * ɾ��ѧ����ɾ��ѧ����������Ϣ
	 * ����ѧ����ѡ�γ�  �� ѧ���ĸ�����Ϣ
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

	/**��ҳ��ѯ**/
	public List<Student> getStudentByPage(int pageno, int num) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Criteria criteria =session.createCriteria(Student.class);
		criteria.setMaxResults(num);//�趨ÿҳ��ʾ�ļ�¼��
		criteria.setFirstResult((pageno-1)*num);//�ӵڼ�����¼��ʼ��ѯ
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
		/**���ѧ����*/
//		for(int i = 1;i<=20;i++){
//			Student stu = new Student(i,"password"+i,"Mr.Li"+i,"2016001"+i,"����"+i,i+"1368898",new Date(),i+"234@qq.com",i+"c:image");
//			studentdao.addStudent(stu);
//		}
		//System.out.println(studentdao.getOneStudent("20160011"));
		
		
		/**ʹ��HQL�����в�ѯ**/
		//String hql = "from Student where tel=?";
		//System.out.println(HibernateUtils.getObjects(hql,new String[]{"11368898"}));
		
		//String hql="from Student s where s.tel=11368898";
		//Query query = session.createQuery(hql);
		
		
		/**ʹ��QBC����������ѯ*/
		/*Criteria criteria =session.createCriteria(Student.class);
		Student student = (Student) criteria.add(Restrictions.eq("tel","11368898")).list().get(0);
		System.out.println(student);*/
		
		/**ʹ��HQL�����в�ѯ������ desc �����ѯ  asc�����ѯ  �ַ�����ASCI������*/
		/*String hql = "select nativeplace from Student order by nativeplace desc";
		Query query = session.createQuery(hql);
		List<Student> ustu = query.list();
		System.out.println(ustu);*/
		
		/**ʹ��QBC��ɲ�ѯ��������*/
//		Criteria cirteria = session.createCriteria(Student.class);
//		cirteria.addOrder(Order.asc("tel"));
//		List<Student> ustulist = cirteria.list();
//		System.out.println(ustulist);
//		
//		HibernateUtils.closeSession();
	}

	/**
	 * �õ�����ĳ�ſγ̵�֮�ڵ�ѧ���б�
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
	 * ���ݿγ�id���ѡȡ�˿γ̵�ѧ��
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
