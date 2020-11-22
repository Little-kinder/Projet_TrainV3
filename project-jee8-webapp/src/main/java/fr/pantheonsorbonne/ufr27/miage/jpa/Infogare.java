package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "showAllDetails", query = "select i from Infogare i")
public class Infogare {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int idInfogare;
	String typeInfogare;
	private final static Set<String> typeInfogares = Set.of("arrivés", "départs", "perturbations", "informations");
	@ManyToOne(cascade = CascadeType.ALL)
	Gare gare;

	public Infogare() {
	}

	public Infogare(int idInfogare, String typeInfogare, Gare gare) {
		Objects.requireNonNull(typeInfogare);
		Objects.requireNonNull(gare);
		if (!typeInfogares.contains(typeInfogare)) {
			throw new IllegalArgumentException("Le type n'est pas conforme : " + typeInfogare);
		}
		this.idInfogare = idInfogare;
		this.typeInfogare = typeInfogare;
		this.gare = gare;
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
		return "Gare [id=" + idInfogare + ", typeInfogare=" + typeInfogare + ", gare=" + gare + "]";
	}

}
