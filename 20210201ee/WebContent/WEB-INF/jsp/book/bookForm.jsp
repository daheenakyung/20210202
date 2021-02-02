<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<style type="text/css">
tr.row:hover {
	background-color: lightblue
}
</style>   
<script type="text/javascript">
	function getBook(str){
		var yn = confirm("도서를 대여하시겠습니까?");
		if(yn) {
			frm.action = "upCount.do?row="+str;
			frm.submit();
		}
	}
	
	function deleteBook(str){
		var yn = confirm("정말 삭제하시겠습니까?");
		if (yn) {
			frm.action = "bookDelete.do?row="+str;
			frm.submit();
		}
	}
</script>
<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width:2000px;margin-top:46px">
</div>
<div align="center">
	<div><h1>도서 목록</h1></div>
	<form id = "frm" name = "frm" method = "post">
		<table border = "1">
			<tr style="background-color : silver">
				<th width="100">도서 코드</th>
				<th width="100">도서명</th>
				<th width="100">기본 수량</th>
				<th width="100">현재 수량</th>
				<th width="100">대여</th>
				<c:if test="${not empty mid and mauth =='MASTER'}">
				<th width="100">삭제</th>
				<th width="100">수정</th>
				</c:if>

			</tr>
			<c:forEach var = "vo" items="${list }">
			<tr class="row">
				<td align="center">${vo.bCode }</td>
				<td align="center">${vo.bName }</td>
				<td align="center">${vo.quanti }</td>
				<td align="center">${vo.bCount }</td>
				<c:if test = "${vo.bCount > 0}">
				<td align="center"><button type="submit" onclick = "getBook('${vo.bCode}')">대여</button></td>
				</c:if>
				<c:if test = "${vo.bCount <= 0}">
				<td align="center">대여불가</td>
				</c:if>
				<c:if test="${not empty mid and mauth =='MASTER'}">
				<td align="center"><button type="submit" onclick = "deleteBook('${vo.bCode}')">삭제</button></td>
				<td align="center"><button type="button" onclick = "location.href='bookUpdateFrom.do?row=${vo.bCode }'">수정</button></td>
				</c:if>
			</tr>
			</c:forEach>
		</table>
	</form>
	<c:if test="${not empty mid and mauth =='MASTER'}">
	<div>
		<button type="button" onclick = "location.href='insertForm.do'">등록</button>
	</div>
	</c:if>
</div>

</body>
</html>