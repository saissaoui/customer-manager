package tn.tunisiana.customer.server.dao;

import java.util.List;

import tn.tunisiana.customer.shared.model.Offer;

public interface IOfferDao {

	public void addOffer();

	public void deleteOffer();

	public Offer getOffer();

	public void updateOffer();

	public List<Offer> listOffers( List<Integer> offers);

}
