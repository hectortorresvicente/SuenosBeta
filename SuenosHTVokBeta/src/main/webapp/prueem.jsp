<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EM</title>
</head>
<body>

	<h1>Sueños</h1>
	<a href="http://localhost:8080/SuenosHTVok/nuevo
	">
		<h3>Prueva EM</h3>
	</a>



	<h1>Sueños</h1>
	<a href="http://localhost:8080/SuenosHTVok/nuevo
	">
		<h3>Nuevo sueño</h3>
	</a>

	<a>EM= ${ListaSuenoEM}</a>
	<a>DAO= ${ListaSuenoDAO}</a>

	<ul>
		<c:forEach var="un" items="${ListaUsuariosEM}">
		<li><br> <label> sueño:</label> <h2>${un.sueno}</h2>
	


		</c:forEach>


	</ul>

	<ul>
		<c:forEach var="unSueno" items="${ListaSuenoEM}">

			<div>
				<li><br> <label>toda la clase: </label> <br> <a>${unSueno}</a>
					<br> <label>IDS: </label> <br> <a>${unSueno.ids}</a> <br>
					<label>Titulo: </label> <br> <span>${unSueno.titulo}</span> <br>
					<label>Sueño: </label> <br> <span>${unSueno.sueno}</span> <br>
					<label>Comentario: </label> <br> <span>${unSueno.comentario}</span>
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


</body>
</html>