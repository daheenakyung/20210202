package co.micol.book.web;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		dao.upCount(vo);
		
		requset.setAttribute("vo", vo);
		
		//insert
		BookRentalDao daob = new BookRentalDao();
		BookRentalVo vb = new BookRentalVo();
		vb.setbCode(vo.getbCode());
		
		HttpSession session = requset.getSession();
		String value = (String) session.getAttribute("mid");
		vb.setmId(value);
		
		int n = daob.insert(vb);
		
		return "user.do";
	}

}