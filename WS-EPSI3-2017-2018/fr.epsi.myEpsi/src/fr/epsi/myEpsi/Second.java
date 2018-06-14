package fr.epsi.myEpsi.jmx;

import fr.epsi.myEpsi.dao.IAnnonceDao;

public class Second implements SecondMBean {

	@Override
	public int getIAnnoncesNb() {
		return OfferDao.getNbIAnnonce();
	}

	public Second() {

	}

}
