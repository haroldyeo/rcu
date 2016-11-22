package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.pojos.TUsers;
import com.utils.OperationsDb;
import com.utils.Utils;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Home() {
        super();
    }


	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		try {
			List<TUsers> list = (List<TUsers>) OperationsDb.find("agents", null);
			request.setAttribute("dataAgents", Utils.doMakeJsonAgent(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		
	}



	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenoms = request.getParameter("prenoms");
		String dob = request.getParameter("dateNaissance");
		String lieuNaissance = request.getParameter("lieuNaissance");
		String adresse = request.getParameter("adresse");
		String tel = request.getParameter("tel");
		
		Map<String, Object>  params = new HashMap<String, Object>();
		params.put("nom", nom);
		params.put("prenoms", prenoms);
		params.put("dob", dob);
		params.put("tel", tel);
		params.put("adresse", adresse);
		params.put("lieuNaissance", lieuNaissance);
		
		try {
			List<TUsers> list = (List<TUsers>) OperationsDb.find("agents", params);
			response.setContentType("application/text");
			PrintWriter out = response.getWriter();
			out.print(Utils.doMakeJsonAgent(list));
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
