package fr.pantheonsorbonne.ufr27.miage.jpa;

import javax.persistence.Entity;

@Entity
public class TrainResO extends TrainPhysique{
	
	String type = "TER";	
	
	public String getType() {
		return type;
	}
}
