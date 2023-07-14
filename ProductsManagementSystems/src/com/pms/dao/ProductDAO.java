package com.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pms.pojo.Product;
import com.pms.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.pms.pojo.Product;
import com.pms.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.pms.pojo.Product;
import com.pms.util.DBUtil;

public class ProductDAO {
	Connection conn = DBUtil.getDBConnection();

	public int addPro(Product pro) {
		String insertQuery = "insert into  product values(?,?,?,?)";
		int count = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);
			pstmt.setInt(1, pro.getPid());
			pstmt.setString(2, pro.getPname());
			pstmt.setDouble(3, pro.getPrice());
			pstmt.setString(4, pro.getDom());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updatePro(Product pro) {

		String UpdateQuery = "update product set pname = ?,price = ?,dom = ? where pid = ?";
		int count = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(UpdateQuery);
			pstmt.setString(1, pro.getPname());
			pstmt.setDouble(2, pro.getPrice());
			pstmt.setString(3, pro.getDom());
			pstmt.setInt(4, pro.getPid());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public Product getProById(int pid) {
		String selectQuery = "select * from product where pid= ? ";
		Product pro = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectQuery);
			pstmt.setInt(1, pid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int pid1 = rs.getInt("pid");
				String pname1 = rs.getString("pname");
				double price1 = rs.getDouble("price");
				String dom1 = rs.getString("dom");
				pro = new Product();
				pro.setPid(pid1);
				pro.setPname(pname1);
				pro.setPrice(price1);
				pro.setDom(dom1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pro;

	}

	public int deleteProById(int pid) {

		String deleteQuery = "delete from  product where pid = ? ";
		int count = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
			pstmt.setInt(1, pid);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<Product> getAll() {
		String selectQuery = "select*from product ";
		List<Product> list = new ArrayList<Product>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("pid");
				String pname = rs.getString("Pname");
				double price = rs.getDouble("price");
				String dom = rs.getString("dom");
				Product pro = new Product();
				list.add(pro);
				pro.setPid(pid);
				pro.setPname(pname);
				pro.setPrice(price);
				pro.setDom(dom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}