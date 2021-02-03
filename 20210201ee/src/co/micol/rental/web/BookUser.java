package co.micol.rental.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.book.common.Command;
import co.micol.book.dao.BookRentalDao;
import co.micol.book.vo.BookRentalVo;

public class BookUser implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// TODO 회원 미반납
		BookRentalDao dao = new BookRentalDao();
		BookRentalVo vo = new BookRentalVo();
		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		
		HttpSession session = requset.getSession();
		String value = (String)session.getAttribute("mid");

		vo.setmId(value);
		
		list = dao.selMem(vo);
		requset.setAttribute("list", list);
		
		return "rental/bookUser";
	}

}
