package fr.pantheonsorbonne.ufr27.miage.resource;

import java.time.LocalDateTime;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.datatype.DatatypeConfigurationException;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Arret;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Gare;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ObjectFactory;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Train;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainPhysique;

@Path("api/infocentre/{idtrainp}")
public class InfocentreResource {
	
	int idArret;
	int idTrainP;
	TrainPhysique idTrainPhysique;
	Gare idGare;
	Arret arret;
	Train train;
	TrainPhysique trainP;
	int numeroVoie;
	LocalDateTime heureArrive;
	LocalDateTime heureDepart;
	String localisation;
	boolean etat;
	
	public InfocentreResource(@PathParam("idtrainp") int idTrainP) {
		this.idTrainP = idTrainP;
		trainP = new ObjectFactory().createTrainPhysique();
		trainP.setIdTrainPhys(idTrainP);
	}
	
	@PUT
	@Path("putE")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response putTrainLocalE(@PathParam("idtrainp") int idTrainP, boolean etat) throws DatatypeConfigurationException{
		train.setEtat(etat);
		
		return Response.ok(etat).build();
	}
	
	@PUT
	@Path("putL")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response putTrainLocalL(@PathParam("idtrainp") int idTrainP, String localisation) throws DatatypeConfigurationException{
		trainP.setLocalisationTrain(localisation);
		
		
		return Response.ok(localisation).build();
	}
	
	@GET
	@Path("getL")
	public Response getLocalisation() {
		return Response.ok(trainP.getLocalisationTrain()).build();
	}
	
	@GET
	@Path("getE")
	public Response getEtat() {
		return Response.ok(train.isEtat()).build();
	}
}
