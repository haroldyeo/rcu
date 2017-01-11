package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojos.Compte;
import com.utils.OperationsDb;
import com.utils.Utils;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Home() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// generate schema
//	    Persistence.generateSchema("rcudemo", null);
		
		// Obtenir le nombre de comptes pour affichage dans la vue -> T_FINAL
//		request.setAttribute("countComptes", Utils.countComptes);
		
			
//		try {
//			List<TUsers> list = (List<TUsers>) OperationsDb.find("agents", null);
//			request.setAttribute("dataAgents", Utils.doMakeJsonAgent(list));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		
	}



	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenoms = request.getParameter("prenoms");
		String dateNaissance = request.getParameter("dateNaissance");
		String piece = request.getParameter("piece");
		String compteContri = request.getParameter("compteContri");
		
		Map<String, Object>  params = new HashMap<String, Object>();
		params.put("nom", nom);
		params.put("prenoms", prenoms);
		params.put("dateNaissance", dateNaissance);
		params.put("piece", piece);
		params.put("compteContri", compteContri);
		
		try {
			List<Compte> list = (List<Compte>) OperationsDb.find("agents", params);
			if(list.size() > 0)
				list = getComptesUniques(list);
			response.setContentType("application/text");
			PrintWriter out = response.getWriter();
			out.print(Utils.doMakeJsonAgent(list));
			out.flush();
			System.out.println();
			/*
			if(list.size()>0) // ==> un seul compte ne doit être affiché à la suite de la recherche
				uniqueResult = list.get(0); 
			if(uniqueResult != null){
				response.setContentType("application/text");
				PrintWriter out = response.getWriter();
				out.print(Utils.doMakeJsonAgent(uniqueResult));
				out.flush();
			}
			*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private List<Compte> getComptesUniques(List<Compte> list) {
		
		// recenser toutes les pièces d'identités dans une liste 
		List<String> allPieces = new ArrayList<>();
		for(Compte c : list){
			allPieces.add(c.getPiece());
		}
		
		// get a set of uniques keys
		LinkedHashSet<String> allPiecesSet = new LinkedHashSet<>();
		allPiecesSet.addAll(allPieces);
		
		// Get the corresponding comptes in the return list
		List<Compte> listToReturn = new ArrayList<>();
		
		for(String s : allPiecesSet){
			for(Compte c : list){
				if(s.equals(c.getPiece())){
					listToReturn.add(c);
					break;
				}
			}
		}
		return listToReturn;
	}
	
	

}
