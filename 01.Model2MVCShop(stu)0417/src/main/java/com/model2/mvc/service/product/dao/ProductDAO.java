package com.model2.mvc.service.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.model2.mvc.common.util.DBUtil;
import com.model2.mvc.service.product.vo.ProductVO;

public class ProductDAO {
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void insertProduct(ProductVO productVO){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO product VALUES(?, ?, ?, ?, ?, ?, 'sysdate')";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productVO.getProdNo());
			pstmt.setString(2, productVO.getProdName());
			pstmt.setString(3, productVO.getProdDetail());
			pstmt.setString(4, productVO.getManuDate());
			pstmt.setInt(5, productVO.getPrice());
			pstmt.setString(6, productVO.getFileName()); 
	
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
			
		}
	}
	
	public ProductVO findProduct(ProductVO findproduct){
		ProductVO findProduct = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM product WHERE prod_no = ?";
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, findproduct.getProdNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				ProductVO productVO = new ProductVO();
				productVO.setProdNo(rs.getInt("PROD_NO"));
				productVO.setProdName(rs.getString("PROD_NAME"));
				productVO.setProdDetail(rs.getString("PROD_DETAIL"));
				productVO.setManuDate(rs.getString("MANUFACTURE_DAY"));
				productVO.setPrice(rs.getInt("PRICE"));
				productVO.setFileName(rs.getString("FILENAME"));
				productVO.setRegDate(rs.getDate("REG_DATE"));
				
				findProduct = new ProductVO();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		return findproduct;
	}
	
	public void updateProduct(ProductVO productVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE product SET prod_name = ?, prod_detail = ?, manufacture_day = ?, price = ? WHERE prod_no = ?";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productVO.getProdName());
			pstmt.setString(2, productVO.getProdDetail());
			pstmt.setString(3, productVO.getManuDate());
			pstmt.setInt(4, productVO.getPrice());
			pstmt.setInt(5, productVO.getProdNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
	}

	
	public void deleteProduct(ProductVO productVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM product WHERE prod_no = ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productVO.getProdNo());
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
	}
	
	public HashMap<String, Object> getProductList(ProductVO productVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM product ORDER BY prod_no";
		ResultSet rs = null;
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		return map;
	}
}
