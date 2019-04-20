package cn.edu.hezeu.jsj.Dao;

import cn.edu.hezeu.jsj.pojo.Course;

public interface CourseDao {

	public void addCourse(Course course);
	/**根据课程id删除*/
	public void deleteCourse(int id);
	/**根据id查找课程*/
	public Course getOneCourse(int id);
	/**根据学生查找查找学生所选课程*/
	
	/**根据教师id删除教师的课程*/
	public void deleteCourseByTeacher();
	
}
