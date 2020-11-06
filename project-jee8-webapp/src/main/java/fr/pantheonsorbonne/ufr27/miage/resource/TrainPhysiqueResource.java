package fr.pantheonsorbonne.ufr27.miage.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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

	@GET
	@Path("location")
	public Response putTrainLocation() throws DatatypeConfigurationException {
		TrainPhysique t = new ObjectFactory().createTrainPhysique();
		t.setIdTrainPhys(idTrainPhys);
		t.setLocalisationTrain("48°49\'32.7\"N 2°21\'35.7\"E");
		String location = t.getLocalisationTrain();
		return Response.ok(location).build();
	}
}
