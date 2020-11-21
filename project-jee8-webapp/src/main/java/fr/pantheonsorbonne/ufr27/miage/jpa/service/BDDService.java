package fr.pantheonsorbonne.ufr27.miage.jpa.service;


import javax.persistence.EntityManager;


import org.jvnet.hk2.annotations.Service;

import fr.pantheonsorbonne.ufr27.miage.jpa.Arret;
import fr.pantheonsorbonne.ufr27.miage.jpa.Billet;
import fr.pantheonsorbonne.ufr27.miage.jpa.Gare;
import fr.pantheonsorbonne.ufr27.miage.jpa.Passager;
import fr.pantheonsorbonne.ufr27.miage.jpa.Train;
import fr.pantheonsorbonne.ufr27.miage.jpa.TrainPhysique;

@Service
public class BDDService {
	
	private EntityManager em;
	
	public BDDService(EntityManager em) {
		this.em = em;
	}
	
	
	public void input() {
		em.getTransaction().begin();
		
		Gare gare = new Gare(1, "Paris","Gare de l'Est");
		Gare gare2 = new Gare(2, "Paris","Gare du Nord");
		Gare gare3 = new Gare(3, "Bordeaux","Gare Bordeaux Saint-Jean");
		Gare gare4 = new Gare(4, "Lyon","Gare Part Dieu");
		Gare gare5 = new Gare(5, "Nantes","Gare Nantes");
		Gare gare6 = new Gare(6, "Toulouse","Gare Toulouse Matabiau");
		Gare gare7 = new Gare(7, "Lille","Gare de Lille Flandres");

		Gare[] gares = {gare, gare2, gare3, gare4, gare5, gare6, gare7};
		for(Gare g : gares ) {
			em.persist(g);
		}
		
		Train train = new Train(1,"20:00:00","22:00:00", true,10);
		Train train2 = new Train(2,"10:00:00","12:00:00", false,20);
		Train train3 = new Train(3,"15:30:00","17:00:00", true,30);
		Train train4 = new Train(4,"21:00:00","23:00:00", true,50);
		Train train5 = new Train(5,"12:00:00","13:00:00", false,15);
		
		Train[] trains = {train, train2, train3, train4, train5};
		for(Train t : trains) {
			em.persist(t);
		}
		
		Arret arret = new Arret(1,14,"22:00:00", "22:03:00", train, gare2);
	    Arret arret2 = new Arret(2,1,"21:00:00", "21:04:00", train5, gare);
	    Arret arret3 = new Arret(3,38,"19:50:00", "19:55:00", train4, gare4);
	    Arret arret4 = new Arret(4,116,"15:00:00", "15:03:00", train2, gare3);
	    Arret arret5 = new Arret(5,19,"18:35:00", "18:39:00", train, gare);

	    Arret[] arrets = {arret, arret2, arret3, arret4, arret5};
	    for(Arret a : arrets) {
	        em.persist(a);
	    }
	    
		//TrainPhysique tp = new TrainPhysique();

		/*	TrainPhysique trainphysique = new TrainPhysique(11);
			em.persist(trainphysique); // cree trainphysique
			
			Billet billet = new Billet(5);
			em.persist(billet);
			
			Passager passager = new Passager("Toto", false, billet);
			em.persist(passager);
			em.flush();
		
			long numOfPassagers = em.createNamedQuery("countPassagers", Long.class).getSingleResult();
			if (numOfPassagers > 0) {
				int res = em.createNamedQuery("deleteAllPassagers").executeUpdate();
				System.out.println("Deleted  " + res + " Passagers");

				int dep = em.createNamedQuery("deleteAllBillets").executeUpdate();
				System.out.println("Deleted  " + dep + " Billet(s)");

			em.persist(new Passager("Toto", true, billet));
			em.persist(new Passager("Fifi", false, billet));


			Collection<Passager> passagers = em.createNamedQuery("findAllPassagers", Passager.class).getResultList();
			for (Passager e : passagers) {
				System.out.println(e);
			}
*/
		
		em.getTransaction().commit();
	}

}
