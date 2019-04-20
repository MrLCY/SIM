package cn.edu.hezeu.jsj.Service;


import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Student;


public interface Student_CourseService {

	/**
	 * 用户教师在课程中删除某个学生
	 * 根据课程id和学生id删除Student_Course的一条信息*/
	public void deleteStudent_Course(int studentId,int courseId);
	/**实际是根据student id course id 添加*/
	public void addStudent_Course(Student student, Course course);
}
