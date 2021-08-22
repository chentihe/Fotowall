<c:if test="${pagination.totalPage>0 }">
	<div class="second-navbar">
		<c:if test="${userWall!=null }">
			<span class="userName">${userWall[0].getUser().getUserName() }'s Wall</span>
		</c:if>
		<div class="pagination">
		   	<a href="?uid=${userSession==null?param.uid:userSession.id }&page=${pagination.currentPage==1?1:pagination.currentPage - 1 }" class="previous">&laquo;</a>
		       <c:forEach var="i" begin="1" end="${pagination.totalPage }">
		   		<a href="?uid=${userSession==null?param.uid:userSession.id }&page=${i}" class=${(pagination.currentPage==i)?"active":"" }>${i }</a>
		   	</c:forEach>
			<a href="?uid=${userSession==null?param.uid:userSession.id }&page=${pagination.currentPage==pagination.totalPage?pagination.totalPage:pagination.currentPage + 1 }" class="next">&raquo;</a>
		</div>
	</div>
</c:if>