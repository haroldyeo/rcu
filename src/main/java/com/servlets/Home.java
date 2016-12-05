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

import com.pojos.TUsers;
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
		String lieuNaissance = request.getParameter("lieuNaissance");
		String piece = request.getParameter("piece");
		String typePiece = request.getParameter("typePiece");
		
		Map<String, Object>  params = new HashMap<String, Object>();
		params.put("nom", nom);
		params.put("prenoms", prenoms);
		params.put("dateNaissance", dateNaissance);
		params.put("lieuNaissance", lieuNaissance);
		params.put("piece", piece);
		params.put("typePiece", typePiece);
		
		try {
			TUsers uniqueResult = null;
			List<TUsers> list = (List<TUsers>) OperationsDb.find("agents", params);
			if(list.size()>0) // ==> un seul compte ne doit être affiché à la suite de la recherche
				uniqueResult = list.get(0); 
			if(uniqueResult != null){
				response.setContentType("application/text");
				PrintWriter out = response.getWriter();
				out.print(Utils.doMakeJsonAgent(uniqueResult));
				out.flush();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
