package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojos.TUsers;
import com.utils.OperationsDb;

public class Find2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/find2.jsp").forward(request, response);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String compteForm = request.getParameter("compteId");
		List<TUsers> listComptes = new ArrayList<>();
		
		// ----  ALL IN ONE
		/* La requete suiveante permet d'obtenir la liste des comptes d'1 client à partir du compte du formulaire
		 * 1. Obtenir le masterID  du compteID du formulaire
		 * 2. Obtenir la liste des master/comptes where masterId = masterCompteForm.masterId
		 */
		listComptes  = OperationsDb.getComptesClient(compteForm);
		
		//Compiler les informations du user:  MAJ des informations autres que les comptes
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
		
		request.setAttribute("agent", endUser);
		request.setAttribute("comptes", listComptes);
	
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/find2.jsp").forward(request, response);
	
	}
}

