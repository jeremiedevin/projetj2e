package fr.epsi.myEpsi.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.epsi.myEpsi.beans.Annonce;
import fr.epsi.myEpsi.beans.Utilisateur;
import fr.epsi.myEpsi.beans.logLevel;
import fr.epsi.myEpsi.dao.IUserDao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface IAnnonceDao {

	boolean create(Annonce annonce);
	boolean update(Annonce annonce);
	Annonce get(int id);
	List<Annonce> get(Utilisateur utilisateur);


	private static void logInsert(int id, String titre, String description, int statut, Double prix, Date creation, String idUser) {
			if(logLevel.actuallyLogLevel == logLevel.DEBUG) {
				StringBuilder toDebug = new StringBuilder();
					toDebug.append ("Injection SQL faite (mode debug) : ");
					toDebug.append ("INSERT INTO ANNONCES (ID , TITLE , CONTENT , PRICE , USER_ID , CREATION_DATE , STATUS , NB_VIEW , UPDATE_DATE) ");
					toDebug.append ("VALUES (" + id + " , \"" + titre + "\" , \"" + description + "\" , " + prix + " , \"" + idUser+ "\" , \"" + creation + "\" , " + statut + " , 0 , \"" + creation + "\")");
		    	logger.debug(toDebug);
		    }
				if(logLevel.actuallyLogLevel == logLevel.ERROR) {
					toError.append ("Echec de l'injection SQL suivante :");
					toError.append ("INSERT INTO ANNONCES (ID , TITLE , CONTENT , PRICE , USER_ID , CREATION_DATE , STATUS , NB_VIEW , UPDATE_DATE) ");
					toError.append ("VALUES (" + id + " , \"" + titre + "\" , \"" + description + "\" , " + prix + " , \"" + idUser+ "\" , \"" + creation + "\" , " + statut + " , 0 , \"" + creation + "\")");
					logger.debug(toError);
				}
				if(logLevel.actuallyLogLevel == logLevel.INFO) {
					StringBuilder toDebug = new StringBuilder();
						toInfo.append ("Injection SQL faite : ");
						toInfo.append ("INSERT INTO ANNONCES (ID , TITLE , CONTENT , PRICE , USER_ID , CREATION_DATE , STATUS , NB_VIEW , UPDATE_DATE) ");
						toInfo.append ("VALUES (" + id + " , \"" + titre + "\" , \"" + description + "\" , " + prix + " , \"" + idUser+ "\" , \"" + creation + "\" , " + statut + " , 0 , \"" + creation + "\")");
						logger.debug(toInfo);
			    }
		}
}
