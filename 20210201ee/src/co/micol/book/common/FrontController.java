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
import co.micol.book.web.BookDelete;
import co.micol.book.web.BookForm;
import co.micol.book.web.InsertForm;
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


@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();   
    
    public FrontController() {
        super();
        
    }

	
    public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/loginForm.do", new LoginForm()); //�α���
		map.put("/login.do", new Login()); //�α���ó��
		map.put("/bookForm.do", new BookForm()); //���� �� ȣ��
		map.put("/insertForm.do", new InsertForm()); // �� ���� ��
		map.put("/bookInsert.do", new BookInsert()); //���
		map.put("/bookDelete.do", new BookDelete()); //����
		map.put("/bookUpdateFrom.do", new BookUpdateForm()); //å ���� �� ȣ��
		map.put("/bookUpdate.do", new BookUpdate()); //å ����
		map.put("/joinForm.do", new JoinForm()); //ȸ������ �� ȣ��
		map.put("/memberjoin.do", new MemberJoin());//ȸ�����ԿϷ�
		map.put("/idCheck.do", new MemberIdCheck());//���̵� üũ
		map.put("/logout.do", new Logout());  //�α׾ƿ�
		map.put("/memList.do", new MemList()); //ȸ�� ��ȸ
		map.put("/memDelete.do", new MemDelete()); //ȸ�� ����
		map.put("/meminForm.do", new MeminForm()); //��� �߰� ��
		map.put("/memInsert.do", new MemInsert()); //��� �߰�
		map.put("/memUpForm.do", new MemUpForm()); //��� ���� ��
		map.put("/memUpdate.do", new MemUpdate()); //��� ����
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
