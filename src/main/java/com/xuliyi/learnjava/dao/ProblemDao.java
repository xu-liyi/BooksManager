package com.xuliyi.learnjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xuliyi.learnjava.bean.AdminBean;
import com.xuliyi.learnjava.bean.ProblemBean;
import com.xuliyi.learnjava.util.DBUtil;

public class ProblemDao {
	/**
	 * 获取所有反馈问题的信息，返回数组形式
	 * 
	 * @return
	 */
	public ArrayList<ProblemBean> get_ListInfo() {
		ArrayList<ProblemBean> tag_Array = new ArrayList<ProblemBean>();
		
		String sql = "SELECT * FROM problem";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while (rs.next()) {
						ProblemBean tag = new ProblemBean();
						tag.setPid(rs.getInt("pid"));
						tag.setAid(rs.getInt("aid"));
						tag.setName(rs.getString("name"));
						tag.setPage(rs.getString("page"));
						tag.setBody(rs.getString("body"));
						tag.setPhone(rs.getString("phone"));
						tag.setStatus(rs.getString("status"));
						tag_Array.add(tag);
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "select * from problem";
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				ProblemBean tag = new ProblemBean();
//				tag.setPid(rs.getInt("pid"));
//				tag.setAid(rs.getInt("aid"));
//				tag.setName(rs.getString("name"));
//				tag.setPage(rs.getString("page"));
//				tag.setBody(rs.getString("body"));
//				tag.setPhone(rs.getString("phone"));
//				tag.setStatus(rs.getString("status"));
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
	 * 获取所有反馈问题的信息，返回数组形式
	 * 
	 * @return
	 */
	public ArrayList<ProblemBean> get_ListInfo2(String aid) {
		ArrayList<ProblemBean> tag_Array = new ArrayList<ProblemBean>();
		
		String sql = "SELECT * FROM problem WHERE aid=?";
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setObject(1, aid);
				try(ResultSet rs = ps.executeQuery()){
					while (rs.next()) {
						ProblemBean tag = new ProblemBean();
						tag.setPid(rs.getInt("pid"));
						tag.setAid(rs.getInt("aid"));
						tag.setName(rs.getString("name"));
						tag.setPage(rs.getString("page"));
						tag.setBody(rs.getString("body"));
						tag.setPhone(rs.getString("phone"));
						tag.setStatus(rs.getString("status"));
						tag_Array.add(tag);
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "select * from problem where aid=" + aid;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				ProblemBean tag = new ProblemBean();
//				tag.setPid(rs.getInt("pid"));
//				tag.setAid(rs.getInt("aid"));
//				tag.setName(rs.getString("name"));
//				tag.setPage(rs.getString("page"));
//				tag.setBody(rs.getString("body"));
//				tag.setPhone(rs.getString("phone"));
//				tag.setStatus(rs.getString("status"));
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
	 * 添加一个反馈问题
	 * 
	 * @param adminbean
	 * @param name
	 * @param page
	 * @param body
	 * @param phone
	 */
	public void addProblem(AdminBean adminbean, String name, String page, String body, String phone) {
		String sql = "INSERT INTO problem(aid,name,page,body,phone) VALUE(?,?,?,?,?)";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setInt(1, adminbean.getAid());
				ps.setString(2, name);
				ps.setString(3, page);
				ps.setString(4, body);
				ps.setString(5, phone);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "insert into problem(aid,name,page,body,phone) values(?,?,?,?,?)";
//		int rs = 0;
//		PreparedStatement ps = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, adminbean.getAid());
//			ps.setString(2, name);
//			ps.setString(3, page);
//			ps.setString(4, body);
//			ps.setString(5, phone);
//			rs = ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * 删除一个反馈问题
	 * 
	 * @param pid
	 */
	public void deleteProblem(int pid) {
		String sql = "DELETE FROM problem WHERE pid=?";
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setObject(1, pid);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "delete from problem where pid=?";
//		PreparedStatement ps = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, pid);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * 修改反馈问题的状态
	 * 
	 * @param pid
	 * @param status
	 */
	public void updateProblem(int pid, String status) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnectDb();
		String sql = "update problem set status=? where pid=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, status);
			ps.setInt(2, pid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 查找反馈问题，根据输入的名称，使用like进行模糊查询，然后返回一个ArrayList数组类型
	 * 
	 * @param name
	 * @return
	 */
	public ArrayList<ProblemBean> getLikeList(String name) {
		// TODO Auto-generated method stub
		ArrayList<ProblemBean> tag_Array = new ArrayList<ProblemBean>();
		String sql = "SELECT * FROM problem WHERE name LIKE ? OR page LIKE ? OR body LIKE ? OR body LIKE ? OR status LIKE ?";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setObject(1, "%"+name+"%");
				ps.setObject(2, "%"+name+"%");
				ps.setObject(3, "%"+name+"%");
				ps.setObject(4, "%"+name+"%");
				ps.setObject(5, "%"+name+"%");
				try(ResultSet rs = ps.executeQuery()){
					while (rs.next()) {
						ProblemBean tag = new ProblemBean();
						tag.setPid(rs.getInt("pid"));
						tag.setAid(rs.getInt("aid"));
						tag.setName(rs.getString("name"));
						tag.setPage(rs.getString("page"));
						tag.setBody(rs.getString("body"));
						tag.setPhone(rs.getString("phone"));
						tag.setStatus(rs.getString("status"));
						tag_Array.add(tag);
					}
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "select * from problem where name like '%" + name + "%' or page like '%" + name
//				+ "%' or body like '%" + name + "%' or status like '%" + name + "%'";
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				ProblemBean tag = new ProblemBean();
//				tag.setPid(rs.getInt("pid"));
//				tag.setAid(rs.getInt("aid"));
//				tag.setName(rs.getString("name"));
//				tag.setPage(rs.getString("page"));
//				tag.setBody(rs.getString("body"));
//				tag.setPhone(rs.getString("phone"));
//				tag.setStatus(rs.getString("status"));
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
}
