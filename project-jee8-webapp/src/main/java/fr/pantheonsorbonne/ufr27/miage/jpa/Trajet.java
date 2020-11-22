package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.util.ArrayList;
import java.util.List;

public class Trajet {
	Arret arretDepart, arretArrivee;
	List<Arret>chemin = new ArrayList<Arret>();
}
