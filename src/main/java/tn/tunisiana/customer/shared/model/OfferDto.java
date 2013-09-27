package tn.tunisiana.customer.shared.model;

import java.io.Serializable;

public class OfferDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idoffer;
	private String offerName;
	private String description;

	public OfferDto(int idoffer, String offerName, String description) {
		super();
		this.idoffer = idoffer;
		this.offerName = offerName;
		this.description = description;
	}

	public OfferDto() {
	}

	public int getIdoffer() {
		return idoffer;
	}

	public void setIdoffer(int idoffer) {
		this.idoffer = idoffer;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
