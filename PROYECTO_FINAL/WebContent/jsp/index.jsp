<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estiloLog.css"> 
</head>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="js/index.js"></script>
  
<body>

  <div class="wrapper">
	<div class="container">
		<h1><b>Bienvenido</b></h1>
		
<form name = "formc" action= "Controlador" method="post">

<input type="text" placeholder="Usuario" name="usuario">
			<input type="password" placeholder="Password" name="clave">
			<br><br>
			<input type="submit" value="Login">
		</form>
	</div>
	
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
</div>

</body>
</html>
