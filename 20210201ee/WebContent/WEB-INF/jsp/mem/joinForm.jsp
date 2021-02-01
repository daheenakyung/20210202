<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	function formCheck() {

		if (frm.mpassword.value != frm.mpassword1.value) {
			alert("패스워드가 일치하지 않습니다.");
			frm.mpassword1.value = null;
			frm.mpassword1.focus();
			return false;
		}
		return true;
	}

	function idCheck(str) {
		var url = "idCheck.do?mid=" + str;
		if (str == "") {
			alert("아이디를 입력하세요.");
			frm.mid.focus();
		} else {
			window.open(url, "아이디 중복확인",
					"width=600, height=200, top=100, left=100");
		}
	}
</script>
<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width: 2000px; margin-top: 46px">
</div>
<div align="center">
	<div>
		<h1>회원가입</h1>
	</div>
	<form id = "frm" name="frm" onsubmit="return formCheck()" action="memberjoin.do" method="post">
		<div>
			<table border="1">
				<tr>
					<th>아이디</th>
					<td><input type="text" id="mid" name="mid" required="required">&nbsp;
						<button type="button" onclick="idCheck(mid.value)">중복체크</button></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" id="mpassword" name="mpassword"
						required="required"></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" id="mpassword1" name="mpassword1"
						required="required"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" id="mname" name="mname"
						required="required"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" id="mtel" name="mtel"
						required="required"></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type="text" id="madd" name="madd"
						required="required"></td>
				</tr>
			</table>
		</div>
		<br /> <input type="submit" value="회원가입">&nbsp; <input
			type="reset" value="취소">
	</form>
</div>
</body>
</html>