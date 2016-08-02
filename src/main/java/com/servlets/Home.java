package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojos.Agent;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Home() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setAttribute("bonjour", "bonjour, Harold");
		request.setAttribute("dataAgents", getData());
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private List<Agent> getData() {
		List<Agent> list = new ArrayList<Agent>();
		list.add(new Agent(1, "YEO", "Harold", "", "23454713", "47680356"));
		list.add(new Agent(1, "YEO", "Harold", "", "23454713", "47680356"));
		list.add(new Agent(1, "YEO", "Harold", "", "23454713", "47680356"));
		list.add(new Agent(1, "YEO", "Harold", "", "23454713", "47680356"));
		list.add(new Agent(1, "YEO", "Harold", "", "23454713", "47680356"));
		list.add(new Agent(1, "YEO", "Harold", "", "23454713", "47680356"));
		return list;
	}

}
