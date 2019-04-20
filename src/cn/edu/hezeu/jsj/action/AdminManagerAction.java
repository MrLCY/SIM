package cn.edu.hezeu.jsj.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.hezeu.jsj.Service.AdminService;
import cn.edu.hezeu.jsj.ServiceImpl.AdminServiceImpl;
import cn.edu.hezeu.jsj.pojo.Admin;

public class AdminManagerAction {
	private Admin admin;
	AdminService adminService = null;
public  String seePersonInfo(){
	/*Admin adminte = (Admin) ActionContext.getContext().getSession().get("admin");
	ActionContext.getContext().put("admin",adminService.getOneAdmin(adminte.getId()));*/
	return "seeMyInfo";
}
public String updateMyInfo(){
	Admin adminte = (Admin) ActionContext.getContext().getSession().get("admin");
	 HttpServletRequest request = ServletActionContext.getRequest();  
	if(adminte.getPassword().equals(request.getParameter("oldPwd"))){
		adminte.setPassword(admin.getPassword());
		adminService.updateAdmin(adminte);
		ActionContext.getContext().put("info","密码重置成功");
	}else{
		ActionContext.getContext().put("info","密码重置失败");
	}
	
	//System.out.println("更新管理员密码");
	return "updateMyInfo";
}
public String getMyInfo(){
	return "getMyInfo";
}
public String getMyInfoToUpdate(){
	return "getMyInfoToUpdate";
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

}
