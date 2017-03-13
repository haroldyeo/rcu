package com.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="REFERENCE_TYPESERVICE" ,schema="POCRCU")
@Table(name="REFERENCE_TYPESERVICE" ,schema="demo")
//@Table(name="REFERENCE_TYPESERVICE" ,schema="system")
public class ReferenceTypeService implements Serializable{
	     /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String idTypeservice;
		private String codeTypeService;
		private String libelleTypeService;

		@Id 
		@Column(name="ID_TYPESERVICE", unique=true, nullable=false)
		public String getIdTypeservice() {
			return idTypeservice;
		}

		public void setIdTypeservice(String idTypeservice) {
			this.idTypeservice = idTypeservice;
		}

		@Column(name="CODE_TYPESERVICE")
		public String getCodeTypeService() {
			return codeTypeService;
		}

		public void setCodeTypeService(String codeTypeService) {
			this.codeTypeService = codeTypeService;
		}

		@Column(name="LIBELLE_TYPESERVICE")
		public String getLibelleTypeService() {
			return libelleTypeService;
		}

		public void setLibelleTypeService(String libelleTypeService) {
			this.libelleTypeService = libelleTypeService;
		}

		
		
	    
	}


