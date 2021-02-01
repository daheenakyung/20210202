package co.micol.member.web;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.MemberDao;
import co.micol.book.vo.MemberVo;


public class MemberJoin implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setmId(requset.getParameter("mid"));
		vo.setmPass(requset.getParameter("mpassword"));
		vo.setmName(requset.getParameter("mname"));
		vo.setmTel(requset.getParameter("mtel"));
		vo.setmAdd(requset.getParameter("madd"));
		
		String viewPage = null;
		int n = dao.insert(vo);
		requset.setAttribute("vo", vo);
		
		if (n != 0) {
			viewPage = "mem/joinSuccess";
		}else {
			viewPage = "mem/joinFail";
		}
					
		
		return viewPage;
		
	}

}
