package com.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.connections.DaoClass;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Home() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			request.setAttribute("dataAgents", DaoClass.getListAgents());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject json;
		try {
			json = (JSONObject) new JSONParser().parse(request.getParameter("test"));
		
		String nom = (String) json.get("nom");
		String prenoms = (String) json.get("prenoms");
		String tel = (String) json.get("tel");
		String adresse = (String) json.get("adresse");
		String lieuNaissance = (String) json.get("lieuNaissance");
		
		try {
			request.setAttribute("dataAgents", DaoClass.getListAgents());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
