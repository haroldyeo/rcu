package com.pojos;

import java.io.Serializable;



public class TableSource implements Serializable{
	

	     /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String compteId;
	     private String nom;
	     private String prenoms;
	     private String dateNaissance;
	     private String lieuNaissance;
//	     private String adresse;
	     private String numero;
	     private String typeService;
	     private String typePiece;
	     private String piece;
	     private String typeCompte;
	     private String statut;
	     private String systemSourceCode;
	     private String compteContribuable;
	 	 private String dateCreation;
	 	 private String idNiveauSuperieur;
	     

	     

		public TableSource() {
			super();
		}


		public TableSource(String compteId, String nom, String prenoms, String dateNaissance, String lieuNaissance,
				String adresse, String numero, String typeService, String typePiece, String piece, String typeCompte,
				String statut, String systemSourceCode) {
			super();
			this.compteId = compteId;
			this.nom = nom;
			this.prenoms = prenoms;
			this.dateNaissance = dateNaissance;
			this.lieuNaissance = lieuNaissance;
			this.numero = numero;
			this.typeService = typeService;
			this.typePiece = typePiece;
			this.piece = piece;
			this.typeCompte = typeCompte;
			this.statut = statut;
		}

		public String getCompteId() {
			return compteId;
		}


		public void setCompteId(String compteId) {
			this.compteId = compteId;
		}

		public String getNom() {
			return nom;
		}


		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenoms() {
			return prenoms;
		}


		public void setPrenoms(String prenoms) {
			this.prenoms = prenoms;
		}

		public String getDateNaissance() {
			return dateNaissance;
		}


		public void setDateNaissance(String dateNaissance) {
			this.dateNaissance = dateNaissance;
		}

		public String getLieuNaissance() {
			return lieuNaissance;
		}


		public void setLieuNaissance(String lieuNaissance) {
			this.lieuNaissance = lieuNaissance;
		}


//		public String getAdresse() {
//			return adresse;
//		}
//
//
//		public void setAdresse(String adresse) {
//			this.adresse = adresse;
//		}

		public String getNumero() {
			return numero;
		}


		public void setNumero(String numero) {
			this.numero = numero;
		}

		public String getTypeService() {
			return typeService;
		}


		public void setTypeService(String typeService) {
			this.typeService = typeService;
		}

		public String getTypePiece() {
			return typePiece;
		}

		
		public void setTypePiece(String typePiece) {
			this.typePiece = typePiece;
		}

		public String getPiece() {
			return piece;
		}

		
		public void setPiece(String piece) {
			this.piece = piece;
		}

		public String getTypeCompte() {
			return typeCompte;
		}


		public void setTypeCompte(String typeCompte) {
			this.typeCompte = typeCompte;
		}

		public String getStatut() {
			return statut;
		}


		public void setStatut(String statut) {
			this.statut = statut;
		}

		public String getSystemSourceCode() {
			return systemSourceCode;
		}


		public void setSystemSourceCode(String systemSourceCode) {
			this.systemSourceCode = systemSourceCode;
		}

		public String getCompteContribuable() {
			return compteContribuable;
		}


		public void setCompteContribuable(String compteContribuable) {
			this.compteContribuable = compteContribuable;
		}
		public String getDateCreation() {
			return dateCreation;
		}


		public void setDateCreation(String dateCreation) {
			this.dateCreation = dateCreation;
		}

		public String getIdNiveauSuperieur() {
			return idNiveauSuperieur;
		}


		public void setIdNiveauSuperieur(String idNiveauSuperieur) {
			this.idNiveauSuperieur = idNiveauSuperieur;
		}
		
		
	    
	}


