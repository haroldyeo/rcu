package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pojos.Agent;
import com.pojos.TableSource;
import com.utils.OperationsDb;
import com.utils.Utils;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Home.class);
       

    public Home() {
    	super();        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("inside home servlet GET");
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);	
	}



	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.info("inside home servlet post POST");
		
		String nom = request.getParameter("nom");
		String prenoms = request.getParameter("prenoms");
		String dateNaissance = request.getParameter("dateNaissance");
		String piece = request.getParameter("piece");
		String compteContri = request.getParameter("compteContri");
		String numero = request.getParameter("numero");
		String idCompte = request.getParameter("idCompte");
		
		Map<String, Object>  params = new HashMap<String, Object>();
		params.put("nom", nom);
		params.put("prenoms", prenoms);
		params.put("dateNaissance", dateNaissance);
		params.put("piece", piece);
		params.put("compteContri", compteContri);
		params.put("numero", numero);
		params.put("idCompte", idCompte);
					
			if(params.get("idCompte") != null && (String)params.get("idCompte") != ""){
				// recherche par le compteId seulement
				doGetResults(response, (String) params.get("idCompte"), null);
			}else {
				// recherche par les autres critères
				List<TableSource> list = (List<TableSource>) OperationsDb.find("agents", params);
				if(list != null){
					doGetResults(response, null, list);
				}else{
					logger.info("Après 1ere requête, liste de comptes is null");
				}
			}	
		
	}


	private void doGetResults(HttpServletResponse response, String idCompte, List<TableSource> list) {
		List<Agent> listAgents = new ArrayList<Agent>(); 
		if(list!=null && list.size() > 0)
			listAgents = OperationsDb.getComptesClient2(list.get(0).getCompteId());
		if(idCompte!=null)
			listAgents = OperationsDb.getComptesClient2(idCompte);
		
//		logger.info("LISTE AGENTS SIZE: "+ listAgents != null ? list.size() : "it's null");
		
		String rep = ""+Utils.doMakeJsonAgent2(listAgents);
		logger.info("json response: "+rep);
		
		response.setContentType("application/text");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(rep);
			
			out.flush();
		} catch (IOException e) {
			logger.error("erreur lors de l'ecriture de la reponse", e);
		}
		
		
	}


}
