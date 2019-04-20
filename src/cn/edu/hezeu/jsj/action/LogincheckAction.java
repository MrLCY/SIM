package cn.edu.hezeu.jsj.action;

import org.apache.struts2.ServletActionContext;

import cn.edu.hezeu.jsj.Service.AdminService;
import cn.edu.hezeu.jsj.Service.StudentService;
import cn.edu.hezeu.jsj.Service.TeacherService;
import cn.edu.hezeu.jsj.ServiceImpl.AdminServiceImpl;
import cn.edu.hezeu.jsj.ServiceImpl.StudentServiceImpl;
import cn.edu.hezeu.jsj.ServiceImpl.TeacherServiceImpl;
import cn.edu.hezeu.jsj.pojo.Admin;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogincheckAction implements Action{
  private Admin admin;
  AdminService adminService = null;
  TeacherService teacherService = null;
  StudentService studentService = null;
	@Override
	public String execute() throws Exception {
		String role = ServletActionContext.getRequest().getParameter("role");
		if("1".equals(role)){
			if(adminService.getOneAdmin(admin.getUsername(),admin.getPassword())!=null){
				ActionContext.getContext().getSession().put("admin",adminService.getOneAdmin(admin.getUsername(),admin.getPassword()));
				return "success";
			}else{
				return "failure";
			}
		}else if("2".equals(role)){
			if(teacherService.getOneTeacher(admin.getUsername(),admin.getPassword())!=null){
				ActionContext.getContext().getSession().put("teacher",teacherService.getOneTeacher(admin.getUsername(),admin.getPassword()));
				return "teachersuccess";
			}else{
				return "failure";
			}
			
		}else if("3".equals(role)){
			if(studentService.getOneStudent(admin.getUsername(),admin.getPassword())!=null){
				ActionContext.getContext().getSession().put("student", studentService.getOneStudent(admin.getUsername(),admin.getPassword()));
				return "studentsuccess";
			}else{
				return "failure";
			}
			
		}else{
			return "failure";
		}
		
		//System.out.println(admin.getUsername()+" \n"+admin.getPassword());
		
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
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
	
	
}
