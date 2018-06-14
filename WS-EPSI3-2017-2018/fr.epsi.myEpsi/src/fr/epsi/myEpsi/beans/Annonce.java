package fr.epsi.myEpsi.beans;

import java.util.Date;

public class Annonce {
	
	private int id;
	private Utilisateur vendeur;
	private String titre;
	private String description;
	private int statut;
	private Double prix;
	private long nbVues;
	private Date creation;
	private Date modification;
	private Utilisateur acheteur;
	private Date achat;
	
	public Annonce(String id,String title, String description, Double prix, String userID) {
		this.setId(Integer.parseInt(id));
		this.setTitre(title);
		this.setDescription(description);
		this.setPrix(prix);
		this.setVendeur(getVendeur());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Utilisateur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public long getNbVues() {
		return nbVues;
	}

	public void setNbVues(long nbVues) {
		this.nbVues = nbVues;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public Date getModification() {
		return modification;
	}

	public void setModification(Date modification) {
		this.modification = modification;
	}

	public Utilisateur getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}

	public Date getAchat() {
		return achat;
	}

	public void setAchat(Date achat) {
		this.achat = achat;
	}
	
	
}
