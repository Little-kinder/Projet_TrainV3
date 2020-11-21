package fr.pantheonsorbonne.ufr27.miage.jpa;

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
	        super();
	    }

	    public Billet(int idBillet) {
	        this.idBillet = idBillet;
	    }

	    public Billet(TrainPhysique trainPhysique, Passager passager) {
	        this.trainPhysique = trainPhysique;
	        this.passager = passager;
	    }

	    public int getIdBillet() {
	        return idBillet;
	    }
	    public void setIdBillet(int idBillet) {
	        this.idBillet = idBillet;
	    }

	    @ManyToOne(cascade = CascadeType.ALL)
	    TrainPhysique trainPhysique;

	    @OneToOne(cascade = CascadeType.ALL)
	    Passager passager;

	    public TrainPhysique getTrainPhysique() {
	        return trainPhysique;
	    }
	    public void setTrainPhysique(TrainPhysique trainPhysique) {
	        this.trainPhysique = trainPhysique;
	    }
	    public Passager getPassager() {
	        return passager;
	    }
	    public void setPassager(Passager passager) {
	        this.passager = passager;
	    }

	    @Override
	    public String toString() {
	        return "Billet [idBillet=" + idBillet + ", trainPhysique=" + trainPhysique + ", passager=" + passager + "]";
	    }
	
}