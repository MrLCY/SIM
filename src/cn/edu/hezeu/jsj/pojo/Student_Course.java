package cn.edu.hezeu.jsj.pojo;

public class Student_Course {
private int id;

private Student student;

private Course course;

public Student_Course() {
	super();
	// TODO Auto-generated constructor stub
}

public Student_Course(Student student, Course course) {
	super();
	this.student = student;
	this.course = course;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Student getStudent() {
	return student;
}

public void setStudent(Student student) {
	this.student = student;
}

public Course getCourse() {
	return course;
}

public void setCourse(Course course) {
	this.course = course;
}

@Override
public String toString() {
	return "Student_Course [course=" + course + ", id=" + id + ", student="
			+ student + "]";
}

}
