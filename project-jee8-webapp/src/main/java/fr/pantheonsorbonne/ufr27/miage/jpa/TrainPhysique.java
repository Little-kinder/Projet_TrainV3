package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.util.Objects;

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

	public TrainPhysique(int idTrainPhysique, Train train, boolean estRes, String localicationTrain) {
		Objects.requireNonNull(train);
		Objects.requireNonNull(localicationTrain);
		this.idTrainPhysique = idTrainPhysique;
		this.train = train;
		this.estRes = estRes;
		this.localicationTrain = localicationTrain;
	}

	public TrainPhysique() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int idTrainPhysique;
	@OneToOne(cascade = CascadeType.ALL) /* un trajet appartient que a un train et vis versa */
	Train train;
	boolean estRes;
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
		return estRes ? "TGV" : "TER";
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
