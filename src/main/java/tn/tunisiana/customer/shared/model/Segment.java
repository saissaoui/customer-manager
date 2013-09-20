package tn.tunisiana.customer.shared.model;

import java.util.Hashtable;
import java.util.List;

public class Segment {

	private int idSegment;
	private String critere;
	private Hashtable<List<String>, Integer> correspondances;

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

	public Hashtable<List<String>, Integer> getCorrespondances() {
		return correspondances;
	}

	public void setCorrespondances(
			Hashtable<List<String>, Integer> correspondances) {
		this.correspondances = correspondances;
	}

}
