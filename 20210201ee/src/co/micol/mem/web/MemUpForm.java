package co.micol.mem.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.MemberDao;
import co.micol.book.vo.MemberVo;

public class MemUpForm implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// TODO ¸â¹ö ¼öÁ¤ Æû
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setmId(requset.getParameter("row"));
		
		vo = dao.select(vo);
		requset.setAttribute("vo", vo);
		
		return "member/memberinF";
	}

}
