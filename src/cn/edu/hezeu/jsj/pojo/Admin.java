package cn.edu.hezeu.jsj.pojo;

public class Admin {
    private int id;
    private String username;
    private String password;

    private String realname;
    private String adminno;
	public Admin() {
	
	}
	
	public Admin(String username, String password, String realname,
			String adminno) {
		super();
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.adminno = adminno;
	}

	public Admin(int id, String username, String password, String realname,
			String adminno) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.adminno = adminno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getAdminno() {
		return adminno;
	}
	public void setAdminno(String adminno) {
		this.adminno = adminno;
	}
	@Override
	public String toString() {
		return "Admin [adminno=" + adminno + ", id=" + id + ", password="
				+ password + ", realname=" + realname + ", username="
				+ username + "]";
	}

}
