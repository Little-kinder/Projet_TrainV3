package fr.pantheonsorbonne.ufr27.miage.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import fr.pantheonsorbonne.ufr27.miage.jpa.Arret;
import fr.pantheonsorbonne.ufr27.miage.jpa.Contract;
import fr.pantheonsorbonne.ufr27.miage.jpa.Customer;
import fr.pantheonsorbonne.ufr27.miage.jpa.Invoice;
import fr.pantheonsorbonne.ufr27.miage.jpa.Train;
import service.InfoCentreService;
import service.InfoGareService;
import fr.pantheonsorbonne.ufr27.miage.dao.TrainDAO;
import service.InvoicingService;
import service.MailingService;

@Stateless
public class InfoGareServiceImpl implements InfoGareService {

	@Inject
	EntityManager em;
	
	@Inject
	MailingService ms;
	
	@Inject 
	TrainDAO TrainDAO;

	

	

}
