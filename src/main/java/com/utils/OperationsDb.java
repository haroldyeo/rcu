package com.utils;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.pojos.CUO;
import com.pojos.FinalTable;
import com.pojos.LSS;
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
                       Criteria criteria = HibernateUtil.getHibSession().createCriteria(TUsers.class);
                       criteria.addOrder(Order.asc("id"));
                       		if(params != null){
                       			
                       		   BigDecimal id = params.get("id") != null ? new BigDecimal((String)params.get("id")) : null; 
                           	   String nom = (String)params.get("nom");
                          	   String prenoms = (String)params.get("prenoms");
                          	   String dateNaissance = (String)params.get("dateNaissance");
                          	   String lieuNaissance = (String)params.get("lieuNaissance");
	                           String piece = (String)params.get("piece");
	                           String typePiece = (String)params.get("typePiece");
	                          	
                           	   
                           	   
                       			if ( id!= null ){
                                         criteria.add(Restrictions.eq("id", id));
                                     }                    			

                                if (nom != null && !nom.equals("")){
                                     	criteria.add(Restrictions.ilike("nom", "%"+nom+"%"));
                                }

                                if (prenoms != null && !prenoms.equals("")){
                                     	criteria.add(Restrictions.ilike("prenoms", "%"+prenoms+"%"));
                                }
                                
                                if (dateNaissance != null && !dateNaissance.equals("")){
                                 	criteria.add(Restrictions.ilike("dateNaissance", "%"+dateNaissance+"%"));
                                }
                                
                                if (lieuNaissance != null && !lieuNaissance.equals("")){
                                 	criteria.add(Restrictions.ilike("lieuNaissance", "%"+lieuNaissance+"%"));
                                }
                                
                                if (piece != null && !piece.equals("")){
                                 	criteria.add(Restrictions.ilike("piece", "%"+piece+"%"));
                                }
                                
                                if (typePiece != null && !typePiece.equals("")){
                                 	criteria.add(Restrictions.ilike("typePiece", "%"+typePiece+"%"));
                                }
                                
                                
        					
                       		}

                       		returnedList = (List<TUsers>)criteria.list();
                        break;
                    
            case("final"):
                Criteria criteriaFn = HibernateUtil.getHibSession().createCriteria(FinalTable.class);
                criteriaFn.addOrder(Order.asc("masterId"));
                		if(params != null){
                			String masterId = params.get("masterId") != null ? ((String)params.get("masterId")) : null;
                			String compteId = params.get("compteId") != null ? ((String)params.get("compteId")) : null;
                			if ( masterId!= null ){
                				criteriaFn.add(Restrictions.eq("masterId", masterId));
                              }
                			if ( compteId!= null ){
                				criteriaFn.add(Restrictions.eq("compteId", compteId));
                              }
                			}
                		returnedList = (List<FinalTable>)criteriaFn.list();
                 break;
           
                
            case("cuo"):

               Criteria CuoCr = HibernateUtil.getHibSession().createCriteria(CUO.class);
            		CuoCr.addOrder(Order.asc("masterId"));
               		if(params != null){
               		   String phone = (String)params.get("phone");
               		   BigDecimal masterId = params.get("masterId") != null ? new BigDecimal((String)params.get("masterId")) : null; 
                   	   Date dateCreation = (Date)params.get("dateCreation");
                   	   Date dateCessation = (Date)params.get("dateCessation");
                  	   String typeMatch = (String)params.get("typeMatch");
                  	   BigDecimal typeservice = params.get("typeservice") != null ? new BigDecimal((String)params.get("typeservice")) : null;
                   	   
                   	   
                  	 if (phone != null && !phone.equals("")){
                      	CuoCr.add(Restrictions.ilike("phone", "%"+phone+"%"));
                  	 }
               			if ( masterId!= null ){
                                 CuoCr.add(Restrictions.eq("masterId", masterId));
                             }  
               			if ( typeservice!= null ){
                            CuoCr.add(Restrictions.eq("typeservice", typeservice));
                        }

                        if (dateCreation != null){
                             	CuoCr.add(Restrictions.eq("dateCreation", dateCreation));
                        }
                        
                        if (dateCessation != null){
                         	CuoCr.add(Restrictions.eq("dateCessation", dateCessation));
                    }

                        if (typeMatch != null && !typeMatch.equals("")){
                             	CuoCr.add(Restrictions.ilike("typeMatch", "%"+typeMatch+"%"));
                        }			
               		}

               		returnedList = (List<TUsers>)CuoCr.list();
                break;
                
                
            case("lss"):

                Criteria LssCr = HibernateUtil.getHibSession().createCriteria(LSS.class);
        		LssCr.addOrder(Order.asc("idclient"));
                		if(params != null){
                			Integer idclient = (Integer)params.get("idclient");
                		   String nom = (String)params.get("nom");
                		   String prenom = (String)params.get("prenom");
                		   String datnai = (String)params.get("datnai");
                		   String lieunai = (String)params.get("lieunai");
                		   String pieceidentite = (String)params.get("pieceidentite");
                		   String description = (String)params.get("description");
                		   String typePiece = (String)params.get("typePiece");
                		   String adresspostal = (String)params.get("adresspostal");
                		   String phone = (String)params.get("phone");
                		   String cpostalBp = (String)params.get("cpostalBp");
                		   String numerobp = (String)params.get("numerobp");
                		   String refClientExt = (String)params.get("refClientExt");
                		   String phonePrincipal = (String)params.get("phonePrincipal");
                		   String contact = (String)params.get("contact");
                		   String identite = (String)params.get("identite");
                		   BigDecimal typeservice = params.get("typeservice") != null ? new BigDecimal((String)params.get("typeservice")) : null;
                		   String numeroMobile = (String)params.get("numeroMobile");
                		   String statut = (String)params.get("statut");
                		   String email = (String)params.get("email");
                    	   
                    	 
                		 if (idclient != null && !idclient.equals("")){
   	                   		LssCr.add(Restrictions.eq("idclient", "idclient"));
   	                   	 }
                		 if (nom != null && !nom.equals("")){
 	                   		LssCr.add(Restrictions.ilike("nom", "%"+nom+"%"));
 	                   	 }
                		 if (prenom != null && !prenom.equals("")){
 	                   		LssCr.add(Restrictions.ilike("prenom", "%"+prenom+"%"));
 	                   	 }
                		 if (datnai != null && !datnai.equals("")){
 	                   		LssCr.add(Restrictions.ilike("datnai", "%"+datnai+"%"));
 	                   	 }
	                   	 if (lieunai != null && !lieunai.equals("")){
	                   		LssCr.add(Restrictions.ilike("lieunai", "%"+lieunai+"%"));
	                   	 }
	                   	if (pieceidentite != null && !pieceidentite.equals("")){
	                   		LssCr.add(Restrictions.ilike("pieceidentite", "%"+pieceidentite+"%"));
	                   	 }
	                   	if (description != null && !description.equals("")){
	                   		LssCr.add(Restrictions.ilike("description", "%"+description+"%"));
	                   	 }
	                   	if (adresspostal != null && !adresspostal.equals("")){
	                   		LssCr.add(Restrictions.ilike("adresspostal", "%"+adresspostal+"%"));
	                   	 }
	                   	if (typePiece != null && !typePiece.equals("")){
	                   		LssCr.add(Restrictions.ilike("lieunai", "%"+lieunai+"%"));
	                   	 }
	                   	if (phone != null && !phone.equals("")){
	                   		LssCr.add(Restrictions.ilike("phone", "%"+phone+"%"));
	                   	 }
                				
                		}

                		returnedList = (List<TUsers>)LssCr.list();
                   
                 break;
            
        }
        
        System.out.println("----------   Entity: "+strEntity +" -  size: "+returnedList.size() +" elements -------------");
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
