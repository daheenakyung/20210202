package co.micol.rental.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.book.common.Command;
import co.micol.book.dao.BookRentalDao;
import co.micol.book.vo.BookRentalVo;

public class User implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// TODO 회원별 조회
		BookRentalDao dao = new BookRentalDao();
		BookRentalVo vo = new BookRentalVo();
		vo.setmId(requset.getParameter("mId"));
		
		vo = dao.selMem(vo);
		dao = new BookRentalDao();
		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		list = dao.masSelect();
		requset.setAttribute("list", list);
		requset.setAttribute("vo", vo);
		
		/*
		 * if(vo.getmAu() == "USER") { HttpSession session = requset.getSession();
		 * session.setAttribute("mId", vo.getmId()); requset.setAttribute("vo", vo); }
		 */
		
		return "rentaluser/userForm";
	}

}
