package metier;

import java.util.Date;

public class Equipe {
    private int equipeId;
    private String nom;
    private Date dateCreation;
    private String pays;
    private int entraineurId;
    private String image_url; // New attribute for the image URL

    public Equipe(int equipeId, String nom, Date dateCreation, String pays, int entraineurId, String image_url) {
        this.equipeId = equipeId;
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.pays = pays;
        this.entraineurId = entraineurId;
        this.image_url = image_url;
    }

    public int getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(int equipeId) {
        this.equipeId = equipeId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public int getEntraineurId() {
        return entraineurId;
    }

    public void setEntraineurId(int entraineurId) {
        this.entraineurId = entraineurId;
    }

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	@Override
	public String toString() {
		return "Equipe [equipeId=" + equipeId + ", nom=" + nom + ", dateCreation=" + dateCreation + ", pays=" + pays
				+ ", entraineurId=" + entraineurId + ", image_url=" + image_url + "]";
	}



 
}
