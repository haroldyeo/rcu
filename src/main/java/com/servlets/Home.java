package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.utils.OperationsDb;
import com.utils.Utils;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = Logger.getLogger(Home.class);
	private Utils utils= new Utils();
	private OperationsDb odb= new OperationsDb();

    public Home() {
    	super();        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("inside home servlet GET");
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.info("inside home servlet post POST");
		
		// check the time limit
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date endDate = null;
		try {
			endDate = sdf.parse("31/07/2017");
		} catch (ParseException e1) {
			e1.printStackTrace();
			logger.error("Erreur de parsing de a date 'END DATE' ");
		}
		
		Date today = new Date(); 
		
		if(today.compareTo(endDate) >= 0){
			logger.info("La date d'essai a expirée!");
			response.setContentType("application/text");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print("{\"limit\":true}");
				
				out.flush();
			} catch (IOException e) {
				logger.error("erreur lors de l'ecriture de la reponse", e);
			}		
		} else{
			logger.info("Date d'essai valide!");
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
			
			List<Agent> listAgents = new ArrayList<>();
			
			try {
				 listAgents = odb.getDataToDisplay(params);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			}
			
			String rep = ""+utils.doMakeJsonAgent2(listAgents);
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
		
				
		
	} // end doPost


}
