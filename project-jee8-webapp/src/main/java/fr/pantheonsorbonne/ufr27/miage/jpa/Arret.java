package fr.pantheonsorbonne.ufr27.miage.jpa;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	String heureDepart;
	String heureArrivee;
	
	public Arret() {
		super();
	}

	public Arret(int idArret, int numeroVoix, String heureDepart,
			String heureArrivee, Train train, Gare gare) {
		this.idArret = idArret;
		this.train = train;
		this.gare = gare;
		this.numeroVoix = numeroVoix;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
	}


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
	public String getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}
	public String getHeureArrivee() {
		return heureArrivee;
	}
	public void setHeureArrivee(String heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	
	@Override
	public String toString() {
		return "Arret [id=" + idArret + ", heureDepart=" + heureDepart + ", heureArrivee=" + heureArrivee + ", numeroVoix=" + numeroVoix + "]";
	}

}
