package com.pojos;

import java.io.Serializable;


public class ReferenceTypeService implements Serializable{
	     /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String idTypeservice;
		private String codeTypeService;
		private String libelleTypeService;

		public String getIdTypeservice() {
			return idTypeservice;
		}

		public void setIdTypeservice(String idTypeservice) {
			this.idTypeservice = idTypeservice;
		}

		public String getCodeTypeService() {
			return codeTypeService;
		}

		public void setCodeTypeService(String codeTypeService) {
			this.codeTypeService = codeTypeService;
		}

		public String getLibelleTypeService() {
			return libelleTypeService;
		}

		public void setLibelleTypeService(String libelleTypeService) {
			this.libelleTypeService = libelleTypeService;
		}

		
		
	    
	}


