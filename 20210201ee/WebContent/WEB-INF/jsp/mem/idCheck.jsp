<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function formClose() {
		
		if(${check }) {
			window.opener.document.getElementById("mpassword").focus();
		}else {
			window.opener.document.getElementById("mid").value="";
			window.opener.document.getElementById("mid").focus();
		}
		window.close();
	}
</script>
<jsp:include page="../main/menu.jsp" />
<div class="w3-content" style="max-width:2000px;margin-top:46px">
</div>
	<div align="center">
		<h3>${msg }</h3>
		<button type="button" onclick="formClose()">확인</button>
	</div>
</body>
</html>