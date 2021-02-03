<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function bookReturn(str) {
		var yn = confirm("정말 반납할까요?");
		if (yn) {
			location.href = "bookReturn.do?row=" + str;
		} else {
			alert("취소하셨습니다.");
		}
	}
</script>
<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width: 2000px; margin-top: 46px">
</div>

<div align="center">
		<div>
			<h1>내 대여목록</h1>
		</div>
	<form id="frm" name="frm" method="post">
		<table border="1">
			<tr>
				<th width="100">도서 코드</th>
				<th width="300">책 제목</th>
				<th width="100">아이디</th>
				<th width="100">대여일자</th>
				<th width="100">반납일자</th>
				<th width="100">반납</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td align="center">${vo.bCode }</td>
					<td align="center">${vo.bName }</td>
					<td align="center">${vo.mId }</td>
					<td align="center">${vo.rentalDate }</td>
					<td align="center">${vo.returnDate }</td>
					<td align="center"><button type="submit"
							onclick="reBook('${vo.bCode}')">반납</button></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</div>
</body>
</html>