package com.xuliyi.learnjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xuliyi.learnjava.bean.AdminBean;
import com.xuliyi.learnjava.bean.BookBean;
import com.xuliyi.learnjava.util.DBUtil;

/**
 * 有关读者账号的连接数据库操作，登录验证，注册，修改账号，修改密码
 */
public class AdminDao {

	/**
	 * 登录验证功能，传入用户名和密码，在数据库中查找，如果找到了，返回true，没找到则返回false
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean Login_verify(String username, String password) {
		//禁用字符串拼接，容易出现SQL注入问题
		//String sql = "select * from admin where username='" + username + " 'and password='" + password + "'";
		//SQL查询语句，使用占位符来避免SQL注入
		String sql = "SELECT * FROM admin WHERE username=? AND password=? ";
		
		//使用JDBC进行数据库查找，这里使用try-with-resource来自动释放资源
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setObject(1, username);
				ps.setObject(2, password);
				try(ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
						return true;
					}
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			if (rs.next()) {
//				return true;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.CloseDB(rs, ps, conn);
//		}
		
		return false;
	}

	/**
	 * 注册账号的函数，传入账号，密码，姓名，邮箱，手机号，借阅天数，可借阅数
	 * 
	 * @param username
	 * @param password
	 * @param name
	 * @param email
	 * @param phone
	 * @param times
	 * @param lend_num
	 * @param max_num
	 */
	public void Register(String username, String password, String name, String email, String phone, int lend_num,
			int max_num) {
		String sql = "INSERT INTO admin(status,username,password,name,email,phone,lend_num,max_num) VALUES(?,?,?,?,?,?,?,?)";
		
		
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setObject(1, 1);
				ps.setObject(2, username);
				ps.setObject(3, password);
				ps.setObject(4, name);
				ps.setObject(5, email);
				ps.setObject(6, phone);
				ps.setObject(7, lend_num);
				ps.setObject(8, max_num);
				int rs = ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		int rs = 0;
//		PreparedStatement ps = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, 1);
//			ps.setString(2, username);
//			ps.setString(3, password);
//			ps.setString(4, name);
//			ps.setString(5, email);
//			ps.setString(6, phone);
//			ps.setInt(7, lend_num);
//			ps.setInt(8, max_num);
//			rs = ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	/**
	 * 新增管理员账号，传入账号，密码，姓名，邮箱，手机号
	 * 
	 * @param username
	 * @param password
	 * @param name
	 * @param email
	 * @param phone
	 * @param times
	 * @param lend_num
	 * @param max_num
	 */
	public void Register_Admin(String username, String password, String name, String email, String phone) {
		
		String sql = "INSERT INTO admin(status,username,password,name,email,phone) VALUES(?,?,?,?,?,?)";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setInt(1, 2);
				ps.setString(2, username);
				ps.setString(3, password);
				ps.setString(4, name);
				ps.setString(5, email);
				ps.setString(6, phone);
				int rs = ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		int rs = 0;
//		PreparedStatement ps = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, 2);
//			ps.setString(2, username);
//			ps.setString(3, password);
//			ps.setString(4, name);
//			ps.setString(5, email);
//			ps.setString(6, phone);
//			rs = ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	/**
	 * 根据传入的账号，密码，来查找对应的读者信息，返回一个AdminBean类型，
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public AdminBean getAdminInfo(String username, String password) {
		
		//String sql = "SELECT * FROM admin WHERE username= '"+username+"' AND password= '"+password+"'";
		String sql = "SELECT * FROM admin WHERE username=? AND password=?";
		AdminBean adminbean = new AdminBean();
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setObject(1, username);
				ps.setObject(2, password);
				try(ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
						adminbean.setAid(rs.getInt("aid"));
						adminbean.setUsername(rs.getString("username"));
						adminbean.setName(rs.getString("name"));
						adminbean.setPassword(rs.getString("password"));
						adminbean.setEmail(rs.getString("email"));
						adminbean.setPhone(rs.getString("phone"));
						adminbean.setTimes(rs.getInt("times"));
						adminbean.setStatus(rs.getInt("status"));
						adminbean.setLend_num(rs.getInt("lend_num"));
						adminbean.setMax_num(rs.getInt("max_num"));
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Connection conn = DBUtil.getConnectDb();
//		
//		
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			if (rs.next()) {
//				adminbean.setAid(rs.getInt("aid"));
//				adminbean.setUsername(rs.getString("username"));
//				adminbean.setName(rs.getString("name"));
//				adminbean.setPassword(rs.getString("password"));
//				adminbean.setEmail(rs.getString("email"));
//				adminbean.setPhone(rs.getString("phone"));
//				adminbean.setTimes(rs.getInt("times"));
//				adminbean.setStatus(rs.getInt("status"));
//				adminbean.setLend_num(rs.getInt("lend_num"));
//				adminbean.setMax_num(rs.getInt("max_num"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.CloseDB(rs, ps, conn);
//		}
		
		return adminbean;
	}

	/**
	 * 获取全部用户的信息，其中sql语句中的status=1，表示只查找读者，不显示管理员的
	 * 
	 * @return
	 */
	public ArrayList<AdminBean> get_ListInfo() {
		ArrayList<AdminBean> tag_Array = new ArrayList<AdminBean>();
		String sql = "SELECT * FROM admin WHERE status=1";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						AdminBean adminbean = new AdminBean();
						adminbean.setAid(rs.getInt("aid"));
						adminbean.setUsername(rs.getString("username"));
						adminbean.setName(rs.getString("name"));
						adminbean.setPassword(rs.getString("password"));
						adminbean.setEmail(rs.getString("email"));
						adminbean.setPhone(rs.getString("phone"));
						adminbean.setTimes(rs.getInt("times"));
						adminbean.setStatus(rs.getInt("status"));
						adminbean.setLend_num(rs.getInt("lend_num"));
						adminbean.setMax_num(rs.getInt("max_num"));
						tag_Array.add(adminbean);
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				AdminBean adminbean = new AdminBean();
//				adminbean.setAid(rs.getInt("aid"));
//				adminbean.setUsername(rs.getString("username"));
//				adminbean.setName(rs.getString("name"));
//				adminbean.setPassword(rs.getString("password"));
//				adminbean.setEmail(rs.getString("email"));
//				adminbean.setPhone(rs.getString("phone"));
//				adminbean.setTimes(rs.getInt("times"));
//				adminbean.setStatus(rs.getInt("status"));
//				adminbean.setLend_num(rs.getInt("lend_num"));
//				adminbean.setMax_num(rs.getInt("max_num"));
//				tag_Array.add(adminbean);
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.CloseDB(rs, ps, conn);
//		}
		return tag_Array;
	}

	/**
	 * 获取全部用户的信息，其中sql语句中的status=2，表示只查找管理员，不显示读者的
	 * 
	 * @return
	 */
	public ArrayList<AdminBean> get_ListInfo2() {
		ArrayList<AdminBean> tag_Array = new ArrayList<AdminBean>();
		String sql = "SELECT * FROM admin WHERE status=2";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						AdminBean adminbean = new AdminBean();
						adminbean.setAid(rs.getInt("aid"));
						adminbean.setUsername(rs.getString("username"));
						adminbean.setName(rs.getString("name"));
						adminbean.setPassword(rs.getString("password"));
						adminbean.setEmail(rs.getString("email"));
						adminbean.setPhone(rs.getString("phone"));
						adminbean.setTimes(rs.getInt("times"));
						adminbean.setStatus(rs.getInt("status"));
						tag_Array.add(adminbean);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				AdminBean adminbean = new AdminBean();
//				adminbean.setAid(rs.getInt("aid"));
//				adminbean.setUsername(rs.getString("username"));
//				adminbean.setName(rs.getString("name"));
//				adminbean.setPassword(rs.getString("password"));
//				adminbean.setEmail(rs.getString("email"));
//				adminbean.setPhone(rs.getString("phone"));
//				adminbean.setTimes(rs.getInt("times"));
//				adminbean.setStatus(rs.getInt("status"));
//				tag_Array.add(adminbean);
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.CloseDB(rs, ps, conn);
//		}
		
		return tag_Array;
	}
	/**
	 * 获取全部用户的信息并排序，其中sql语句中的status=1，表示只查找读者，不显示管理员的
	 * 
	 * @return
	 */
	public ArrayList<AdminBean> get_ListInfo3() {
		ArrayList<AdminBean> tag_Array = new ArrayList<AdminBean>();
		String sql = "SELECT * FROM admin WHERE status=1 ORDER BY times DESC";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						AdminBean adminbean = new AdminBean();
						adminbean.setAid(rs.getInt("aid"));
						adminbean.setUsername(rs.getString("username"));
						adminbean.setName(rs.getString("name"));
						adminbean.setPassword(rs.getString("password"));
						adminbean.setEmail(rs.getString("email"));
						adminbean.setPhone(rs.getString("phone"));
						adminbean.setTimes(rs.getInt("times"));
						adminbean.setStatus(rs.getInt("status"));
						adminbean.setLend_num(rs.getInt("lend_num"));
						adminbean.setMax_num(rs.getInt("max_num"));
						tag_Array.add(adminbean);
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				AdminBean adminbean = new AdminBean();
//				adminbean.setAid(rs.getInt("aid"));
//				adminbean.setUsername(rs.getString("username"));
//				adminbean.setName(rs.getString("name"));
//				adminbean.setPassword(rs.getString("password"));
//				adminbean.setEmail(rs.getString("email"));
//				adminbean.setPhone(rs.getString("phone"));
//				adminbean.setTimes(rs.getInt("times"));
//				adminbean.setStatus(rs.getInt("status"));
//				adminbean.setLend_num(rs.getInt("lend_num"));
//				adminbean.setMax_num(rs.getInt("max_num"));
//				tag_Array.add(adminbean);
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.CloseDB(rs, ps, conn);
//		}
		return tag_Array;
	}

	/**
	 * 根据传入的aid，查找到对应的读者的全部信息，返回一个AdminBean类型的数据
	 * 
	 * @param aid
	 * @return
	 */
	public AdminBean get_AidInfo(int aid) {
		AdminBean adminbean = new AdminBean();
		String sql = "SELECT * FROM admin WHERE aid=?";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setObject(1, aid);
				try(ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
						adminbean.setAid(rs.getInt("aid"));
						adminbean.setUsername(rs.getString("username"));
						adminbean.setName(rs.getString("name"));
						adminbean.setPassword(rs.getString("password"));
						adminbean.setEmail(rs.getString("email"));
						adminbean.setPhone(rs.getString("phone"));
						adminbean.setTimes(rs.getInt("times"));
						adminbean.setStatus(rs.getInt("status"));
						adminbean.setLend_num(rs.getInt("lend_num"));
						adminbean.setMax_num(rs.getInt("max_num"));
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "select * from admin where aid=" + aid;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			if (rs.next()) {
//				adminbean.setAid(rs.getInt("aid"));
//				adminbean.setUsername(rs.getString("username"));
//				adminbean.setName(rs.getString("name"));
//				adminbean.setPassword(rs.getString("password"));
//				adminbean.setEmail(rs.getString("email"));
//				adminbean.setPhone(rs.getString("phone"));
//				adminbean.setTimes(rs.getInt("times"));
//				adminbean.setStatus(rs.getInt("status"));
//				adminbean.setLend_num(rs.getInt("lend_num"));
//				adminbean.setMax_num(rs.getInt("max_num"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.CloseDB(rs, ps, conn);
//		}
		return adminbean;
	}

	/**
	 * 根据传入的aid，查找到对应的读者的全部信息，返回一个AdminBean类型的数据，与上一个相似，只是aid的类型为String
	 * 
	 * @param aid
	 * @return
	 */
	public AdminBean get_AidInfo2(String aid) {
		AdminBean adminbean = new AdminBean();
		String sql = "SELECT * FROM admin WHERE aid=?";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setObject(1, aid);
				try(ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
						adminbean.setAid(rs.getInt("aid"));
						adminbean.setUsername(rs.getString("username"));
						adminbean.setName(rs.getString("name"));
						adminbean.setPassword(rs.getString("password"));
						adminbean.setEmail(rs.getString("email"));
						adminbean.setPhone(rs.getString("phone"));
						adminbean.setTimes(rs.getInt("times"));
						adminbean.setStatus(rs.getInt("status"));
						adminbean.setLend_num(rs.getInt("lend_num"));
						adminbean.setMax_num(rs.getInt("max_num"));
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "select * from admin where aid=" + aid;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			if (rs.next()) {
//				adminbean.setAid(rs.getInt("aid"));
//				adminbean.setUsername(rs.getString("username"));
//				adminbean.setName(rs.getString("name"));
//				adminbean.setPassword(rs.getString("password"));
//				adminbean.setEmail(rs.getString("email"));
//				adminbean.setPhone(rs.getString("phone"));
//				adminbean.setTimes(rs.getInt("times"));
//				adminbean.setStatus(rs.getInt("status"));
//				adminbean.setLend_num(rs.getInt("lend_num"));
//				adminbean.setMax_num(rs.getInt("max_num"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.CloseDB(rs, ps, conn);
//		}
		return adminbean;
	}

	/**
	 * 修改读者的信息
	 */
	public void updateUser(int aid, String username, String password, String name, String email, String phone,
			int lend_num, int max_num) {
		String sql = "UPDATE admin SET username=?,name=?,email=?,phone=?,password=?,lend_num=?,max_num=? WHERE aid=?";
//		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, username);
				ps.setString(2, name);
				ps.setString(3, email);
				ps.setString(4, phone);
				ps.setString(5, password);
				ps.setInt(6, lend_num);
				ps.setInt(7, max_num);
				ps.setInt(8, aid);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Connection conn = DBUtil.getConnectDb();
//		String sql = "update admin set username=?,name=?,email=?,phone=?,password=?,lend_num=?,max_num=? where aid=?";
//		PreparedStatement ps = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, username);
//			ps.setString(2, name);
//			ps.setString(3, email);
//			ps.setString(4, phone);
//			ps.setString(5, password);
//			ps.setInt(6, lend_num);
//			ps.setInt(7, max_num);
//			ps.setInt(8, aid);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * 修改管理员的信息
	 */
	public void updateAdmin(int aid, String username, String password, String name, String email, String phone) {
		// TODO Auto-generated method stub
		String sql = "UPDATE admin SET username=?,name=?,email=?,phone=?,password=? WHERE aid=?";
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1, username);
				ps.setString(2, name);
				ps.setString(3, email);
				ps.setString(4, phone);
				ps.setString(5, password);
				ps.setInt(6, aid);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "update admin set username=?,name=?,email=?,phone=?,password=? where aid=?";
//		PreparedStatement ps = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, username);
//			ps.setString(2, name);
//			ps.setString(3, email);
//			ps.setString(4, phone);
//			ps.setString(5, password);
//			ps.setInt(6, aid);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * 删除用户的信息，根据传入的aid作为条件
	 * 
	 * @param aid
	 */
	public void deleteUser(int aid) {
		
		String sql = "DELETE FROM admin WHERE aid=?";
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setObject(1, aid);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "delete from admin where aid=?";
//		PreparedStatement ps = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, aid);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * 删除管理员的信息，根据传入的aid作为条件
	 * 
	 * @param aid
	 */
	public void deleteAdmin(int aid) {
		
		String sql = "DELETE FROM admin WHERE aid=?";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setObject(1, aid);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "delete from admin where aid=?";
//		PreparedStatement ps = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, aid);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	/**
	 * 查找用户，根据输入的名称，使用like进行模糊查询，然后返回一个ArrayList数组类型
	 * 
	 * @param name
	 * @return
	 */
	public ArrayList<AdminBean> getLikeList(String name) {
		// TODO Auto-generated method stub
		ArrayList<AdminBean> tag_Array = new ArrayList<AdminBean>();
		String sql = "SELECT * FROM admin WHERE name like %?% OR username like %?% OR aid like %?%";
		
		try(Connection conn = DBUtil.getConnectDb()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setObject(1, name);
				ps.setObject(2, name);
				ps.setObject(3, name);
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						AdminBean tag = new AdminBean();
						tag.setAid(rs.getInt("aid"));
						tag.setStatus(rs.getInt("status"));
						tag.setUsername(rs.getString("username"));
						tag.setName(rs.getString("name"));
						tag.setPassword(rs.getString("password"));
						tag.setEmail(rs.getString("email"));
						tag.setPhone(rs.getString("phone"));
						tag.setTimes(rs.getInt("times"));
						tag.setLend_num(rs.getInt("lend_num"));
						tag.setMax_num(rs.getInt("max_num"));
						tag_Array.add(tag);
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		Connection conn = DBUtil.getConnectDb();
//		String sql = "select * from admin where name like '%" + name + "%' or username like '%" + name + "%' or aid like '%" + name + "%'";
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				AdminBean tag = new AdminBean();
//				tag.setAid(rs.getInt("aid"));
//				tag.setStatus(rs.getInt("status"));
//				tag.setUsername(rs.getString("username"));
//				tag.setName(rs.getString("name"));
//				tag.setPassword(rs.getString("password"));
//				tag.setEmail(rs.getString("email"));
//				tag.setPhone(rs.getString("phone"));
//				tag.setTimes(rs.getInt("times"));
//				tag.setLend_num(rs.getInt("lend_num"));
//				tag.setMax_num(rs.getInt("max_num"));
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
