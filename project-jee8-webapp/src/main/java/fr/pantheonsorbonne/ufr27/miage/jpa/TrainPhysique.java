package fr.pantheonsorbonne.ufr27.miage.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToOne;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class TrainPhysique {
	
	public TrainPhysique() {
		super();
	}
	
	public TrainPhysique(int idTrainPhysique) {
		this.idTrainPhysique = idTrainPhysique;
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int idTrainPhysique;
	String type;
	@OneToOne(cascade = CascadeType.ALL)/*un trajet appartient que a un train et vis versa*/
	Train train;
	
	String localicationTrain;
	
	@Override
	public String toString() {
		return "TrainPhysique [id=" + idTrainPhysique + "]";
	}

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

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public String getLocalicationTrain() {
		return localicationTrain;
	}

	public void setLocalicationTrain(String localicationTrain) {
		this.localicationTrain = localicationTrain;
	}

}
