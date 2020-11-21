package fr.pantheonsorbonne.ufr27.miage.jpa;

import javax.persistence.Entity;

@Entity
public class TrainResNo extends TrainPhysique{
	
	String type = "TGV";	
	
	public String getType() {
		return type;
	}

	
}
