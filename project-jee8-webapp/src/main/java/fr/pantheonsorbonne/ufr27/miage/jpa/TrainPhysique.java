package fr.pantheonsorbonne.ufr27.miage.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="trainPhysique")
public class TrainPhysique {
	
	@Id
	int idTrainPhysique;
	String type;
	
	@OneToOne(cascade = CascadeType.ALL)
	Train idTrain;
	
	String localicationTrain;
	
	public int getIdTrainPhysique() {
		return idTrainPhysique;
	}

	public void setIdTrainPhysique(int idTrainPhysique) {
		this.idTrainPhysique = idTrainPhysique;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Train getIdTrain() {
		return idTrain;
	}

	public void setIdTrain(Train idTrain) {
		this.idTrain = idTrain;
	}

	public String getLocalicationTrain() {
		return localicationTrain;
	}

	public void setLocalicationTrain(String localicationTrain) {
		this.localicationTrain = localicationTrain;
	}


}
