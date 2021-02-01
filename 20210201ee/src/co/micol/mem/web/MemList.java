package co.micol.mem.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.MemberDao;
import co.micol.book.vo.MemberVo;

public class MemList implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// TODO ¸â¹ö ¸®½ºÆ®
		MemberDao dao = new MemberDao();
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		list = dao.selectMemList();
		
		requset.setAttribute("list", list);
		
		return "member/memberList";
	}

}
