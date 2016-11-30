package com.utils;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.pojos.TUsers;

public class Utils {
	
//	public static final long countComptes = getCountComptes();

	/**
	 * Fonction qui transforme une liste d'utilisateurs en array JSON
	 * @param list liste Utilisateurs
	 * @return JsonArray
	 */
	@SuppressWarnings("unchecked")
	public static JSONArray doMakeJsonAgent(List<TUsers> list){
		JSONArray jsonArray = new JSONArray();
		for (TUsers u : list){			
			jsonArray.add(doMakeJsonAgent(u));
		}
		return jsonArray;
	}
	
	/**
	 * Fonction qui transforme un utlisateur en format objet JSON
	 * @param u objet utilisateur
	 * @return JsonObject
	 */
	@SuppressWarnings("unchecked")
	public static JSONObject doMakeJsonAgent(TUsers u){
			JSONObject job = new JSONObject();
			
			job.put("id", u.getId());
			job.put("nom", u.getNom());
			job.put("prenoms", u.getPrenoms());
			job.put("lieuNaissance", u.getLieuNaissance());
			job.put("id", u.getId());
			
			job.put("adresse", u.getAdresse());
			job.put("telFixe", u.getTelFixe());
			job.put("telMobile", u.getTelMobile());
			job.put("email", u.getEmail());
			
			job.put("aviso", u.getAviso());
			job.put("orangeMoney", u.getOrangeMoney());
			job.put("service", u.getService());
			job.put("typeService", u.getTypeService());
			job.put("dateNaissance", u.getDateNaissance());		
			
			job.put("piece", u.getPiece());
			job.put("typePiece", u.getTypePiece());
		return job;
	}

//	private static long getCountComptes() {
//		@SuppressWarnings("unchecked")
//		List<FinalTable> list = (List<FinalTable>) OperationsDb.find("final", null);
//		return list.size();
//	}
}
