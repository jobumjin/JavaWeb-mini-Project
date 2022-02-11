/* CREATE TABLE Category (
       CName           	VARCHAR2(50) PRIMARY KEY,
       CNumber     	VARCHAR2(50) NOT NULL,
);
 * 
 */
package book.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.model.dto.CategoryDTO;
import book.model.util.DBUtil;

public class CategoryDAO {

	public static boolean addCategory(CategoryDTO category) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into category values(?, ?)");
			pstmt.setString(1, category.getCName());
			pstmt.setString(2, category.getCNumber());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static boolean updateCategory(String cNumber, String cName) throws SQLException{		
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update category set cName=? where cNumber=?");
			pstmt.setString(1, cName );
			pstmt.setString(2, cNumber);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static boolean deleteCategory(String cNumber) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from category where cNumber=?");
			pstmt.setString(1, cNumber);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static CategoryDTO getCategory(String cNumber) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CategoryDTO category = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from category where cNumber=?");
			pstmt.setString(1, cNumber);
			rset = pstmt.executeQuery();
			if(rset.next()){
				category = new CategoryDTO(rset.getString(1), rset.getString(2));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return category;
	}	
	
	public static ArrayList<CategoryDTO> getAllCategories() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CategoryDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from category");				rset = pstmt.executeQuery();
			
		list = new ArrayList<CategoryDTO>();			
		while(rset.next()){
			list.add(new CategoryDTO(rset.getString(1), rset.getString(2)) );				}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}