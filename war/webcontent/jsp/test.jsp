<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="org.bitalert.global.Global"%>
<%@page import="org.bitalert.db.RegisterObject"%>

<% 
    //TODO Important, move somewhere else
    RegisterObject.register();


	//Bg color of the field value
    String bgColor = "#9C9";
    if(Global.ImproveString.equals(Global.TICKER_EQUAL))
    bgColor = "white";
    else if (Global.ImproveString.equals(Global.TICKER_WORSE))
    bgColor = "#F96";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>BitAlert.org - Test</title>

<link href="webcontent/css/style.css" rel="stylesheet" type="text/css" />
<link rel="icon" href="webcontent/img/favicon.png" type="image/png" />
<script type="text/javascript" src="webcontent/js/livevalidation_standalone.compressed.js"></script> 

		<!-- Start VideoLightBox.com HEAD section -->
		<link rel="stylesheet" href="webcontent/jsp/engine/css/videolightbox.css" type="text/css" />
		<style type="text/css">#videogallery a#videolb{display:none}</style>
		
			<link rel="stylesheet" type="text/css" href="webcontent/jsp/engine/css/overlay-minimal.css"/>
			<script src="webcontent/jsp/engine/js/jquery.tools.min.js" type="text/javascript"></script>
			<script src="webcontent/jsp/engine/js/swfobject.js" type="text/javascript"></script>
			<!-- make all links with the 'rel' attribute open overlays -->
			<script src="webcontent/jsp/engine/js/videolightbox.js" type="text/javascript"></script>
		<!-- End VideoLightBox.com HEAD section -->


</head>

<body bgcolor="#aabfcc">   

<h1>Bit Alert </h1>
<h2>Stop worrying - get an email when Bitcoin price changes - Test</h2>
<script type="text/javascript">

function onYouTubePlayerReady(playerId) { 
ytplayer = document.getElementById("video_overlay"); 
ytplayer.setVolume(100); 
} 

</script> 
<div id="videogallery">
	Learn more <a rel="#voverlay" href="http://vimeo.com/moogaloop.swf?clip_id=25362764&amp;server=vimeo.com&amp;show_title=1&amp;show_byline=1&amp;autoplay=1" title="Bit Alert - HowTo"><img src="webcontent/jsp/0.png" alt="Bit Alert - HowTo" /><span></span></a>
</div>

<form id="test_form" action="webcontent/jsp/addAlert.jsp" method="post">
<fieldset>
<legend>Try it.</legend>
    				<p><label for="email" class="displayBlock">Email (required):</label><input id="email" name="email" type="text"></p>
                    <p>
                      <label for="threshold" class="displayBlock">Alert when 1 bicoin  is &lt; $</label> 
                      <input type="text" id="lowThreshold" name="lowThreshold" size="5" maxlength="5">
                      <input type="text"  style="background-color:<%=bgColor%>" disabled="disabled" id="last" size="5" readonly="readonly" value="<%=Global.LastPrice%>"/>
or &gt;                     
<input type="text" id="highThreshold" name="highThreshold" size="5" maxlength="5" />
                    </p>
    		    <p><input class="submit" value="Test me!" type="submit"></p>
   		     </fieldset>
</form>
            
<script type="text/javascript">
		            var emailVal = new LiveValidation('email');
		            emailVal.add(Validate.Email );
</script>  

</body>
</html>
