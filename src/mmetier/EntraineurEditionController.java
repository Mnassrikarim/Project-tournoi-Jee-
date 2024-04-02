package mmetier;

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

@WebServlet("/EntraineurEditionController")
public class EntraineurEditionController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EntraineurMetierImpl entraineurMetier;
    private EquipeMetierImpl equipeMetier;
    public void init() {
        entraineurMetier = new EntraineurMetierImpl();
        equipeMetier = new EquipeMetierImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    int entraineurId = Integer.parseInt(request.getParameter("entraineurId"));
    String mode = request.getParameter("mode");

    if (mode.equals("Suppression")) {
        // Delete the entraineur from the database
        entraineurMetier.supprimerEntraineur(entraineurId);

        // Redirect to the entraineurList servlet to display the updated list
        response.sendRedirect("entraineurList");
    } else {
        // Get the existing entraineur from the database using the entraineurId
        Entraineur existingEntraineur = entraineurMetier.obtenirEntraineur(entraineurId);

        if (existingEntraineur != null) {
            request.setAttribute("entraineur", existingEntraineur);
            request.getRequestDispatcher("entraineurEdition.jsp").forward(request, response);
        } else {
            // Handle the case where the existingEntraineur is null
            // Add your custom error handling code here
        }
        
        // Get the list of all equipes
        List<Equipe> equipes = equipeMetier.obtenirToutesLesEquipes();

        // Set the list of equipes as a request attribute
        request.setAttribute("listOfEquipes", equipes);

        // Forward the request to entraineurEdition.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/entraineurEdition.jsp");
        dispatcher.forward(request, response);
    }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int entraineurId = Integer.parseInt(request.getParameter("entraineurId"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String dateNaissanceString = request.getParameter("dateNaissance");
        String pays = request.getParameter("pays");
        double salaire = Double.parseDouble(request.getParameter("salaire"));
        int equipeId = Integer.parseInt(request.getParameter("equipeId"));

        // Parse the date string to a java.util.Date object
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNaissance;
        try {
            dateNaissance = dateFormat.parse(dateNaissanceString);
        } catch (ParseException e) {
            throw new ServletException("Invalid date format. Please use yyyy-MM-dd.", e);
        }

        if (entraineurId == 0) {
            // New entraineur is being added
            Entraineur entraineur = new Entraineur(entraineurId, nom, prenom, dateNaissance, pays, salaire, equipeId);
            entraineur.setNom(nom);
            entraineur.setPrenom(prenom);
            entraineur.setDateNaissance(dateNaissance);
            entraineur.setPays(pays);
            entraineur.setSalaire(salaire);
            entraineur.setEquipeId(equipeId);

            // Add the entraineur to the database
            entraineurMetier.ajouterEntraineur(entraineur);
            // Forward the request to entraineurEdition.jsp
            response.sendRedirect("entraineurList");
        } else {
            // Existing entraineur is being updated
            Entraineur existingEntraineur = entraineurMetier.obtenirEntraineur(entraineurId);

            if (existingEntraineur != null) {
                // Update the properties of the existing entraineur with the new values
                existingEntraineur.setNom(nom);
                existingEntraineur.setPrenom(prenom);
                existingEntraineur.setDateNaissance(dateNaissance);
                existingEntraineur.setPays(pays);
                existingEntraineur.setSalaire(salaire);
                existingEntraineur.setEquipeId(equipeId);

                // Call the modifierEntraineur method to update the entraineur in the database
                entraineurMetier.modifierEntraineur(existingEntraineur);
            } else {
                // Handle the case where the existingEntraineur is null
                // Add your custom error handling code here
            }
            // Forward the request to entraineurEdition.jsp
            response.sendRedirect("entraineurList");
        }
    }
}
