package co.micol.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.MemberDao;


public class MemberIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//아이디 중복 체크
		MemberDao dao = new MemberDao();
		String id = request.getParameter("mid"); //idCheck.do?mid="+str;
		boolean bool = dao.isIdCheck(id);
		String message = null;
		if(bool) {
			message = id + "사용할 수 있는 아이디입니다.";
			
		}else {
			message = id + "사용할 수 없는 아이디입니다.";
		}
		request.setAttribute("msg", message);
		request.setAttribute("check", bool);
		return "mem/idCheck";
	}

}
