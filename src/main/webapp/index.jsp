<html>
<head>
<title>Login</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
 
</head>
<body>
<%
if(request.getAttribute("isValid") != null && request.getAttribute("isValid").equals("true")){
	request.setAttribute("isValid", "false");
	out.print("<script>alert('Invalid Username or password')</script>");
}
%>
<form action="Login" method="post">
<div style="padding: 100px 0 0 250px;">
<div id="login-box">
<h2>Login Page</h2>
Please provide your credential to use this website
<br>
<br>
<div id="login-box-name" style="margin-top:20px; " > UserName:</div>
<div id="login-box-field" style="margin-top:20px;">
<input type = "text" class="form-login" name = "username" required placeholder="username"></div>
         
<div id="login-box-name">Password:</div>
  <div id="login-box-field">
  <input type = "password" name = "password" class="form-login" required placeholder="password"/>
</div>
<br/>
<input type="submit" value="submit" style="margin-left:100px;">
</div></div>
</form>

<a href="changePassword.jsp">Forgot Password</a> 

</body>

</html>
