package com.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connections.DaoClass;
import com.pojos.Agent;

public class Find2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/find2.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = null;
		if(request.getParameter("id")!=null){
			id = request.getParameter("id");
			System.out.println("request param: "+id);
		}
		
		Agent selectedAgent = new Agent(Integer.parseInt(id), null, null, null, null, null, null, null, null, null, null, null, null);
		
		try {
			List<Agent> list = DaoClass.getListAgentsWithCriteria(selectedAgent);
			
//			for(Agent ag : list){
//				if(ag.getId() == Integer.parseInt(id)){
//					selectedAgent = ag;
//					System.out.println("Found agent");
//					break;
//				}
//			}
			if(list.size()==1){
				System.out.println("Found agent");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("agent", selectedAgent);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/find2.jsp").forward(request, response);
	
	}
}

