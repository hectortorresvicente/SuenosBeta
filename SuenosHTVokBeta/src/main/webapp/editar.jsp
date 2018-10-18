<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SueñoS</title>
</head>
<body>
	<button onClick="location='/SuenosHTVokBeta'">Home</button>

	<h1>Editando</h1>


	<div class="editando">
		<div class="id">
			<label>IDS: </label>${listaSuenoSeleccionado.ids}</div>


		<div>

			<form action="" method="post">

				<div>
					<label>Titulo </label><input type="text" name="titulo"
						placeholder="Nombre" value="${listaSuenoSeleccionado.titulo}" />
				</div>
				<div>
					<label>Sueño </label><input type="text" name="sueno"
						placeholder="Código de país"
						value="${listaSuenoSeleccionado.sueno}" />
				</div>
				<div>
					<label>Comentario </label><input type="text" name="comentario"
						placeholder="Distrito"
						value="${listaSuenoSeleccionado.comentario}" />
				</div>

				<%-- <div>
					<label>Idus </label><input type="text" name="idus"
						placeholder="idus"
						value="${listaSuenoSeleccionado.idus}" />
				</div> --%>
				<div class="error">${error}</div>

				<button name="Modi">Modificar</button>


			</form>
			<br>
			<%-- <form action="" method="post">

				<div>
					<label>ids </label><input type="text" name="titulo"
						placeholder="Nombre" value="${listaSuenoSeleccionado.ids}" />
				</div> --%>

			<a href="./borrar?ids=${listaSuenoSeleccionado.ids}"> Eliminar</a>
			<!-- </form> -->

		</div>
	</div>

</body>
</html>