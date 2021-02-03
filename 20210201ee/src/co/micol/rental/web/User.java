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
		BookRentalDao dao = new BookRentalDao();
		BookRentalVo vo = new BookRentalVo();
		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		
		vo.setbCode(requset.getParameter("row"));
		
		
		HttpSession session = requset.getSession();
		String value = (String)session.getAttribute("mid");

		vo.setmId(value);
		
		list = dao.selMem(vo);
		requset.setAttribute("list", list);
		
		
		return "rentaluser/userForm";
	}

}
