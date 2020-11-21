package fr.pantheonsorbonne.ufr27.miage.resource;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.time.LocalDateTime;
import java.util.List;

import javax.ws.rs.Consumes;
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



@Path("api/arret/{idarret}")
public class ArretResource {
	
	/*@Inject
	private EntityManager manager;*/
	
	int idArret;
	Train idTrain;
	TrainPhysique idTrainPhysique;
	Gare idGare;
	Arret arret;
	int numeroVoie;
	LocalDateTime heureArrive;
	LocalDateTime heureDepart;
	
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
		/*SeContainerInitializer initializer = SeContainerInitializer.newInstance();

		try (SeContainer container = initializer.addPackages(true, ArretResource.class.getPackage()).initialize()) {
			ArretResource jpa = container.select(ArretResource.class).get();
			EntityTransaction tx = jpa.manager.getTransaction();
			tx.begin();
			try {
				jpa.creerGare(idGare);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(".. done");

		}*/
		return Response.ok(idGare).build();
	}
	
	/*public void creerGare(Gare idGare) {
		// get the main criteria building block
				CriteriaBuilder builder = manager.getCriteriaBuilder();

				// create the query with the expected return type
				CriteriaQuery<Arret> query = builder.createQuery(Arret.class);
				// table from which to return data
				Root<Arret> root = query.from(Arret.class);
				
				manager.createNativeQuery("insert into Arret ()
		
				// joint with DepartmentTable
				//Join<Employee, Department> join = root.join(Employee_.department);

				// different predicates for different requests
				//Predicate predicateJava = builder.equal(join.get(Department_.NAME), "java");
				//Predicate predicatePhp = builder.equal(join.get(Department_.NAME), "php");

	

				manager.persist(new Arret("Goofie", departmentPhp,80));

				}
	}*/
	

}
