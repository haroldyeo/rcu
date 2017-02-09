package com.utils;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.pojos.Agent;
import com.pojos.CustomerMaster;
import com.pojos.TableSource;

/**
 *
 * @author Harold
 */
public class OperationsDb {
	
	public static final Session hibSession = HibernateUtil.getHibSession();
	final static Logger logger = Logger.getLogger(OperationsDb.class);
	
	public static final String GET_COMPTES_FORM = "select * from TEST_RCU_TABLE_SOURCE c inner  join "
				+ " (select f1.ID_COMPTE from RCU_CUSTOMER_MASTER f1 left outer join RCU_CUSTOMER_MASTER f on f.MASTER_ID = f1.MASTER_ID where f.ID_COMPTE = :compteForm) i"
				+ " on c.ID_COMPTE = i.ID_COMPTE";
	
	public static final String GET_COMPTES_FORM_NEW = "select  B.MASTER_ID, B.MASTER_ID_B2C, B.TYPE_MATCH_CD, B.TYPE_SERVICE_ID, B.DATE_CESSATION_MID, B.DATE_CREATION_MID,  A.* from TEST_RCU_TABLE_SOURCE A, Rcu_customer_master B"
												+ " where A.id_compte = b.id_compte"
												+ " and B.master_id in ("
												+ " select master_id from rcu_customer_master where  id_compte like :compteForm)"
												+ " order by master_id";
	
	public static final String GET_COMPTE_DETAILS = "select  B.MASTER_ID, B.MASTER_ID_B2C,  B.TYPE_MATCH_CD, B.TYPE_SERVICE_ID, B.DATE_CESSATION_MID, B.DATE_CREATION_MID,  A.* from TEST_RCU_TABLE_SOURCE A, Rcu_customer_master B" 
												+ " where A.id_compte = b.id_compte and A.ID_COMPTE = :compteForm";
	
    @SuppressWarnings("unchecked")
	public static Object find (String strEntity, Map<String, Object> params){    	
        
        @SuppressWarnings("rawtypes")
		List returnedList = null;
        
        switch(strEntity){
            
            case("agents"):
                       Criteria criteria = hibSession.createCriteria(TableSource.class);
                       criteria.addOrder(Order.asc("id"));
                       		if(params != null){
                       			
                       			logger.info("find -> agents -> params not null");
                       			
                       		   BigDecimal id = params.get("id") != null ? new BigDecimal((String)params.get("id")) : null; 
                           	   String nom = (String)params.get("nom");
                          	   String prenoms = (String)params.get("prenoms");
                          	   String dateNaissance = (String)params.get("dateNaissance");
	                           String piece = (String)params.get("piece");
	                           String compteContri = (String)params.get("compteContri");
	                           String numero = (String)params.get("numero");
	                           String idCompte = (String)params.get("idCompte");
	                          	
                       			if ( id!= null ){
                                         criteria.add(Restrictions.eq("id", id));
                                         logger.info( "param id: "+id);
                                     }                    			

                                if (nom != null && !nom.equals("")){
                                     	criteria.add(Restrictions.ilike("nom", "%"+nom+"%"));
                                     	logger.info( "param nom: "+nom);
                                }

                                if (prenoms != null && !prenoms.equals("")){
                                     	criteria.add(Restrictions.ilike("prenoms", "%"+prenoms+"%"));
                                     	logger.info( "param prenoms: "+prenoms);
                                }
                                
                                if (dateNaissance != null && !dateNaissance.equals("")){
                                 	criteria.add(Restrictions.ilike("dateNaissance", "%"+dateNaissance+"%"));
                                 	logger.info( "param date Naissance: "+dateNaissance);
                                }
                                
                                if (piece != null && !piece.equals("")){
                                 	criteria.add(Restrictions.ilike("piece", "%"+piece+"%"));
                                 	logger.info( "param piece: "+piece);
                                 	
                                }
                                
                                if (compteContri != null && !compteContri.equals("")){
                                 	criteria.add(Restrictions.ilike("compteContribuable", "%"+compteContri+"%"));
                                 	logger.info( "param compte contri: "+compteContri);
                                }
                                
                                if (numero != null && !numero.equals("")){
                                 	criteria.add(Restrictions.ilike("numero", "%"+numero+"%"));
                                 	logger.info( "param numero: "+numero);
                                 	
                                }
                                
                                if (idCompte != null && !idCompte.equals("")){
                                 	criteria.add(Restrictions.ilike("compteId", "%"+idCompte+"%"));
                                 	logger.info( "param idCompte: "+idCompte);
                                }
                                
                       		}
                       		
                       		// actual query
                       		try {
                       			returnedList = (List<TableSource>)criteria.list();
							} catch (Exception e) {
								logger.error("some error when getting returnedList", e);
							}
                       		
                       		if(returnedList != null)
                       			logger.info( "size retruned list: "+returnedList.size());
                       		else
                       			logger.info( "returned list is null");
                        break;
                    
            case("final"):
                Criteria criteriaFn = hibSession.createCriteria(CustomerMaster.class);
                criteriaFn.addOrder(Order.asc("masterId"));
                		if(params != null){
                			
                			logger.info( "find -> final -> params not null");
                			
                			String masterId = params.get("masterId") != null ? ((String)params.get("masterId")) : null;
                			String idCompte = params.get("idCompte") != null ? ((String)params.get("idCompte")) : null;
                			
                			if ( masterId!= null ){
                				criteriaFn.add(Restrictions.eq("masterId", masterId));
                				logger.info( "param masterId: "+masterId);
                              }
                			if ( idCompte!= null ){
                				criteriaFn.add(Restrictions.eq("compteId", idCompte));
                				logger.info( "param compteId: "+idCompte);
                              }
                			}
                		try{
                			returnedList = (List<CustomerMaster>)criteriaFn.list();
                		}catch (Exception e) {
							logger.error("some error when getting returnedList", e);
						}
                		
                 break;
          
        }
        
        System.out.println("---   Entity: "+strEntity +" -  size: "+returnedList.size() +" elements -------------");
        return returnedList;
    }

	@SuppressWarnings("unchecked")
	public static List<TableSource> getComptesClient(String compteForm) {
		
		logger.info("requete getComptes about to be executed");
		
		SQLQuery q = hibSession.createSQLQuery(GET_COMPTES_FORM);
		q.addEntity(TableSource.class);
		q.setParameter("compteForm", compteForm);
		try {
			return (List<TableSource>)q.list();
		} catch (Exception e) {
			logger.error(" Erreur sur la requete getComptesClients()", e );
		}
		return null;
	}
	
@SuppressWarnings("unchecked")
public static List<Agent> getComptesClient2(String compteForm) {
		
		logger.info("requete getComptes about to be executed");
		
		SQLQuery q = hibSession.createSQLQuery(GET_COMPTES_FORM_NEW) ;

		q.setParameter("compteForm", "%"+compteForm+"%");
		try {
			List<Object[]> rows = q.list();
			
			return Utils.doSetAgents(rows);
		} catch (Exception e) {
			logger.error(" Erreur sur la requete getComptesClients()", e );
		}
		return null;
	}

@SuppressWarnings("unchecked")
public static List<Agent> getComptesClient3(String compteForm) {
		
		logger.info("requete getComptes about to be executed");
		
		SQLQuery q = hibSession.createSQLQuery(GET_COMPTE_DETAILS);

		q.setParameter("compteForm", compteForm);
		try {
			List<Object[]> rows = q.list();
			
			return Utils.doSetAgents(rows);
		} catch (Exception e) {
			logger.error(" Erreur sur la requete getComptesClients()", e );
		}
		return null;
	}
    
}
