package fr.epsi.myEpsi;

import java.io.Console;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fr.epsi.myEpsi.Constantes;
import fr.epsi.myEpsi.beans.Annonce;
import fr.epsi.myEpsi.beans.Utilisateur;
import fr.epsi.myEpsi.listeners.StartupListener;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final Logger logger = LogManager.getLogger(StartupListener.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/inscription.html").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String id = request.getParameter("ID");		
		String password = request.getParameter("PWD");
		String name = request.getParameter("NAME");
		String phone = request.getParameter("PHONE");
		
		logger.error(id);
		
		this.insertData(id, password, name, phone);
		

		this.getServletContext().getRequestDispatcher("/AnnoncesServlet").forward( request, response );
	}

	
	
	private void insertData(String id,String password,String name,String phone) {
		 try {
				Class.forName("org.hsqldb.jdbcDriver");
				Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003","SA","");
		    	//con.close();
		        String requete = "INSERT INTO USERS VALUES(?,?,?,?,false)";
		        try { 
		        	PreparedStatement pt = con.prepareStatement(requete);
		        	pt.setString(1, id);
		        	pt.setString(2, password);
		        	pt.setString(3, name);
		        	pt.setString(4, phone);
		        	pt.executeUpdate();
		        	
		            logger.error("REUSSITE de la requete");
		            
		            
		        } catch (SQLException e) {
		       	 logger.error("ECHEC de la requete" + e.getMessage());
		        } 
			}catch (ClassNotFoundException | SQLException e){
	    		logger.error("Connexion impossible" + e.getMessage());
	    	}
	}
	
}
