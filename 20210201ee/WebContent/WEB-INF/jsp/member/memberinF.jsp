
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width:2000px;margin-top:46px">
</div>
<div align="center">
	<div><h1>회원 수정</h1></div>
	<form id = "frm" name = "frm" action = "memUpdate.do?mId=${vo.mId }" method = "post">
		<table border = "1">
			<tr style="background-color : silver">
				<th width="100">회원 아이디</th>
				<th width="100">회원명</th>
				<th width="100">전화번호</th>
				<th width="100">주소</th>
			</tr>
			<tr class="row">
				<td align="center">${vo.mId }</td>
				<td align="center">${vo.mName }</td>
				<td align="center"><input type="text" id = "mTel" name = "mTel" value="${vo.mTel }"></td>
				<td align="center"><input type="text" id = "mAdd" name = "mAdd" value="${vo.mAdd }"></td>
			</tr>
		</table><br/>
		<button type="submit">수정</button>&nbsp;&nbsp;&nbsp;
		<button type="reset">취소</button>&nbsp;&nbsp;&nbsp;
		<button type="button" onclick = "location.href='memList.do'">목록</button>
	</form>
</div>

</body>
</html>