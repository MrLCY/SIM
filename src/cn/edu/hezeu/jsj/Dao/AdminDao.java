package cn.edu.hezeu.jsj.Dao;

import cn.edu.hezeu.jsj.pojo.Admin;

public interface AdminDao {
/**����id��ȡ����Ա*/
	public Admin getOneAdmin(int id);
/**�޸� ����Ա��Ϣ*/
	public void Update(Admin admin);
/**��ӹ���Ա��Ϣ*/
	public void addAdmin(Admin admin);
/**�����û��������ж��Ƿ���������*/
	public Admin  getOneAdmin(String username,String password);
	

}
