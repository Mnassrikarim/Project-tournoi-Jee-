package metier;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EquipeEditionController")
public class EquipeEditionController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EquipeMetierImpl equipeMetier;

    public void init() {
        equipeMetier = new EquipeMetierImpl();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int equipeId = Integer.parseInt(request.getParameter("equipeId"));
        String mode = request.getParameter("mode");

        if (mode.equals("Suppression")) {
            // Delete the equipe from the database
            equipeMetier.supprimerEquipe(equipeId);

            // Redirect to the equipeList servlet to display the updated list
            response.sendRedirect("equipeList");
        } else {
            // Get the existing equipe from the database using the equipeId
            Equipe existingEquipe = equipeMetier.obtenirEquipe(equipeId);

            if (existingEquipe != null) {
                request.setAttribute("equipe", existingEquipe);
                request.getRequestDispatcher("equipeEdition.jsp").forward(request, response);
            } else {
                // Handle the case where the existingEquipe is null
                // Add your custom error handling code here
            }
        }
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    int equipeId = Integer.parseInt(request.getParameter("equipeId"));
    String nom = request.getParameter("nom");
    String dateCreationString = request.getParameter("dateCreation");
    String pays = request.getParameter("pays");
    int entraineurId = Integer.parseInt(request.getParameter("entraineurId"));
    String imageUrl = request.getParameter("image_url");

    // Parse the date string to a java.util.Date object
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dateCreation;
    try {
        dateCreation = dateFormat.parse(dateCreationString);
    } catch (ParseException e) {
        throw new ServletException("Invalid date format. Please use yyyy-MM-dd.", e);
    }
    
    if (equipeId == 0) {
        // New equipe is being added
        Equipe equipe = new Equipe(equipeId, nom, dateCreation, pays, entraineurId, imageUrl);
        equipe.setNom(nom);
        equipe.setDateCreation(dateCreation);
        equipe.setPays(pays);
        equipe.setEntraineurId(entraineurId);
        equipe.setImage_url(imageUrl);
        
        // Add the equipe to the database
        equipeMetier.ajouterEquipe(equipe);
    } else {
        // Existing equipe is being updated
        Equipe existingEquipe = equipeMetier.obtenirEquipe(equipeId);
        
        if (existingEquipe != null) {
            // Update the properties of the existing equipe with the new values
            existingEquipe.setNom(nom);
            existingEquipe.setDateCreation(dateCreation);
            existingEquipe.setPays(pays);
            existingEquipe.setEntraineurId(entraineurId);
            existingEquipe.setImage_url(imageUrl);
            
            // Call the modifierEquipe method to update the equipe in the database
            equipeMetier.modifierEquipe(existingEquipe);
        } else {
            // Handle the case where the existingEquipe is null
            // Add your custom error handling code here
        }
    }

    // Redirect to the equipeList servlet to display the updated list
    response.sendRedirect("equipeList");
}
}
