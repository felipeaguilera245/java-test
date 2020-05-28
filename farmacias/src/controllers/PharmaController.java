package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import models.Pharma;

@Path("/pharma")
public class PharmaController {

	@GET
	@Path("/list/{comune_id}/{search_local}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAlbums(@PathParam("comune_id") String comune_id, @PathParam("search_local") String search_local,
			@Context HttpServletRequest request) {

		Pharma pharma = new Pharma();

		JSONObject object = pharma.getList(comune_id, search_local);

		return Response.status(200).entity(object.toString()).build();

	}

	@GET
	@Path("/comune/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response comune(@Context HttpServletRequest request) {

		Pharma pharma = new Pharma();

		JSONObject object = pharma.getComunes();

		return Response.status(200).entity(object.toString()).build();

	}

	@GET
	@Path("/pharma_names/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pharma_names(@Context HttpServletRequest request) {

		Pharma pharma = new Pharma();

		JSONObject object = pharma.getPharmaNames();

		return Response.status(200).entity(object.toString()).build();

	}

}
