package fr.epsi.myEpsi.jmx;

import fr.epsi.myEpsi.beans.logLevel;

public class Premier implements PremierMBean {
	private static String level;

	public String getLevel() {
		return level;
	}

	public void setLevel() {
		level = logLevel.getLevel();
	}

	@Override
	public void DEBUG() {
		logLevel.setLevel(logLevel.DEBUG);
		setLevel();
		System.out.println("Niveau du log :" + level);
	}

	@Override
	public void INFO() {
		logLevel.setLevel(logLevel.INFO);
		setLevel();
		System.out.println("Niveau du log :" + level);
	}

	@Override
	public void ERROR() {
		logLevel.setLevel(logLevel.ERROR);
		setLevel();
		System.out.println("Niveau du log :" + level);
	}

	public Premier() {
		level = logLevel.getLevel();
	}

}
