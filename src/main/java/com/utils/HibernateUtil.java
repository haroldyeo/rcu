/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.hibernate.Session;

public class HibernateUtil {

	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager;
	final static Logger logger = Logger.getLogger(HibernateUtil.class);
    
    public static Session getHibSession(){
    	
    	try {
    		entityManagerFactory = Persistence.createEntityManagerFactory("rcudemo");
    		entityManager = entityManagerFactory.createEntityManager();
    		return (Session) entityManager.getDelegate();
		} catch (Exception e) {
			logger.error("BUILD HIBERNATE SESSION ERROR" , e);
			Utils.doTakeCareException(e);
			throw new RuntimeException();
		}
		
	}
}
