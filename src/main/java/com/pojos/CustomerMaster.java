package com.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RCU_CUSTOMER_MASTER" ,schema="POCRCU")
//@Table(name="RCU_CUSTOMER_MASTER" ,schema="demo")
//@Table(name="RCU_CUSTOMER_MASTER" ,schema="system")
public class CustomerMaster  {

	
	
//	private long id;
	private String masterId;
	private String compteId;
	private String masterIdB2C;
	private String systemSourceCode;
	private String typeMatch;
	private String typerService;
	private String dateCreation;
	private String dateCessation;
	
	
//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
	@Id
	@Column(name="MASTER_ID")
	public String getMasterId() {
		return masterId;
	}
	
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	@Column(name="ID_COMPTE")
	public String getCompteId() {
		return compteId;
	}
	public void setCompteId(String compteId) {
		this.compteId = compteId;
	}
	@Column(name="MASTER_ID_B2C")
	public String getMasterIdB2C() {
		return masterIdB2C;
	}
	public void setMasterIdB2C(String masterIdB2C) {
		this.masterIdB2C = masterIdB2C;
	}
	@Column(name="SYSTEME_SOURCE_CD")
	public String getSystemSourceCode() {
		return systemSourceCode;
	}
	public void setSystemSourceCode(String systemSourceCode) {
		this.systemSourceCode = systemSourceCode;
	}
	@Column(name="TYPE_MATCH_CD")
	public String getTypeMatch() {
		return typeMatch;
	}
	public void setTypeMatch(String typeMatch) {
		this.typeMatch = typeMatch;
	}
	@Column(name="TYPE_SERVICE_ID")
	public String getTyperService() {
		return typerService;
	}
	public void setTyperService(String typerService) {
		this.typerService = typerService;
	}
	@Column(name="DATE_CREATION_MID")
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	@Column(name="DATE_CESSATION_MID")
	public String getDateCessation() {
		return dateCessation;
	}
	public void setDateCessation(String dateCessation) {
		this.dateCessation = dateCessation;
	}
	
	
	
	

}
