package cn.edu.hezeu.jsj.Service;

import java.util.List;

import cn.edu.hezeu.jsj.pojo.Teacher_Course;

public interface Teacher_CourseService {

	public List<Teacher_Course> getTeacher_CourseByStudentId(int studentid);
	
	/****
	 * ����ѧ��ID���δѡ�γ̵�������Ϣ
	 */
	public List<Teacher_Course> getNoSelectTeacher_CourseByStudentId(int studentid);
}
