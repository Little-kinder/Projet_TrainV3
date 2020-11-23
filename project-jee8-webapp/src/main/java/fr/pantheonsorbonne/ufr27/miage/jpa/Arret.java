package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Arret {

	@Id
	int idArret;

	@ManyToOne(cascade = CascadeType.ALL)
	Gare gare;
	int numeroVoix;

	public Arret() {
	}

	public Arret(int idArret, int numeroVoix, Gare gare) {
		Objects.requireNonNull(gare);

		this.idArret = idArret;
		this.gare = gare;
		this.numeroVoix = numeroVoix;
	}

	public int getIdArret() {
		return idArret;
	}

	public void setIdArret(int idArret) {
		this.idArret = idArret;
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

}
