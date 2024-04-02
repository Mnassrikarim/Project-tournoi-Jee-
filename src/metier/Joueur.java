package metier;

import java.util.Date;

public class Joueur {
    private int joueurId;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String pays;
    private double salaire;
    private String image_url; // New attribute for the image URL
    private int equipeId;

    // Constructor with parameters
    public Joueur(int joueurId, String nom, String prenom, Date dateNaissance, String pays, double salaire, String image_url, int equipeId) {
        this.joueurId = joueurId;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.pays = pays;
        this.salaire = salaire;
        this.image_url = image_url;
        this.equipeId = equipeId;
    }
 // Constructor with parameters
    public Joueur(int joueurId, String nom, String prenom, String image_url) {
        this.joueurId = joueurId;
        this.nom = nom;
        this.prenom = prenom;
        this.image_url = image_url;
    }
    
	public int getJoueurId() {
		return joueurId;
	}

	public void setJoueurId(int joueurId) {
		this.joueurId = joueurId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public int getEquipeId() {
		return equipeId;
	}

	public void setEquipeId(int equipeId) {
		this.equipeId = equipeId;
	}

	@Override
	public String toString() {
		return "Joueur [joueurId=" + joueurId + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", pays=" + pays + ", salaire=" + salaire + ", image_url=" + image_url + ", equipeId="
				+ equipeId + "]";
	}
    

}