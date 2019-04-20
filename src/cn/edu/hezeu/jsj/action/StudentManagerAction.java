package cn.edu.hezeu.jsj.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.edu.hezeu.jsj.Service.StudentService;
import cn.edu.hezeu.jsj.Service.Student_CourseService;
import cn.edu.hezeu.jsj.Service.Teacher_CourseService;
import cn.edu.hezeu.jsj.ServiceImpl.StudentServiceImpl;
import cn.edu.hezeu.jsj.ServiceImpl.Student_CourseServiceImpl;
import cn.edu.hezeu.jsj.ServiceImpl.Teacher_CourseServiceImpl;
import cn.edu.hezeu.jsj.pojo.Course;
import cn.edu.hezeu.jsj.pojo.PageBean;
import cn.edu.hezeu.jsj.pojo.Student;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;

public class StudentManagerAction {
	private Student student;
	private File file;
	private String fileFileName;
	private String fileContextType;
	private PageBean pagebean;
	private Course course;
	StudentService studentService = null;
	Teacher_CourseService teacher_courseService = null;
	Student_CourseService student_courseService = null;
    /**Ajax|Jquery�ж���**/
	public String deajax()throws Exception{
	
		
		HttpServletResponse response = ServletActionContext.getResponse();
		//response.setCharacterEncoding("text/html;charset=utf-8");*/
		System.out.println("�յ�Ajax����"+student.getStudentno());
		//response.getWriter().write("Ajax����ɹ� ");
		//response.setCharacterEncoding("text/html;charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		  PrintWriter out = response.getWriter();
		  if(studentService.getOneStudent(student.getStudentno())==null){
			  out.write("ѧ�ſ���ʹ��");	
		  }else{
			  out.write("ѧ���Ѿ���ע��");
		  }
	                
		return null;
	}
	public String getAllStudent() {
		
		System.out.println("ѧ���б�"+pagebean.getCurrentPage() +" "+pagebean.getPageSize());
		/**��ҳ**/
		
		//��pagebean��ֵѧ���б�
		pagebean.setList(studentService.getStudentByPage(pagebean.getCurrentPage(),pagebean.getPageSize()));
		//�ܼ�¼��
		int totalsize = studentService.getCountStudent();
		pagebean.setTotalSize(totalsize);
		//��ҳ��
		if(totalsize%pagebean.getPageSize()>0){
			pagebean.setTotalPage(totalsize/pagebean.getPageSize()+1);
		}else{
			pagebean.setTotalPage(totalsize/pagebean.getPageSize());
		}
		//ActionContext.getContext().put("pagebean", pagebean);
		ActionContext.getContext().put("stulist",
				pagebean.getList());
		System.out.println("ѧ���б�");
		
		//ActionContext.getContext().put("info1",ActionContext.getContext().getSession().get("info") );
		return "getAllStudent";
	}

	/** �鿴ʹ�� */
	public String getOneStudent() {
		System.out.println(student.getId());
		ActionContext.getContext().put("student",
				studentService.getOneStudent(student.getId()));
		return "getOneStudentInfo";
	}

	/** �༭ʹ�� */
	public String getStudentToUpdate() {
		ActionContext.getContext().put("student",
				studentService.getOneStudent(student.getId()));
		return "getStudentToUpdate";
	}

	public String deleteStudent() {
		studentService.deleteStudent(student.getId());
		System.out.println("ɾ��");
		return "deleteStudent";
	}

	public String addStudent() {
		
		String realpath = "D:\\workspace\\sims2.1\\WebRoot\\File";
		// fileFileName
		// System.out.println("0000000000"+student.getImage()+"111111 "+realpath+"2222\n"+this.getFileFileName().toString()+"33333333\n"+this.getFileContextType());

		if (file != null) {
			File savedir = new File(realpath);
			this.student.setImage(this.getFileFileName().toString());
			System.out.println(realpath);
			if (!savedir.exists()) {
				savedir.mkdirs();
			}

			try {
				File savefileFile = new File(savedir, fileFileName);
				FileUtils.copyFile(file, savefileFile);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 ActionContext.getContext().getSession().put("info", "��ӳɹ�");
		}
		studentService.addStudent(this.student);

		return "addStudent";
	}

	public String updateStudent() {
		System.out.println("================================================");
		// Student student1 = studentService.getOneStudent(student.getId());
		student.setPassword(studentService.getOneStudent(student.getId())
				.getPassword());
		//String realpath = ServletActionContext.getServletContext().getRealPath(
			//	"/file");
		String realpath = "D:\\workspace\\sims2.1\\WebRoot\\File";
		// fileFileName
		// System.out.println("0000000000"+student.getImage()+"111111 "+realpath+"2222\n"+this.getFileFileName().toString()+"33333333\n"+this.getFileContextType());

		if (file != null) {
			File savedir = new File(realpath);
			this.student.setImage(this.getFileFileName().toString());
			System.out.println(realpath);
			if (!savedir.exists()) {
				savedir.mkdirs();
			}

			try {
				File savefileFile = new File(savedir, fileFileName);
				FileUtils.copyFile(file, savefileFile);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 ActionContext.getContext().getSession().put("info", "����ɹ�");
		}
		studentService.updateStudent(this.student);

		//System.out.println("================================================");

		return "updateStudent";
	}
	/**�õ�ѧ����ѡ���б�*/
	public String getHasSelectedCourseByStudent(){
		ActionContext.getContext().put("teacher_course",
				teacher_courseService.getTeacher_CourseByStudentId(
						((Student)ActionContext.getContext().getSession().get("student")).getId()));
		return "getHasSelectedCourseByStudent";
	}
	public String getNoSelectedCourseByStudent(){
		ActionContext.getContext().put("teacher_course",
				teacher_courseService.getNoSelectTeacher_CourseByStudentId(
						((Student)ActionContext.getContext().getSession().get("student")).getId()));
		return "getNoSelectedCourseByStudent";
	}
	/***
	 * ѧ��ѡ��γ�
	 * @return
	 */
	public String chooseCourse(){
		student_courseService.addStudent_Course(
				((Student)ActionContext.getContext().getSession().get("student")), course);
		return "chooseCourse";
	}
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContextType() {
		return fileContextType;
	}

	public void setFileContextType(String fileContextType) {
		this.fileContextType = fileContextType;
	}
	public PageBean getPagebean() {
		return pagebean;
	}
	public void setPagebean(PageBean pagebean) {
		this.pagebean = pagebean;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public Teacher_CourseService getTeacher_courseService() {
		return teacher_courseService;
	}
	public void setTeacher_courseService(Teacher_CourseService teacherCourseService) {
		teacher_courseService = teacherCourseService;
	}
	public Student_CourseService getStudent_courseService() {
		return student_courseService;
	}
	public void setStudent_courseService(Student_CourseService studentCourseService) {
		student_courseService = studentCourseService;
	}
	
}
