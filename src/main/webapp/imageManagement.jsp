<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.0.0.js"></script>
<script type="text/javascript">
                $(document).ready(
                          function(){
                              $('#upload-btn').attr('disabled',true);
                              $('input:file').change(
                                  function(){
                                      if ($(this).val()){
                                          $('#upload-btn').removeAttr('disabled'); 
                                      }
                                      else {
                                          $('#upload-btn').attr('disabled',true);
                                      }
                                  });
                          });
     </script>

</head>
<body>
	<h2 style="color: blue; text-align: center">Image Management
		Utility</h2>
	<hr>
	<h4>Please select an image file to upload(Max size 1 MB)</h4>

	<!-- 
 <h1>
 <%out.print(request.getSession().getAttribute("username"));%></h1>
 -->
 
 <%
if(request.getAttribute("uploaded") != null && request.getAttribute("uploaded").equals("false")){
	request.setAttribute("uploaded", "true");
	out.print("<script>alert('Image size should be less tham 1mb and folder size should be less than 10mb')</script>");
}
%>

	<div style="display: flex; justify-content: center">
		<form action="UploadServlet" method="post"
			enctype="multipart/form-data">
			<input type="file" name="file" size="50" style="display: inline"
				accept="image/*" /> &nbsp; <input id="upload-btn" type="submit" value="Upload File" />
		</form>
	</div>
	<br>
	<br>
	<p>Uploaded images</p>
	<br />
	<!-- 
<img src="D:\\Software\\Software for fresher\\eclipse\\images\\test0.jpg" width="100" height="100" />
 -->
	<table border="1" width="1300" style="text-align: center">
		<tr>
			<th>S.NO</th>
			<th>Name</th>
			<th>Size</th>
			<th>Preview</th>
			<th>Action</th>
		</tr>

		<%@page import="java.io.File"%>

		<%
			String imageFilePath = new File(".").getAbsolutePath() + "\\images";
			long totalSize=0;
			File folder = new File(imageFilePath);
			File[] listOfFiles = folder.listFiles();

			for (int index = 0; index < listOfFiles.length; index++) {
				if (listOfFiles[index].isFile()) {
					//System.out.println("File " + listOfFiles[i].getName());}}
					totalSize = totalSize + ((File)listOfFiles[index]).length();
					String id = listOfFiles[index].getName();
					id = id.substring(id.lastIndexOf("#") + 1, id.lastIndexOf("."));
					out.print("<tr>");

					out.print("<td>");
					out.print(index + 1);
					out.print("</td>");

					out.print("<td>");
					String name = listOfFiles[index].getName();
					int indx = name.lastIndexOf("#");
					name = name.substring(0, indx) + name.substring(name.lastIndexOf("."));
					out.print(name);
					out.print("</td>");

					out.print("<td>");
					long size = listOfFiles[index].length() / 1024;
					out.print(size + "kb");
					out.print("</td>");

					out.print("<td>");

					out.print("<img src='" + imageFilePath + "\\" + listOfFiles[index].getName()
							+ "' height='150' width='150'/>");
					out.print("</td>");
					out.print("<td>");
					out.print(
							"<form action='UploadServlet' method='get'><input type='hidden' name='action' value='delete'/><input type='hidden' name='imageId' value='"
									+ id
									+ "'/> <input type='submit' value='Delete' /></form>");
					out.print("<input type='button' class='form-control btn-link btn-outline-info text-info' data-toggle='modal' data-target='#exampleModal' value='Update' onclick='updateClicked("+id+")' />");
					out.print("</td>");

					out.print("</tr>");
					//listOfFiles[index].delete();
				}
			}
			request.getSession().setAttribute("folderSize", totalSize);
		%>
	</table>
<%
out.print("<tr>");
out.print("<td>");
long folderSize=Long.parseLong(request.getSession().getAttribute("folderSize")+"")/(1024);
out.print("Total Size: "+folderSize+"kb");
out.print("</td>");
out.print("</tr>"); 

%>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
      
      <div class="modal" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">Update</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <form class="form-group" method="post" action="UpdateImageName">
                  <input class="form-control" type="text" placeholder="Enter new name" name="imgNewName">
                  <input class="btn btn-info py-1 px-3" type="submit" id="upload-btn" value="Update Name"/>
              </form>
            </div>
            
            <div class="modal-body">
              <form class="form-group" method="post" enctype = "multipart/form-data" action="UpdateImage">
                        <input class="btn btn-outline-info text-info p-0 mr-1" type="file" name="image" accept="image/*"/>
                        <input class="btn btn-info py-1 px-3" type="submit" id="upload-btn" value="Update Image"/>
                  </form>
            </div>
          </div>
        </div>
      </div>
<script>
            function updateClicked(imgId) {
              document.cookie = "imageId="+imgId;
          }
</script>

</body>
</html>