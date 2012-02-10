<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="org.bitalert.global.Global"%>
<%@page import="org.bitalert.engine.AddAlert"%>


<% 
   String email = request.getParameter("email");
   String lowThreshold = request.getParameter("lowThreshold");
   String highThreshold = request.getParameter("highThreshold");
   
   //TODO Validate input !!! 
   
   AddAlert.add(email,lowThreshold,highThreshold);
   

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>testForm</title>

<link href="webcontent/css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="webcontent/js/livevalidation_standalone.compressed.js"></script> 

</head>

<body>        
<%=email%></br>
<%=lowThreshold%></br>
<%=highThreshold%></br>
            

</body>
</html>
