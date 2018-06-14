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
 * Servlet implementation class AnnonceAjout
 */
@WebServlet("/AnnonceAjout")
public class AnnonceAjout extends HttpServlet {
	
	private static final Logger logger = LogManager.getLogger(StartupListener.class);
	private static final long serialVersionUID = 1L;
	
	private int message = 0;
	private int id = 0;
	
	private static final String PARAM_TITLE = "TITLE";
	private static final String PARAM_DESCRIPTION = "DESCRIPTION";  
	private static final String PARAM_PRIX = "PRIX";  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnonceAjout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher( "/AjoutAnnonce.html" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
						
		String title = request.getParameter(PARAM_TITLE);
		String description = request.getParameter(PARAM_DESCRIPTION);
		Double prix = Double.parseDouble(request.getParameter(PARAM_PRIX));
		
		logger.error(title);
		
		this.insertData(title, description, prix);


		response.sendRedirect("AnnoncesServlet");
		//this.getServletContext().getRequestDispatcher("/AnnoncesServlet").forward(request, response);
         
		
	}
	
	
	
	
	
	
	
	private void insertData(String title,String description,Double prix) {
		 try {
				Class.forName("org.hsqldb.jdbcDriver");
				Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003","SA","");
		    	//con.close();
				ResultSet résultats = null;
				String requete1 = "SELECT MAX(ID) FROM ANNONCES";
				
				 try {
		                PreparedStatement pt1 = con.prepareStatement(requete1);
		                résultats = pt1.executeQuery();
		                while (résultats.next() ) {
		                    int idUtilisateur = résultats.getInt(1);
		                    message=idUtilisateur;
		                    }
		                id=message;
		                
		                String requete = "INSERT INTO ANNONCES VALUES(?,?,?,'test@epsi.fr',NULL,NULL,?,0,NULL,NULL,NULL)";
				        try { 
				        	PreparedStatement pt = con.prepareStatement(requete);
				        	pt.setInt(1, id+1);
				        	pt.setString(2, title);
				        	pt.setString(3, description);
				        	pt.setDouble(4, prix);
				        	pt.executeUpdate();
				        	
				            logger.error("REUSSITE de la requete");
				            
				            //this.getServletContext().getRequestDispatcher( "/AnnoncesServlet" ).forward( request, response );
				            
				        } catch (SQLException e) {
				       	 logger.error("ECHEC de la requete" + e.getMessage());
				        } 
				 } catch (SQLException e) {
			       	 logger.error("ECHEC de la requete1" + e.getMessage());
			        } 
		        
			}catch (ClassNotFoundException | SQLException e){
	    		logger.error("Connexion impossible" + e.getMessage());
	    	}
	}

}
