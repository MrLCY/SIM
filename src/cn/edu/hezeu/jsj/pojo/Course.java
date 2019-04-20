package cn.edu.hezeu.jsj.pojo;

import java.util.Set;

public class Course {

	private int id;
	
	private String coursename;//¿Î³ÌÃû
	
	private Set<Teacher_Course> teacher_course;
	
	private Set<Student_Course> student_course;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int id, String coursename) {
		super();
		this.id = id;
		this.coursename = coursename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public Set<Teacher_Course> getTeacher_course() {
		return teacher_course;
	}

	public void setTeacher_course(Set<Teacher_Course> teacherCourse) {
		teacher_course = teacherCourse;
	}

	public Set<Student_Course> getStudent_course() {
		return student_course;
	}

	public void setStudent_course(Set<Student_Course> studentCourse) {
		student_course = studentCourse;
	}

	@Override
	public String toString() {
		return "Course [coursename=" + coursename + ", id=" + id + "]";
	}
	
}
