package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Arret {

	@Id
	int idArret;
	/*Un trajet à plusieurs arrets, mais un arret n'a qu'un seul trajet */
	@ManyToOne(cascade = CascadeType.ALL)
	Train train;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	Gare gare;
	
	
	int numeroVoix;
	LocalDateTime heureDepart;
	LocalDateTime heureArrivee;
	
	public int getIdArret() {
		return idArret;
	}
	public void setIdArret(int idArret) {
		this.idArret = idArret;
	}
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	
	public Gare getGare() {
		return gare;
	}
	public void setGare(Gare gare) {
		this.gare = gare;
	}
	public int getNumeroVoix() {
		return numeroVoix;
	}
	public void setNumeroVoix(int numeroVoix) {
		this.numeroVoix = numeroVoix;
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
	

}
