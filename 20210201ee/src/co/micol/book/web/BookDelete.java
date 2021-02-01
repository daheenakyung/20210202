package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.BookDao;
import co.micol.book.vo.BookVo;

public class BookDelete implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// 梨� �궘�젣
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		vo.setbCode(requset.getParameter("row"));
		
		int n = dao.delete(vo);
		
		String viewPage = null;
		
		if(n != 0) {
			viewPage = "book/bookDeleteSuccess";
		}else {
			viewPage = "book/bookDeleteFail";
		}
		return viewPage;
		
	}

}
