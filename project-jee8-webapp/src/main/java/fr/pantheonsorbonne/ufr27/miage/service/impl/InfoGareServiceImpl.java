package fr.pantheonsorbonne.ufr27.miage.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import service.InfoGareService;
import fr.pantheonsorbonne.ufr27.miage.dao.TrainDAO;
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
