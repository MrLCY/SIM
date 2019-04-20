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
	 * 教师删除某个自己开设的课程
	 * 删除Student_Course有关课程信息
	 * 删除Teacher_Course有关信息
	 * 删除Course有关信息
	 * @param courseid
	 */
	public void deleteCourse(int courseid);
}
