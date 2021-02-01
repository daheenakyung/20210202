package co.micol.book.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.BookDao;
import co.micol.book.vo.BookVo;

public class BookForm implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// TODO 도서 폼 호출
		BookDao dao = new BookDao();
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		list = dao.selectList();
		
		requset.setAttribute("list", list);
		
		return "book/bookForm";
	}

}
