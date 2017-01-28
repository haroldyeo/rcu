/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utils;

import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

public class HibernateUtil {

	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager;
	
	    
    public static Session getHibSession(){
    	Log mylog = new Log(Utils.logFilePath);
    	
    	
    	try {
    		entityManagerFactory = Persistence.createEntityManagerFactory("rcudemo");
    		entityManager = entityManagerFactory.createEntityManager();
    		return (Session) entityManager.getDelegate();
		} catch (Exception e) {
			mylog.logger.log(Level.SEVERE, "Erreur de build de session factory: ", e);
		    throw new RuntimeException(e);
		}		
	}
}
