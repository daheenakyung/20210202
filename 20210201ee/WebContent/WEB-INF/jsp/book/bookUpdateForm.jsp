<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width:2000px;margin-top:46px">
</div>
<div align="center">
	<div><h1>도서 관리</h1></div>
	<form id = "frm" name = "frm" action = "bookUpdate.do?bCode=${vo.bCode }" method = "post">
		<table border = "1">
			<tr>
				<th width="100">도서 코드</th>
				<th width="200">도서명</th>
				<th width="100">기본 수량</th>
				<th width="100">현재 수량</th>
			</tr>
			<tr>
				<td align="center">${vo.bCode }</td>
				<td align="center"><input type="text" id = "bName" name = "bName" size = "30" value="${vo.bName }"></td>
				<td align="center">${vo.quanti }</td>
				<td align="center"><input type="text" id = "bCount" name = "bCount" size = "10" value="${vo.bCount }"></td>
			</tr>
		</table><br/>
		<button type="submit">등록</button>&nbsp;&nbsp;&nbsp;
		<button type="reset">취소</button>&nbsp;&nbsp;&nbsp;
		<button type="button" onclick = "location.href='bookForm.do'">목록</button>
	</form><br/>
</div>
</body>
</html>