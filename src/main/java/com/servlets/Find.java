package com.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojos.Agent;

public class Find extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/find.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		String dateInString = request.getParameter("dateNaissance").toString();
		Date dob = null;
		try {
			dob = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String lieuNaissance = request.getParameter("lieuNaissance");
		String adresse = request.getParameter("adresse");
		String tel = request.getParameter("tel");
		
		Agent searchedAgent = new Agent(nom, prenom, dob, lieuNaissance, adresse, tel);
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/find.jsp").forward(request, response);
	
	}
}

