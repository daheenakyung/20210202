package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.BookRentalDao;
import co.micol.book.vo.BookVo;

public class DownCount implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// TODO 반납
		BookVo vo = new BookVo();
		BookRentalDao dao = new BookRentalDao();
		vo.setbCode(requset.getParameter("row"));
		
		int n = dao.downCount(vo);
		
		return "bookForm.do";
	}

}
