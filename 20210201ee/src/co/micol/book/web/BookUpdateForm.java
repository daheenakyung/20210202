package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.BookDao;
import co.micol.book.vo.BookVo;

public class BookUpdateForm implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// 梨� �닔�젙 �뤌 �샇異�
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		vo.setbCode(requset.getParameter("row"));
		vo = dao.select(vo);
		requset.setAttribute("vo", vo);
		return "book/bookUpdateForm";
	}

}
