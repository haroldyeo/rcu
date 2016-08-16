package com.utils;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.pojos.TUsers;

/**
 *
 * @author Harold
 */
public class OperationsDb {

    @SuppressWarnings("unchecked")
	public static Object find (String strEntity, Map<String, Object> params){
        
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

                       Criteria criteria = HibernateUtil.getHibSession().createCriteria(TUsers.class);
                       criteria.addOrder(Order.asc("id"));
                       		if(params != null){
                       			
                       			BigDecimal id = params.get("id") != null ? new BigDecimal((String)params.get("id")) : null; 
                           	   String nom = (String)params.get("nom");
                          	   String prenoms = (String)params.get("prenoms");
                          	   String tel = (String)params.get("tel");
	                          	 String adresse = (String)params.get("adresse");
	                          	String lieuNaissance = (String)params.get("lieuNaissance");
                           	   
                           	   
                       			if ( id!= null ){
                                         criteria.add(Restrictions.eq("id", id));
                                     }                    			

                                if (nom != null && !nom.equals("")){
                                     	criteria.add(Restrictions.ilike("nom", "%"+nom+"%"));
                                }

                                if (prenoms != null && !prenoms.equals("")){
                                     	criteria.add(Restrictions.ilike("prenoms", "%"+prenoms+"%"));
                                }
                                
                                if (tel != null && !tel.equals("")){
                                 	criteria.add(Restrictions.ilike("telFixe", "%"+tel+"%"));
                                }
                                
                                if (adresse != null && !adresse.equals("")){
                                 	criteria.add(Restrictions.ilike("adresse", "%"+adresse+"%"));
                                }
                                
                                if (lieuNaissance != null && !lieuNaissance.equals("")){
                                 	criteria.add(Restrictions.ilike("lieuNaissance", "%"+lieuNaissance+"%"));
                                }
        					
                       		}

                       		returnedList = (List<TUsers>)criteria.list();
                          System.out.println("list size: "+returnedList.size());
                        break;
           
            
           
                
            case (""):
                        break;
            
        }
        
        return returnedList;
    }
    
    
//  public static Session getHibSession()
//  {
//      return HibernateUtil.getHibSession().openSession();
//  }

	/*
  
  public static void persistObject(Object obj){
       
          try{
              Session session = HibernateUtil.getHibSession();
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
              Session session = HibernateUtil.getHibSession();
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
//              Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//              session.beginTransaction();
              HibernateUtil.getCurrentSession().delete(obj);
              HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
              
          } catch (HibernateException e){
              e.printStackTrace();
              JOptionPane.showMessageDialog(null, "Une erreur est survenue", "Base de données des fidèles", JOptionPane.ERROR);
          }
  }
  */
    
}
