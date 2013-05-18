<%@page import="java.io.*, java.util.*"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<HTML>
<HEAD>
<TITLE>EasyCab</TITLE>

<!--  This HTML file plays an .mp4 or .flv media file using JW Player 6.
The following code is from the Longtail Video Setup Wizard at 
http://www.longtailvideo.com/support/jw-player-setup-wizard.
-->

<!-- Call the JW Player JavaScript file, jwplayer.js. 
Replace DOWNLOAD-DISTRIBUTION-DOMAIN-NAME with the domain name of your 
CloudFront download distribution, for example, d1234.cloudfront.net 
(begins with "d"). This causes a browser to download the JW Player file 
before streaming begins.
-->
<script type="text/javascript" src="/embed/swfobject.js"></script>
<script type="text/javascript" src="jwplayer/jwplayer.js"></script>

</HEAD>

<BODY>
	<H1>EasyCab</H1>

	<h3>Register for our service </h3>
	Please register our easy taxi calling service
	<br /> Your New Accout Information:
	<form name='input' action='RegisterServlet' method='get'>
		User Name: <input type='email' name='userName'>Password: <input
			type='password' name='password'> <br>First Name: <input
			type='text' name='firstName'>Last Name: <input type='text'
			name='lastName'><input type='submit' value='Sign-up'>
	</form>
	<br />
	<form action="InitializingServlet" method="post" enctype="text/plain">
		<input type="submit" value="Initializing Service" />
	</form>
	<br />
	<form action="ListServlet" method="post" enctype="text/plain">
		<input type="submit" value="List All" />
	</form>
	<%
		if (request.getAttribute("information") != null) {
			String errorMessage = request.getAttribute("information")
					.toString();
			out.print(errorMessage);
		} else {
			out.print("welcome");
		}
	%>	
<%
		if (request.getAttribute("message") != null) {
			String errorMessage = request.getAttribute("message")
					.toString();
			out.print(errorMessage);
		} else {
			out.print("welcome");
		}
	%>	
</BODY>
</HTML>
