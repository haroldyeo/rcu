package com.utils;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.pojos.Compte;

public class Utils {
	
//	public static final long countComptes = getCountComptes();

	/**
	 * Fonction qui transforme une liste de comptes en array JSON
	 * @param list liste comptes
	 * @return JsonArray
	 */
	@SuppressWarnings("unchecked")
	public static JSONArray doMakeJsonAgent(List<Compte> list){
		JSONArray jsonArray = new JSONArray();
		for (Compte c : list){			
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
	public static JSONObject doMakeJsonAgent(Compte c){
			JSONObject job = new JSONObject();
			
			job.put("id", c.getCompteId());
			job.put("nom", c.getNom());
			job.put("prenoms", c.getPrenoms());
			job.put("lieuNaissance", c.getLieuNaissance());
			
			job.put("numero", c.getNumero());
			job.put("adresse", c.getAdresse());
			job.put("typeService", c.getTypeService());
			job.put("dateNaissance", c.getDateNaissance());		
			
			job.put("piece", c.getPiece());
			job.put("typePiece", c.getTypePiece());
			
			job.put("typeCompte", c.getTypeCompte());
			job.put("statut", c.getStatut());
			job.put("systemSourceCode", c.getSystemSourceCode());
			job.put("compteContri", c.getCompteContribuable());
		return job;
	}

//	private static long getCountComptes() {
//		@SuppressWarnings("unchecked")
//		List<FinalTable> list = (List<FinalTable>) OperationsDb.find("final", null);
//		return list.size();
//	}
}
