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
/**得到未选此门课程的学生列表*/
public List<Student> getStudentNoInCourse(Course course);
/**根据课程id获取选此课程的学生*/
public List<Student> getStudentInCourse(int courseid);
/**根据学号和密码拿到一个学生*/
public Student getOneStudent(String studentno,String password);
}
