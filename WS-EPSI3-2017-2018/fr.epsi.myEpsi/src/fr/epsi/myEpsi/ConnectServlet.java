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
 * Servlet implementation class ConnectServlet
 */
@WebServlet("/ConnectServlet")
public class ConnectServlet extends HttpServlet {	

	private static final Logger logger = LogManager.getLogger(StartupListener.class);
	private static final long serialVersionUID = 1L;
	private List<String> utilisateur = new ArrayList<String>();
	
	private static final String PARAM_ID = "ID";
	private static final String PARAM_PWD = "PWD";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectServlet() {
        super();
    }
    
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		this.getServletContext().getRequestDispatcher( "/login.html" ).forward( request, response );
	}
	
	
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter(PARAM_ID);
		String pwd = request.getParameter(PARAM_PWD);
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003","SA","");
	    	//con.close();
			ResultSet résultats = null;
	        String requete = "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	        try {            	
	        	PreparedStatement pt = con.prepareStatement(requete);
	        	pt.setString(1, pseudo);
	        	pt.setString(2, pwd);
	        	résultats = pt.executeQuery();
	        	
	            if( résultats.next() ) {
	            String idUtilisateur = résultats.getString("id");
	            String nomUtilisateur = résultats.getString("nom");
	            String phoneUtilisateur = résultats.getString("telephone");
	            String pwdUtilisateur = résultats.getString( "password" );
 	            Utilisateur utilisateur = new Utilisateur(idUtilisateur,nomUtilisateur,phoneUtilisateur,pwdUtilisateur);
	            
	            this.getServletContext().getRequestDispatcher( "/AnnoncesServlet" ).forward( request, response );
	            }
	            else {
	            	request.getRequestDispatcher("login.html").forward(request, response);
	            }
	            logger.info("REUSSITE de la requete");
	            	
	            
	        } catch (SQLException e) {
	       	 logger.error("ECHEC de la requete" + e.getMessage());
	       	 request.getRequestDispatcher("login.html").forward(request, response);
	        } 
		}catch (ClassNotFoundException | SQLException e){
    		logger.error("Connexion impossible" + e.getMessage());
    		request.getRequestDispatcher("login.html").forward(request, response);
    	}
		
	}

}
