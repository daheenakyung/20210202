  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
	font-family: "Lato", sans-serif
}
.mySlides {
	display: none
}
</style>

<body>
	<!-- Navbar -->
	<div class="w3-top">
		<div class="w3-bar w3-black w3-card">
			<a
				class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right"
				href="javascript:void(0)" onclick="myFunction()"
				title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a> <a
				href="main.do" class="w3-bar-item w3-button w3-padding-large">HOME</a>
			<c:if test="${mid eq null }">
				<a href="loginForm.do"
					class="w3-bar-item w3-button w3-padding-large w3-hide-small">LOGIN</a>
			</c:if>
			<c:if test="${not empty mid and mauth !='MASTER'}">
				<a href="bookForm.do"
					class="w3-bar-item w3-button w3-padding-large w3-hide-small">책목록</a>
				<a href="user.do"
					class="w3-bar-item w3-button w3-padding-large w3-hide-small">내 대여목록</a>
			</c:if>
			<div class="w3-dropdown-hover w3-hide-small">
				<c:if test="${not empty mid and mauth =='MASTER'}">
					<button class="w3-padding-large w3-button" title="More">
						도서관리 <i class="fa fa-caret-down"></i>
					</button>
					<div class="w3-dropdown-content w3-bar-block w3-card-4">
						<a href="bookForm.do" class="w3-bar-item w3-button">도서등록</a> <a
							href="masList.do" class="w3-bar-item w3-button">대여관리</a> <a
							href="memList.do" class="w3-bar-item w3-button">회원관리</a>
					</div>
				</c:if>
			</div>
			<c:if test="${mid ne null }">
				<a href="logout.do"
					class="w3-bar-item w3-button w3-padding-large w3-hide-small">LOGOUT</a>
			</c:if>
			<a href="javascript:void(0)"
				class="w3-padding-large w3-hover-red w3-hide-small w3-right"><i
				class="fa fa-search"></i></a>
		</div>
	</div>