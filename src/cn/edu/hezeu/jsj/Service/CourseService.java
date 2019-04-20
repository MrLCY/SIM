package cn.edu.hezeu.jsj.Service;

import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Teacher;

public interface CourseService {

	public void addCourse(Course course,Teacher teacher);
	/**根据课程id删除*/
	public void deleteCourse(int id);
	/**根据id查询课程*/
	public Course getOneCourseById(int id);
}
