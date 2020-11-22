package fr.pantheonsorbonne.ufr27.miage.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gare {

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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	String ville;
	String nom;
	
	public Gare() {
		
	}

	public Gare(int idGare, String ville, String nom) {
		this.idGare = idGare;
		this.ville = ville;
		this.nom = nom;
	}

	
	@Override
	public String toString() {
		return "Gare [id=" + idGare + ", ville=" + ville + ", nom=" + nom + " ]";
	}

}
