package tn.tunisiana.customer.server.services;

import org.hibernate.Session;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import tn.tunisiana.customer.client.services.CustomerManagerService;
import tn.tunisiana.customer.shared.model.Customer;
import tn.tunisiana.customer.shared.model.Offer;
import tn.tunisiana.customer.util.HibernateUtil;

public class CustomerServiceImpl extends RemoteServiceServlet implements
		CustomerManagerService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1067546708007865289L;
	private static Session session = null;

	public int saveCustomer(Customer customer) {

		if (session == null || !session.isOpen()) {
			session = HibernateUtil.getSessionFactory().getCurrentSession();

		}
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
		return customer.getIdcustomer();
	}

	public Customer getCustomer(int id) {
		if (session == null||!session.isOpen()) {
			session = HibernateUtil.getSessionFactory().openSession();

		}

		session.beginTransaction();
		return (Customer) session.get(Customer.class, id);

	}

	public Offer getOffer() {

		Offer offer = new Offer();
		offer.setOfferName("Big Offer");
		return offer;
	}

}
