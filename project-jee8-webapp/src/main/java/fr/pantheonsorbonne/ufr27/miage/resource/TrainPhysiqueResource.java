package fr.pantheonsorbonne.ufr27.miage.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ObjectFactory;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainPhysique;



@Path("api/trainphys/{id}")
public class TrainPhysiqueResource {

	int idTrainPhys;

	public TrainPhysiqueResource(@PathParam("id") int idTrainPhys) {
		this.idTrainPhys = idTrainPhys;

	}
	
	@POST
	@Path("placeholder")
	public void postTrainLocation() {
		
	}

	@PUT
	@Path("location")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response putTrainLocation(String gpsCoordinate) throws DatatypeConfigurationException {
		TrainPhysique t = new ObjectFactory().createTrainPhysique();
		t.setIdTrainPhys(idTrainPhys);
		t.setLocalisationTrain(gpsCoordinate);
		String location = t.getLocalisationTrain();
		return Response.ok(location).build();
	}
	
	@GET
	@Path("info")
	public Response getInfoTrain() {
		return Response.ok().build();
	}

}
