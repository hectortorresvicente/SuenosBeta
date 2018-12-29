package com.htv.api;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.htv.models.Sueno;

import com.htv.persistencia.SuenoEM;





@Path("/sueno")
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
	public Response addSueno(Sueno SueñoNuevo) {
		try {

			return Response.status(202).entity(SuenoEM.getInstance().NuevoSueno(SueñoNuevo)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode())
					.entity("Ha habido un error al guardar el pedido").build();
		}
	};

	@Path("")
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
	@Path("/editar/{ids}")
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	public Response deleteModulo(@PathParam("idu") int idu, @PathParam("ids") int ids) {

		try {

			boolean bSalida = SuenoEM.getInstance().BorrarSuenoById(ids);
			if (bSalida == true)
				return Response.status(202).entity(bSalida).build();
			else
				return Response.status(400).entity("El modulo no existe en el sistema").build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Ha habido un error al pedir el modulo").build();
		}
	
	
}
	@Path("/editar/{ids}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PUT
	public Response updateCurso(@PathParam("ids") int ids) {
		try {
			return Response.status(202).entity(SuenoEM.getInstance()).build();
		} catch (Exception e) {
			return Response.status(500).entity("Internal Server Error").build();
		}
	}
}


