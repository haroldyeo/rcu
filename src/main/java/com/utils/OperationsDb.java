package com.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pojos.Agent;
import com.pojos.TableSource;

/**
 *
 * @author Harold
 */
public class OperationsDb {
	
	final Logger logger = Logger.getLogger(OperationsDb.class);
	private Utils utils= new Utils();
	
	Connection con = null;
    PreparedStatement pst = null;
	
	public static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
//-------------------	 PROD ----------------------------------//
	public static final String DB_CONNECTION = "jdbc:oracle:thin@10.242.69.158:1521:IDENTDG";
	public static final String DB_USER = "POCRCU";
	public static final String DB_PASSWORD = "Password1";
	
	//-------------------	Local Connection ----------------------------------//
//	public static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
//	public static final String DB_USER = "demo";
//	public static final String DB_PASSWORD = "demo2016";
		
	public static String GET_AGENTS = "select trts.ID_COMPTE from TEST_RCU_TABLE_SOURCE trts where 1=1";
	
	public static final String GET_MID = "select rcm.MASTER_ID "
							+ " from TEST_RCU_TABLE_SOURCE trts, RCU_CUSTOMER_MASTER rcm "
							+ " where trts.ID_COMPTE = rcm.ID_COMPTE"
							+ " and trts.ID_COMPTE = ?";
	
	public List<Agent> getDataToDisplay(Map<String, Object> params) throws Exception{
		
		String INNER_SELECT = "select distinct master_id from rcu_customer_master rcm left join TEST_RCU_TABLE_SOURCE tt on rcm.ID_COMPTE = tt.ID_COMPTE where 1=1 ";
				
		String nom = (String)params.get("nom");
   	    String prenoms = (String)params.get("prenoms");
   	    String dateNaissance = (String)params.get("dateNaissance");
        String piece = (String)params.get("piece");
        String compteContri = (String)params.get("compteContri");
        String numero = (String)params.get("numero");
        String idCompte = (String)params.get("idCompte");
        
        if(nom!=null && !nom.isEmpty())
        	INNER_SELECT += " and LOWER(tt.NOM) like '%"+nom.toLowerCase()+"%' ";
        if(prenoms!=null && !prenoms.isEmpty())
        	INNER_SELECT += " and LOWER(tt.PRENOM) like '%"+prenoms.toLowerCase()+"%' ";
        if(dateNaissance!=null && !dateNaissance.isEmpty())
        	INNER_SELECT += " and LOWER(tt.DATE_NAISSANCE) like '%"+dateNaissance.toLowerCase()+"%' ";
        if(piece!=null && !piece.isEmpty())
        	INNER_SELECT += " and LOWER(tt.ID_PIECE) like '"+piece.toLowerCase()+"' ";
        if(compteContri!=null && !compteContri.isEmpty())
        	INNER_SELECT += " and LOWER(tt.COMPTE_CONTRIBUABLE) = '"+compteContri.toLowerCase()+"' ";
        if(numero!=null && !numero.isEmpty())
        	INNER_SELECT += " and LOWER(tt.PHONE_NUM) like '"+numero.toLowerCase()+"' ";
        if(idCompte!=null && !idCompte.isEmpty())
        	INNER_SELECT += " and LOWER(tt.ID_COMPTE) = '"+idCompte.toLowerCase()+"' ";
        
        String GET_COMPTES_FORM_NEW = "  select  "
			    + " rcm.MASTER_ID, rcm.MASTER_ID_B2C,  rcm.TYPE_MATCH_CD, rcm.TYPE_SERVICE_ID, rcm.DATE_CESSATION_MID, rcm.DATE_CREATION_MID,  "
			    + " trts.ID_COMPTE, trts.ID_NIVEAU_SUPERIEUR,  trts.SYSTEME_SOURCE_CD, trts.NOM, trts.PRENOM, trts.DATE_NAISSANCE, trts.LIEU_NAISSANCE, trts.TYPE_COMPTE"
			    + " trts.ID_PIECE, trts.TYPE_PIECE, trts.DATE_CREATION, trts.PHONE_NUM, trts.STATUTS, trts.TYPE_COMPTE, trts.COMPTE_CONTRIBUABLE, ts.LIBELLE_TYPESERVICE "
			    + " from Rcu_customer_master rcm, TEST_RCU_TABLE_SOURCE trts"
			    + " left join REFERENCE_TYPESERVICE ts on trts.TYPE_SERVICE = ts.CODE_TYPESERVICE"
			    + " where trts.id_compte = rcm.id_compte"
			    + " and rcm.master_id in ("+INNER_SELECT+")"
			    + " order by master_id";
        
        logger.info("La requête suivante sera exécutée pour obtenir la liste des comptes en fonction des critères de recherche: ");
		logger.info(GET_COMPTES_FORM_NEW);
		
		List<Agent> list= new ArrayList<Agent>();
		
		try {
            con = getConnection();
            pst = con.prepareStatement(GET_COMPTES_FORM_NEW);
         // execute statement
    		ResultSet rs = pst.executeQuery();
    		list = utils.doSetAgents2(rs);
            
        } catch (Exception e) {
			logger.error("Error pendant l'exécution de getCompteClient2: "+e.getMessage());
			throw new Exception("Une erreur est survenue");
		} finally{
			if(pst!=null){
				logger.info("Statement closed");
				pst.close();
			}				
			if(con != null){
				logger.info("Connection closed");
				con.close();
			}
				
		}
		
		return list.size()>0 ? list : null;
	}
	
	
	
