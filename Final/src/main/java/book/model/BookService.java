package book.model;

import java.sql.SQLException;
import java.util.ArrayList;

import book.Exception.MessageException;
import book.Exception.NotExistException;
import book.model.dto.BookDTO;
import book.model.dto.CategoryDTO;
import book.model.dto.PersonDTO;

public class BookService {

	//Book - CRUD
	public static void notExistBook(String bname) throws NotExistException, SQLException{
		BookDTO book = BookDAO.getBook(bname);
		if(book == null){
			throw new NotExistException("검색하신 책 정보가 없습니다.");
		}
	}
	
	//모든 book 정보 반환
	public static ArrayList<BookDTO> getAllBooks() throws SQLException{
		return BookDAO.getAllBooks();
	}
	//book 이름으로 검색
	public static BookDTO getBooks(String bname) throws SQLException, NotExistException{
		BookDTO book = BookDAO.getBook(bname);
		if(book == null){
			throw new NotExistException("검색하신 책 정보가 없습니다.");
		}
		return book;
	}
	//새로운 book 저장
	public static boolean addBook(BookDTO book) throws SQLException, MessageException{
		boolean result = false;
		try{
			result = BookDAO.addBook(book);
		}catch(SQLException s){
			throw new MessageException("이미 존재하는 책입니다 다시 시도 하세요");
		}
		return result;
	}
	//기존 책정보 수정
	public static boolean updateBook(String bname, String bnumber, String publisher) throws SQLException, NotExistException{
		notExistPerson(bnumber);
		boolean result = BookDAO.updateBook(bname, bnumber, publisher);
		if(!result){
			throw new NotExistException("책 정보 갱신 실패");
		}
		return result;
	}
	//책정보 삭제
	public static boolean deleteBook(String bname) throws SQLException, NotExistException{
		notExistBook(bname);
		boolean result = BookDAO.deleteBook(bname);
		if(!result){
			throw new NotExistException("책 정보 삭제 실패");
		}
		return result;
	}
		
	
	
	//Person - CRUD
	public static void notExistPerson(String Pid) throws NotExistException, SQLException{
		PersonDTO person = PersonDAO.getPerson(Pid);
		if(person == null){
			throw new NotExistException("검색하는 고객이 미 존재합니다.");
		}
	}
	
	public static boolean addPerson(PersonDTO person) throws MessageException{
		boolean result = false;
		try{
			result = PersonDAO.addPerson(person);
		}catch(SQLException s){
			throw new MessageException("이미 존재하는 ID입니다 다시 시도 하세요");
		}
		return result;
	}
	
	//대여자 수정 메소드[PersonDAO의 updatePerson()]
	public static boolean updatePerson(String personId, String interest) throws SQLException, NotExistException{		
		notExistPerson(personId);
		boolean result = PersonDAO.updatePerson(personId, interest);
		if(!result){
			throw new NotExistException("고객 관심분야 정보 갱신 실패");
		}
		return result;
	}
	
	
	//고객 삭제 메소드[ PersonDAO.deletePerson()]
	public static boolean deletePerson(String personId) throws SQLException, NotExistException{
		notExistPerson(personId);
		boolean result = PersonDAO.deletePerson(personId);
		if(!result){
			throw new NotExistException("고객 정보 삭제 실패");
		}
		return result;
	}
	
	public static PersonDTO getPerson(String personId) throws SQLException, NotExistException{
		PersonDTO person = PersonDAO.getPerson(personId);
		if(person == null){
			throw new NotExistException("검색하는 고객이 미 존재합니다.");
		}
		return person;
	}
	
	public static ArrayList<PersonDTO> getAllPerson() throws SQLException{
		return PersonDAO.getAllPerson();
	}
	
	//Category - CRUD
	public static void notExistCategory(String CName) throws NotExistException, SQLException{
		CategoryDTO probono = CategoryDAO.getCategory(CName);
		if(probono == null){
			throw new NotExistException("검색하신 카테고리가 없습니다.");
		}
	}
	
	//모든 Category 정보 반환
	public static ArrayList<CategoryDTO> getAllCategories() throws SQLException{
		return CategoryDAO.getAllCategories();
	}
	
	//Category id로 검색
	public static CategoryDTO getCategory(String CName) throws SQLException, NotExistException{
		CategoryDTO probono = CategoryDAO.getCategory(CName);
		if(probono == null){
			throw new NotExistException("검색하신 카테고리 정보가 없습니다.");
		}
		return probono;
	}
	//새로운 Category 저장
	public static boolean addCategory(CategoryDTO category) throws SQLException, MessageException{
		boolean result = false;
		try{
			result = CategoryDAO.addCategory(category);
		}catch(SQLException s){
			throw new MessageException("이미 존재하는 카테고리입니다 다시 시도 하세요");
		}
		return result;
	}
	//기존 Category 수정
	public static boolean updateCategory(String CNumber, String CName) throws SQLException, NotExistException{
		notExistCategory(CNumber);
		boolean result = CategoryDAO.updateCategory(CNumber, CName);
		if(!result){
			throw new NotExistException("카테고리 갱신 실패");
		}
		return result;
	}
	//Category 삭제
	public boolean deleteCategory(String CName) throws SQLException, NotExistException{
		notExistCategory(CName);
		boolean result = CategoryDAO.deleteCategory(CName);
		if(!result){
			throw new NotExistException("카테고리 정보 삭제 실패");
		}
		return result;
	}		
		
}
