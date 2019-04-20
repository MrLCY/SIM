package cn.edu.hezeu.jsj.ServiceImpl;

import cn.edu.hezeu.jsj.Dao.AdminDao;
import cn.edu.hezeu.jsj.Dao.Impl.AdminDaoImpl;
import cn.edu.hezeu.jsj.Service.AdminService;
import cn.edu.hezeu.jsj.Utils.HibernateUtils;
import cn.edu.hezeu.jsj.pojo.Admin;

public class AdminServiceImpl implements AdminService {
	AdminDao  admindao = null;
	@Override
	public void addAdmin(Admin admin) {
		admindao.addAdmin(admin);

	}

	@Override
	public Admin getOneAdmin(int id) {
		
		return admindao.getOneAdmin(id);
	}

	@Override
	public Admin getOneAdmin(String username, String password) {
		
		return admindao.getOneAdmin(username, password);
	}

	@Override
	public void updateAdmin(Admin admin) {
		admindao.Update(admin);
		
	}

	public AdminDao getAdmindao() {
		return admindao;
	}

	public void setAdmindao(AdminDao admindao) {
		this.admindao = admindao;
	}
	
}
