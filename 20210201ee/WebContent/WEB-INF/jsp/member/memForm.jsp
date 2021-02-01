<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width:2000px;margin-top:46px">
</div>
<div align="center">
	<div><h1>새 회원 등록</h1></div>
	<form id = "frm" name = "frm" action = "memInsert.do" method = "post">
		<table border = "1">
			<tr>
				<th width="20">회원 아이디</th>
				<th width="20">회원명</th>
				<th width="20">회원 비밀번호</th>
				<th width="20">전화번호</th>
				<th width="20">주소</th>
			</tr>
			<tr class="row">
				<td align="center"><input type="text" id = "mId" name = "mId" size="20"></td>
				<td align="center"><input type="text" id = "mName" name = "mName" size="20"></td>
				<td align="center"><input type="text" id = "mPass" name = "mPass" size="20"></td>
				<td align="center"><input type="text" id = "mTel" name = "mTel" size="20"></td>
				<td align="center"><input type="text" id = "mAdd" name = "mAdd" size="20"></td>
			</tr>
		</table><br/>
		<button type="submit">등록</button>&nbsp;&nbsp;&nbsp;
		<button type="reset">취소</button>&nbsp;&nbsp;&nbsp;
		<button type="button" onclick = "location.href='memList.do'">목록</button>
	</form><br/>
</div>
</body>
</html>