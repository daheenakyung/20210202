package co.micol.rental.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.book.common.Command;
import co.micol.book.dao.BookRentalDao;
import co.micol.book.vo.BookRentalVo;
import co.micol.book.vo.MemberVo;

public class MemBook implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// TODO 멤버 대여 관리
		BookRentalVo vo = new BookRentalVo();
		MemberVo vm = new MemberVo();
		BookRentalDao dao = new BookRentalDao();
		vo.setmId(requset.getParameter("mId"));
		vo = dao.selMem(vo, vm);
		
		if(vm.getmAu() == "USER") {
			HttpSession session = requset.getSession();
			session.setAttribute("mId", vm.getmId());
			requset.setAttribute("vo", vo);
		}
		return "rental/memBook";
	}

}
