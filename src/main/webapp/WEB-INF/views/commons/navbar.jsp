<div class="nav">
    <ul>
        <li> <a href="${pageContext.request.contextPath }/" class="active">Home</a> </li>
    </ul>
    <ul style="float:right">
    	<c:if test="${userSession != null }">
		    <li> <a class="showUpload" href="javascript:;">Upload</a> </li>
		    <li> <a href="${pageContext.request.contextPath }/foto/edit">EditWall</a> </li>
	    </c:if>
	        <li> 
	            <a href="javascript:;">FotoWall</a>
	            <ul>
	            	<c:if test="${userSession != null }">
	                <li> <a href="${pageContext.request.contextPath }/foto/show">Mine</a> </li>
	                </c:if>
	                <li> <a href="${pageContext.request.contextPath }/foto/browse">Others</a> </li>
	            </ul>
	        </li>
	        <c:if test="${userSession != null }">
	    	<li> <a href="${pageContext.request.contextPath }/user.controller?useraction=Logout">Logout</a> </li>
	    	</c:if>
    	<c:if test="${userSession == null }">
		    <li style="float:right"> <a class="showRegister" href="javascript:;">Register</a> </li>
	    	<li style="float:right"> <a class="showLogin" href="javascript:;">Login</a> </li>
	    </c:if>
    </ul>
</div>