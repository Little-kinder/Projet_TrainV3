package fr.pantheonsorbonne.ufr27.miage.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "findAllGares", query = "select i from Gare i"),
	@NamedQuery(name = "countGares", query = "select count(i) from Gare i"),
	@NamedQuery(name = "findGareByNom", query = "select i from Gare i where i.nom = :nom"),
	@NamedQuery(name = "deleteGareByNom", query = "delete from Gare i where i.nom = :nom"),
	@NamedQuery(name = "deleteAllGares", query = "delete from Gare") })

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
