package fr.pantheonsorbonne.ufr27.miage.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gare")
public class Gare {
	
	@Id
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
	

}
