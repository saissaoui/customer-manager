package tn.tunisiana.customer.shared.model;

// default package
// Generated Sep 16, 2013 4:02:27 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Offer generated by hbm2java
 */
@Entity
@Table(name = "offer", catalog = "tunisianaDb")
public class Offer implements java.io.Serializable {

	private int idoffer;
	private String offerName;
	private String description;

	public Offer() {
	}

	public Offer(int idoffer) {
		this.idoffer = idoffer;
	}

	public Offer(int idoffer, String offerName, String description) {
		this.idoffer = idoffer;
		this.offerName = offerName;
		this.description = description;
	}

	@Id
	@Column(name = "idoffer", unique = true, nullable = false)
	public int getIdoffer() {
		return this.idoffer;
	}

	public void setIdoffer(int idoffer) {
		this.idoffer = idoffer;
	}

	@Column(name = "offerName", length = 45)
	public String getOfferName() {
		return this.offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	@Column(name = "description", length = 45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
