package cn.edu.hezeu.jsj.pojo;

import java.util.Date;
import java.util.Set;

import javax.activation.DataSource;

public class Student {
	private int id;
	private String password;
	private String realname;
	private String studentno;
	private String nativeplace;
	private String tel;
	private Date birthday;
	private String email;
	private String image;
	private Set<Student_Course> student_course;

	public Student() {
		
	}


	public Student(int id, String password, String realname, String studentno,
			String nativeplace, String tel, Date birthday, String email,
			String image) {
		super();
		this.id = id;
		this.password = password;
		this.realname = realname;
		this.studentno = studentno;
		this.nativeplace = nativeplace;
		this.tel = tel;
		this.birthday = birthday;
		this.email = email;
		this.image = image;
	}


	
	public Set<Student_Course> getStudent_course() {
		return student_course;
	}


	public void setStudent_course(Set<Student_Course> studentCourse) {
		student_course = studentCourse;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRealname() {
		return realname;
	}


	public void setRealname(String realname) {
		this.realname = realname;
	}


	public String getStudentno() {
		return studentno;
	}


	public void setStudentno(String studentno) {
		this.studentno = studentno;
	}


	public String getNativeplace() {
		return nativeplace;
	}


	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "Student [birthday=" + birthday + ", email=" + email + ", id="
				+ id + ", image=" + image + ", nativeplace=" + nativeplace
				+ ", password=" + password + ", realname=" + realname
				+ ", studentno=" + studentno + ", tel=" + tel + "]";
	}



}
