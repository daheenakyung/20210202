package co.micol.mem.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.MemberDao;
import co.micol.book.vo.MemberVo;
import sun.awt.datatransfer.DataTransferer.ReencodingInputStream;

public class MemInsert implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// TODO ¸â¹ö Ãß°¡
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setmId(requset.getParameter("mId"));
		vo.setmName(requset.getParameter("mName"));
		vo.setmPass(requset.getParameter("mPass"));
		vo.setmTel(requset.getParameter("mTel"));
		vo.setmAdd(requset.getParameter("mAdd"));
		
		int n = dao.insert(vo);
		
		return "memList.do";
	}

}
