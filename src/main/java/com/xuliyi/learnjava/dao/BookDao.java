package com.xuliyi.learnjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.time.*;
import java.time.format.DateTimeFormatter;

import com.xuliyi.learnjava.bean.AdminBean;
import com.xuliyi.learnjava.bean.BookBean;
import com.xuliyi.learnjava.bean.HistoryBean;
import com.xuliyi.learnjava.util.DBUtil;

/**
 * 关于图书连接数据库的所有操作的类
 */
public class BookDao {

	/**
	 * 添加图书信息，传入所有的信息
	 * 
	 * @param card
	 * @param name
	 * @param type
	 * @param autho
	 * @param press
	 * @param num
	 * @param times
	 */
	public void addBook(String card, String name, String type, String autho, String press, int num) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO book(card,name,type,autho,press,num,times) VALUES(?,?,?,?,?,?,?)";
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, card);
				ps.setString(2, name);
				ps.setString(3, type);
				ps.setString(4, autho);
				ps.setString(5, press);
				ps.setInt(6, num);
				ps.setInt(7, 0);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "insert into book(card,name,type,autho,press,num,times) values(?,?,?,?,?,?,?)";
//		int rs = 0;
//		PreparedStatement ps = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, card);
//			ps.setString(2, name);
//			ps.setString(3, type);
//			ps.setString(4, autho);
//			ps.setString(5, press);
//			ps.setInt(6, num);
//			ps.setInt(7, 0);
//			rs = ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * 获取所有的图书信息，返回的是ArrayList数组形式
	 * 
	 * @return
	 */
	public ArrayList<BookBean> get_ListInfo() {
		ArrayList<BookBean> tag_Array = new ArrayList<BookBean>();
		String sql = "SELECT * FROM book";
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while (rs.next()) {
						BookBean tag = new BookBean();
						tag.setBid(rs.getInt("bid"));
						tag.setName(rs.getString("name"));
						tag.setCard(rs.getString("card"));
						tag.setType(rs.getString("type"));
						tag.setAutho(rs.getString("autho"));
						tag.setPress(rs.getString("press"));
						tag.setNum(rs.getInt("num"));
						tag.setTimes(rs.getInt("times"));
						tag_Array.add(tag);
					}
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "select * from book";
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				BookBean tag = new BookBean();
//				tag.setBid(rs.getInt("bid"));
//				tag.setName(rs.getString("name"));
//				tag.setCard(rs.getString("card"));
//				tag.setType(rs.getString("type"));
//				tag.setAutho(rs.getString("autho"));
//				tag.setPress(rs.getString("press"));
//				tag.setNum(rs.getInt("num"));
//				tag.setTimes(rs.getInt("times"));
//				tag_Array.add(tag);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.CloseDB(rs, ps, conn);
//		}
		return tag_Array;
	}
	
	/**
	 * 获取所有的图书信息并排序，返回的是ArrayList数组形式
	 * 
	 * @return
	 */
	public ArrayList<BookBean> get_ListInfo2() {
		ArrayList<BookBean> tag_Array = new ArrayList<BookBean>();
		String sql = "SELECT * FROM book order by times DESC";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while (rs.next()) {
						BookBean tag = new BookBean();
						tag.setBid(rs.getInt("bid"));
						tag.setName(rs.getString("name"));
						tag.setCard(rs.getString("card"));
						tag.setType(rs.getString("type"));
						tag.setAutho(rs.getString("autho"));
						tag.setPress(rs.getString("press"));
						tag.setNum(rs.getInt("num"));
						tag.setTimes(rs.getInt("times"));
						tag_Array.add(tag);
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "select * from book order by times desc";
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				BookBean tag = new BookBean();
//				tag.setBid(rs.getInt("bid"));
//				tag.setName(rs.getString("name"));
//				tag.setCard(rs.getString("card"));
//				tag.setType(rs.getString("type"));
//				tag.setAutho(rs.getString("autho"));
//				tag.setPress(rs.getString("press"));
//				tag.setNum(rs.getInt("num"));
//				tag.setTimes(rs.getInt("times"));
//				tag_Array.add(tag);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.CloseDB(rs, ps, conn);
//		}
		return tag_Array;
	}

	/**
	 * 获取借阅记录的全部信息，传入的条件有status，aid，表示搜索正在借阅的，或者已经还书的信息，aid代表当前登录用户
	 * 
	 * @param status
	 * @return
	 */
	public ArrayList<HistoryBean> get_HistoryListInfo(int status, String aid) {
		ArrayList<HistoryBean> tag_Array = new ArrayList<HistoryBean>();
		String sql = "SELECT * FROM history WHERE aid=? AND status=?";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setObject(1, aid);
				ps.setObject(2, status);
				try(ResultSet rs = ps.executeQuery()){
					while (rs.next()) {
						HistoryBean tag = new HistoryBean();
						tag.setHid(rs.getInt("hid"));
						tag.setAid(rs.getInt("aid"));
						tag.setBid(rs.getInt("bid"));
						tag.setBookname(rs.getString("bookname"));
						tag.setCard(rs.getString("card"));
						tag.setAdminname(rs.getString("adminname"));
						tag.setUsername(rs.getString("username"));
						tag.setBegintime(rs.getString("begintime"));
						tag.setEndtime(rs.getString("endtime"));
						tag.setStatus(rs.getInt("status"));
						tag_Array.add(tag);
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "select * from history where aid=" + aid + " and status=" + status;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				HistoryBean tag = new HistoryBean();
//				tag.setHid(rs.getInt("hid"));
//				tag.setAid(rs.getInt("aid"));
//				tag.setBid(rs.getInt("bid"));
//				tag.setBookname(rs.getString("bookname"));
//				tag.setCard(rs.getString("card"));
//				tag.setAdminname(rs.getString("adminname"));
//				tag.setUsername(rs.getString("username"));
//				tag.setBegintime(rs.getString("begintime"));
//				tag.setEndtime(rs.getString("endtime"));
//				tag.setStatus(rs.getInt("status"));
//				tag_Array.add(tag);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.CloseDB(rs, ps, conn);
//		}
		return tag_Array;
	}

	/**
	 * 获取借阅记录的全部信息，传入的条件有status，表示搜索正在借阅的，或者已经还书的信息
	 * 
	 * @param status
	 * @return
	 */
	public ArrayList<HistoryBean> get_HistoryListInfo2(int status) {
		ArrayList<HistoryBean> tag_Array = new ArrayList<HistoryBean>();
		String sql = "SELECT * FROM history WHERE status=?";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setObject(1, status);
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						HistoryBean tag = new HistoryBean();
						tag.setHid(rs.getInt("hid"));
						tag.setAid(rs.getInt("aid"));
						tag.setBid(rs.getInt("bid"));
						tag.setBookname(rs.getString("bookname"));
						tag.setCard(rs.getString("card"));
						tag.setAdminname(rs.getString("adminname"));
						tag.setUsername(rs.getString("username"));
						tag.setBegintime(rs.getString("begintime"));
						tag.setEndtime(rs.getString("endtime"));
						tag.setStatus(rs.getInt("status"));
						tag_Array.add(tag);
						
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "select * from history where status=" + status;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				HistoryBean tag = new HistoryBean();
//				tag.setHid(rs.getInt("hid"));
//				tag.setAid(rs.getInt("aid"));
//				tag.setBid(rs.getInt("bid"));
//				tag.setBookname(rs.getString("bookname"));
//				tag.setCard(rs.getString("card"));
//				tag.setAdminname(rs.getString("adminname"));
//				tag.setUsername(rs.getString("username"));
//				tag.setBegintime(rs.getString("begintime"));
//				tag.setEndtime(rs.getString("endtime"));
//				tag.setStatus(rs.getInt("status"));
//				tag_Array.add(tag);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.CloseDB(rs, ps, conn);
//		}
		return tag_Array;
	}

	/**
	 * 获取单个图书的信息，根据传入的bid来查找，返回一个BookBean数据类型
	 * 
	 * @param bid
	 * @return
	 */
	public BookBean get_BookInfo(int bid) {
		BookBean tag = new BookBean();
		String sql = "SELECT * FROM book WHERE bid=?";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setObject(1, bid);
				try(ResultSet rs = ps.executeQuery()){
					while (rs.next()) {
						tag.setBid(rs.getInt("bid"));
						tag.setName(rs.getString("name"));
						tag.setCard(rs.getString("card"));
						tag.setType(rs.getString("type"));
						tag.setAutho(rs.getString("autho"));
						tag.setPress(rs.getString("press"));
						tag.setTimes(rs.getInt("times"));
						tag.setNum(rs.getInt("num"));
					}
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "select * from book where bid=" + bid;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				tag.setBid(rs.getInt("bid"));
//				tag.setName(rs.getString("name"));
//				tag.setCard(rs.getString("card"));
//				tag.setType(rs.getString("type"));
//				tag.setAutho(rs.getString("autho"));
//				tag.setPress(rs.getString("press"));
//				tag.setTimes(rs.getInt("times"));
//				tag.setNum(rs.getInt("num"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.CloseDB(rs, ps, conn);
//		}
		return tag;
	}

	/**
	 * 修改图书的信息，bid作为条件
	 */
	public void updateBook(int bid, String card, String name, String type, String autho, String press, int num) {
		// TODO Auto-generated method stub
		String sql = "UPDATE book SET name=?,card=?,type=?,autho=?,press=?,num=? WHERE bid=?";
		
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, name);
				ps.setString(2, card);
				ps.setString(3, type);
				ps.setString(4, autho);
				ps.setString(5, press);
				ps.setInt(6, num);
				ps.setInt(7, bid);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "update book set name=?,card=?,type=?,autho=?,press=?,num=? where bid=?";
//		PreparedStatement ps = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, name);
//			ps.setString(2, card);
//			ps.setString(3, type);
//			ps.setString(4, autho);
//			ps.setString(5, press);
//			ps.setInt(6, num);
//			ps.setInt(7, bid);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * 删除图书信息，根据传入的bid作为条件
	 * 
	 * @param bid
	 */
	public void deleteBook(int bid) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM book WHERE bid=?";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setObject(1,bid);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "delete from book where bid=?";
//		PreparedStatement ps = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, bid);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * 用户查找图书，根据输入的名称，使用like进行模糊查询，然后返回一个ArrayList数组类型
	 * 
	 * @param name
	 * @return
	 */
	public ArrayList<BookBean> getLikeList(String name) {
		// TODO Auto-generated method stub
		ArrayList<BookBean> tag_Array = new ArrayList<BookBean>();
		String sql = "SELECT * FROM book WHERE name like ? OR autho like ? OR type like ?";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setObject(1, "%"+name+"%");
				ps.setObject(2, "%"+name+"%");
				ps.setObject(3, "%"+name+"%");
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						BookBean tag = new BookBean();
						tag.setBid(rs.getInt("bid"));
						tag.setName(rs.getString("name"));
						tag.setCard(rs.getString("card"));
						tag.setType(rs.getString("type"));
						tag.setAutho(rs.getString("autho"));
						tag.setPress(rs.getString("press"));
						tag.setTimes(rs.getInt("times"));
						tag.setNum(rs.getInt("num"));
						tag_Array.add(tag);
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "select * from book where name like '%" + name + "%' or autho like '%" + name
//				+ "%' or type like '%" + name + "%'";
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				BookBean tag = new BookBean();
//				tag.setBid(rs.getInt("bid"));
//				tag.setName(rs.getString("name"));
//				tag.setCard(rs.getString("card"));
//				tag.setType(rs.getString("type"));
//				tag.setAutho(rs.getString("autho"));
//				tag.setPress(rs.getString("press"));
//				tag.setTimes(rs.getInt("times"));
//				tag.setNum(rs.getInt("num"));
//				tag_Array.add(tag);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.CloseDB(rs, ps, conn);
//		}
		return tag_Array;
	}

	/**
	 * 图书借阅函数，根据传入bid图书id，adminbean当前登录用户的信息，在借阅记录数据表中新插入一条记录
	 * 使用新API重写
	 * @param bid
	 * @param adminbean
	 */
	public void borrowBook(int bid, AdminBean adminbean) {
		//生成日期并格式化
		LocalDateTime ldt = LocalDateTime.now();
		LocalDate borrow_date = ldt.toLocalDate();
		LocalDate return_date = borrow_date.plusMonths(1);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String begintime = dtf.format(borrow_date);
		String endtime = dtf.format(return_date);
		//提取书籍信息
		BookBean bookbean = this.get_BookInfo(bid);
		//插入书籍借阅历史
		String sql = "INSERT INTO history(aid,bid,card,bookname,adminname,username,begintime,endtime,status) VALUES(?,?,?,?,?,?,?,?,?)";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setInt(1, adminbean.getAid());
				ps.setInt(2, bookbean.getBid());
				ps.setString(3, bookbean.getCard());
				ps.setString(4, bookbean.getName());
				ps.setString(5, adminbean.getUsername());
				ps.setString(6, adminbean.getName());
				ps.setString(7, begintime);
				ps.setString(8, endtime);
				ps.setInt(9, 1);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//更新书籍借阅次数信息
		String sql2 = "UPDATE book SET times=? WHERE bid=?";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql2)){
				ps.setObject(1, bookbean.getTimes() + 1);
				ps.setObject(2, bookbean.getBid());
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//更新借书人借阅次数信息
		String sql3 = "UPDATE admin SET times=? WHERE aid=?";
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql3)){
				ps.setObject(1, adminbean.getTimes() + 1);
				ps.setObject(2, adminbean.getAid());
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		BookBean bookbean = new BookBean();
//		bookbean = this.get_BookInfo(bid);
//		// 生成日期的功能
//		Calendar c = Calendar.getInstance();
//		int year = c.get(Calendar.YEAR);
//		int month = c.get(Calendar.MONTH) + 1;
//		int day = c.get(Calendar.DATE);
//		// 生成借阅开始日期
//		String begintime = "" + year + "-" + month + "-" + day;
//		month = month + 1;
//		// 生成截止还书日期
//		String endtime = "" + year + "-" + month + "-" + day;
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "insert into history(aid,bid,card,bookname,adminname,username,begintime,endtime,status) values(?,?,?,?,?,?,?,?,?)";
//		int rs = 0;
//		PreparedStatement ps = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, adminbean.getAid());
//			ps.setInt(2, bookbean.getBid());
//			ps.setString(3, bookbean.getCard());
//			ps.setString(4, bookbean.getName());
//			ps.setString(5, adminbean.getUsername());
//			ps.setString(6, adminbean.getName());
//			ps.setString(7, begintime);
//			ps.setString(8, endtime);
//			ps.setInt(9, 1);
//			rs = ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String sql2 = "update book set times=? where bid=?";
//		PreparedStatement ps2 = null;
//		try {
//			ps2 = conn.prepareStatement(sql2);
//			ps2.setInt(1, bookbean.getTimes() + 1);
//			ps2.setInt(2, bookbean.getBid());
//			ps2.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String sql3 = "update admin set times=? where aid=?";
//		PreparedStatement ps3 = null;
//		try {
//			ps3 = conn.prepareStatement(sql3);
//			ps3.setInt(1, adminbean.getTimes() + 1);
//			ps3.setInt(2, adminbean.getAid());
//			ps3.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}


	/**
	 * 还书功能的函数，根据传入的hid借阅记录id，将status字段的值改为0，并将还书日期改变为当前日期
	 * 
	 * @param hid
	 */
	public void borrowBook2(int hid) {
		//生成日期并格式化
		LocalDateTime ldt = LocalDateTime.now();
		LocalDate borrow_date = ldt.toLocalDate();
		LocalDate return_date = borrow_date.plusMonths(1);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String endtime = dtf.format(return_date);
		
		String sql = "UPDATE history SET endtime=?,status=? WHERE hid=?";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, endtime);
				ps.setInt(2, 0);
				ps.setInt(3, hid);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
//		// 生成日期
//		Calendar c = Calendar.getInstance();
//		int year = c.get(Calendar.YEAR);
//		int month = c.get(Calendar.MONTH) + 1;
//		int day = c.get(Calendar.DATE);
//		// 生成还书日期
//		String endtime = "" + year + "-" + month + "-" + day;
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "update history set endtime=?,status=? where hid=?";
//		PreparedStatement ps = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, endtime);
//			ps.setInt(2, 0);
//			ps.setInt(3, hid);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	/**
	 * 图书延期，根据传入hid记录id，在借阅记录数据表中更新endtime记录
	 * 
	 * @param hid
	 * @param endtime
	 */
	public void AddTime(int hid, String endtime) {
		String sql = "UPDATE history SET endtime=? WHERE hid=?";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, endtime);
				ps.setInt(2, hid);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "update history set endtime=? where hid=?";
//		PreparedStatement ps = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, endtime);
//			ps.setInt(2, hid);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
