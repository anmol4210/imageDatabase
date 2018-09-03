<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>




      <style>
         #updateImage {
            display: none;
            background-color: #91FF00;
            border: 1px solid #aaa;
            position: fixed;
            width: 250px;
            left: 50%;
            margin-left: -100px;
            padding: 6px 8px 8px;
            box-sizing: border-box;
            text-align: center;
         }
         #updateImage button {
            background-color: #48E5DA;
            display: inline-block;
            border-radius: 5px;
            border: 1px solid #aaa;
            padding: 5px;
            text-align: center;
            width: 80px;
            cursor: pointer;
         }
         #updateImage .message {
            text-align: left;
         }
         
                  #nameChange {
            display: none;
            background-color: #91FF00;
            border: 1px solid #aaa;
            position: fixed;
            width: 250px;
            left: 50%;
            margin-left: -100px;
            padding: 6px 8px 8px;
            box-sizing: border-box;
            text-align: center;
         }
         #nameChange button {
            background-color: #48E5DA;
            display: inline-block;
            border-radius: 5px;
            border: 1px solid #aaa;
            padding: 5px;
            text-align: center;
            width: 80px;
            cursor: pointer;
         }
         #nameChange .message {
            text-align: left;
         }
         
      </style>   
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
      </script>
      <script>
         function functionAlert(msg, myYes) {
            var confirmBox = $("#updateImage");
            confirmBox.find(".message").text(msg);
            confirmBox.find(".changeName").unbind().click(function() {
            //	console.log("change name");
                 confirmBox.hide();
            });
            confirmBox.find(".changeImage").unbind().click(function() {
            	//console.log("change name");
                   confirmBox.hide();
             });
             confirmBox.find(".changeName").click(myYes);

            confirmBox.find(".changeImage").click(myYes);
            
            confirmBox.show();
         }

         function functionChangeName(msg, myYes){
             console.log("change name");
             var confirmBox = $("#nameChange");
             confirmBox.find(".nameChangeMessage").text(msg);
             confirmBox.find(".changeNm").unbind().click(function() {
             //	console.log("change name");
                  confirmBox.hide();
             });

             confirmBox.find(".changeNm").click(myYes);
             
             confirmBox.show();
          
             }
         function functionChangeImage(msg, myYes){
             console.log("change image");
             }
      </script>
</head>

<body>
     <input type = "button"  value = "Click Me"  onclick = "functionAlert();" />
   
   <div id = "updateImage">
         <div class = "message">This is a warning message.</div>
        <button type="submit" class = "changeName" onclick = "functionChangeName();">changeName</button>
         <button type="submit" class = "changeImage" onclick = "functionChangeImage();">changeImage</button>
      </div>
    
<div id="nameChange">
<form action = "UpdateImage" method = "post"
         enctype = "multipart/form-data">
<div class= "nameChangeMessage">Enter new Name</div>
	<input type="text" placeholder="Enter name" name="newName"/>
	<button type="submit" class = "changeNm" >Change Name</button>
</form>
</div>

</body>
</html>