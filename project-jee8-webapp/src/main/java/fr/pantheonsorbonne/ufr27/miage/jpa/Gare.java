package fr.pantheonsorbonne.ufr27.miage.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gare {
	
	public Gare(int idGare, String ville, String localisation) {
		super();
		this.idGare = idGare;
		this.ville = ville;
		this.localisation = localisation;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int idGare;
	
	public int getIdGare() {
		return idGare;
	}
	public void setIdGare(int idGare) {
		this.idGare = idGare;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	String ville;
	String localisation;
	
	public Gare() {
		
	}
	
	
	@Override
	public String toString() {
		return "Gare [id=" + idGare + ", ville=" + ville + ", localisation=" + localisation + " ]";
	}

}
