package fr.epsi.myEpsi.beans;

public class logLevel {
	public final static int DEBUG = 0;
	public final static int INFO = 1;
	public final static int ERROR = 2;

	public static int actuallyLogLevel = DEBUG;

	public static String getLevel() {
		String levelbeans = "";
		if(actuallyLogLevel == 0) {
			lvl = "DEBUG";
		}
		if(actuallyLogLevel == 1) {
			lvl = "INFO";
		}
		if(actuallyLogLevel == 2) {
			lvl = "ERROR";
		}
		return levelbeans;
	}

	public static void setLevel(int levelbeans) {
		actuallyLogLevel = levelbeans;
	}
}
