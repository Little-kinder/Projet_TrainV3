package fr.pantheonsorbonne.ufr27.miage.resource;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Arret;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Gare;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.ObjectFactory;



@Path("api/arret/{idarret}")
public class ArretResource {
	
	@Inject
	private EntityManager manager;
	
	int idArret;
	int idTrain;
	int idTrainPhysique;
	Gare idGare;
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
	public Response putIdGare(Gare idGare) throws DatatypeConfigurationException{
		arret.setIdGare(idGare);
		this.idGare=idGare;
		SeContainerInitializer initializer = SeContainerInitializer.newInstance();

		try (SeContainer container = initializer.addPackages(true, ArretResource.class.getPackage()).initialize()) {
			ArretResource jpa = container.select(ArretResource.class).get();
			EntityTransaction tx = jpa.manager.getTransaction();
			tx.begin();
			try {
				jpa.setIdArret();
			} catch (Exception e) {
				e.printStackTrace();
			}
			tx.commit();

			jpa.listEmployees();

			tx.begin();

			System.out.println("firing php guys");
			jpa.fireAllPhpGuys();

			tx.commit();

			

			System.out.println(".. done");

		}
		return Response.ok(idGare).build();
	}
	
}
