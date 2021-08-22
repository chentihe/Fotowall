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
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/fotowall.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
<script src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.js"></script>
<script src="${pageContext.request.contextPath }/static/js/navbar.js"></script>
<script src="${pageContext.request.contextPath }/static/js/commons.js"></script>
<script src="${pageContext.request.contextPath }/static/js/fotowall.js"></script>
</head>
<body>
<%@ include file="commons/navbar.jsp" %>
<%@ include file="commons/commons.jsp" %>
<%@ include file="commons/pagination.jsp" %>
    
   	<c:forEach  var="foto" items="${userWall }" varStatus="i" >
   		<c:if test="${(i.count%4)==1}">
   			<div class="row">
   		</c:if>
  				<div class="column">
        			<img src="${pageContext.request.contextPath }/static/upload/${foto.fotoPath }" alt="" class="img">
        		</div>
   		<c:if test="${(i.count%4)==0}">
   			</div>
   		</c:if>
   	</c:forEach>
   	
    <div class="imgPreview">
        <img src="#" alt="" id="imgPreview">
    </div>
</body>
</html>