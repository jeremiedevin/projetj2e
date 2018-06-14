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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VoirAnnonce
 */
@WebServlet("/VoirAnnonce")
public class VoirAnnonce extends HttpServlet {
	private static final Logger logger = LogManager.getLogger(StartupListener.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoirAnnonce() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		

		int id = Integer.parseInt(request.getParameter("id"));
		logger.error(id);
				
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003","SA","");
	    	//con.close();
			ResultSet resultats = null;
	        String requete = "SELECT * FROM ANNONCES WHERE ID=?";
	        try {         
	        	PreparedStatement pt = con.prepareStatement(requete);
	        	pt.setInt(1, id);
	        	resultats = pt.executeQuery();


	        	 if(resultats.next() ) {
	 	            String idAnnonce = resultats.getString( "id" );
	 	            String titleAnnonce = resultats.getString( "title" );
	 	            String descriptionAnnonce = resultats.getString("content");
	 	            Double prix = resultats.getDouble("prix");
	 	            String userID = resultats.getString("user_id");
	 	            Annonce annonce = new Annonce(idAnnonce,titleAnnonce,descriptionAnnonce,prix,userID);
	 	            request.setAttribute("titreAnnonce",titleAnnonce);
	 	            request.setAttribute("annonce",annonce);
	        	 }
	        	
	            logger.error("REUSSITE de la requete");
	            
	        } catch (SQLException e) {
	       	 logger.error("ECHEC de la requete");
	        } 
		}catch (ClassNotFoundException | SQLException e){
    		logger.error("Connexion impossible" + e.getMessage());
    	};
		
		this.getServletContext().getRequestDispatcher( "/voirAnnonce.jsp" ).forward( request, response );
		
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request,response);
	}
	

}
