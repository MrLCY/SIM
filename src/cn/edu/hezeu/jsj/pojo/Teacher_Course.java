package cn.edu.hezeu.jsj.pojo;

public class Teacher_Course {

	private int id;
	
	private Teacher teacher;
	
	private Course course;

	
	public Teacher_Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher_Course(Teacher teacher, Course course) {
		super();
		this.teacher = teacher;
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Teacher_Course [course=" + course + ", id=" + id + ", teacher="
				+ teacher + "]";
	}

	
	
}
