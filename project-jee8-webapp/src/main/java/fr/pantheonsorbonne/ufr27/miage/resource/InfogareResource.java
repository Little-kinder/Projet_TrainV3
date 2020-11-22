package fr.pantheonsorbonne.ufr27.miage.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.datatype.DatatypeConfigurationException;


import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Infogare;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ObjectFactory;

@Path("api/infogare/{idinfogare}")
public class InfogareResource {
	int idInfogare;
	Infogare infogare;
	String typeInfogare;
	public InfogareResource(@PathParam("idinfogare") int idInfogare) {
		this.idInfogare = idInfogare;
		infogare = new ObjectFactory().createInfogare();
		infogare.setIdInfogare(idInfogare);
	}
	
	@PUT
	@Path("put")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response putTypeInfogare(@PathParam("idinfogare") int idInfogare, String typeInfogare) throws DatatypeConfigurationException{
		infogare.setIdInfogare(idInfogare);
		this.idInfogare=idInfogare;
		infogare.setTypeInfogare(typeInfogare);
		this.typeInfogare=typeInfogare;
		return Response.ok(typeInfogare).build();
	}
	
	@GET
	@Path("get")
	public Response getTypeInfogare(@PathParam("idinfogare") int idInfogare) {
		
		return Response.ok(infogare.getTypeInfogare()).build();
	}
}
