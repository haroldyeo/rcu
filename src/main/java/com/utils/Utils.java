package com.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.pojos.Agent;
import com.pojos.CustomerMaster;
import com.pojos.TableSource;

public class Utils {
	
//	public static final long countComptes = getCountComptes();

	/**
	 * Fonction qui transforme une liste de comptes en array JSON
	 * @param list liste comptes
	 * @return JsonArray
	 */
	@SuppressWarnings("unchecked")
	public static JSONArray doMakeJsonAgent(List<TableSource> list){
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
	public static JSONObject doMakeJsonAgent(TableSource c){
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
	public static JSONObject doMakeJsonAgent2(Agent c){
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

	public static void doTakeCareException(Exception e) {
		
	}

	@SuppressWarnings("unchecked")
	public static JSONArray doMakeJsonAgent2(List<Agent> listAgents) {
		JSONArray jsonArray = new JSONArray();
		for (Agent c : listAgents){			
			jsonArray.add(doMakeJsonAgent2(c));
		}
		return jsonArray;
	}

	/**
	 * Méthode de récupération des données brutes de la requete et assignation à l'entité "Agent"
	 * @param rows
	 * @return
	 */
	public static List<Agent> doSetAgents(List<Object[]> rows) {
		
		
		List<Agent> listAgents = new ArrayList<>();
		
		for(Object[] row : rows){
			TableSource ts = new TableSource();
			CustomerMaster cm = new CustomerMaster();
			
			cm.setMasterId((row[0] != null ? row[0].toString() : ""));
			cm.setMasterIdB2C(row[1] != null ? row[1].toString() : "");
			cm.setTypeMatch(row[2] != null ? row[2].toString() : "");
			cm.setTyperService(row[3] != null ? row[3].toString() : "");
			cm.setDateCessation(row[4] != null ? row[4].toString() : "");
			cm.setDateCreation(row[5] != null ? row[5].toString() : "");
			
			ts.setCompteId(row[6] != null ? row[6].toString() : "");
			ts.setIdNiveauSuperieur(row[7] != null ? row[7].toString() : "");
			
			ts.setSystemSourceCode(row[8] != null ? row[8].toString() : "");
			ts.setNom(row[9] != null ? row[9].toString() : "");
			ts.setPrenoms(row[10] != null ? row[10].toString() : "");
			ts.setDateNaissance(row[11] != null ? row[11].toString() : "");
			ts.setLieuNaissance(row[12] != null ? row[12].toString() : "");
			ts.setPiece(row[13] != null ? row[13].toString() : "");
			ts.setTypePiece(row[14] != null ? row[14].toString() : "");
			ts.setDateCreation(row[15] != null ? row[15].toString() : "");
			ts.setNumero(row[16] != null ? row[16].toString() : "");
			ts.setStatut(row[17] != null ? row[17].toString() : "");
			ts.setTypeCompte(row[18] != null ? row[18].toString() : "");
			ts.setCompteContribuable(row[19] != null ? row[19].toString() : "");
			ts.setTypeService(row[20] != null ? row[20].toString() : "");
			if(ts.getTypeService()!=null){
				ts.setTypeService(getValueTypeService(ts.getTypeService()));
			}
			
			listAgents.add(new Agent(ts, cm));
			
		}
		
		return listAgents;
		
	}

	private static String getValueTypeService(String typeService) {
		switch (typeService) {
		case "1": return "Mobile";
		case "2": return "Fixe";
		case "3": return "Aviso";
		case "4": return "Orange Money";
		case "5": return "Wimax";
		default: break;
		}
		return "";
	}


//	private static long getCountComptes() {
//		@SuppressWarnings("unchecked")
//		List<FinalTable> list = (List<FinalTable>) OperationsDb.find("final", null);
//		return list.size();
//	}
}