	public  List<TableSource> getTableSources (Map<String, Object> params) throws Exception{  
		
//		BigDecimal id = params.get("id") != null ? new BigDecimal((String)params.get("id")) : null; 
    	String nom = (String)params.get("nom");
   	    String prenoms = (String)params.get("prenoms");
   	    String dateNaissance = (String)params.get("dateNaissance");
        String piece = (String)params.get("piece");
        String compteContri = (String)params.get("compteContri");
        String numero = (String)params.get("numero");
        String idCompte = (String)params.get("idCompte");
        
        if(nom!=null && !nom.isEmpty())
        	GET_AGENTS += " and LOWER(trts.NOM) = '%"+nom.toLowerCase()+"%' ";
        if(prenoms!=null && !prenoms.isEmpty())
        	GET_AGENTS += " and LOWER(trts.PRENOM) like '%"+prenoms.toLowerCase()+"%' ";
        if(dateNaissance!=null && !dateNaissance.isEmpty())
        	GET_AGENTS += " and LOWER(trts.DATE_NAISSANCE) like '%"+dateNaissance.toLowerCase()+"%' ";
        if(piece!=null && !piece.isEmpty())
        	GET_AGENTS += " and LOWER(trts.ID_PIECE) = '"+piece.toLowerCase()+"' ";
        if(compteContri!=null && !compteContri.isEmpty())
        	GET_AGENTS += " and LOWER(trts.COMPTE_CONTRIBUABLE) = '"+compteContri.toLowerCase()+"' ";
        if(numero!=null && !numero.isEmpty())
        	GET_AGENTS += " and LOWER(trts.PHONE_NUM) = '"+numero.toLowerCase()+"' ";
        if(idCompte!=null && !idCompte.isEmpty())
        	GET_AGENTS += " and LOWER(trts.ID_COMPTE) = '"+idCompte.toLowerCase()+"' ";
        
        logger.info("La requête suivante sera exécutée pour obtenir la liste des comptes en fonction des critères de recherche: ");
		logger.info(GET_AGENTS);
                
            List<TableSource> list= new ArrayList<TableSource>();
            
            try {
	            con = getConnection();
	            pst = con.prepareStatement(GET_AGENTS);
	         // execute statement
	    		ResultSet rs = pst.executeQuery();
	    		list = utils.doSetTabeSource(rs);
	            
            } catch (SQLException e) {
    			logger.error("Error pendant l'exécution de getCompteClient2: "+e.getMessage());
    			throw new Exception("Une erreur est survenue");
    		} finally{
    			if(pst!=null){
    				logger.info("Statement closed");
    				pst.close();
    			}				
    			if(con != null){
    				logger.info("Connection closed");
    				con.close();
    			}
    				
    		}
            
        return list.size()>0 ? list : null;
    }
	
	
	/*

	/**
	 * Cette méthode ramène la liste a afficher dans le tableau
	 * @param compteForm
	 * @return
	 * @throws Exception
	 
	public List<Agent> getComptesClient2(String compteForm) throws Exception {
		
		String GET_COMPTES_FORM_NEW = "      select  "
			    + " rcm.MASTER_ID, rcm.MASTER_ID_B2C,  rcm.TYPE_MATCH_CD, rcm.TYPE_SERVICE_ID, rcm.DATE_CESSATION_MID, rcm.DATE_CREATION_MID,  "
			    + " trts.ID_COMPTE, trts.ID_NIVEAU_SUPERIEUR,  trts.SYSTEME_SOURCE_CD, trts.NOM, trts.PRENOM, trts.DATE_NAISSANCE, trts.LIEU_NAISSANCE,"
			    + " trts.ID_PIECE, trts.TYPE_PIECE, trts.DATE_CREATION, trts.PHONE_NUM, trts.STATUTS, trts.TYPE_COMPTE, trts.COMPTE_CONTRIBUABLE, ts.LIBELLE_TYPESERVICE "
			    + " from Rcu_customer_master rcm, TEST_RCU_TABLE_SOURCE trts"
			    + " left join REFERENCE_TYPESERVICE ts on trts.TYPE_SERVICE = ts.CODE_TYPESERVICE"
			    + " where trts.id_compte = rcm.id_compte"
			    + " and rcm.master_id in ("+INNER_SELECT+")"
			    + " order by master_id";
		
		logger.info("La requête  suivante sera exécutée pour obtenir la liste de comptes à afficher, avec paramètre id_compte: ");
		logger.info(GET_COMPTES_FORM_NEW);
		logger.info("Paramètre id_compte: "+compteForm);
		
        List<Agent> listAgents = new ArrayList<Agent>();
		
		try {
		con = getConnection();
		pst = con.prepareStatement(GET_COMPTES_FORM_NEW);
		pst.setString(1, "%"+compteForm+"%");
		// execute statement
		ResultSet rs = pst.executeQuery();
		
		listAgents = utils.doSetAgents2(rs);
				
		} catch (SQLException e) {
			logger.error("Error pendant l'exécution de getCompteClient2: "+e.getMessage());
			throw new Exception("Une erreur est survenue");
		} finally{
			if(pst!=null){
				logger.info("Statement closed");
				pst.close();
			}				
			if(con != null){
				logger.info("Connection closed");
				con.close();
			}
				
		}
		return listAgents.size()>0 ? listAgents : null;
	}
*/

	public Connection getConnection() throws Exception{
		Connection con = null;
		try{
			Class.forName(DB_DRIVER);
		}catch(ClassNotFoundException e){
			logger.error(e.getMessage());
			throw new Exception("Une erreur est survenue");
		}
		
		try {
			con = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new Exception("Une erreur est survenue");
		}
		return con;
	}

	public String getMasterId(String compteId ) throws Exception {
		
		logger.info("La requête  suivante sera exécutée pour obtenir le Master ID pour le compte: "+compteId);
		logger.info(GET_MID);
		try {
			String mid = null;
			con = getConnection();
			pst = con.prepareStatement(GET_MID);
			pst.setString(1, compteId);
			// execute
			ResultSet rs = pst.executeQuery();
			if(rs.next())
				mid =  rs.getString("MASTER_ID");
			return mid;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception("Une erreur est survenue");
		}	}
    
}
