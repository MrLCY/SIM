package cn.edu.hezeu.jsj.Service;

import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Teacher;

public interface CourseService {

	public void addCourse(Course course,Teacher teacher);
	/**���ݿγ�idɾ��*/
	public void deleteCourse(int id);
	/**����id��ѯ�γ�*/
	public Course getOneCourseById(int id);
}
