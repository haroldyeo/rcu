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
			if(list != null)
				logger.info("size retruned list: "+list.size());
       		else
       			logger.info("returned list is null");
			
			// make second query and return list of all comptes with same master ID
			// On consid�re que tous les �l�ments de la 1ere requete ont le mm masterID
			String idCompteSelected = null;
			if(list != null && list.size() > 0){
				idCompteSelected = list.get(0).getCompteId();
			}
			
			// On lance la 2eme requete
			List<TableSource> listSameMasterId = OperationsDb.getComptesClient(idCompteSelected);
			if(listSameMasterId!=null){
				logger.info("size liste comptes sur same Master ID: "+listSameMasterId.size());
			} else{
				logger.info("liste comptes sur same Master ID is NULL");
			}
			
			
			
			
			response.setContentType("application/text");
			PrintWriter out = response.getWriter();
			out.print(Utils.doMakeJsonAgent(listSameMasterId));
			out.flush();
			/*
			if(list.size()>0) // ==> un seul compte ne doit �tre affich� � la suite de la recherche
				uniqueResult = list.get(0); 
			if(uniqueResult != null){
				response.setContentType("application/text");
				PrintWriter out = response.getWriter();
				out.print(Utils.doMakeJsonAgent(uniqueResult));
				out.flush();
			}
			*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

/*  WE DONT GET UNIQUE ACCOUNTS ANYMORE!!!!
 * 
 * 
	private List<TableSource> getComptesUniquesByPiece(List<TableSource> list) {
		
		// recenser toutes les pi�ces d'identit�s dans une liste 
		List<String> allPieces = new ArrayList<>();
		for(TableSource c : list){
			allPieces.add(c.getPiece());
		}
		
		// get a set of uniques keys
		LinkedHashSet<String> allPiecesSet = new LinkedHashSet<>();
		allPiecesSet.addAll(allPieces);
		
		// Get the corresponding comptes in the return list
		List<TableSource> listToReturn = new ArrayList<>();
		
		for(String s : allPiecesSet){
			for(TableSource c : list){
				if(s.equals(c.getPiece())){
					listToReturn.add(c);
					break;
				}
			}
		}
		return listToReturn;
	}
	
private List<TableSource> getComptesUniquesByCompte(List<TableSource> list) {
		
		// recenser toutes les pi�ces d'identit�s dans une liste 
		List<String> allComptes = new ArrayList<>();
		for(TableSource c : list){
			allComptes.add(c.getCompteId().toString());
		}
		
		// get a set of uniques keys
		LinkedHashSet<String> allComptesSet = new LinkedHashSet<>();
		allComptesSet.addAll(allComptes);
		
		// Get the corresponding comptes in the return list
		List<TableSource> listToReturn = new ArrayList<>();
		
		for(String s : allComptesSet){
			for(TableSource c : list){
				if(s.equals(c.getCompteId())){
					listToReturn.add(c);
					break;
				}
			}
		}
		return listToReturn;
	}
	
	*/

}
