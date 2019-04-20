package cn.edu.hezeu.jsj.Service;

import java.util.List;

import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Student;
import cn.edu.hezeu.jsj.pojo.Teacher;
import cn.edu.hezeu.jsj.pojo.Teacher_Course;

public interface TeacherService {


	public void addTeacher(Teacher teacher);
	
	public Teacher getOneTeacher(int id);
	
	public List<Teacher> getTeachers();
	
	public void deleteTeacher(int id);
	
	public Teacher getOneTeacher(String username,String password);
	
	public List<Course> getCourseByTeacherId(int id);
	
	public void addStduentToCourse(Student student,Course course);
	/**
	 * ��ʦɾ��ĳ���Լ�����Ŀγ�
	 * ɾ��Student_Course�йؿγ���Ϣ
	 * ɾ��Teacher_Course�й���Ϣ
	 * ɾ��Course�й���Ϣ
	 * @param courseid
	 */
	public void deleteCourse(int courseid);
}
