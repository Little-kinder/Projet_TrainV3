package service;

import fr.pantheonsorbonne.ufr27.miage.jpa.Invoice;

public interface MailingService {

	public void sendInvoice(Invoice invoice);

}