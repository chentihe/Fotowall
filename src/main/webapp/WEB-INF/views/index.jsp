<%@ page import="java.util.List" %>
<%@ page import="dao.bean.Foto" %>
<%@ page import="service.FotoService" %>
<%@ page import="service.FotoServiceImpl" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	FotoService service = new FotoServiceImpl();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FotoWall</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/navbar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/commons.css">
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


<div class="jumbotron">
    <div class="jumbotron-content">
        <h1>Make Your Wall Great Again</h1>
        <p>Beautiful Wall, Wonderful World!</p>
    </div>
</div>
<img src="" alt="" class="indexImg">
<span id="indexFoto"></span>
<c:forEach var="foto" varStatus="i" items="${indexWall }">
   		<c:if test="${(i.count%4)==1}">
   			<div class="row">
   		</c:if>
  				<div class="column">
        			<img src="${foto.fotoPath }" alt="" class="img">
        		</div>
   		<c:if test="${(i.count%4)==0}">
   			</div>
   		</c:if>
   	</c:forEach>
    
    <div class="imgPreview">
        <img src="#" alt="" id="imgPreview">
    </div>
<script type="text/javascript">
$(function() {
	$.ajax({
		type: "get",
		url: "/cth-fotowall/foto/random"
	}).then(function(data) {
		$(".indexImg").prop("src", "/cth-fotowall/static/upload/"+data.fotoPath);
		console.log(data);
	});
})
</script>
</body>
</html>