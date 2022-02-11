package book.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.BookService;
import book.model.dto.BookDTO;
import book.model.dto.PersonDTO;
import book.model.dto.CategoryDTO;

@WebServlet("/book")
public class BookController extends HttpServlet {
  
	public BookController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 정보에 한해서 한글인 경우에 인코딩 처리하는 설정
		//post방식으로 전송되는 데이터에 대한 한글 인코딩 처리는 잘 됨
		//get방식인 경우 server의 설정 파일에 인코딩 설정 추가 권장 - server.xml에 URIEncoding="utf-8"
		request.setCharacterEncoding("utf-8");
	
		//command pattern
		String command = request.getParameter("command");
		
		//?		
		try{
			if(command.equals("SemobookAll")){//모든 재능 기부자 검색
				SemobookAll(request, response);
			}else if(command.equals("book")){//특정 재능 기부자 정보 검색
				book(request, response);
			}else if(command.equals("bookInsert")){//재능 기부자 추가 등록
				bookInsert(request, response);
			}else if(command.equals("bookUpdateReq")){//재능 기부자 정보 수정요청
				bookUpdateReq(request, response);
			}else if(command.equals("bookUpdate")){//재능 기부자 정보 수정
				bookUpdate(request, response);
			}else if(command.equals("bookDelete")){//재능 기부자 탈퇴[삭제]
				bookDelete(request, response);
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	
	// 모든 책 검색
	private void SemobookAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("bookAll", BookService.getAllBooks());
			url = "BookList.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);	
	}
	
	//책 검색 
	public void book(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("activist", BookService.getBooks(request.getParameter("bname")));
			url = "bookDetail.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	

	//책 추가 메소드
	protected void bookInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		
		String name = request.getParameter("bname");
		String bnumber = request.getParameter("Bnumber");
		String publisher = request.getParameter("publisher");
		
		//해킹등으로 불합리하게 요청도 될수 있다는 가정하에 모든 데이터가 제대로 전송이 되었는지를 검증하는 로직
		//if(id != null && id.length() !=0 && name != null) {
			
		
		BookDTO book = new BookDTO(name, bnumber, publisher);
		try{
			boolean result = BookService.addBook(book);
			if(result){
				request.setAttribute("book", book);
				request.setAttribute("successMsg", "책 등록 완료");
				url = "bookDetail.jsp";
			}else{
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//재능 기부자 수정 요구
	public void bookUpdateReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("activist", BookService.getBooks(request.getParameter("bname")));
			url = "bookUpdate.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	
	//책 정보 수정 - 상세정보 확인 jsp[bookDetail.jsp]
	public void bookUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String bname = request.getParameter("bname");
			String Bnumber = request.getParameter("bnumber");
			String publisher = request.getParameter("publisher");
			BookService.updateBook(bname, Bnumber, publisher);
			request.setAttribute("book", BookService.getBooks(request.getParameter("bname")));
			url = "bookDetail.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//책 삭제
	public void bookDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String bname = request.getParameter("bname");
			if(BookService.deleteBook(bname)){
				request.setAttribute("activistAll", BookService.getAllBooks());
				url = "activistList.jsp";
			}else{
				request.setAttribute("errorMsg", "재 실행 해 주세요");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", "이미 책이 등록되어 있습니다");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}