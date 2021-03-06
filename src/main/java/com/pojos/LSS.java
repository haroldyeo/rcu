package com.pojos;
// Generated 16 ao�t 2016 00:01:08 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ListSelectionStg generated by hbm2java
 */
@Entity
@Table(name="LIST_SELECTION_STG"
    ,schema="DEMO"
)
public class LSS  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idclient;
     private String nom;
     private String prenom;
     private String datnai;
     private String lieunai;
     private String pieceidentite;
     private String description;
     private String typePiece;
     private String adresspostal;
     private String phone;
     private BigDecimal typeservice;
     private String cpostalBp;
     private String numerobp;
     private String refClientExt;
     private String phonePrincipal;
     private String contact;
     private String identite;
     private String numeroMobile;
     private String statut;
     private String email;

    public LSS() {
    }

	
    public LSS(int idclient) {
        this.idclient = idclient;
    }
    public LSS(int idclient, String nom, String prenom, String datnai, String lieunai, String pieceidentite, String description, String typePiece, String adresspostal, String phone, BigDecimal typeservice, String cpostalBp, String numerobp, String refClientExt, String phonePrincipal, String contact, String identite, String numeroMobile, String statut, String email) {
       this.idclient = idclient;
       this.nom = nom;
       this.prenom = prenom;
       this.datnai = datnai;
       this.lieunai = lieunai;
       this.pieceidentite = pieceidentite;
       this.description = description;
       this.typePiece = typePiece;
       this.adresspostal = adresspostal;
       this.phone = phone;
       this.typeservice = typeservice;
       this.cpostalBp = cpostalBp;
       this.numerobp = numerobp;
       this.refClientExt = refClientExt;
       this.phonePrincipal = phonePrincipal;
       this.contact = contact;
       this.identite = identite;
       this.numeroMobile = numeroMobile;
       this.statut = statut;
       this.email = email;
    }
   
     @Id 

    
    @Column(name="IDCLIENT", unique=true, nullable=false, precision=8, scale=0)
    public int getIdclient() {
        return this.idclient;
    }
    
    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    
    @Column(name="NOM")
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    @Column(name="PRENOM")
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    
    @Column(name="DATNAI")
    public String getDatnai() {
        return this.datnai;
    }
    
    public void setDatnai(String datnai) {
        this.datnai = datnai;
    }

    
    @Column(name="LIEUNAI")
    public String getLieunai() {
        return this.lieunai;
    }
    
    public void setLieunai(String lieunai) {
        this.lieunai = lieunai;
    }

    
    @Column(name="PIECEIDENTITE")
    public String getPieceidentite() {
        return this.pieceidentite;
    }
    
    public void setPieceidentite(String pieceidentite) {
        this.pieceidentite = pieceidentite;
    }

    
    @Column(name="DESCRIPTION")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="TYPE_PIECE", length=3)
    public String getTypePiece() {
        return this.typePiece;
    }
    
    public void setTypePiece(String typePiece) {
        this.typePiece = typePiece;
    }

    
    @Column(name="ADRESSPOSTAL")
    public String getAdresspostal() {
        return this.adresspostal;
    }
    
    public void setAdresspostal(String adresspostal) {
        this.adresspostal = adresspostal;
    }

    
    @Column(name="PHONE", length=32)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    @Column(name="TYPESERVICE", precision=22, scale=0)
    public BigDecimal getTypeservice() {
        return this.typeservice;
    }
    
    public void setTypeservice(BigDecimal typeservice) {
        this.typeservice = typeservice;
    }

    
    @Column(name="CPOSTAL_BP", length=8)
    public String getCpostalBp() {
        return this.cpostalBp;
    }
    
    public void setCpostalBp(String cpostalBp) {
        this.cpostalBp = cpostalBp;
    }

    
    @Column(name="NUMEROBP", length=8)
    public String getNumerobp() {
        return this.numerobp;
    }
    
    public void setNumerobp(String numerobp) {
        this.numerobp = numerobp;
    }

    
    @Column(name="REF_CLIENT_EXT", length=100)
    public String getRefClientExt() {
        return this.refClientExt;
    }
    
    public void setRefClientExt(String refClientExt) {
        this.refClientExt = refClientExt;
    }

    
    @Column(name="PHONE_PRINCIPAL", length=1)
    public String getPhonePrincipal() {
        return this.phonePrincipal;
    }
    
    public void setPhonePrincipal(String phonePrincipal) {
        this.phonePrincipal = phonePrincipal;
    }

    
    @Column(name="CONTACT", length=25)
    public String getContact() {
        return this.contact;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }

    
    @Column(name="IDENTITE", length=512)
    public String getIdentite() {
        return this.identite;
    }
    
    public void setIdentite(String identite) {
        this.identite = identite;
    }

    
    @Column(name="NUMERO_MOBILE", length=20)
    public String getNumeroMobile() {
        return this.numeroMobile;
    }
    
    public void setNumeroMobile(String numeroMobile) {
        this.numeroMobile = numeroMobile;
    }

    
    @Column(name="STATUT", length=4000)
    public String getStatut() {
        return this.statut;
    }
    
    public void setStatut(String statut) {
        this.statut = statut;
    }

    
    @Column(name="EMAIL", length=100)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }




}


