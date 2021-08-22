<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FotoWall</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/navbar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/commons.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/pagination.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/otherswall.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
<script src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.js"></script>
<script src="${pageContext.request.contextPath }/static/js/navbar.js"></script>
<script src="${pageContext.request.contextPath }/static/js/commons.js"></script>
</head>
<body>
<%@ include file="commons/navbar.jsp" %>
<%@ include file="commons/commons.jsp" %>
<%@ include file="commons/pagination.jsp" %>

<c:forEach var="userFoto" items="${othersFoto }">
	<c:if test="${userFoto[0].fotoPath!=null }">
		<div class="row">
	        <div class="column">
	            <a href="${pageContext.request.contextPath }/foto/show?uid=${userFoto[0].uid }">
	                <img src="${pageContext.request.contextPath }/static/upload/${userFoto[0].fotoPath }" class="img">
	                <div class="userName">
	                    ${userFoto[1].userName }
	                </div>
	            </a>
	        </div>
	    </div>
    </c:if>
</c:forEach>
</body>
</html>