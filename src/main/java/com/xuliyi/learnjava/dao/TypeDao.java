package com.xuliyi.learnjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xuliyi.learnjava.bean.TypeBean;
import com.xuliyi.learnjava.util.DBUtil;

/**
 * 图书分类的类
 */
public class TypeDao {
	/**
	 * 获取所有图书类型的信息，返回数组形式
	 * 
	 * @return
	 */
	public ArrayList<TypeBean> get_ListInfo() {
		ArrayList<TypeBean> tag_Array = new ArrayList<TypeBean>();
		String sql = "SELECT * FROM booktype";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while (rs.next()) {
						TypeBean tag = new TypeBean();
						tag.setTid(rs.getInt("tid"));
						tag.setName(rs.getString("name"));
						tag_Array.add(tag);
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "select * from booktype";
//		PreparedStatement stm = null;
//		ResultSet rs = null;
//		try {
//			stm = conn.prepareStatement(sql);
//			rs = stm.executeQuery();
//			while (rs.next()) {
//				TypeBean tag = new TypeBean();
//				tag.setTid(rs.getInt("tid"));
//				tag.setName(rs.getString("name"));
//				tag_Array.add(tag);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.CloseDB(rs, stm, conn);
//		}
		return tag_Array;
	}

	/**
	 * 修改图书分类的信息
	 * 
	 * @param tid
	 * @param name
	 */
	public void updateTypeBook(int tid, String name) {
		
		String sql = "UPDATE booktype SET name=? WHERE tid=?";
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, name);
				ps.setInt(2, tid);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "update booktype set name=? where tid=?";
//		PreparedStatement stm = null;
//		try {
//			stm = conn.prepareStatement(sql);
//			stm.setString(1, name);
//			stm.setInt(2, tid);
//			stm.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * 添加一个图书分类
	 * 
	 * @param name
	 */
	public void addBookType(String name) {
		
		String sql = "INSERT INTO booktype(name) VALUES(?)";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, name);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "insert  into booktype(name) values(?)";
//		int rs = 0;
//		PreparedStatement stm = null;
//		try {
//			stm = conn.prepareStatement(sql);
//			stm.setString(1, name);
//			;
//			rs = stm.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * 删除一个图书分类
	 * 
	 * @param tid
	 */
	public void deleteBookType(int tid) {
		String sql = "DELETE FROM booktype WHERE tid=?";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setInt(1, tid);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "delete from booktype where tid=?";
//		PreparedStatement stm = null;
//		try {
//			stm = conn.prepareStatement(sql);
//			stm.setInt(1, tid);
//			stm.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// System.out.println(uid);

	}
}
