<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width:2000px;margin-top:46px">
</div>
<div align="center">
	<div><h1>새 도서 등록</h1></div>
	<form id = "frm" name = "frm" action = "bookInsert.do" method = "post">
		<table border = "1">
			<tr>
				<th width="20">도서 코드</th>
				<th width="30">도서명</th>
				<th width="10">기본 수량</th>
				<th width="10">현재 수량</th>
			</tr>
			<tr>
				<td align="center"><input type="text" id = "bCode" name = "bCode" size = "30"></td>
				<td><input type="text" id = "bName" name = "bName" size = "30"></td>
				<td align="center"><input type="text" id = "quanti" name = "quanti" size = "10" value = 5></td>
				<td align="center"><input type="text" id = "bCount" name = "bCount" size = "10" value = 5></td>
			</tr>
		</table><br/>
		<button type="submit">등록</button>&nbsp;&nbsp;&nbsp;
		<button type="reset">취소</button>&nbsp;&nbsp;&nbsp;
		<button type="button" onclick = "location.href='bookForm.do'">목록</button>
	</form><br/>
</div>
</body>
</html>