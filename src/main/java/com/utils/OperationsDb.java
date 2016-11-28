package com.utils;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
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
	
	public static final String GET_COMPTES_FORM = "select * from T_USERS u  inner  join "
				+ " (select f1.COMPTEID from T_FINAL f1 left outer join T_FINAL f on f.master_id = f1.master_id where f.COMPTEID = :compteForm) i"
				+ " on u.id = i.COMPTEID";
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
        
        System.out.println("---   Entity: "+strEntity +" -  size: "+returnedList.size() +" elements -------------");
        return returnedList;
    }

	@SuppressWarnings("unchecked")
	public static List<TUsers> getComptesClient(String compteForm) {
		SQLQuery q = HibernateUtil.getHibSession().createSQLQuery(GET_COMPTES_FORM);
		q.addEntity(TUsers.class);
		q.setParameter("compteForm", compteForm);
		return (List<TUsers>)q.list();
	}
    
}
