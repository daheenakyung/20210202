package co.micol.rental.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import co.micol.book.common.Command;
import co.micol.book.dao.BookRentalDao;
import co.micol.book.vo.BookRentalVo;

public class User implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// TODO 회원별 조회
		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		BookRentalVo vo = new BookRentalVo();
		BookRentalDao dao = new BookRentalDao();
		vo.setmId(requset.getParameter("id"));
		HttpSession session = requset.getSession();
		String id = (String) session.getAttribute("mid");
		String auth = (String) session.getAttribute("auth");
		
		/*
		 * if(auth.equals("MASTER")) list = dao.selMem(); else list = dao.selMem(id);
		 */
		
		requset.setAttribute("list", list);
		/*
		 * vo = dao.selMem(vo); dao = new BookRentalDao(); ArrayList<BookRentalVo> list
		 * = new ArrayList<BookRentalVo>(); list = dao.masSelect();
		 * requset.setAttribute("vo", vo);
		 */
		/*
		 * if(vo.getmAu() == "USER") { HttpSession session = requset.getSession();
		 * session.setAttribute("mId", vo.getmId()); requset.setAttribute("vo", vo); }
		 */
		
		return "rentaluser/userForm";
	}

}
