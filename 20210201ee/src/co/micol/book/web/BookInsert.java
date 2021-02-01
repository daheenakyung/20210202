package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.BookDao;
import co.micol.book.vo.BookVo;

public class BookInsert implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// TODO 등록
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		vo.setbCode(requset.getParameter("bCode"));
		vo.setbName(requset.getParameter("bName"));
		vo.setQuanti(Integer.parseInt(requset.getParameter("quanti")));
		vo.setbCount(Integer.parseInt(requset.getParameter("bCount")));
		
		int n = dao.insert(vo);
		
		return "bookForm.do";
	}

}
