package com.utils;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.pojos.TableSource;
import com.pojos.FinalTable;

/**
 *
 * @author Harold
 */
public class OperationsDb {
	
	public static final Session hibSession = HibernateUtil.getHibSession();
	
	public static final String GET_COMPTES_FORM = "select * from TEST_RCU_TABLE_SOURCE c inner  join "
				+ " (select f1.ID_COMPTE from TEST_RCU_CUSTOMER_MASTER f1 left outer join TEST_RCU_CUSTOMER_MASTER f on f.MASTER_ID = f1.MASTER_ID where f.ID_COMPTE = :compteForm) i"
				+ " on c.id = i.ID_COMPTE";
    @SuppressWarnings("unchecked")
	public static Object find (String strEntity, Map<String, Object> params){
        
        @SuppressWarnings("rawtypes")
		List returnedList = null;
        
        switch(strEntity){
            
            case("agents"):
                       Criteria criteria = hibSession.createCriteria(TableSource.class);
                       criteria.addOrder(Order.asc("id"));
                       		if(params != null){
                       			
                       		   BigDecimal id = params.get("id") != null ? new BigDecimal((String)params.get("id")) : null; 
                           	   String nom = (String)params.get("nom");
                          	   String prenoms = (String)params.get("prenoms");
                          	   String dateNaissance = (String)params.get("dateNaissance");
	                           String piece = (String)params.get("piece");
	                           String compteContri = (String)params.get("compteContri");
	                          	
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
                                
                                if (piece != null && !piece.equals("")){
                                 	criteria.add(Restrictions.ilike("piece", "%"+piece+"%"));
                                }
                                
                                if (compteContri != null && !compteContri.equals("")){
                                 	criteria.add(Restrictions.ilike("compteContribuable", "%"+compteContri+"%"));
                                }
                                
                       		}

                       		returnedList = (List<TableSource>)criteria.list();
                        break;
                    
            case("final"):
                Criteria criteriaFn = hibSession.createCriteria(FinalTable.class);
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
          
        }
        
        System.out.println("---   Entity: "+strEntity +" -  size: "+returnedList.size() +" elements -------------");
        return returnedList;
    }

	@SuppressWarnings("unchecked")
	public static List<TableSource> getComptesClient(String compteForm) {
		SQLQuery q = hibSession.createSQLQuery(GET_COMPTES_FORM);
		q.addEntity(TableSource.class);
		q.setParameter("compteForm", compteForm);
		return (List<TableSource>)q.list();
	}
    
}
