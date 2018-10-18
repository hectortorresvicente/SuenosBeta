<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<button onClick="location='/SuenosHTVokBeta'">Home</button>


	<h1>gestionando Usuario</h1>
	



	<form action="" method="post">

		<label>idu: </label> <input type="number"  name="idu" value="${UnUsuario.idu}" placeholder="idu" readonly /> <br> 
		<label>nombre:</label> 
		<input type="text" name="nombre" placeholder="nombre"
			value="${UnUsuario.nombre}" /><br> 
		<label>correo:</label> 
		<input type="text" name="correo" placeholder="correo" 
		    value="${UnUsuario.correo}" /><br> 
			
		<label>contraseña:</label>
		<input type="text" name="contraseña" placeholder="contraseña"
			value="${UnUsuario.contraseña}" /><br>

<div> <a> ${modificado} </a></div>

		<button name="Modi">Modificar</button>
	</form>
	<br>
	<br>
	<a href="./borrarUs?idu=${UnUsuario.idu}"> Eliminar</a>


</body>
</html>