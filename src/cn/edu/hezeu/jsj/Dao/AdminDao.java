package cn.edu.hezeu.jsj.Dao;

import cn.edu.hezeu.jsj.pojo.Admin;

public interface AdminDao {
/**根据id获取管理员*/
	public Admin getOneAdmin(int id);
/**修改 管理员信息*/
	public void Update(Admin admin);
/**添加管理员信息*/
	public void addAdmin(Admin admin);
/**根据用户名密码判断是否存在这个人*/
	public Admin  getOneAdmin(String username,String password);
	

}
