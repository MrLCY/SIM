package cn.edu.hezeu.jsj.Dao;

import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Student;
import cn.edu.hezeu.jsj.pojo.Student_Course;

public interface Student_CourseDao {

	public void addStudent_Course(Student student,Course course);
	/**
	 * 用户教师在课程中删除某个学生
	 * 根据课程id和学生id删除Student_Course的一条信息*/
	public void deleteStudent_Course(Student student,Course course);
	
	public Student_Course getStudent_Course(Student student,Course course);
	/**根据id去批量删除Stduent_Course的信息*/
	public void deleteStudent_CourseByCourse(int courseid);
	/**根据教师的ID去删除教师的所有课程的所有Student_Course*/
	public void deleteStudent_CourseByTeacher(int teacherid);
}
