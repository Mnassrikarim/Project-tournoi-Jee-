package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class EquipeMetierImpl implements EquipeMetierInterface {
	@Override
	public void ajouterEquipe(Equipe equipe) {
	    // récupérer une connexion à la BD
	    Connection conn = DBConnexion.getConnection();
	    try {
	        // préparer la requête SQL
	        PreparedStatement ps = conn.prepareStatement("INSERT INTO equipe VALUES (0,?,?,?,?,?)");
	        // passer les paramètres
	        ps.setString(1, equipe.getNom());
	        ps.setDate(2, new java.sql.Date(equipe.getDateCreation().getTime()));
	        ps.setString(3, equipe.getPays());
	        ps.setInt(4, equipe.getEntraineurId());
	        ps.setString(5, equipe.getImage_url()); 
	        // exécuter la requête
	        ps.executeUpdate();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
    

    @Override
    public void modifierEquipe(Equipe equipe) {
        // récupérer une connexion à la BD
        Connection conn = DBConnexion.getConnection();
        try {
            // préparer la requête SQL
            PreparedStatement ps = conn.prepareStatement("UPDATE equipe SET nom=?, date_creation=?, pays=?, entraineur_id=?, image_url=? WHERE equipe_id=?");
            // passer les paramètres
            ps.setString(1, equipe.getNom());
            ps.setDate(2, new java.sql.Date(equipe.getDateCreation().getTime()));
            ps.setString(3, equipe.getPays());
            ps.setInt(4, equipe.getEntraineurId());
            ps.setString(5, equipe.getImage_url());
            ps.setInt(6, equipe.getEquipeId());
            // exécuter la requête
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerEquipe(int equipeId) {
        // récupérer une connexion à la BD
        Connection conn = DBConnexion.getConnection();
        try {
            // préparer la requête SQL
            PreparedStatement ps = conn.prepareStatement("DELETE FROM equipe WHERE equipe_id=?");
            // passer les paramètres
            ps.setInt(1, equipeId);
            // exécuter la requête
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Equipe obtenirEquipe(int equipeId) {
        // récupérer une connexion à la BD
        Connection conn = DBConnexion.getConnection();
        Equipe equipe = null;
        try {
            // préparer la requête SQL
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM equipe WHERE equipe_id=?");
            // passer les paramètres
            ps.setInt(1, equipeId);
            // exécuter la requête
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Construire un objet Equipe
                equipe = new Equipe(
                        rs.getInt("equipe_id"),
                        rs.getString("nom"),
                        rs.getDate("date_creation"),
                        rs.getString("pays"),
                        rs.getInt("entraineur_id"),
                        rs.getString("image_url")
                );
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipe;
    }

    @Override
    public List<Equipe> obtenirToutesLesEquipes() {
        // Définir une liste vide pour stocker les objets Equipe
        List<Equipe> equipes = new ArrayList<>();
        // récupérer une connexion à la BD
        Connection conn = DBConnexion.getConnection();
        try {
            // préparer la requête SQL
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM equipe");
            // Récupérer le résultat de la requête
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Construire un objet Equipe puis lui affecter les attributs
                Equipe equipe = new Equipe(
                        rs.getInt("equipe_id"),
                        rs.getString("nom"),
                        rs.getDate("date_creation"),
                        rs.getString("pays"),
                        rs.getInt("entraineur_id"),
                        rs.getString("image_url") 
                );
                // Ajouter l'objet Equipe dans la liste
                equipes.add(equipe);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Retourner la liste
        return equipes;
    }
}
