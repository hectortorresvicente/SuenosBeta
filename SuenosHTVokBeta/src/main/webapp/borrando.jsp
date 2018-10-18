<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SueñoS</title>
</head>
<body>
	<button onClick="location='/SuenosHTVok'">Home</button>
	<h1>hola</h1>

	<form action="" method="post">

		<div>
			<label>ids </label><input type="text" name="titulo"
				placeholder="Nombre" value="${listaSuenoSeleccionado.ids}" />
		</div>

		<a href="./borrando?ids=${listaSuenoSeleccionado.ids}"><h3>
				Eliminar</h3></a>
	</form>
</body>
</html>