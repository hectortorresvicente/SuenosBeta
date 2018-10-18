<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SueñoS</title>

<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<button onClick="location='/SuenosHTVokBeta'">Home</button>

	<h1>Añadir Sueño</h1>

	<form action="" method="post">

		<div>
			<label>Idu: </label><span type="text" name="idu" placeholder="idu"
				value="0"> ${idUsuario} </span>
		</div>
		
		<div>
			<label>Ids: </label><span type="text" name="ids" placeholder="Nombre"
				value="0"> 0 </span>
		</div>

		<div>
			<label>Titulo </label><input type="text" name="titulo" size="15" maxlength="30"
				placeholder="Nombre" value="Titulo" />
		</div>
		<div>
			<label>Sueño </label><input type="text" id="sueno" name="sueno"
				placeholder="Código de país" value="Sueño" />
		</div>
		<div>
			<label>Comentario </label><input type="text" name="comentario"
				placeholder="Distrito" value="Comentario" />
		</div>
		<div>
		<span>año= ${fecha}</span>
		</div>
		<!-- <div>
			<label>Idus </label><input type="text" name="idus"
				placeholder="idus" value="2" />
		</div> -->	
		<br>	
	

			<button>Guardar</button>
	</form>

</body>
</html>


