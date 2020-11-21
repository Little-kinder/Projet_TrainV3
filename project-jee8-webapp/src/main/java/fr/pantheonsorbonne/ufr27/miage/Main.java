package fr.pantheonsorbonne.ufr27.miage;

import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.Locale;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.bridge.SLF4JBridgeHandler;

import fr.pantheonsorbonne.ufr27.miage.conf.EMFFactory;
import fr.pantheonsorbonne.ufr27.miage.conf.EMFactory;
import fr.pantheonsorbonne.ufr27.miage.conf.PersistenceConf;
import fr.pantheonsorbonne.ufr27.miage.dao.InvoiceDAO;
import fr.pantheonsorbonne.ufr27.miage.dao.PaymentDAO;
import fr.pantheonsorbonne.ufr27.miage.exception.ExceptionMapper;
import fr.pantheonsorbonne.ufr27.miage.jms.PaymentValidationAckownledgerBean;
import fr.pantheonsorbonne.ufr27.miage.jms.conf.ConnectionFactorySupplier;
import fr.pantheonsorbonne.ufr27.miage.jms.conf.JMSProducer;
import fr.pantheonsorbonne.ufr27.miage.jms.conf.PaymentAckQueueSupplier;
import fr.pantheonsorbonne.ufr27.miage.jms.conf.PaymentQueueSupplier;
import fr.pantheonsorbonne.ufr27.miage.jms.utils.BrokerUtils;
import fr.pantheonsorbonne.ufr27.miage.jpa.Billet;
import fr.pantheonsorbonne.ufr27.miage.jpa.Passager;
import fr.pantheonsorbonne.ufr27.miage.jpa.TrainPhysique;
import fr.pantheonsorbonne.ufr27.miage.service.impl.GymServiceImpl;
import fr.pantheonsorbonne.ufr27.miage.service.impl.InvoicingServiceImpl;
import fr.pantheonsorbonne.ufr27.miage.service.impl.MailingServiceImpl;
import fr.pantheonsorbonne.ufr27.miage.service.impl.PaymentServiceImpl;
import fr.pantheonsorbonne.ufr27.miage.service.impl.UserServiceImpl;
import service.GymService;
import service.InvoicingService;
import service.MailingService;
import service.PaymentService;
import service.UserService;

/**
 * Main class.
 *
 */
public class Main {

	public static final String BASE_URI = "http://localhost:8080/";

	@Inject
	private EntityManager manager;
	
	public static HttpServer startServer() {

		final ResourceConfig rc = new ResourceConfig()//
				.packages(true, "fr.pantheonsorbonne.ufr27.miage")//
				.register(DeclarativeLinkingFeature.class)//
				.register(ExceptionMapper.class)
				.register(PersistenceConf.class)
				.register(new AbstractBinder() {

					@Override
					protected void configure() {

						bind(GymServiceImpl.class).to(GymService.class);
						bind(PaymentServiceImpl.class).to(PaymentService.class);
						bind(InvoicingServiceImpl.class).to(InvoicingService.class);
						bind(InvoiceDAO.class).to(InvoiceDAO.class);
						//bind(UserDAO.class).to(UserDAO.class);
						bind(MailingServiceImpl.class).to(MailingService.class);
						bind(PaymentDAO.class).to(PaymentDAO.class);
						bindFactory(EMFFactory.class).to(EntityManagerFactory.class).in(Singleton.class);
						bindFactory(EMFactory.class).to(EntityManager.class).in(RequestScoped.class);
						bindFactory(ConnectionFactorySupplier.class).to(ConnectionFactory.class).in(Singleton.class);
						bindFactory(PaymentAckQueueSupplier.class).to(Queue.class).named("PaymentAckQueue").in(Singleton.class);
						bindFactory(PaymentQueueSupplier.class).to(Queue.class).named("PaymentQueue").in(Singleton.class);
						
//						bind(PaymentProcessorBean.class).to(PaymentProcessorBean.class).in(Singleton.class);
						bind(PaymentValidationAckownledgerBean.class).to(PaymentValidationAckownledgerBean.class).in(Singleton.class);

					}

				});

		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
	}
	
	

	/**
	 * Main method.beanbeanbeanbean
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Locale.setDefault(Locale.ENGLISH);
		SLF4JBridgeHandler.removeHandlersForRootLogger();
		SLF4JBridgeHandler.install();
		final HttpServer server = startServer();
		
		BrokerUtils.startBroker();
		
		
		PersistenceConf pc = new PersistenceConf();
		pc.getEM();
		pc.launchH2WS();
	
		SeContainerInitializer initializer = SeContainerInitializer.newInstance();

		try (SeContainer container = initializer.addPackages(true, Main.class.getPackage()).initialize()) {
			Main jpa = container.select(Main.class).get();
			EntityTransaction tx = jpa.manager.getTransaction();
			tx.begin();
			try {
				jpa.createTrainPhysique();
				jpa.createPassagers();
			} catch (Exception e) {
				e.printStackTrace();
			}
			tx.commit();
			jpa.listPassagers();

			System.out.println(".. done");
		}
		
		System.out.println(String.format(
				"Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...",
				BASE_URI));
		System.in.read();
		
		server.stop();
		
		
	}
	
	private void createTrainPhysique() {
	
		manager.getTransaction().begin();
		TrainPhysique trainphysique = new TrainPhysique(11);
		manager.persist(trainphysique); // cree trainphysique
		
		Billet billet = new Billet(5);
		manager.persist(billet);
		
		Passager passager = new Passager("Toto", false, billet);
		manager.persist(passager);
		manager.flush();
	

		manager.getTransaction().commit();
	}
	
	private void createPassagers() {
		long numOfPassagers = manager.createNamedQuery("countPassagers", Long.class).getSingleResult();
		if (numOfPassagers > 0) {
			int res = manager.createNamedQuery("deleteAllPassagers").executeUpdate();
			System.out.println("Deleted  " + res + " Passagers");

			int dep = manager.createNamedQuery("deleteAllBillets").executeUpdate();
			System.out.println("Deleted  " + dep + " Billet(s)");
		}

		Billet billet = new Billet(10);
		manager.persist(billet);
		manager.persist(new Passager("Toto", true, billet));
		manager.persist(new Passager("Fifi", false, billet));

	}

	private void listPassagers() {
		Collection<Passager> passagers = manager.createNamedQuery("findAllPassagers", Passager.class).getResultList();
		for (Passager e : passagers) {
			System.out.println(e);
	}

	}


}
