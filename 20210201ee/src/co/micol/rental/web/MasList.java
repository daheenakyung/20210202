package co.micol.rental.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.BookRentalDao;
import co.micol.book.vo.BookRentalVo;
import co.micol.book.vo.BookVo;
import co.micol.book.vo.MemberVo;

public class MasList implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// TODO 관리자 대여 폼
		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		BookRentalDao dao = new BookRentalDao();
		MemberVo vm = new MemberVo();
		BookVo vb = new BookVo();
		list = dao.masSelect(vm, vb);
		requset.setAttribute("list", list);
		
		return "rental/rentalList";
	}

}
