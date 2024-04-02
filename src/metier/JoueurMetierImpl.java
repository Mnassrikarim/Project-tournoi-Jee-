package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JoueurMetierImpl implements JoueurMetierInterface {
    @Override
    public void ajouterJoueur(Joueur joueur) {
        // Get a connection to the database
        Connection conn = DBConnexion.getConnection();
        try {
            // Prepare the SQL statement
            PreparedStatement ps = conn.prepareStatement("INSERT INTO joueur VALUES (0,?,?,?,?,?,?,?)");
            // Set the parameters
            ps.setString(1, joueur.getNom());
            ps.setString(2, joueur.getPrenom());
            ps.setDate(3, new java.sql.Date(joueur.getDateNaissance().getTime()));
            ps.setString(4, joueur.getPays());
            ps.setDouble(5, joueur.getSalaire());
            ps.setString(6, joueur.getImage_url());
            ps.setInt(7, joueur.getEquipeId());
            // Execute the query
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifierJoueur(Joueur joueur) {
        // Get a connection to the database
        Connection conn = DBConnexion.getConnection();
        try {
            // Prepare the SQL statement
            PreparedStatement ps = conn.prepareStatement("UPDATE joueur SET nom=?, prenom=?, date_naissance=?, pays=?, salaire=?, image_url=?, equipe_id=? WHERE joueur_id=?");
            // Set the parameters
            ps.setString(1, joueur.getNom());
            ps.setString(2, joueur.getPrenom());
            ps.setDate(3, new java.sql.Date(joueur.getDateNaissance().getTime()));
            ps.setString(4, joueur.getPays());
            ps.setDouble(5, joueur.getSalaire());
            ps.setString(6, joueur.getImage_url());
            ps.setInt(7, joueur.getEquipeId());
            ps.setInt(8, joueur.getJoueurId());
            // Execute the query
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerJoueur(int joueurId) {
        // Get a connection to the database
        Connection conn = DBConnexion.getConnection();
        try {
            // Prepare the SQL statement
            PreparedStatement ps = conn.prepareStatement("DELETE FROM joueur WHERE joueur_id=?");
            // Set the parameter
            ps.setInt(1, joueurId);
            // Execute the query
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Joueur obtenirJoueur(int joueurId) {
        // Get a connection to the database
        Connection conn = DBConnexion.getConnection();
        Joueur joueur = null;
        try {
            // Prepare the SQL statement
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM joueur WHERE joueur_id=?");
            // Set the parameter
            ps.setInt(1, joueurId);
            // Execute the query
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Construct a Joueur object
                joueur = new Joueur(
                        rs.getInt("joueur_id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getDate("date_naissance"),
                        rs.getString("pays"),
                        rs.getDouble("salaire"),
                        rs.getString("image_url"),
                        rs.getInt("equipe_id")
                );
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return joueur;
    }

    @Override
    public List<Joueur> obtenirTousLesJoueurs() {
        // Create an empty list to store Joueur objects
        List<Joueur> joueurs = new ArrayList<>();
        // Get a connection to the database
        Connection conn = DBConnexion.getConnection();
        try {
            // Prepare the SQL statement
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM joueur");
            // Execute the query and get the result
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Construct a Joueur object and set its attributes
                Joueur joueur = new Joueur(
                        rs.getInt("joueur_id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getDate("date_naissance"),
                        rs.getString("pays"),
                        rs.getDouble("salaire"),
                        rs.getString("image_url"),
                        rs.getInt("equipe_id")
                );
                // Add the Joueur object to the list
                joueurs.add(joueur);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Return the list
        return joueurs;
    }
    public List<Joueur> retrieveJoueursForEquipe(int equipeId) {
        List<Joueur> joueurList = new ArrayList<>();

        try (Connection conn = DBConnexion.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM joueur WHERE equipe_id = ?")) {
            statement.setInt(1, equipeId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int joueurId = resultSet.getInt("joueur_id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom"); 
                String image_url = resultSet.getString("image_url");
                Joueur joueur = new Joueur(joueurId, nom, prenom,image_url);
                joueurList.add(joueur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }

        return joueurList;
    }
    
    
    
    
}
