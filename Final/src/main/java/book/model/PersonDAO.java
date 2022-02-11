/* CREATE TABLE person (
       pid       VARCHAR2(20)  PRIMARY KEY,
       pname               VARCHAR2(20) NULL,
       password             VARCHAR2(20) NULL,
       interest           VARCHAR2(50) NULL
);  */
package book.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.model.dto.PersonDTO;
import book.model.util.DBUtil;

public class PersonDAO {
	
		public static boolean addPerson(PersonDTO person) throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			try{
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("insert into person values(?, ?, ?, ?)");
				pstmt.setString(1, person.getPid());
				pstmt.setString(2, person.getPname());
				pstmt.setString(3, person.getPassword());
				pstmt.setString(4, person.getInterest());
				
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
		//기부자 id로 주요 기부 내용 수정하기
		public static boolean updatePerson(String personId, String interest) throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			try{
				con = DBUtil.getConnection();
				
				pstmt = con.prepareStatement("update person set interest=? where Pid=?");
				pstmt.setString(1, interest);
				pstmt.setString(2, personId);
				
				int result = pstmt.executeUpdate();
				if(result == 1){
					return true;
				}
			}finally{
				DBUtil.close(con, pstmt);
			}
			return false;
		}

	
		//??? 삭제
		//sql - delete from activist where activist_id=?
		public static boolean deletePerson(String personId) throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			try{
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("delete from person where Pid=?");
				pstmt.setString(1, personId);
				int result = pstmt.executeUpdate();
				if(result == 1){
					return true;
				}
			}finally{
				DBUtil.close(con, pstmt);
			}
			return false;
		}
	
		//id로 해당 기부자의 모든 정보 반환
		public static PersonDTO getPerson(String personId) throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			PersonDTO activist = null;
			
			try{
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from person where Pid=?");
				pstmt.setString(1, personId);
				rset = pstmt.executeQuery();
				if(rset.next()){
					activist = new PersonDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
				}
			}finally{
				DBUtil.close(con, pstmt, rset);
			}
			return activist;
		}

		//???모든 기부자 검색해서 반환
		public static ArrayList<PersonDTO> getAllPerson() throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<PersonDTO> list = null;
			try{
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from person");
				rset = pstmt.executeQuery();
				
				list = new ArrayList<PersonDTO>();
				while(rset.next()){
					list.add(new PersonDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)) );
				}
			}finally{
				DBUtil.close(con, pstmt, rset);
			}
			return list;
		}
}
