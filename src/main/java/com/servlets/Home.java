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
//			request.setAttribute("dataAgents", OperationsDb.find("agents", null));
			List<TUsers> list = (List<TUsers>) OperationsDb.find("agents", null);
			JSONArray jarr = new JSONArray();
			for (TUsers u : list){
				JSONObject job = new JSONObject();
				job.put("nom", u.getNom());
				job.put("prenoms", u.getPrenoms());
				job.put("telephone", u.getTelFixe());
				
				jarr.add(job);
				
			}
			request.setAttribute("dataAgents", jarr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}
	
	

}
