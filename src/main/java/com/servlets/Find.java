package com.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utils.OperationsDb;

public class Find extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/find.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String nom = request.getParameter("nom");
		String prenoms = request.getParameter("prenoms");
		String dob = request.getParameter("dateNaissance");
		String lieuNaissance = request.getParameter("lieuNaissance");
		String adresse = request.getParameter("adresse");
		String tel = request.getParameter("tel");
		
//		if(request.getParameter("dateNaissance")!=null && request.getParameter("dateNaissance") != ""){
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//			String dateInString = request.getParameter("dateNaissance");
//			try {
//				dob = formatter.parse(dateInString);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
				
		
		
//		Agent searchedAgent = new Agent(nom, prenoms, dob, lieuNaissance, adresse, tel);
		
		Map<String, Object>  params = new HashMap<String, Object>();
		params.put("nom", nom);
		params.put("prenoms", prenoms);
		params.put("dob", dob);
		params.put("tel", tel);
		params.put("adresse", adresse);
		params.put("lieuNaissance", lieuNaissance);
		
		try {
			request.setAttribute("dataAgents", OperationsDb.find("agents", params));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/find.jsp").forward(request, response);
	
	}
}

