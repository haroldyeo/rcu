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

import com.pojos.TableSource;
import com.utils.Log;
import com.utils.OperationsDb;
import com.utils.Utils;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Log rcuLog;
       

    public Home() {
    	super();
    	rcuLog = new Log(Utils.logFilePath);
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rcuLog.logger.info("home servlet get executed");
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		
	}



	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		rcuLog.logger.info("home servlet post executed");
		
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
			List<TableSource> list = (List<TableSource>) OperationsDb.find("agents", params);
			response.setContentType("application/text");
			PrintWriter out = response.getWriter();
			out.print(Utils.doMakeJsonAgent(list));
			out.flush();
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


	private List<TableSource> getComptesUniquesByPiece(List<TableSource> list) {
		
		// recenser toutes les pièces d'identités dans une liste 
		List<String> allPieces = new ArrayList<>();
		for(TableSource c : list){
			allPieces.add(c.getPiece());
		}
		
		// get a set of uniques keys
		LinkedHashSet<String> allPiecesSet = new LinkedHashSet<>();
		allPiecesSet.addAll(allPieces);
		
		// Get the corresponding comptes in the return list
		List<TableSource> listToReturn = new ArrayList<>();
		
		for(String s : allPiecesSet){
			for(TableSource c : list){
				if(s.equals(c.getPiece())){
					listToReturn.add(c);
					break;
				}
			}
		}
		return listToReturn;
	}
	
private List<TableSource> getComptesUniquesByCompte(List<TableSource> list) {
		
		// recenser toutes les pièces d'identités dans une liste 
		List<String> allComptes = new ArrayList<>();
		for(TableSource c : list){
			allComptes.add(c.getCompteId().toString());
		}
		
		// get a set of uniques keys
		LinkedHashSet<String> allComptesSet = new LinkedHashSet<>();
		allComptesSet.addAll(allComptes);
		
		// Get the corresponding comptes in the return list
		List<TableSource> listToReturn = new ArrayList<>();
		
		for(String s : allComptesSet){
			for(TableSource c : list){
				if(s.equals(c.getCompteId())){
					listToReturn.add(c);
					break;
				}
			}
		}
		return listToReturn;
	}
	
	

}
