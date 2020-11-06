package fr.pantheonsorbonne.ufr27.miage.resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Arret;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ObjectFactory;



@Path("api/arret/{idarret}")
public class ArretResource {
	int idArret;
	int idTrain;
	int idTrainPhysique;
	int idGare;
	Arret arret;
	int numeroVoie;
	XMLGregorianCalendar heureArrive;
	XMLGregorianCalendar heureDepart;
	
	public ArretResource(@PathParam("idarret") int idArret) {
		this.idArret = idArret;
		arret = new ObjectFactory().createArret();
		arret.setIdArret(idArret);
	}
	
	@PUT
	@Path("gare")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response putIdGare(int idGare) throws DatatypeConfigurationException{
		arret.setIdGare(idGare);
		this.idGare=idGare;
		return Response.ok(idGare).build();
	}
	
}
