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
	 * ��ӿγ�
	 * Ϊĳ����ʦ��ӿγ�
	 * ͬʱ����Course �� Teacher_Course
	 * @return
	 */
	public String addCourse(){
		courseService.addCourse(course,(Teacher)ActionContext.getContext().getSession().get("teacher"));
		
		return "addCourse";
	}
	
	/**
	 * �õ���ʦ�Ŀγ��б�
	 * @return
	 */
	public String getCourseByTeacher(){
		
		ActionContext.getContext().put("courselist",teacherService.getCourseByTeacherId(((Teacher)ActionContext.getContext().getSession().get("teacher")).getId()));
		return "getCourseByTeacher";
	}
	/**
	 * �õ�����ĳ���γ̵�ѧ��
	 * ��ʦ���Բ鿴�Լ�ĳ���γ̵�����ѧ��
	 * @return
	 */
	public String getStudentByCourse(){
		return "getStudentByCourse";
	}
	/**
	 * �õ�δѡ���ſγ̵�ѧ��
	 * ���ڽ�ʦΪ�Լ��Ŀγ����ѧ��
	 * ʵ��ʹ�õ���course.id
	 * @return
	 */
	public String getStudentNoInCourse(){
		if(null==course){
			ActionContext.getContext().put("stulist",studentService.getStudentNoInCourse((Course)ActionContext.getContext().getSession().get("courseid")));
		}else{
			ActionContext.getContext().put("stulist",studentService.getStudentNoInCourse(course));
			ActionContext.getContext().getSession().put("courseid", course);//��couseֻ��id������ֵ
		}
		
		
		return "getStudentNoInCourse";
	}
	/**
	 * ��ʦΪ�Լ���ĳ�γ����ѧ��
	 * */
	public String addStudentToCourse(){
		
		Course cou = courseService.getOneCourseById(((Course) ActionContext.getContext().getSession().get("courseid")).getId());
		teacherService.addStduentToCourse(studentService.getOneStudent(student.getId()), cou);
		return "addStudentToCourse";
	}
	
	/**
	 * ��ʦɾ���Լ������ĳ�ſγ�
	 * ɾ��Techer_Course
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
