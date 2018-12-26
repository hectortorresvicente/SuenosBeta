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

import com.htv.models.Sueno;
import com.htv.models.Usuario;
import com.htv.persistencia.SuenoEM;
import com.htv.persistencia.UsuarioEM;


@Path("/suenos")
public class SuenoAPI {
	private static Logger logger = Logger.getLogger("Customers");

	public static List<Sueno> Suenos;
	
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	// Codigo get
	public Response getSuenos() {
		try {
			return Response.status(202).entity(SuenoEM.getInstance().getListaSuenos()).build();
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
	public Response addUsuario(Sueno SueñoNuevo) {
		try {

			return Response.status(202).entity(SuenoEM.getInstance().NuevoSueno(SueñoNuevo)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode())
					.entity("Ha habido un error al guardar el pedido").build();
		}
	};

	@Path("/{idu}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getUsuariosPorNombre(@PathParam(value = "idu") int idu) {
		try {
			return Response.status(202).entity(SuenoEM.getInstance().getListaSuenosPorUsuario(idu)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Ha habido un error al pedir los pedidos").build();
		}

	};
	
	
	
}


