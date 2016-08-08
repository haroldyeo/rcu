package com.utils;


import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.pojos.TUsers;

/**
 *
 * @author Harold
 */
public class OperationsDb {
    
    public static Session getHibSession()
    {
        return HibernateUtil.getSessionFactory().openSession();
    }
 
    
    public static void persistObject(Object obj){
         
            try{
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(obj);
                session.getTransaction().commit();
                
            } catch (HibernateException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Une erreur est survenue", "Base de données des fidèles", JOptionPane.ERROR);
            }
    }
    
    public static void updateObject(Object obj){
         
            try{
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.merge(obj);  
                session.getTransaction().commit();
                
            } catch (HibernateException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Une erreur est survenue", "Base de données des fidèles", JOptionPane.ERROR);
            }
    }
    
    public static void deleteObject(Object obj){
         
            try{
//                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//                session.beginTransaction();
                HibernateUtil.getSessionFactory().getCurrentSession().delete(obj);
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
                
            } catch (HibernateException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Une erreur est survenue", "Base de données des fidèles", JOptionPane.ERROR);
            }
    }
    
    @SuppressWarnings("unchecked")
	public static Object find (String strEntity, HashMap<String, Object> params){
        // a = nom de l'entité; b,c,d,e => paramètres de recherces
        
        @SuppressWarnings("rawtypes")
		List returnedList = null;
        
        switch(strEntity){
            
            case("agents"):
                        /**
                        * DEFINITION DES PARAMETRES
                        * 
                        * int id; 
                        * String nom;
                        * String prenoms ;
                        */

                       Criteria criteria = getHibSession().createCriteria(TUsers.class);
                       criteria.addOrder(Order.asc("id"));
                       		if(params != null){
                       			
                       			Integer id = (Integer)params.get("id"); 
                           	   String nom = (String)params.get("nom");
                          	   String prenoms = (String)params.get("prenoms");
                           	   
                           	   
                       			if ( id!= null && id != 0){
                                         criteria.add(Restrictions.eq("id", id));
                                     }                    			

                                if (nom != null && !nom.equals("")){
                                     	criteria.add(Restrictions.ilike("nom", "%"+nom+"%"));
                                }

                                if (prenoms != null && !prenoms.equals("")){
                                     	criteria.add(Restrictions.ilike("prenoms", "%"+prenoms+"%"));
                                }
        					
                       		}

                       		returnedList = (List<TUsers>)criteria.list();
                          System.out.println("list size: "+returnedList.size());
                        break;
           
            
           
                
            case ("ENFANTS"):
                        break;
            
        }
        
        return returnedList;
    }
    
    
}
