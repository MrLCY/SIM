package cn.edu.hezeu.jsj.action;

import cn.edu.hezeu.jsj.Service.StudentService;
import cn.edu.hezeu.jsj.Service.Student_CourseService;
import cn.edu.hezeu.jsj.Service.TeacherService;
import cn.edu.hezeu.jsj.ServiceImpl.StudentServiceImpl;
import cn.edu.hezeu.jsj.ServiceImpl.Student_CourseServiceImpl;
import cn.edu.hezeu.jsj.ServiceImpl.TeacherServiceImpl;
import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Student;
import cn.edu.hezeu.jsj.pojo.Teacher;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TeacherManagerAction extends ActionSupport implements Action{
private Teacher teacher;
private Course course;
private Student student;
TeacherService teacherService = null;
StudentService studentService = null;
Student_CourseService student_courseService = null;
	/*
	 * ��ӽ�ʦ
	 */
	public String addTeacher(){
		teacherService.addTeacher(teacher);
		return "addTeacher";
	}
	/**
	 * �õ���ʦ�б�
	 * @return
	 */
	public String getAllTeacher(){
		
		ActionContext.getContext().put("teacherlist",teacherService.getTeachers());
		return "getAllTeacher";
	}
	
	/**
	 * ɾ����ʦ
	 * @return
	 */
	
	public String deleteTeacher(){
		teacherService.deleteTeacher(teacher.getId());
		return "deleteTeacher";
	}
	/**
	 * �õ��γ̰༶��ȫ��ѧ��
	 * @return
	 */
	public String getStudentInCourse(){
		if(null==course){
			ActionContext.getContext().put("stulist", studentService.getStudentInCourse(((Course)ActionContext.getContext().getSession().get("courseid")).getId()));
		}else{
			ActionContext.getContext().put("stulist", studentService.getStudentInCourse(course.getId()));
			ActionContext.getContext().getSession().put("courseid",course);//����ֻ��id��ֵ
		}
		
		return "getStudentInCourse";
	}
	
	/**
	 * ��ĳ���γ���ɾ��ĳ��ѧ��
	 * ��Student_Course��ɾ��
	 * @return
	 */
	public String deleteStudentFromCourse(){
		student_courseService.deleteStudent_Course(student.getId(),((Course)ActionContext.getContext().getSession().get("courseid")).getId());
		return "deleteStudentFromCourse";
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
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public Student_CourseService getStudent_courseService() {
		return student_courseService;
	}
	public void setStudent_courseService(Student_CourseService studentCourseService) {
		student_courseService = studentCourseService;
	}
	
}
