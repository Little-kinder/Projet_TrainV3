package fr.pantheonsorbonne.ufr27.miage.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Infogare {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int idInfogare;
	String typeInfogare;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Gare gare;
	
	public Infogare() {
		super();
	}
	
	public Infogare(int idInfogare, String typeInfogare) {
		this.idInfogare = idInfogare;
		this.typeInfogare = typeInfogare;
	}
	
	public int getIdInfogare() {
		return idInfogare;
	}
	public void setIdInfogare(int idInfogare) {
		this.idInfogare = idInfogare;
	}
	public String getTypeInfogare() {
		return typeInfogare;
	}
	public void setTypeInfogare(String typeInfogare) {
		this.typeInfogare = typeInfogare;
	}
	public Gare getGare() {
		return gare;
	}
	public void setGare(Gare gare) {
		this.gare = gare;
	}
	
	@Override
	public String toString() {
		return "Gare [id=" + idInfogare + ", typeInfogare=" + typeInfogare +" ]";
	}

}
