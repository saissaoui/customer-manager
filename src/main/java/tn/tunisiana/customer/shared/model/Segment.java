package tn.tunisiana.customer.shared.model;

import java.util.Hashtable;

public class Segment {

	private int idSegment;
	private String critere;
	private Hashtable<String, Offer> correspondances;

	public int getIdSegment() {
		return idSegment;
	}

	public void setIdSegment(int idSegment) {
		this.idSegment = idSegment;
	}

	public String getCritere() {
		return critere;
	}

	public void setCritere(String critere) {
		this.critere = critere;
	}

	public Hashtable<String, Offer> getCorrespondances() {
		return correspondances;
	}

	public void setCorrespondances(Hashtable<String, Offer> correspondances) {
		this.correspondances = correspondances;
	}

}
