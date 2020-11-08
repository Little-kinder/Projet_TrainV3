package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="train")
public class Train {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int idTrain;
	String typeTrain;
	LocalDateTime heureDepart;
	LocalDateTime heureArrivee;
	boolean etat;
	int nbPassager;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "train")
	List<Passager> passagers;
	List<String> Chemin;
	
	public List<Passager> getPassagers() {
		return passagers;
	}
	public void setPassagers(List<Passager> passagers) {
		this.passagers = passagers;
	}
		
	public int getIdTrain() {
		return idTrain;
	}
	public void setIdTrain(int idTrain) {
		this.idTrain = idTrain;
	}
	public String getTypeTrain() {
		return typeTrain;
	}
	public void setTypeTrain(String typeTrain) {
		this.typeTrain = typeTrain;
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
	public List<String> getChemin() {
		return Chemin;
	}
	public void setChemin(List<String> chemin) {
		Chemin = chemin;
	}


}
