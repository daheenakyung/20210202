  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
	function deleteMem(str){
		var yn = confirm("정말 삭제하시겠습니까?");
		if (yn) {
			frm.action = "memDelete.do?row="+str;
			frm.submit();
		}
	}
	function updateMem(str){
		frm.action = "memUpForm.do?row="+str;
		frm.submit();
	}
</script>    
<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width:2000px;margin-top:46px">
</div>
<div align="center">
	<div><h1>회원 리스트</h1></div>
	<form id = "frm" name = "frm" method = "post">
		<table border = "1">
			<tr style="background-color : silver">
				<th width="100">회원 아이디</th>
				<th width="100">회원명</th>
				<th width="100">전화번호</th>
				<th width="100">주소</th>
				<th width="100">권한</th>
				<th width="100">삭제</th>
				<th width="100">수정</th>
			</tr>
			<c:forEach var = "vo" items="${list }">
			<tr class="row">
				<td align="center">${vo.mId }</td>
				<td align="center">${vo.mName }</td>
				<td align="center">${vo.mTel }</td>
				<td align="center">${vo.mAdd }</td>
				<td align="center">${vo.mAu }</td>
				<td align="center"><button type="submit" onclick = "deleteMem('${vo.mId}')">삭제</button></td>
				<td align="center"><button type="button" onclick = "updateMem('${vo.mId}')">수정</button></td>
			</tr>
			</c:forEach>
		</table>
	</form>
	<div>
		<button type="button" onclick = "location.href='meminForm.do'">등록</button>
	</div>
</div>

</body>
</html>