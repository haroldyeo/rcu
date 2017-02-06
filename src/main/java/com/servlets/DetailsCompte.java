package com.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pojos.TableSource;
import com.utils.OperationsDb;
import com.utils.Utils;

public class DetailsCompte extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(DetailsCompte.class);
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	logger.info("Inside GET details comptes");
		
	}


	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.info("Inside  POST details comptes");
		
		String compteForm = request.getParameter("compteId");
		
		Map<String, Object>  params = new HashMap<String, Object>();
		params.put("idCompte", compteForm);
		List<TableSource> listComptes  = (List<TableSource>) OperationsDb.find("agents", params);
		
		if(listComptes != null && listComptes.size() > 0){
			logger.info("ListComptes is not null and contains elements");
			
			String compte = "["+Utils.doMakeJsonAgent(listComptes)+"]";
			
			logger.info("json response: "+compte );
			
			response.getWriter().write(compte);
			
		} else{
			logger.info("ListComptes is null or empty");
		}
		

	
	}

}

