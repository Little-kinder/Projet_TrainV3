package fr.pantheonsorbonne.ufr27.miage.jpa;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Train {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int idTrain;
	LocalDateTime heureDepart;
	LocalDateTime heureArrivee;
	boolean etat;
	int nbPassager;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "train")
	Set<TrainPhysique> listTrain = new HashSet<>();
	
	public Set<TrainPhysique> getListTrain() {
		return listTrain;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "train")
	Set<Passager>passagers= new HashSet<>();
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "train")
//	@JoinColumn(name="idarret", nullable=false)
//	List<Arret>chemin = new ArrayList<Arret>();
	Arret depart, arrivee;
	public Train() {
	}
	
	public Train(int idTrain, LocalDateTime heureDepart, LocalDateTime heureArrivee, boolean etat, int nbPassager, Arret depart, Arret arrivee) {
		Objects.requireNonNull(depart);
		Objects.requireNonNull(arrivee);
		if (heureDepart.isAfter(heureArrivee)) {
			throw new IllegalArgumentException("L'heure de départ est erronée, heureDépart: " + heureDepart + " heureArrivée: " + heureArrivee);
		}
		this.idTrain = idTrain;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.etat = etat;
		this.nbPassager = nbPassager;
		this.depart = depart;
		this.arrivee = arrivee;
	}

	@Override
	public String toString() {
		return "Train [id=" + idTrain + ", heureDepart=" + heureDepart + ", heureArrivee=" + heureArrivee + ", nbPassager=" + nbPassager + "]";
	}
	
	
	public int getIdTrain() {
		return idTrain;
	}

	public boolean isEtat() {
		return etat;
	}

	public int getNbPassager() {
		return nbPassager;
	}

	public Set<Passager> getPassagers() {
		return passagers;
	}
	public void setPassagers(Set<Passager> passagers) {
		this.passagers = passagers;
	}
	
	public Arret getDepart() {
		return depart;
	}
	
	public Arret getArrivee() {
		return arrivee;
	}
	
	public LocalDateTime getHeureDepart() {
		return heureDepart;
	}

	public LocalDateTime getHeureArrivee() {
		return heureArrivee;
	}



//	public List<Arret> getChemin() {
//		return chemin;
//	}
//	public void setChemin(List<Arret> chemin) {
//		this.chemin = chemin;
//	}

}
