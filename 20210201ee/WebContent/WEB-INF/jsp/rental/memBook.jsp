<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width:2000px;margin-top:46px">
</div>

<div align="center">
	<div><h1>대여 도서</h1></div>
	<form id = "frm" name = "frm" method = "post">
		<table border = "1">
			<tr>
				<th width="100">회원 아이디</th>
				<th width="100">도서코드</th>
				<th width="100">대여일자</th>
				<th width="100">반납일자</th>
				<c:if test="${vm.mAu == 'USER' }">
				<th width="100"><button type="button">반납</button></th>
				</c:if>
			</tr>
			<c:forEach>
			<tr>
				<td align="center">${vm.mId}</td>
				<td align="center">${vo.bCode}</td>
				<td align="center">${vo.rentalDate }</td>
				<td align="center">${vo.returnDate }</td>
			</tr>
			</c:forEach>
		</table>
	</form>
</div>

</body>
</html>