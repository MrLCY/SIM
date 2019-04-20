package cn.edu.hezeu.jsj.Dao;

import java.util.List;

import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Student;

public interface StudentDao {
public void addStudent(Student student);

public void deleteStudent(int id);

public void updateStudent(Student student);

public List<Student> getStudentList();

public Student getOneStudent(int id);

public Student getOneStudent(String studentno);

public List<Student> getStudentByPage(int pageno,int num);

public int getStudentCount();
/**�õ�δѡ���ſγ̵�ѧ���б�*/
public List<Student> getStudentNoInCourse(Course course);
/**���ݿγ�id��ȡѡ�˿γ̵�ѧ��*/
public List<Student> getStudentInCourse(int courseid);
/**����ѧ�ź������õ�һ��ѧ��*/
public Student getOneStudent(String studentno,String password);
}
