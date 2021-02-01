package co.micol.member.web;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.book.common.Command;
import co.micol.book.dao.MemberDao;
import co.micol.book.vo.MemberVo;

public class Login implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// 로그인 처리
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setmId(requset.getParameter("mid"));
		vo.setmPass(requset.getParameter("mpassword"));

		vo = dao.login(vo);

		String viewPage = null;

		if (vo.getmAu() != null) {
			HttpSession session = requset.getSession();
			session.setAttribute("mid", vo.getmId());
			session.setAttribute("mauth", vo.getmAu());
			requset.setAttribute("vo", vo);
			viewPage = "mem/loginSuccess";
		} else {
			viewPage = "mem/loginFail";
		}

		return viewPage;
	}
}
