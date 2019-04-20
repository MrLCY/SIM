package cn.edu.hezeu.jsj.Dao.Impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.hezeu.jsj.Dao.AdminDao;
import cn.edu.hezeu.jsj.Utils.HibernateUtils;
import cn.edu.hezeu.jsj.pojo.Admin;

public class AdminDaoImpl implements AdminDao {
	private HibernateTemplate hibernateTemplate = null;
	@Override
	public void Update(Admin admin) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(admin);
	}

	@Override
	public Admin getOneAdmin(int id) {
		
		return hibernateTemplate.get(Admin.class, id);
	}

	@Override
	public void addAdmin(Admin admin) {
		hibernateTemplate.save(admin);
		
	}
	public static void main(String args[]){
		
		AdminDao admindao  =  new AdminDaoImpl();
		/*Admin admin = new Admin("Mr.AD","1234","СоµП","001");*/
		//admindao.addAdmin(admin);
		System.out.println(admindao.getOneAdmin("Mr.AD","admin"));
	}

	public  Admin getOneAdmin(String username, String password) {
		
		String hql ="from Admin where username=? and password =?";
		return (Admin) hibernateTemplate.find(hql,new Object[]{username,password}).get(0);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
}
