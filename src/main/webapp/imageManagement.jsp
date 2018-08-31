<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <h2 style="color:blue;text-align:center">Image Management Utility</h2>
<hr>
<h4>Please select an image file to upload(Max size 1 MB)</h4>

<!-- 
 <h1>
 <%
 out.print(request.getSession().getAttribute("username"));
 %></h1>
 -->

<div style="display: flex; justify-content: center">
      <form action = "UploadServlet" method = "post"
         enctype = "multipart/form-data">
         <input type = "file" name = "file" size = "50" style="display: inline" accept="image/*"/>
         &nbsp;
         <input type = "submit" value = "Upload File" />
      </form>
   </div>
<br>
<br>
<p>
Uploaded images
</p>
<br/>
<!-- 
<img src="D:\\Software\\Software for fresher\\eclipse\\images\\test0.jpg" width="100" height="100" />
 -->
<table border="1" width="1300" style="text-align:center">
<tr>
	<th>S.NO</th>
	<th>Name</th>
	<th>Size</th>
	<th>Preview</th>
	<th>Action</th>
</tr>


 

<%@page import="java.io.File"%>

<%

String imageFilePath=new File(".").getAbsolutePath()+"\\images";

File folder = new File(imageFilePath);
File[] listOfFiles = folder.listFiles();

for (int index = 0; index < listOfFiles.length; index++) {
    if (listOfFiles[index].isFile()) {
      //System.out.println("File " + listOfFiles[i].getName());}}

out.print("<tr>");

out.print("<td>");
out.print(index);
out.print("</td>");

out.print("<td>");
out.print(listOfFiles[index].getName());
out.print("</td>");

out.print("<td>");
long size=listOfFiles[index].length()/1024;
out.print(size+"kb");
out.print("</td>");

out.print("<td>");
out.print("<img src='"+imageFilePath+"\\"+listOfFiles[index].getName()+"' height='150' width='150'/>");
out.print("</td>");
out.print("<td>");
out.print("<button>Update</button> &nbsp; <button>Delete</button>");
out.print("</td>");

out.print("</tr>");
}}

%>
</table>

   </body>
</html>