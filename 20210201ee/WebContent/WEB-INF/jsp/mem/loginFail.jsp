<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width:2000px;margin-top:46px">
</div>

<div align="center">
	<h3>${param.mid }님이 로그인에 실패하셨습니다.</h3>
	<button type="button" onclick="location.href='loginForm.do'">재 로그인</button>
</div>
</body>
</html>