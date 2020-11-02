package fr.pantheonsorbonne.ufr27.miage.resource;

import java.util.List;

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
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Train;



@Path("api/train/{id}")
public class TrainResource {
	int idTrain;
	Train t;
	boolean etat;
	int nbpassager;
	public TrainResource(@PathParam("id") int idTrain) {
		this.idTrain = idTrain;
		t = new ObjectFactory().createTrain();
		t.setIdTrain(idTrain);
		t.setNbPassager(0);
	}

	/*@PUT
	@Path("location")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response putTrainLocation(String gpsCoordinate) throws DatatypeConfigurationException {
		System.out.println("gpsCoordinate=" + gpsCoordinate);
		Train t = new ObjectFactory().createTrain();
		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2009-05-07T17:05:45.678Z");
		XMLGregorianCalendar date1 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2009-05-07T17:05:45.678Z");
		t.setHeureArrive(date2);
		t.setHeureDepart(date1);
		t.setIdTrain(idTrain);
		return Response.ok(t).build();
	}*/
	
	@GET
	@Path("etat")
	public Response getTrainEtat() throws DatatypeConfigurationException {	
		etat = t.isEtat();
		return Response.ok(etat).build();
	}
	
	@PUT
	@Path("hdep")
	public Response putTrainHeureDepart() throws DatatypeConfigurationException {
		return Response.ok().build();
	}
	
	@PUT
	@Path("harr")
	public Response putTrainHeureArrive() throws DatatypeConfigurationException {
		return Response.ok().build();
	}
	
	@PUT
	@Path("chemin")
	public Response putChemin() throws DatatypeConfigurationException {
		return Response.ok().build();
	}
	
	@GET
	@Path("nbpas")
	public Response putTrainnbPassager() throws DatatypeConfigurationException {
		nbpassager=t.getNbPassager();
		return Response.ok(nbpassager).build();
	}
}