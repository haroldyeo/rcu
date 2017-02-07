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

import org.apache.log4j.Logger;

import com.pojos.CustomerMaster;
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
		
		try {
			List<TableSource> list = (List<TableSource>) OperationsDb.find("agents", params);
			if(list != null){
				logger.info(list.size() == 0 ? "1ere requete: Liste de comptes is empty" : "1ere requete: liste de comptes contains elements; size: "+list.size() );
				
				
				// make second query and return list of all comptes with same master ID
				// On considère que tous les éléments de la 1ere requete ont le mm masterID
				
				String idCompteSelected = null;
				List<CustomerMaster> listMaster;
				
				if(list != null && list.size() > 0){
					idCompteSelected = list.get(0).getCompteId();
					
				// Obtenir le master id du compte sélectionné
					listMaster = (List<CustomerMaster>) OperationsDb.find("final", params);
					
					if(listMaster!=null){
						logger.info(listMaster.size() == 0 ? "List Master is empty" : "List Master contains elements; masterID is: "+listMaster.get(0).getMasterId() );
						
						// On lance la 2eme requete
						List<TableSource> listSameMasterId = OperationsDb.getComptesClient(idCompteSelected);
						if(listSameMasterId!=null){
							logger.info("size liste comptes sur same Master ID: "+listSameMasterId.size());
						} else{
							logger.info("liste comptes sur same Master ID is NULL");
						}
						
						String rep = "["+Utils.doMakeJsonAgent(listSameMasterId)+",["+listMaster.get(0).getMasterId()+"]]";
						logger.info("json response: "+rep);
						
						response.setContentType("application/text");
						PrintWriter out = response.getWriter();
						out.print(rep);
						
						out.flush();
						
					} else{
						logger.info("List master est nulle");
					}
				}
				
				
			}else
       			logger.info("Après 1ere requête, liste de comptes is null");
		
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Erreur lors de l'affichage des comptes", e);
		}
	}


}
