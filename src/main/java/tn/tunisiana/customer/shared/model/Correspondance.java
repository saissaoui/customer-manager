package tn.tunisiana.customer.shared.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Correspondance {

	private String conditions;

	private int idOffre;

	@XmlAttribute(name="conditions")
	public  String getConditions() {
		return conditions;
	}

	public void setConditions( String conditions) {
		this.conditions = conditions;
	}

	@XmlAttribute(name = "offre")
	public int getIdOffre() {
		return idOffre;
	}

	public void setIdOffre(int idOffre) {
		this.idOffre = idOffre;
	}

}
