<c:if test="${userSession==null }">
	<div id="login" class="modalLogin">
	     <form class="modal-content" action="${pageContext.request.contextPath }/user.controller" method="post">
	         <div class="container">
	             <label for="loginemail"><b>E-mail</b></label>
	             <input type="text" placeholder="Enter email" id="loginemail" name="email" required/> <br />
	             <span>${erros.email }</span>
	             <label for="loginpwd"><b>Password</b></label>
	             <input type="password" placeholder="Enter Password" id="loginpwd" name="password" required/> <br />
	             <span>${errors.password }</span>
	             <input class="button" type="submit" name="useraction" value="Login" />
	         </div>
	     </form>
	</div>
	 
	<div id="register" class="modalRegister">
	     <form class="modal-content" action="${pageContext.request.contextPath }/user.controller" method="post" onsubmit="return checkUserData()">
	         <div class="container">
	             <label><b>User Name</b></label>
				 <input type="text" placeholder="Enter userName" name="userName" id="userName" required>
	             
	             <label for="registeremail"><b>E-mail</b></label>
	             <input type="text" placeholder="Enter Email" id="registeremail" name="email" required/> <br />
	             
	             <label for="registerpwd"><b>Password</b></label>
	             <input type="password" placeholder="Enter Password" id="registerpwd" name="password" required/> <br />
	             
	             <input class="button" type="submit" name="useraction" value="Register" />
	         </div>
	     </form>
	</div>
</c:if>

<c:if test="${userSession!=null }">
    <div id="upload" class="modalUpload">
        <form class="modal-content-upload" action="${pageContext.request.contextPath }/foto/upload" enctype="multipart/form-data" method="post">
            <label>
                <input class="upload" name="multiparts" multiple type="file" required/>
                <div class="choose-block">Click here to Choose Files</div>
            </label>
            <span>${errors.upload }</span>
            <div class="btn-align">
            	<input class="btns upload" type="submit" name="fotoaction" value="Upload"/>
        	</div>
        </form>
    </div>
</c:if>