package fr.pantheonsorbonne.ufr27.miage.jpa.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;

import org.jvnet.hk2.annotations.Service;

import fr.pantheonsorbonne.ufr27.miage.jpa.Arret;
import fr.pantheonsorbonne.ufr27.miage.jpa.Billet;
import fr.pantheonsorbonne.ufr27.miage.jpa.Gare;
import fr.pantheonsorbonne.ufr27.miage.jpa.Infogare;
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

		Gare gare = new Gare(1, "Paris", "Gare de l'Est");
		Gare gare2 = new Gare(2, "Paris", "Gare du Nord");
		Gare gare3 = new Gare(3, "Bordeaux", "Gare Bordeaux Saint-Jean");
		Gare gare4 = new Gare(4, "Lyon", "Gare Part Dieu");
		Gare gare5 = new Gare(5, "Nantes", "Gare Nantes");
		Gare gare6 = new Gare(6, "Toulouse", "Gare Toulouse Matabiau");
		Gare gare7 = new Gare(7, "Lille", "Gare de Lille Flandres");

		Gare[] gares = { gare, gare2, gare3, gare4, gare5, gare6, gare7 };
		for (Gare g : gares) {
			em.persist(g);
		}

		Arret arret = new Arret(1, 14, gare2);
		Arret arret2 = new Arret(2, 1, gare);
		Arret arret3 = new Arret(3, 38, gare4);
		Arret arret4 = new Arret(4, 116, gare3);
		Arret arret5 = new Arret(5, 19, gare);

		Arret[] arrets = { arret, arret2, arret3, arret4, arret5 };
		for (Arret a : arrets) {
			em.persist(a);
		}

		// Année, mois, jour, heure, minute
		Train train = new Train(1, LocalDateTime.of(2020, 5, 12, 15, 56), LocalDateTime.of(2020, 5, 12, 15, 59), true,
				10, arret, arret2);
		Train train2 = new Train(2, LocalDateTime.of(2020, 12, 8, 20, 00), LocalDateTime.of(2020, 12, 8, 20, 05), false,
				20, arret3, arret);
		Train train3 = new Train(3, LocalDateTime.of(2020, 5, 22, 21, 45), LocalDateTime.of(2020, 5, 22, 21, 55), true,
				30, arret5, arret4);
		Train train4 = new Train(4, LocalDateTime.of(2020, 6, 9, 1, 48), LocalDateTime.of(2020, 6, 9, 2, 00), true, 50,
				arret, arret3);
		Train train5 = new Train(5, LocalDateTime.of(2020, 5, 1, 19, 35), LocalDateTime.of(2020, 5, 1, 19, 40), false,
				15, arret2, arret4);

		Train[] trains = { train, train2, train3, train4, train5 };
		for (Train t : trains) {
			em.persist(t);
		}

		TrainPhysique tp = new TrainPhysique(1, train, true, "Paris");
		TrainPhysique tp2 = new TrainPhysique(2, train, false, "Paris");
		TrainPhysique tp3 = new TrainPhysique(3, train3, true, "Bordeaux");
		TrainPhysique tp4 = new TrainPhysique(4, train, false, "Toulouse");
		TrainPhysique tp5 = new TrainPhysique(5, train, true, "Lyon");

		TrainPhysique[] tps = { tp, tp2, tp3, tp4, tp5 };
		for (TrainPhysique tr : tps) {
			em.persist(tr);
		}

		// Init Billet
		IntStream.range(0, 5).forEach(i -> em.persist(new Billet(i + 1, tps[i])));

		// Init infoGare
		String[] typeinfogare = new String[] { "arrivés", "informations", "départs", "arrivés", "perturbations" };
		IntStream.range(0, 5).forEach(i -> em.persist(new Infogare(i + 1, typeinfogare[i], gares[i])));

		Passager passager = new Passager(1, "Ines", false, train, new Billet(6, tp));
		Passager passager2 = new Passager(2, "Pauline", false, train2, new Billet(9, tp));
		Passager passager3 = new Passager(3, "Thomas", false, train, new Billet(10, tp2));
		Passager passager4 = new Passager(4, "Rami", false, train4, new Billet(8, tp4));
		Passager passager5 = new Passager(5, "Luna", false, train3, new Billet(7, tp5));

		Passager[] passagers = { passager, passager2, passager3, passager4, passager5 };
		for (Passager p : passagers) {
			em.persist(p);
		}

		// Nombre de passagers
		Long res = em.createNamedQuery("countPassagers", Long.class).getSingleResult();
		System.out.println("There are " + res + " Passagers");

		// Suppression passagers
		if (res > 0) {
			int res1 = em.createNamedQuery("deleteAllPassagers").executeUpdate();
			System.out.println("Deleted  " + res1 + " Passagers");
		}

		// Liste de passagers
		Collection<Passager> pgrs = em.createNamedQuery("findAllPassagers", Passager.class).getResultList();
		for (Passager e : pgrs) {
			System.out.println(e);
		}
		
		// Trouver TrainPhysique par id
		TrainPhysique trainp = em.createNamedQuery("findTrainPById", TrainPhysique.class)
						.setParameter("idTrainPhysique", 1).getSingleResult();
		System.out.println(trainp);

		// Trouver la liste des billets dont les idtrainPhysiques sont 1
		Collection<Billet> bs = em.createNamedQuery("findBilletByTrainP", Billet.class)
						.setParameter("idTrainPhysique", 1).getResultList();
		for (Billet e : bs) {
			System.out.println(e);
		}


//		// Suppression tous Billets		
//	  int dep = em.createNamedQuery("deleteAllBillets").executeUpdate();
//	  System.out.println("Deleted  " + dep + " Billet(s)");
//		 
//		// Suppression tous TrainPhysiques		 
//		int dep2 = em.createNamedQuery("deleteAllTrainsP").executeUpdate();
//		System.out.println("Deleted  " + dep2 + " TrainP(s)");

		
		em.getTransaction().commit();
	}

}
