package com.utils;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.pojos.TUsers;

public class Utils {
	
//	public static final long countComptes = getCountComptes();

	/**
	 * Fonction qui transforme une liste d'utilisateurs en format JSON
	 * @param list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static JSONArray doMakeJsonAgent(List<TUsers> list){
		JSONArray jarr = new JSONArray();
		for (TUsers u : list){
			JSONObject job = new JSONObject();
			
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
							
			jarr.add(job);
			
		}
		return jarr;
	}
	
	/**
	 * Fonction qui transforme une utlisateur en format JSONArray
	 * @param list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static JSONObject doMakeJsonAgent(TUsers u){
			JSONObject job = new JSONObject();
			
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
		return job;
	}

//	private static long getCountComptes() {
//		@SuppressWarnings("unchecked")
//		List<FinalTable> list = (List<FinalTable>) OperationsDb.find("final", null);
//		return list.size();
//	}
}
