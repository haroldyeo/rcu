package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojos.FinalTable;
import com.pojos.TUsers;
import com.utils.OperationsDb;

public class Find2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/find2.jsp").forward(request, response);
	}


	@SuppressWarnings({ "unchecked"})
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, Object>  params = new HashMap<String, Object>();
		
		//--------- Obtenir le masterID  du compteID du formulaire ==> masterCompteForm
		
		FinalTable masterCompteForm = null;
		if(request.getParameter("compteId")!=null){
			System.out.println("param id: "+request.getParameter("compteId"));
			params.put("compteId", request.getParameter("compteId"));
		}		
		try {
			masterCompteForm = ((List<FinalTable>) OperationsDb.find("final", params)).get(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//------Obtenir la liste des master/comptes where masterId = masterCompteForm.masterId ==> listMasters
		List<FinalTable> listMasters = null;
		params.clear(); params.put("masterId", masterCompteForm.getMasterId());
		listMasters = (List<FinalTable>) OperationsDb.find("final", params);
		
		
		//----- Obtenir la liste des comptes ==> listComptes
		List<TUsers> listComptes = new ArrayList<>();
		if(listMasters.isEmpty()){
			System.out.println("Find2.doPost(): NO MASTER ID FOUND");
		} else 
		for(FinalTable f : listMasters){
			params.clear(); params.put("id", f.getCompteId());
			listComptes.addAll((List<TUsers>) OperationsDb.find("agents", params));
		}
		
		//--- Compiler les informations du user
		
				
		// MAJ des informations autres que les comptes
		TUsers endUser = listComptes.get(0);
		for(TUsers a : listComptes){
			
			if(endUser.getAdresse() == null){
				endUser.setAdresse(a.getAdresse()!= null  ? a.getAdresse() : null);
			}
			
			if(endUser.getDateNaissance() == null){
				endUser.setDateNaissance(a.getDateNaissance()!= null  ? a.getDateNaissance() : null);
			}
			
			if(endUser.getEmail() == null){
				endUser.setEmail(a.getEmail()!= null  ? a.getEmail() : null);
			}
			
			if(endUser.getLieuNaissance() == null){
				endUser.setLieuNaissance(a.getLieuNaissance()!= null  ? a.getLieuNaissance() : null);
			}
			if(endUser.getNom() == null){
				endUser.setNom( a.getNom()!= null  ? a.getNom() : null);
			}
			if(endUser.getPrenoms() == null){
				endUser.setPrenoms(a.getPrenoms()!= null  ? a.getPrenoms() : null);
			}
			if(endUser.getService() == null){
				endUser.setService( a.getService()!= null  ? a.getService() : null);
			}
			if(endUser.getTypeService() == null){
				endUser.setTypeService( a.getTypeService()!= null  ? a.getTypeService() : null);
			}
			if(endUser.getPiece() == null){
				endUser.setPiece( a.getPiece()!= null  ? a.getPiece() : null);
			}
			if(endUser.getTypePiece() == null){
				endUser.setTypePiece( a.getTypePiece()!= null  ? a.getTypePiece() : null);
			}
			
		}
		
		// PEC des comptes
//		Map<String,Object> mapComptesValeurs = new HashMap<>();
//		for(TUsers a : listComptes){
//			mapComptesValeurs.put(String.valueOf(a.getId()), a);
//		}
		
		request.setAttribute("masterId", masterCompteForm.getMasterId());
		request.setAttribute("agent", endUser);
		request.setAttribute("comptes", listComptes);
	
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/find2.jsp").forward(request, response);
	
	}
}

