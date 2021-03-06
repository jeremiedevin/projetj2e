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
import java.util.*;
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
 * Servlet implementation class AnnoncesServlet
 */
@WebServlet("/AnnoncesServlet")
public class AnnoncesServlet  extends HttpServlet {

	private static final Logger logger = LogManager.getLogger(StartupListener.class);
	private static final long serialVersionUID = 1L;
	ArrayList<Annonce> annonces = new ArrayList<Annonce>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnoncesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003","SA","");
	    	//con.close();
			ResultSet resultats = null;
	        String requete = "SELECT * FROM ANNONCES WHERE STATUS=0 ORDER BY CREATION_DATE";
	        try {            	
        		annonces.clear();
	        	PreparedStatement pt = con.prepareStatement(requete);
	        	resultats = pt.executeQuery();
	        	 while (resultats.next() ) {
	 	            String idAnnonce = resultats.getString( "id" );
	 	            String titleAnnonce = resultats.getString( "title" );
	 	            String descriptionAnnonce = resultats.getString("content");
	 	            Double prix = resultats.getDouble("prix");
	 	            String userID = resultats.getString("user_id");
	 	            annonces.add(new Annonce(idAnnonce,titleAnnonce,descriptionAnnonce,prix,userID));
	        	 }
	        	
	            logger.error("REUSSITE de la requete");
	            
	        } catch (SQLException e) {
	       	 logger.error("ECHEC de la requete");
	        } 
		}catch (ClassNotFoundException | SQLException e){
    		logger.error("Connexion impossible" + e.getMessage());
    	}
		
		request.setAttribute("annonces",annonces);
		this.getServletContext().getRequestDispatcher("/ListeAnnonces.jsp").forward( request, response );
	}
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request,response);
         
		
	}

}
