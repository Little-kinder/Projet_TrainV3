package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity

@NamedQueries({ @NamedQuery(name = "findAllPassagers", query = "select i from Passager i"),
	@NamedQuery(name = "countPassagers", query = "select count(i) from Passager i"),
	@NamedQuery(name = "findPassagerByName", query = "select i from Passager i where i.name = :name"),
	@NamedQuery(name = "deletePassagerByName", query = "delete from Passager i where i.name = :name"),
	@NamedQuery(name = "deleteAllPassagers", query = "delete from Passager") })


public class Passager {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int idPassager;
	String name;
	boolean correspondance;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Train train;
	
	@OneToOne(cascade = CascadeType.ALL)
	Billet billet = null;
	
	public Passager() {
	}
	
	
	
	public Passager(int idPassager, String name, boolean correspondance, Train train, Billet billet) {
		Objects.requireNonNull(train);
		Objects.requireNonNull(name);
		Objects.requireNonNull(billet);
		this.idPassager = idPassager;
		this.name = name;
		this.correspondance = correspondance;
		this.train = train;
		this.billet = billet;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Billet getBillet() {
		return billet;
	}

	public void setBillet(Billet billet) {
		this.billet = billet;
	}

	public int getIdPassager() {
		return idPassager;
	}

	public void setIdPassager(int idPassager) {
		this.idPassager = idPassager;
	}

	public boolean isCorrespondance() {
		return correspondance;
	}

	public void setCorrespondance(boolean correspondance) {
		this.correspondance = correspondance;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}
	
	@Override
	public String toString() {
		return "Passager [name=" + name + ", correspondance=" + correspondance + ", billet="+ billet +"]";
	}

}
