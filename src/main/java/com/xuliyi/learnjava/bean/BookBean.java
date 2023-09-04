package com.xuliyi.learnjava.bean;

/**
 * 图书数据表
 * @Date: 2023年9月4日
 */
public class BookBean {
	private int bid;// id
	private String name;// 图书名称
	private String card;// 图书号
	private String autho;// 作者
	private int num;// 图书数量
	private String type;// 图书的分类
	private String press;// 出版社
	private int times;//借阅次数

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getAutho() {
		return autho;
	}

	public void setAutho(String autho) {
		this.autho = autho;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}
}
