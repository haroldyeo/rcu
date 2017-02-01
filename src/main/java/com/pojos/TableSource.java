package com.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TEST_RCU_TABLE_SOURCE" ,schema="POCRCU")
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
//	     private String systemSourceCode;
	     private String compteContribuable;
	 	private String dateCreation;
	     

	     

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


		@Id 
		@Column(name="ID_COMPTE", unique=true, nullable=false)
		public String getCompteId() {
			return compteId;
		}


		public void setCompteId(String compteId) {
			this.compteId = compteId;
		}

		@Column(name="NOM")
		public String getNom() {
			return nom;
		}


		public void setNom(String nom) {
			this.nom = nom;
		}

		@Column(name="PRENOM")
		public String getPrenoms() {
			return prenoms;
		}


		public void setPrenoms(String prenoms) {
			this.prenoms = prenoms;
		}

		@Column(name="DATE_NAISSANCE")
		public String getDateNaissance() {
			return dateNaissance;
		}


		public void setDateNaissance(String dateNaissance) {
			this.dateNaissance = dateNaissance;
		}

		@Column(name="LIEU_NAISSANCE")
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

		@Column(name="PHONE_NUM")
		public String getNumero() {
			return numero;
		}


		public void setNumero(String numero) {
			this.numero = numero;
		}

		@Column(name="TYPE_SERVICE")
		public String getTypeService() {
			return typeService;
		}


		public void setTypeService(String typeService) {
			this.typeService = typeService;
		}

		@Column(name="TYPE_PIECE")
		public String getTypePiece() {
			return typePiece;
		}

		
		public void setTypePiece(String typePiece) {
			this.typePiece = typePiece;
		}

		@Column(name="ID_PIECE")
		public String getPiece() {
			return piece;
		}

		
		public void setPiece(String piece) {
			this.piece = piece;
		}

		@Column(name="TYPE_COMPTE")
		public String getTypeCompte() {
			return typeCompte;
		}


		public void setTypeCompte(String typeCompte) {
			this.typeCompte = typeCompte;
		}

		@Column(name="STATUTS")
		public String getStatut() {
			return statut;
		}


		public void setStatut(String statut) {
			this.statut = statut;
		}

//		@Column(name="SYSTEM_SOURCE_CODE")
//		public String getSystemSourceCode() {
//			return systemSourceCode;
//		}
//
//
//		public void setSystemSourceCode(String systemSourceCode) {
//			this.systemSourceCode = systemSourceCode;
//		}

		@Column(name="COMPTE_CONTRIBUABLE")
		public String getCompteContribuable() {
			return compteContribuable;
		}


		public void setCompteContribuable(String compteContribuable) {
			this.compteContribuable = compteContribuable;
		}
		@Column(name="DATE_CREATION")
		public String getDateCreation() {
			return dateCreation;
		}


		public void setDateCreation(String dateCreation) {
			this.dateCreation = dateCreation;
		}
		
		
		
		
		
	    
	}


