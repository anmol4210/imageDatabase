<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="https://m...content-available-to-author-only...n.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> 
<style>
	.login-content {
		background: aliceblue;
    	text-align: center;
    	padding: 20px;
    	border-radius: 10px;
	}
</style>
</head>
<body>
<%
if(request.getAttribute("isValid") != null && request.getAttribute("isValid").equals("true")){
	request.setAttribute("isValid", "false");
	out.print("<script>alert('Invalid Username or password')</script>");
}
%>
<form class="container" action="Login" method="post">
<div id="login-box" class="login-content">
<h2>Login Page</h2>
Please provide your credential to use this website
<br>
<br>
<div id="login-box-name" style="margin-top:20px;"> UserName:</div>
<div "login-box-field" style="margin-top:20px; margin-bottom:20px">
<input type = "text" class="form-login" name = "username" required placeholder="username"></div>
         
<div id="login-box-name" style="margin-top:20px;">Password:</div>
  <div "login-box-field" style="margin-top:20px; margin-bottom:20px">
  <input type = "password" name = "password" class="form-login" required placeholder="password"/>
</div>
<br/>
<input type="submit" value="submit" style="margin-left:100px;">
</div>
</form>
<span class="login-box-options">
<a href="changePassword.jsp" style="margin-left:30px;">Forgot Password</a> 
</span>
</body>

</html>
