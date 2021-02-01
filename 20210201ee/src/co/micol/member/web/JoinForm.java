package co.micol.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;

public class JoinForm implements Command {

	@Override
	public String exec(HttpServletRequest requset, HttpServletResponse response) {
		// 회원가입 폼 호출
		return "mem/joinForm";
	}

}
