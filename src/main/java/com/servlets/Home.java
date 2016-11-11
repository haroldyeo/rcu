package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.pojos.TUsers;
import com.utils.OperationsDb;

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
			request.setAttribute("dataAgents", doMakeJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		
	}


	@SuppressWarnings("unchecked")
	private JSONArray doMakeJson(List<TUsers> list) {
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}
	
	

}
