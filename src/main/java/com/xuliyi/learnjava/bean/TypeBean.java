package com.xuliyi.learnjava.bean;

/**
 * 图书分类记录表
 * @Date: 2023年9月4日
 */
public class TypeBean {
	
	private int tid;// 分类的id
	private String name;// 分类的名称

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
