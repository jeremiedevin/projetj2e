package fr.epsi.myEpsi.beans;

public class Utilisateur {
	
	private String id;
	private String nom;
	private String password;
	private String telephone;
	private boolean administrateur;
	
	public Utilisateur(String idUtilisateur, String nomUtilisateur, String phoneUtilisateur, String pwdUtilisateur) {
		this.setId(idUtilisateur);
		this.setNom(nomUtilisateur);
		this.setPassword(pwdUtilisateur);
		this.setTelephone(phoneUtilisateur);
		this.setAdministrateur(false);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public boolean isAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	
}
