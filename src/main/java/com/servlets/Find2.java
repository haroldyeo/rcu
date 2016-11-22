package com.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojos.TUsers;
import com.utils.OperationsDb;
import com.utils.Utils;

public class Find2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/find2.jsp").forward(request, response);
	}


	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, Object>  params = new HashMap<String, Object>();
		
		if(request.getParameter("id")!=null){
			System.out.println("param id: "+request.getParameter("id"));
			params.put("id", request.getParameter("id"));
		}		
		try {
			List<TUsers> list = (List<TUsers>) OperationsDb.find("agents", params);
			if(list!=null && !list.isEmpty() && list.size()==1)
				request.setAttribute("agent", Utils.doMakeJsonAgent(list).get(0));
			else
				System.out.println("No agent found");
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/find2.jsp").forward(request, response);
	
	}
}

