package co.micol.rental.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.BookRentalDao;
import co.micol.book.vo.BookRentalVo;

public class Books implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// TODO 미반납 도서 조회
		BookRentalDao dao = new BookRentalDao();
		
		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		list = dao.masSelect();
		
		requset.setAttribute("list", list);
		
		return "rental/books";
	}

}
