package com.pojos;

import java.util.Date;

public class Agent {
	
	private int id;
	private String nom;
	private String prenom;
	private Date dob;
	private String lieuNaissance;
	private String adresse;
	private String telFixe;
	private String telMobile;
	private String email;
	private String aviso;
	private String orangeMoney;
	private String service;
	private String typeService;
	
	
	
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Agent(String nom, String prenom, Date dob, String lieuNaissance, String adresse, String telFixe) {
		this.nom = nom;
		this.prenom = prenom;
		this.dob = dob;
		this.lieuNaissance = lieuNaissance;
		this.adresse = adresse;
		this.telFixe = telFixe;
	}
	
	


	public Agent(int id, String nom, String prenom, Date dob, String lieuNaissance, String adresse, String telFixe,
			String telMobile, String email, String aviso, String orangeMoney, String service, String typeService) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dob = dob;
		this.lieuNaissance = lieuNaissance;
		this.adresse = adresse;
		this.telFixe = telFixe;
		this.telMobile = telMobile;
		this.email = email;
		this.aviso = aviso;
		this.orangeMoney = orangeMoney;
		this.service = service;
		this.typeService = typeService;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelFixe() {
		return telFixe;
	}
	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}
	public String getTelMobile() {
		return telMobile;
	}
	public void setTelMobile(String telMobile) {
		this.telMobile = telMobile;
	}
	public String getAviso() {
		return aviso;
	}
	public void setAviso(String aviso) {
		this.aviso = aviso;
	}
	public String getOrangeMoney() {
		return orangeMoney;
	}
	public void setOrangeMoney(String orangeMoney) {
		this.orangeMoney = orangeMoney;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getTypeService() {
		return typeService;
	}
	public void setTypeService(String typeService) {
		this.typeService = typeService;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
