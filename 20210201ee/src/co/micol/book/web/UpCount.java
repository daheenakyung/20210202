package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.book.common.Command;
import co.micol.book.dao.BookRentalDao;
import co.micol.book.vo.BookVo;


public class UpCount implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// TODO 대여
		BookVo vo = new BookVo();
		BookRentalDao dao = new BookRentalDao();
		vo.setbCode(requset.getParameter("row"));
		
		int n = dao.upCount(vo);
		
		return "bookForm.do";
	}

}