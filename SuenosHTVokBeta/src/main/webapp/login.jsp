<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	
<!--  CSS -->

<link rel="stylesheet" href="./css/style.css">

<title>SueñoS</title>
</head>
<body id="body">


	<h1>BD Sueños</h1>

	<hr>
	<label> ${error} </label>

	<form action="" method="post">
	<div> </div>

		<!-- <div>
			<label>Idu: </label><span type="text" name="ids" placeholder="Nombre"
				value="0"> 0 </span>
		</div> -->

		<div>
			<label>Nombre </label><input var="uno" type="nombre" name="nombre"
				placeholder="nombre" value="hola1" />
		</div>
		<!-- <div>
			<label>Correo </label><input type="correo" name="correo"
				placeholder="correo" value="Correo" />
		</div> -->
		<div>
			<label>Contraseña </label><input type="contraseña" name="contraseña"
				placeholder="contraseña" value="hola1" />
		</div>


		<button>Entrar</button>
	</form>


	<a href="./registro"><h3>No estoy registrado</h3></a>
	
	<a href="./juego"><h4>Me aburro- quiero jugar</h4></a>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js "
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN "
		crossorigin="anonymous "></script>
		
		<script type="text/javascript" src="./js/login.js"></script>

	

</body>
</html>