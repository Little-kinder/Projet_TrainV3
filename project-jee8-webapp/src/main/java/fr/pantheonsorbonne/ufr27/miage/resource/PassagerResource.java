package fr.pantheonsorbonne.ufr27.miage.resource;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.xml.datatype.DatatypeConfigurationException;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ObjectFactory;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Passager;

@Path("api/passager/{idpassager}")
public class PassagerResource {
	int idPassager;
	Passager passager;
	Boolean correspondance;
	public PassagerResource(@PathParam("idpassager") int idPassager) {
		this.idPassager = idPassager;
		passager = new ObjectFactory().createPassager();
		passager.setIdPass(idPassager);
	}
	
	@GET
	@Path("getcorrespondance")
	public Response getCorrespondance(@PathParam("idpassager") int idPassager) {
		passager.setIdPass(idPassager);
		return Response.ok(passager.isCorrespondance()).build();
	}
	
	@PUT
	@Path("putcorrespondance")
	public Response putCorrespondance(@PathParam("idpassager") int idPassager, boolean correspondance) throws DatatypeConfigurationException{
		passager.setIdPass(idPassager);
		passager.setCorrespondance(correspondance);
		return Response.ok(passager.isCorrespondance()).build();
	}
}
