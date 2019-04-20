package cn.edu.hezeu.jsj.Service;

import java.util.List;

import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Student;

public interface StudentService {

	public List<Student> getAllStudent();
	
	public Student getOneStudent(int id);
	
	public void addStudent(Student student);
	
	public void deleteStudent(int id);
	
	public void updateStudent(Student student);
	
	public Student getOneStudent(String studentno);
	
	public List<Student> getStudentByPage(int currentpage,int num);
	
	public int getCountStudent();
	
	/**�õ�δѡ���ſγ̵�ѧ���б�,ʹ��course.id*/
	public List<Student> getStudentNoInCourse(Course course);
	/**���ݿγ�id��ȡѡ�˿γ̵�ѧ��*/
	public List<Student> getStudentInCourse(int courseid);
	/**����ѧ�ź������õ�һ��ѧ��*/
	public Student getOneStudent(String studentno,String password);
}
