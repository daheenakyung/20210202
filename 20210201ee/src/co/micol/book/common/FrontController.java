package co.micol.book.common;

import java.io.IOException;

import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.web.BookInsert;
import co.micol.book.web.BookUpdate;
import co.micol.book.web.BookUpdateForm;
import co.micol.book.web.DownCount;
import co.micol.book.web.BookDelete;
import co.micol.book.web.BookForm;
import co.micol.book.web.InsertForm;
import co.micol.book.web.UpCount;
import co.micol.mem.web.MemDelete;
import co.micol.mem.web.MemInsert;
import co.micol.mem.web.MemList;
import co.micol.mem.web.MemUpForm;
import co.micol.mem.web.MemUpdate;
import co.micol.mem.web.MeminForm;
import co.micol.member.web.JoinForm;
import co.micol.member.web.Login;
import co.micol.member.web.LoginForm;
import co.micol.member.web.Logout;
import co.micol.member.web.MainCommand;
import co.micol.member.web.MemberIdCheck;
import co.micol.member.web.MemberJoin;
import co.micol.rental.web.Books;
import co.micol.rental.web.MasList;
import co.micol.rental.web.User;


@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();   
    
    public FrontController() {
        super();
        
    }

	
    public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/loginForm.do", new LoginForm()); //로그인
		map.put("/login.do", new Login()); //로그인처리
		map.put("/bookForm.do", new BookForm()); //도서 폼 호출
		map.put("/insertForm.do", new InsertForm()); // 새 도서 폼
		map.put("/bookInsert.do", new BookInsert()); //등록
		map.put("/bookDelete.do", new BookDelete()); //삭제
		map.put("/bookUpdateFrom.do", new BookUpdateForm()); //책 수정 폼 호출
		map.put("/bookUpdate.do", new BookUpdate()); //책 수정
		map.put("/joinForm.do", new JoinForm()); //회원가입 폼 호출
		map.put("/memberjoin.do", new MemberJoin());//회원가입완료
		map.put("/idCheck.do", new MemberIdCheck());//아이디 체크
		map.put("/logout.do", new Logout());  //로그아웃
		map.put("/memList.do", new MemList()); //회원 조회
		map.put("/memDelete.do", new MemDelete()); //회원 삭제
		map.put("/meminForm.do", new MeminForm()); //멤버 추가 폼
		map.put("/memInsert.do", new MemInsert()); //멤버 추가
		map.put("/memUpForm.do", new MemUpForm()); //멤버 수정 폼
		map.put("/memUpdate.do", new MemUpdate()); //멤버 수정
		map.put("/masList.do", new MasList()); //관리자 대여관리
		map.put("/upCount.do", new UpCount()); //대여
		map.put("/books.do", new Books()); //미반납 도서
		map.put("/user.do", new User());	//회원의 대여목록
		map.put("/reBook.do", new DownCount()); //반납
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length());
		
		Command command = map.get(path);
		String viewPage = command.exec(request, response);
		
		if(!viewPage.endsWith(".do")) viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
