<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>BitAlert.org - Control Panel</title>

<!-- CSS -->
<link href="../../css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" media="screen" href="../css/ie6.css" /><![endif]-->
<!--[if IE 7]><link rel="stylesheet" type="text/css" media="screen" href="../css/ie7.css" /><![endif]-->

<!-- JavaScripts-->
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/jNice.js"></script>
</head>

<body>
<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    if (user != null) {
%>
	<div id="wrapper">
    	<!-- h1 tag stays for the logo, you can use the a tag for linking the index page -->
    	<h1><a href="http://www.bitalert.org"><span>BitAlert Backend</span></a></h1>
        
        <!-- You can name the links with lowercase, they will be transformed to uppercase by CSS, we prefered to name them with uppercase to have the same effect with disabled stylesheet -->
        <ul id="mainNav">
        	<li><a href="index.jsp" class="active">DASHBOARD</a></li> <!-- Use the "active" class for the active menu item  -->
        	<li><a href="database.jsp">DATABASE</a></li>
        	<li><a href="cronjob.jsp">CRONJOB</a></li>
            <li><a href="autotrade.jsp">AUTOTRADE</a></li>
            <li class="logout"><a href="http://www.appspot.com" target="_blank">APPSPOT</a></li>

        	</li>
        </ul>
        <!-- // #end mainNav -->
        
        <div id="containerHolder">
			<div id="container">
        		<div id="sidebar">
                	<ul class="sideNav">
                    	<li><a href="#" class="active">Take action!</a></li>
                    </ul>
                    <!-- // .sideNav -->
                </div>    
                <!-- // #sidebar -->
                
                <!-- h2 stays for breadcrumbs -->
                <h2><a href="#">Dashboard</a> &raquo; <a href="#" class="active">Overview</a></h2>
                
                <div id="main">
                	<form action="" class="jNice">
					<h3>Actions</h3>
                    	<table cellpadding="0" cellspacing="0">
							<tr>
                                <td>Stop sending mail</td>
                                <td class="action"><a href="#" class="view">ON</a><a href="#" class="delete">OFF</a></td>
                            </tr>                        
							<tr class="odd">
                                <td>Stop subscriptions </td>
                                <td class="action"><a href="#" class="view">ON</a><a href="#" class="delete">OFF</a></td>
                            </tr> 
                            <tr>
                                <td>Register Objects</td>
                                <td class="action"><a href="#" class="view" style="text-align:right">  <input type="submit" value="Submit Query" />
</a></td>
                            </tr>                                              
                        </table>
					</form>
                </div>
                <!-- // #main -->
                
                <div class="clear"></div>
            </div>
            <!-- // #container -->
        </div>	
        <!-- // #containerHolder -->
        
        <p id="footer"> <%= user.getNickname() %> is hungry and foolish</p>
    </div>
    <!-- // #wrapper -->
    
     <%
    } else {
%>
<p>Authorization required!
<a href="<%= userService.createLoginURL(request.getRequestURI()) %>">Sign in</a></p>
<%
    }
%>
</body>
</html>


