/*
CREATE TABLE SemobookProjcet (
	   Semobook     		VARCHAR2(50) PRIMARY KEY,
	   bname 		VARCHAR2(50) NOT NULL,
       PId           			VARCHAR2(50) NOT NULL,       
       Cname          				VARCHAR2(50) NOT NULL,
);   */
package book.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.model.dto.SemobookDTO;
import book.model.util.DBUtil;

public class SemobookDAO {
	
	//프로보노 프로젝트 저장
	public static boolean addSemobook(SemobookDTO Semobook) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into SemobookProjcet values(Semobook_seq.nextval,?, ?, ?, ?)");
			pstmt.setString(1, Semobook.getSemobook());
			pstmt.setString(2, Semobook.getBname());
			pstmt.setString(3, Semobook.getPId());
			pstmt.setString(4, Semobook.getCname());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//수정
	public static boolean updateSemobookBname(String Semobook, String Bname) throws SQLException{		
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement("update SemobookProjcet set bname=? where Semobook=?");
			pstmt.setString(1, Bname);
			pstmt.setString(2, Semobook);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//수정
	//프로보노 프로젝트 id로 수해자 정보 변경
	public static boolean updateSemobookPerson(String Semobook, String  PId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement("update SemobookProjcet set PId=? where Semobook=?");
			pstmt.setString(1, PId);
			pstmt.setString(2, Semobook);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	
	//삭제 
	//프로보노 프로젝트 id로 프로보노 프로젝트 삭제
	public static boolean deleteSemobook(String Semobook) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from SemobookProjcet where Semobook=?");
			pstmt.setString(1, Semobook);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//프로보노 프로젝트 id로 해당 프로보노프로젝트 검색
	public static SemobookDTO getSemobook(String Semobook) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SemobookDTO SemobookUser = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from SemobookProjcet where Semobook=?");
			pstmt.setString(1, Semobook);
			rset = pstmt.executeQuery();
			if(rset.next()){
				SemobookUser = new SemobookDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return SemobookUser;
	}
	
	//모든 프로보노 프로젝트 검색 
	public static ArrayList<SemobookDTO> getAllSemobook() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SemobookDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from SemobookProjcet");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<SemobookDTO>();
			while(rset.next()){
				list.add( new SemobookDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}