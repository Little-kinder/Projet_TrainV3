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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({ @NamedQuery(name = "findAllTrainsP", query = "select i from TrainPhysique i"),
		@NamedQuery(name = "countTrainsP", query = "select count(i) from TrainPhysique i"),
		@NamedQuery(name = "findTrainPById", query = "select i from TrainPhysique i where i.idTrainPhysique = :idTrainPhysique"),
		@NamedQuery(name = "deleteAllTrainsP", query = "delete from TrainPhysique") })

public class TrainPhysique {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int idTrainPhysique;
	@OneToOne(cascade = CascadeType.ALL)
	Train train;
	boolean estRes;
	double longitude;
	double latitude;

	public TrainPhysique(int idTrainPhysique, Train train, boolean estRes, double latitude, double longitude) {
		Objects.requireNonNull(train);
		if (longitude > 180 || longitude < -180 || latitude < -90 || latitude > 90) {
			throw new IllegalArgumentException(
					"La longitude doit est entre -180 et 180 et la latitude entre -90 et 90");
		}
		this.idTrainPhysique = idTrainPhysique;
		this.train = train;
		this.estRes = estRes;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public TrainPhysique() {
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

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	@Override
	public String toString() {
		return "TrainPhysique [idTrainPhysique=" + idTrainPhysique + ", train=" + train + ", estRes=" + estRes
				+ ", localicationTrain= " + latitude + ", " + longitude + "]";
	}

}
