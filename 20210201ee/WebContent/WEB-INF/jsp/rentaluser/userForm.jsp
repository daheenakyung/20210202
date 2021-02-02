<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="p" %>   
<script type="text/javascript">
function reBook(str){
	var yn = confirm("도서를 반납 하시겠습니까?");
	if(yn) {
		frm.action = "reBook.do?row="+str;
		frm.submit();
	}
}
</script> 
<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width:2000px;margin-top:46px">
</div>

<div align="center">
	<div><h1>${vo.mId }회원님 대여관리</h1></div>
	<form id = "frm" name = "frm" method = "post">
		<table border = "1">
			<tr>
				<th width="100">도서 코드</th>
				<th width="100">회원 아이디</th>
				<th width="100">대여일자</th>
				<th width="100">반납일자</th>
				<th width="100">반납</th>
			</tr>
			<p:forEach var = "vo" items="${list }">
			<tr>
				<td align="center">${vo.bCode }</td>
				<td align="center">${vo.mId }</td>
				<td align="center">${vo.rentalDate }</td>
				<td align="center">${vo.returnDate }</td>
				<td align="center"><button type="submit" onclick = "reBook('${vo.bCode}')">반납</button></td>
			</tr>
			</p:forEach>
		</table>
		
	</form>
</div>
</body>
</html>