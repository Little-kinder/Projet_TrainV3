package fr.pantheonsorbonne.ufr27.miage.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Gare;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ObjectFactory;

@Path("api/gare/{idgare}")
public class GareResource {
	int idGare;
	Gare gare;
	public GareResource(@PathParam("idgare") int idGare) {
		this.idGare=idGare;
		gare = new ObjectFactory().createGare();
		gare.setIdGare(idGare);
	}
	
	@GET
	@Path("ville")
	public Response getVilleGare() {

		
		return Response.ok(	gare.getVille()).build();
	}
	
	@GET
	@Path("localisation")
	public Response getLocalGare() {

		
		return Response.ok(	gare.getLocalisation()).build();
	}
}
