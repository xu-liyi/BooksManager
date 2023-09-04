package com.xuliyi.learnjava.bean;

/**
 * 用户数据表
 * @Date: 2023年9月4日
 */
public class AdminBean {
	//用户ID
	private int aid;
	//用户状态信息，读者的值为1，管理员为2
	private int status;
	//用户名
	private String username;
	//姓名
	private String name;
	//密码
	private String password;
	//邮箱
	private String email;
	//手机号
	private String phone;
	//借阅量
	private int times;
	//可借阅天数
	private int lend_num;
	//最大可借数
	private int max_num;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public int getLend_num() {
		return lend_num;
	}

	public void setLend_num(int lend_num) {
		this.lend_num = lend_num;
	}

	public int getMax_num() {
		return max_num;
	}

	public void setMax_num(int max_num) {
		this.max_num = max_num;
	}

}
