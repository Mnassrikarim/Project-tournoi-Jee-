package mmetier;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.DBConnexion;

public class EntraineurMetierImpl implements EntraineurMetierInterface {
    @Override
    public void ajouterEntraineur(Entraineur entraineur) {
        // récupérer une connexion à la BD
        Connection conn = DBConnexion.getConnection();
        try {
            // préparer la requête SQL
            PreparedStatement ps = conn.prepareStatement("INSERT INTO entraineur VALUES (0,?,?,?,?,?,?)");
            // passer les paramètres
            ps.setString(1, entraineur.getNom());
            ps.setString(2, entraineur.getPrenom());
            ps.setDate(3, new java.sql.Date(entraineur.getDateNaissance().getTime()));
            ps.setString(4, entraineur.getPays());
            ps.setDouble(5, entraineur.getSalaire());
            ps.setInt(6, entraineur.getEquipeId());
            // exécuter la requête
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifierEntraineur(Entraineur entraineur) {
        // récupérer une connexion à la BD
        Connection conn = DBConnexion.getConnection();
        try {
            // préparer la requête SQL
            PreparedStatement ps = conn.prepareStatement("UPDATE entraineur SET nom=?, prenom=?, date_naissance=?, pays=?, salaire=?, equipe_id=? WHERE entraineur_id=?");
            // passer les paramètres
            ps.setString(1, entraineur.getNom());
            ps.setString(2, entraineur.getPrenom());
            ps.setDate(3, new java.sql.Date(entraineur.getDateNaissance().getTime()));
            ps.setString(4, entraineur.getPays());
            ps.setDouble(5, entraineur.getSalaire());
            ps.setInt(6, entraineur.getEquipeId());
            ps.setInt(7, entraineur.getEntraineurId());
            // exécuter la requête
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerEntraineur(int entraineurId) {
        // récupérer une connexion à la BD
        Connection conn = DBConnexion.getConnection();
        try {
            // préparer la requête SQL
            PreparedStatement ps = conn.prepareStatement("DELETE FROM entraineur WHERE entraineur_id=?");
            // passer les paramètres
            ps.setInt(1, entraineurId);
            // exécuter la requête
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Entraineur obtenirEntraineur(int entraineurId) {
        // récupérer une connexion à la BD
        Connection conn = DBConnexion.getConnection();
        Entraineur entraineur = null;
        try {
            // préparer la requête SQL
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM entraineur WHERE entraineur_id=?");
            // passer les paramètres
            ps.setInt(1, entraineurId);
            // exécuter la requête
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Construire un objet Entraineur
                entraineur = new Entraineur(
                        rs.getInt("entraineur_id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getDate("date_naissance"),
                        rs.getString("pays"),
                        rs.getDouble("salaire"),
                        rs.getInt("equipe_id")
                );
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entraineur;
    }

    @Override
    public List<Entraineur> obtenirTousLesEntraineurs() {
        // Définir une liste vide pour stocker les objets Entraineur
        List<Entraineur> entraineurs = new ArrayList<>();
        // récupérer une connexion à la BD
        Connection conn = DBConnexion.getConnection();
        try {
            // préparer la requête SQL
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM entraineur");
            // Récupérer le résultat de la requête
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Construire un objet Entraineur puis lui affecter les attributs
                Entraineur entraineur = new Entraineur(
                        rs.getInt("entraineur_id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getDate("date_naissance"),
                        rs.getString("pays"),
                        rs.getDouble("salaire"),
                        rs.getInt("equipe_id")
                );
                // Ajouter l'objet Entraineur dans la liste
                entraineurs.add(entraineur);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Retourner la liste
        return entraineurs;
    }
}
