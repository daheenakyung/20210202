package co.micol.book.web;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.BookRentalDao;
import co.micol.book.vo.BookRentalVo;
import co.micol.book.vo.BookVo;


public class UpCount implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// TODO 대여
		BookVo vo = new BookVo();
		BookRentalDao dao = new BookRentalDao();
		vo.setbCode(requset.getParameter("row"));
		
		int n = dao.upCount(vo);
		
		BookRentalVo vb = new BookRentalVo();
		vb.setbCode(requset.getParameter("bCode"));
		vb.setmId(requset.getParameter("mId"));
		vb.setReturnDate(Date.valueOf(requset.getParameter("returnDate")));
		dao = new BookRentalDao();
		n = dao.insertR(vb);
		
		
		return "bookForm.do";
	}

}