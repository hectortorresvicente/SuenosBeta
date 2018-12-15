<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>SueñoS</title>
</head>

<!-- <script type="text/javascript">
setTimeout( 3000);
location.href ="http://localhost:8080/SuenosHTVokBeta/sueno";
console.log("lanzando setTimeout")
break;


</script> -->

<body onload="">
<a href="http://localhost:8080/SuenosHTVokBeta/logout
	">
		<h2>Logout</h2>
	</a>
	<button value="bton" onclick="TiempoLanza()"/>Entrar</button>
	<br><br>
	
	<span> Ultima entrada =   ${dateSql}</span>
	
	<a href="http://localhost:8080/SuenosHTVokBeta/sueno
	">
		<h2>Gargar lista de sueños</h2>
	</a>

	<h1>Sueños</h1>
	<a href="http://localhost:8080/SuenosHTVokBeta/nuevo?idu=${usuarioRecep.idu}
	">
		<h3>Nuevo sueño</h3>
	</a>
	<a href="http://localhost:8080/SuenosHTVokBeta/usuario
	">
		<h3>usuario</h3>
	</a>
	<hr><div>
	<label name="hola" id="hola">IdUsaurio = ${usuarioRecep.idu} </label>
	<hr><div>
	<label>Total sueños = ${totalSuenos} </label>
	</div>
	<hr>

	
	

	<ul>
		<c:forEach var="unSueno" items="${listaSuenoEM}">

			<div>
				<li><br> <label>IDS: </label> <br> <a>${unSueno.ids}</a>
					<br> <label>Titulo: </label> <br> <span>${unSueno.titulo}</span>
					<br> <label>Sueño: </label> <br> <span>${unSueno.sueno}</span>
					<br> <label>Comentario: </label> <br> <span>${unSueno.comentario}</span>
					<%-- <br> <label>IduS: </label> <br> <span>${unSueno.idus}</span> --%>
					<br> <a href="./editar?ids=${unSueno.ids}"><h3>
							Editar</h3></a> <br> <%-- <button onClick="./editar?ids=${unSueno.ids}
"  class=eeditar data-id='${unSueno.ids}'>Editar</button> --%>
					<form action="" method="post">

						<div>
							<span type="text" name="ids" placeholder="Nombre"
								value="${unSueno.ids}"></span>
						</div>

					</form>
					
					<hr></li>
			</div>
			

		</c:forEach>
	</ul>


<script src="./js/suenos.js"></script>
</body>
</html>