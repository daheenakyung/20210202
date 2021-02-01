package co.micol.mem.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;

public class MeminForm implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// TODO ¸â¹ö Ãß°¡ Æû
		return "member/memForm";
	}

}
