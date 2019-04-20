package cn.edu.hezeu.jsj.Service;

import cn.edu.hezeu.jsj.pojo.Admin;

public interface AdminService {
	public Admin getOneAdmin(int id);
	
	public void addAdmin(Admin admin); 
	
	public Admin getOneAdmin(String username,String password);
	
	public void updateAdmin(Admin admin);
	

}
