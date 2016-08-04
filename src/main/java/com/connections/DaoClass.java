package com.connections;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojos.Agent;

import oracle.jdbc.driver.OracleDriver;

public class DaoClass {

    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USER = "demo";
    private static final String DB_PASSWORD = "demo2016";

 
    public static List<Agent> getListAgents() throws SQLException {
    	

        Connection dbConnection = null;
        Statement statement = null;
        List<Agent> listAgents = new ArrayList<Agent>();

        String selectTableSQL = "select ID , NOM , PRENOMS,  DATE_NAISSANCE , LIEU_NAISSANCE , ADRESSE , TEL_FIXE , TEL_MOBILE,"
        						+" EMAIL , AVISO , ORANGE_MONEY , SERVICE , TYPE_SERVICE   from t_users";

        try {
           
            
             dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            System.out.println(selectTableSQL);

            
            Agent ag = null;
            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);

            while (rs.next()) {

            	ag = new Agent(rs.getInt("ID"), rs.getString("NOM"), rs.getString("PRENOMS"), 
            			       rs.getDate("DATE_NAISSANCE"), rs.getString("LIEU_NAISSANCE"), rs.getString("ADRESSE"), 
            			       rs.getString("TEL_FIXE"), rs.getString("TEL_MOBILE"), rs.getString("EMAIL"), 
            			       rs.getString("AVISO"), rs.getString("ORANGE_MONEY"), rs.getString("SERVICE"), rs.getString("TYPE_SERVICE"));
            	
            	listAgents.add(ag);

            }
            System.out.println("size list agents: "+listAgents.size());

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }
		return listAgents;

    }

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }
    
    public static List<Agent> getData() {
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