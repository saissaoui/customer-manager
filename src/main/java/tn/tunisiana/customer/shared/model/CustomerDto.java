package tn.tunisiana.customer.shared.model;

import java.io.Serializable;
import java.util.Date;

public class CustomerDto implements Serializable{

	private Integer idcustomer;
	private String name;
	private String lastname;
	private Integer age;
	private String gouvernorat;
	private String adress;
	private String country;
	private Character sex;
	private String phone;
	private String email;
	private String idType;
	private String idNumber;
	private String profession;
	private String raisonAchat;
	private String lienParente;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private Date dateNaissanceUtilisateur;
	private String professionUtilisateur;
	private Date dateNaissance;
	private String villeUtilisateur;
	private Long codePostalUtilisateur;
	private Long codePostal;
	private String gouvernoratUtilisateur;
	private String sexeUtilisateur;
	private String achatAccompagne;
	private String accompagnant;
	private String raisonChoix;

	public Integer getIdcustomer() {
		return idcustomer;
	}

	public void setIdcustomer(Integer idcustomer) {
		this.idcustomer = idcustomer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGouvernorat() {
		return gouvernorat;
	}

	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Character getSex() {
		return sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getRaisonAchat() {
		return raisonAchat;
	}

	public void setRaisonAchat(String raisonAchat) {
		this.raisonAchat = raisonAchat;
	}

	public String getLienParente() {
		return lienParente;
	}

	public void setLienParente(String lienParente) {
		this.lienParente = lienParente;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public Date getDateNaissanceUtilisateur() {
		return dateNaissanceUtilisateur;
	}

	public void setDateNaissanceUtilisateur(Date dateNaissanceUtilisateur) {
		this.dateNaissanceUtilisateur = dateNaissanceUtilisateur;
	}

	public String getProfessionUtilisateur() {
		return professionUtilisateur;
	}

	public void setProfessionUtilisateur(String professionUtilisateur) {
		this.professionUtilisateur = professionUtilisateur;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getVilleUtilisateur() {
		return villeUtilisateur;
	}

	public void setVilleUtilisateur(String villeUtilisateur) {
		this.villeUtilisateur = villeUtilisateur;
	}

	public Long getCodePostalUtilisateur() {
		return codePostalUtilisateur;
	}

	public void setCodePostalUtilisateur(Long codePostalUtilisateur) {
		this.codePostalUtilisateur = codePostalUtilisateur;
	}

	public Long getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Long codePostal) {
		this.codePostal = codePostal;
	}

	public String getGouvernoratUtilisateur() {
		return gouvernoratUtilisateur;
	}

	public void setGouvernoratUtilisateur(String gouvernoratUtilisateur) {
		this.gouvernoratUtilisateur = gouvernoratUtilisateur;
	}

	public String getSexeUtilisateur() {
		return sexeUtilisateur;
	}

	public void setSexeUtilisateur(String sexeUtilisateur) {
		this.sexeUtilisateur = sexeUtilisateur;
	}

	public String getAchatAccompagne() {
		return achatAccompagne;
	}

	public void setAchatAccompagne(String achatAccompagne) {
		this.achatAccompagne = achatAccompagne;
	}

	public String getAccompagnant() {
		return accompagnant;
	}

	public void setAccompagnant(String accompagnant) {
		this.accompagnant = accompagnant;
	}

	public String getRaisonChoix() {
		return raisonChoix;
	}

	public void setRaisonChoix(String raisonChoix) {
		this.raisonChoix = raisonChoix;
	}

}
