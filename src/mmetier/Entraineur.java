package mmetier;

import java.util.Date;

import metier.Equipe;

public class Entraineur {
    private int entraineurId;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String pays;
    private double salaire;
    private int equipeId;
    private Equipe equipe;

    public Entraineur(int entraineurId, String nom, String prenom, Date dateNaissance, String pays, double salaire, int equipeId) {
        this.entraineurId = entraineurId;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.pays = pays;
        this.salaire = salaire;
        this.equipeId = equipeId;
        
    }

    public int getEntraineurId() {
        return entraineurId;
    }

    public void setEntraineurId(int entraineurId) {
        this.entraineurId = entraineurId;
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

    public int getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(int equipeId) {
        this.equipeId = equipeId;
    }
    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    @Override
	public String toString() {
		return "Entraineur [entraineurId=" + entraineurId + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", pays=" + pays + ", salaire=" + salaire + ", equipeId=" + equipeId + ", equipe="
				+ equipe + "]";
	}
    
}
