package cn.edu.hezeu.jsj.Service;

import java.util.List;

import cn.edu.hezeu.jsj.pojo.Teacher_Course;

public interface Teacher_CourseService {

	public List<Teacher_Course> getTeacher_CourseByStudentId(int studentid);
	
	/****
	 * 根据学生ID获得未选课程的所有信息
	 */
	public List<Teacher_Course> getNoSelectTeacher_CourseByStudentId(int studentid);
}
