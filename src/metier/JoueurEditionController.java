package metier;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Equipe;
import metier.EquipeMetierImpl;

@WebServlet("/JoueurEditionController")
public class JoueurEditionController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private JoueurMetierImpl joueurMetier;
    private EquipeMetierImpl equipeMetier;

    public void init() {
        joueurMetier = new JoueurMetierImpl();
        equipeMetier = new EquipeMetierImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int joueurId = Integer.parseInt(request.getParameter("joueurId"));
        String mode = request.getParameter("mode");

        if (mode.equals("Suppression")) {
            // Delete the joueur from the database
            joueurMetier.supprimerJoueur(joueurId);

            // Redirect to the joueurList servlet to display the updated list
            response.sendRedirect("joueurList");
        } else {
            // Get the existing joueur from the database using the joueurId
            Joueur existingJoueur = joueurMetier.obtenirJoueur(joueurId);

            if (existingJoueur != null) {
                request.setAttribute("joueur", existingJoueur);
                request.getRequestDispatcher("joueurEdition.jsp").forward(request, response);
            } else {
                // Handle the case where the existingJoueur is null
                // Add your custom error handling code here
            }

            // Get the list of all equipes
            List<Equipe> equipes = equipeMetier.obtenirToutesLesEquipes();

            // Set the list of equipes as a request attribute
            request.setAttribute("listOfEquipes", equipes);

            // Forward the request to joueurEdition.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("/joueurEdition.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int joueurId = Integer.parseInt(request.getParameter("joueurId"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String dateNaissanceString = request.getParameter("dateNaissance");
        String pays = request.getParameter("pays");
        double salaire = Double.parseDouble(request.getParameter("salaire"));
        String imageUrl = request.getParameter("image_url");
        int equipeId = Integer.parseInt(request.getParameter("equipeId"));

        // Parse the date string to a java.util.Date object
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNaissance;
        try {
            dateNaissance = dateFormat.parse(dateNaissanceString);
        } catch (ParseException e) {
            throw new ServletException("Invalid date format. Please use yyyy-MM-dd.", e);
        }

        if (joueurId == 0) {
            // New joueur is being added
            Joueur joueur = new Joueur(joueurId, nom, prenom, dateNaissance, pays, salaire, imageUrl, equipeId);
            joueur.setNom(nom);
            joueur.setPrenom(prenom);
            joueur.setDateNaissance(dateNaissance);
            joueur.setPays(pays);
            joueur.setSalaire(salaire);
            joueur.setImage_url(imageUrl);
            joueur.setEquipeId(equipeId);

            // Add the joueur to the database
            joueurMetier.ajouterJoueur(joueur);

            // Forward the request to joueurEdition.jsp
            response.sendRedirect("joueurList");
        } else {
            // Existing joueur is being updated
            Joueur existingJoueur = joueurMetier.obtenirJoueur(joueurId);

            if (existingJoueur != null) {
                // Update the properties of the existing joueur with the new values
                existingJoueur.setNom(nom);
                existingJoueur.setPrenom(prenom);
                existingJoueur.setDateNaissance(dateNaissance);
                existingJoueur.setPays(pays);
                existingJoueur.setSalaire(salaire);
                existingJoueur.setImage_url(imageUrl);
                existingJoueur.setEquipeId(equipeId);

                // Call the modifierJoueur method to update the joueur in the database
                joueurMetier.modifierJoueur(existingJoueur);
            } else {
                // Handle the case where the existingJoueur is null
                // Add your custom error handling code here
            }
            // Forward the request to joueurEdition.jsp
            response.sendRedirect("joueurList");
        }
    }
}
