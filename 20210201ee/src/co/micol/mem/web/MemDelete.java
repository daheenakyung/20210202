package co.micol.mem.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.MemberDao;
import co.micol.book.vo.MemberVo;

public class MemDelete implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// TODO 회원 삭제
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setmId(requset.getParameter("row"));
		
		int n = dao.delete(vo);
		
		return "memList.do";
	}

}
