package com.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.pojos.Agent;
import com.pojos.CustomerMaster;
import com.pojos.TableSource;

public class Utils {
	
//	public static final long countComptes = getCountComptes();

	final Logger logger = Logger.getLogger(Utils.class);

	/**
	 * Fonction qui transforme une liste de comptes en array JSON
	 * @param list liste comptes
	 * @return JsonArray
	 */
	@SuppressWarnings("unchecked")
	public  JSONArray doMakeJsonAgent(List<TableSource> list){
		JSONArray jsonArray = new JSONArray();
		for (TableSource c : list){			
			jsonArray.add(doMakeJsonAgent(c));
		}
		return jsonArray;
	}
	
	/**
	 * Fonction qui transforme un compte en format objet JSON
	 * @param c objet compte
	 * @return JsonObject
	 */
	@SuppressWarnings("unchecked")
	public  JSONObject doMakeJsonAgent(TableSource c){
			JSONObject job = new JSONObject();
			
			job.put("id", c.getCompteId());
			job.put("nom", c.getNom());
			job.put("prenoms", c.getPrenoms());
			job.put("lieuNaissance", c.getLieuNaissance());
			
			job.put("numero", c.getNumero());
//			job.put("adresse", c.getAdresse());
			job.put("typeService", c.getTypeService());
			job.put("dateNaissance", c.getDateNaissance());		
			
			job.put("piece", c.getPiece());
			job.put("typePiece", c.getTypePiece());
			job.put("idNiveauSup", c.getIdNiveauSuperieur());
			
			job.put("typeCompte", c.getTypeCompte());
			job.put("statut", c.getStatut());
			job.put("source", c.getSystemSourceCode());
			job.put("compteContri", c.getCompteContribuable());
		return job;
	}
	
	@SuppressWarnings("unchecked")
	public  JSONObject doMakeJsonAgent2(Agent c){
			JSONObject job = new JSONObject();
			
			job.put("id", c.getTableSource().getCompteId());
			job.put("nom", c.getTableSource().getNom());
			job.put("prenoms", c.getTableSource().getPrenoms());
			job.put("lieuNaissance", c.getTableSource().getLieuNaissance());
			job.put("numero", c.getTableSource().getNumero());
//			job.put("adresse", c.getAdresse());
			job.put("typeService", c.getTableSource().getTypeService());
			job.put("dateNaissance", c.getTableSource().getDateNaissance());
			job.put("piece", c.getTableSource().getPiece());
			job.put("typePiece", c.getTableSource().getTypePiece());
			job.put("idNiveauSup", c.getTableSource().getIdNiveauSuperieur());
			job.put("typeCompte", c.getTableSource().getTypeCompte());
			job.put("statut", c.getTableSource().getStatut());
			job.put("source", c.getTableSource().getSystemSourceCode());
			job.put("compteContri", c.getTableSource().getCompteContribuable());
			
			job.put("masterId", c.getMaster().getMasterId());
			job.put("compteId", c.getMaster().getCompteId());
			job.put("masterIdB2C", c.getMaster().getMasterIdB2C());
			job.put("systemSourceCode", c.getMaster().getSystemSourceCode());
			job.put("typeMatch", c.getMaster().getTypeMatch());
			job.put("typerService", c.getMaster().getTyperService());
			job.put("dateCreation", c.getMaster().getDateCreation());
			job.put("dateCessation", c.getMaster().getDateCessation());
			
			
		return job;
	}

	public  void doTakeCareException(Exception e) {
		
	}

	@SuppressWarnings("unchecked")
	public  JSONArray doMakeJsonAgent2(List<Agent> listAgents) {
		JSONArray jsonArray = new JSONArray();
		for (Agent c : listAgents){			
			jsonArray.add(doMakeJsonAgent2(c));
		}
		return jsonArray;
	}

	
	public  List<Agent> doSetAgents2(ResultSet rs) throws SQLException {
		List<Agent> listAgents = new ArrayList<>();
		
		while(rs.next()){
			
			TableSource ts = new TableSource();
			CustomerMaster cm = new CustomerMaster();
			
			cm.setMasterId(rs.getString("MASTER_ID"));
			cm.setMasterIdB2C(rs.getString("MASTER_ID_B2C"));
			cm.setTypeMatch(rs.getString("TYPE_MATCH_CD"));
			cm.setTyperService(rs.getString("TYPE_SERVICE_ID"));
			cm.setDateCessation(rs.getString("DATE_CESSATION_MID"));
			cm.setDateCreation(rs.getString("DATE_CREATION_MID"));
			
			ts.setCompteId(rs.getString("ID_COMPTE"));
			ts.setIdNiveauSuperieur(rs.getString("ID_NIVEAU_SUPERIEUR"));
			
			ts.setSystemSourceCode(rs.getString("SYSTEME_SOURCE_CD"));
			ts.setNom(rs.getString("NOM"));
			ts.setPrenoms(rs.getString("PRENOM"));
			ts.setDateNaissance(rs.getString("DATE_NAISSANCE"));
			ts.setLieuNaissance(rs.getString("LIEU_NAISSANCE"));
			ts.setPiece(rs.getString("ID_PIECE"));
			ts.setTypePiece(rs.getString("TYPE_PIECE"));
			ts.setDateCreation(rs.getString("DATE_CREATION"));
			ts.setNumero(rs.getString("PHONE_NUM"));
			ts.setStatut(rs.getString("STATUTS"));
			ts.setTypeCompte(rs.getString("TYPE_COMPTE"));
			ts.setCompteContribuable(rs.getString("COMPTE_CONTRIBUABLE"));
			ts.setTypeService(rs.getString("LIBELLE_TYPESERVICE"));
			
			listAgents.add(new Agent(ts, cm));
			
		}
		
		return listAgents;
		
	}
	
	
	public List<TableSource> doSetTabeSource (ResultSet rs) throws SQLException {
		List<TableSource> list = new ArrayList<>();
		while(rs.next()){
			TableSource tb = new TableSource();
			
			tb.setCompteId(rs.getString("ID_COMPTE"));
			list.add(tb);	
		}
		logger.info("--------   comptes --------");
		for(TableSource s : list){
			logger.info(s.getCompteId());
		}
		return list;
	}


}
