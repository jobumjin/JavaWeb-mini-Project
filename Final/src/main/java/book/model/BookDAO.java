/*
 * CREATE TABLE book (
       bname           	VARCHAR2(50) PRIMARY KEY,
       Bnumber     	VARCHAR2(50) NOT NULL,
       publisher VARCHAR2(50) NOT NULL
);  */
package book.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.model.dto.BookDTO;
import book.model.util.DBUtil;

public class BookDAO {	
	
	//저장
	public static boolean addBook(BookDTO book) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into book values(?, ?, ?)");
			pstmt.setString(1, book.getbname());
			pstmt.setString(2, book.getBnumber());
			pstmt.setString(3, book.getPublisher());
			
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
	//책 넘버로 책 이름과 출판사 수정하기
	public static boolean updateBook(String bname, String bnumber, String publisher) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update book set bname=?, set publisher=? where Bnumber=?");
			pstmt.setString(1, bname);
			pstmt.setString(2, publisher);
			pstmt.setString(3, bnumber);
			
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
	public static boolean deleteBook(String bnumber) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from book where Bnumber=?");
			pstmt.setString(1, bnumber);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//책넘버로 해당 책 모든 정보 검색
	public static BookDTO getBook(String bnumber) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BookDTO probono = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from book where Bnumber=?");
			pstmt.setString(1, bnumber);
			rset = pstmt.executeQuery();
			if(rset.next()){
				probono = new BookDTO(rset.getString(1), rset.getString(2), rset.getString(3));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return probono;
	}

	//모든 책 검색
	public static ArrayList<BookDTO> getAllBooks() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BookDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from book");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<BookDTO>();
			while(rset.next()){
				list.add(new BookDTO(rset.getString(1), rset.getString(2), rset.getString(3)) );
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
