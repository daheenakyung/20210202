<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width:2000px;margin-top:46px">
</div>

<div align="center">
	<div><h1>미반납 도서 목록</h1></div>
	<form id = "frm" name = "frm" method = "post">
		<table border = "1">
			<tr style="background-color : silver">
				<th width="100">책 제목</th>
				<th width="100">회원 아이디</th>
				<th width="100">대여일자</th>
				<th width="100">반납일자</th>
			</tr>
			<c:forEach var = "vo" items="${list }">
			<c:if test="${vo.returnDate eq null }">
			<tr>
				<td align="center">${vo.bCode}</td>
				<td align="center">${vo.mId}</td>
				<td align="center">${vo.rentalDate }</td>
				<td align="center">${vo.returnDate }</td>
			</tr>
			</c:if>
			</c:forEach>
		</table>
	</form>
</div>

</body>
</html>