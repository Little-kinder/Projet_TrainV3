package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "deleteAllBillets", query = "delete from Billet d")
public class Billet {
	  	@Id
	    int idBillet; 

	    public Billet() {
	    }


	    public Billet(int idBillet,TrainPhysique trainPhysique) {
	    	Objects.requireNonNull(trainPhysique);
	    	this.idBillet = idBillet;
	        this.trainPhysique = trainPhysique;
	    }

	    public int getIdBillet() {
	        return idBillet;
	    }
	    public void setIdBillet(int idBillet) {
	        this.idBillet = idBillet;
	    }

	    @ManyToOne(cascade = CascadeType.ALL)
	    TrainPhysique trainPhysique;

	    public TrainPhysique getTrainPhysique() {
	        return trainPhysique;
	    }
	    public void setTrainPhysique(TrainPhysique trainPhysique) {
	        this.trainPhysique = trainPhysique;
	    }
//	    public Passager getPassager() {
//	        return passager;
//	    }
//	    public void setPassager(Passager passager) {
//	        this.passager = passager;
//	    }

	    @Override
	    public String toString() {
	        return "Billet [idBillet=" + idBillet + ", trainPhysique=" + trainPhysique + "]";
	    }
	
}