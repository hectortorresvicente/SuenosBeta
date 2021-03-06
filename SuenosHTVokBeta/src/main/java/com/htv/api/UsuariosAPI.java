package com.htv.api;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.htv.models.Usuario;
import com.htv.persistencia.UsuarioEM;


@Path("/usuarios")
public class UsuariosAPI {

	private static Logger logger = Logger.getLogger("Customers");

	public static List<Usuario> usuarios;

	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	// Codigo get
	public Response getUsuarios() {
		try {
			return Response.status(202).entity(UsuarioEM.getInstance().getListaUsuario()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Ha habido un error al pedir los pedidos").build();
		}
	};

	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	// Codigo POST
	public Response addUsuario(Usuario nuevoUsuario) {
		try {

			return Response.status(202).entity(UsuarioEM.getInstance().NuevoUsuario(nuevoUsuario)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode())
					.entity("Ha habido un error al guardar el pedido").build();
		}
	};

	@Path("/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getUsuariosPorNombre(@PathParam(value = "nombre") String nombre) {
		try {
			return Response.status(202).entity(UsuarioEM.getInstance().getUnUsuario(nombre)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Ha habido un error al pedir los pedidos").build();
		}

	};
}
