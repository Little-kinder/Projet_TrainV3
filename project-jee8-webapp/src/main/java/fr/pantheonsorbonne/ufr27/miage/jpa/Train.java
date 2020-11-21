package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

	
	

	private String typeTrain;

	public Train(int idTrain, String typeTrain, LocalDateTime heureDepart, LocalDateTime heureArrivee, boolean etat,
			int nbPassager, Set<TrainPhysique> listTrain, Set<Passager> passagers, List<Arret> chemin) {
		super();
		this.idTrain = idTrain;
		this.typeTrain = typeTrain;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.etat = etat;
		this.nbPassager = nbPassager;
		this.listTrain = listTrain;
		this.passagers = passagers;
		this.chemin = chemin;
	}
	
	public Train() {
		super();
	}
	

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
	public void setListTrain(Set<TrainPhysique> listTrain) {
		this.listTrain = listTrain;
	}
	
	
	public Train(int idTrain, LocalDateTime heureDepart, LocalDateTime heureArrivee,
			int nbPassager) {
		this.idTrain = idTrain;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.nbPassager = nbPassager;
	}
	
	public Train(int idTrain, int nbPassager) {
		this.idTrain = idTrain;
		this.nbPassager = nbPassager;
	}
	
	@Override
	public String toString() {
		return "Train [id=" + idTrain + ", heureDepart=" + heureDepart + ", heureArrivee=" + heureArrivee + ", nbPassager=" + nbPassager + "]";
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "train")
	Set<Passager>passagers= new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "train")
	 @JoinColumn(name="idarret", nullable=false)
	List<Arret>chemin = new ArrayList<Arret>();
	
	public int getIdTrain() {
		return idTrain;
	}
	public void setIdTrain(int idTrain) {
		this.idTrain = idTrain;
	}
	public LocalDateTime getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(LocalDateTime heureDepart) {
		this.heureDepart = heureDepart;
	}
	public LocalDateTime getHeureArrivee() {
		return heureArrivee;
	}
	public void setHeureArrivee(LocalDateTime heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public int getNbPassager() {
		return nbPassager;
	}
	public void setNbPassager(int nbPassager) {
		this.nbPassager = nbPassager;
	}
	public Set<Passager> getPassagers() {
		return passagers;
	}
	public void setPassagers(Set<Passager> passagers) {
		this.passagers = passagers;
	}
	public List<Arret> getChemin() {
		return chemin;
	}
	public void setChemin(List<Arret> chemin) {
		this.chemin = chemin;
	}

}
