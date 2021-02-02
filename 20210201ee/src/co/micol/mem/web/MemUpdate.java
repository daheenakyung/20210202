package co.micol.mem.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.MemberDao;
import co.micol.book.vo.MemberVo;

public class MemUpdate implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// TODO ����
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setmPass(requset.getParameter("mPass"));
		vo.setmTel(requset.getParameter("mTel"));
		vo.setmAdd(requset.getParameter("mAdd"));
		vo.setmId(requset.getParameter("mId"));
		
		int n = dao.update(vo);
		String viewPage = null;
		if(n != 0) {
			viewPage = "member/insertFail";
		}else {
			viewPage = "memList.do";
		}
		
		return viewPage;
	}

}
