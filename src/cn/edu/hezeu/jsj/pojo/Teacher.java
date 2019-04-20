package cn.edu.hezeu.jsj.pojo;

import java.util.Set;

public class Teacher {
   private int id;
   private String username;
   private String password;
   private String teacherid;
   private String realname;
   private Set<Teacher_Course> teacher_course;
public Teacher() {

}

public Teacher(String username, String password, String teacherid,
		String realname) {
	super();
	this.username = username;
	this.password = password;
	this.teacherid = teacherid;
	this.realname = realname;
}

public Teacher(int id, String username, String password, String teacherid,
		String realname) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.teacherid = teacherid;
	this.realname = realname;
}



public Teacher(String username, String password, String teacherid,
		String realname, Set<Teacher_Course> teacherCourse) {
	super();
	this.username = username;
	this.password = password;
	this.teacherid = teacherid;
	this.realname = realname;
	teacher_course = teacherCourse;
}

public Set<Teacher_Course> getTeacher_course() {
	return teacher_course;
}

public void setTeacher_course(Set<Teacher_Course> teacherCourse) {
	teacher_course = teacherCourse;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getTeacherid() {
	return teacherid;
}

public void setTeacherid(String teacherid) {
	this.teacherid = teacherid;
}

public String getRealname() {
	return realname;
}

public void setRealname(String realname) {
	this.realname = realname;
}

@Override
public String toString() {
	return "Teacher [id=" + id + ", password=" + password + ", realname="
			+ realname + ", teacherid=" + teacherid + ", username=" + username
			+ "]";
}


}