package fr.epsi.myEpsi.listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class StartupListener
 *
 */
@WebListener
public class StartupListener implements ServletContextListener {

	private static final Logger logger = LogManager.getLogger(StartupListener.class);
	
    /**
     * Default constructor. 
     */
    public StartupListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	logger.error("Démarrage de l'application");
    	try {
    		Class.forName("org.hsqldb.jdbc.JDBCDriver");
    		Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003","SA","");
    		con.close();
    	} catch(ClassNotFoundException | SQLException e){
    		logger.error("Connexion Impossible" + e.getMessage());
    	}
    }
	
}
