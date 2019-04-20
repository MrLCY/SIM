package cn.edu.hezeu.jsj.action;

import cn.edu.hezeu.jsj.Service.CourseService;
import cn.edu.hezeu.jsj.Service.StudentService;
import cn.edu.hezeu.jsj.Service.TeacherService;
import cn.edu.hezeu.jsj.ServiceImpl.CourseServiceImpl;
import cn.edu.hezeu.jsj.ServiceImpl.StudentServiceImpl;
import cn.edu.hezeu.jsj.ServiceImpl.TeacherServiceImpl;
import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.Student;
import cn.edu.hezeu.jsj.pojo.Teacher;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CourseManagerAction extends ActionSupport {

	private Course course;
	private Teacher teacher;
	private Student student;
	TeacherService teacherService=null;
	CourseService courseService  = null;
	StudentService studentService = null;
	/**
	 * 添加课程
	 * 为某个老师添加课程
	 * 同时更新Course 和 Teacher_Course
	 * @return
	 */
	public String addCourse(){
		courseService.addCourse(course,(Teacher)ActionContext.getContext().getSession().get("teacher"));
		
		return "addCourse";
	}
	
	/**
	 * 得到老师的课程列表
	 * @return
	 */
	public String getCourseByTeacher(){
		
		ActionContext.getContext().put("courselist",teacherService.getCourseByTeacherId(((Teacher)ActionContext.getContext().getSession().get("teacher")).getId()));
		return "getCourseByTeacher";
	}
	/**
	 * 得到数据某个课程的学生
	 * 教师可以查看自己某个课程的所有学生
	 * @return
	 */
	public String getStudentByCourse(){
		return "getStudentByCourse";
	}
	/**
	 * 得到未选此门课程的学生
	 * 用于教师为自己的课程添加学生
	 * 实际使用的是course.id
	 * @return
	 */
	public String getStudentNoInCourse(){
		if(null==course){
			ActionContext.getContext().put("stulist",studentService.getStudentNoInCourse((Course)ActionContext.getContext().getSession().get("courseid")));
		}else{
			ActionContext.getContext().put("stulist",studentService.getStudentNoInCourse(course));
			ActionContext.getContext().getSession().put("courseid", course);//此couse只有id属性有值
		}
		
		
		return "getStudentNoInCourse";
	}
	/**
	 * 教师为自己的某课程添加学生
	 * */
	public String addStudentToCourse(){
		
		Course cou = courseService.getOneCourseById(((Course) ActionContext.getContext().getSession().get("courseid")).getId());
		teacherService.addStduentToCourse(studentService.getOneStudent(student.getId()), cou);
		return "addStudentToCourse";
	}
	
	/**
	 * 教师删除自己开设的某门课程
	 * 删除Techer_Course
	 * 	  Student_Course
	 * 	  Course
	 * @return
	 */
	public String deleteCourseByTeacher(){
		teacherService.deleteCourse(course.getId());
		return "deleteCourseByTeacher";
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
}
