package cn.edu.hezeu.jsj.Dao;

import java.util.List;

import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Teacher;
import cn.edu.hezeu.jsj.pojo.Teacher_Course;

public interface TeacherDao {

	public void addTeacher(Teacher teacher);
	
	public Teacher getOneTeacher(int id);
	
	public List<Teacher> getTeachers();
	
	public void deleteTeacher(int id);
	
	public Teacher getOneTeacher(String username,String password);
	
	public List<Teacher_Course> getCourseByTeacherId(int id);
	
	
}
