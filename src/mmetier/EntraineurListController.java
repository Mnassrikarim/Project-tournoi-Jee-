package mmetier;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Equipe;
import metier.EquipeMetierImpl;

@WebServlet("/entraineurList")
public class EntraineurListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EntraineurMetierImpl entraineurMetier;
    private EquipeMetierImpl equipeMetier;
    public void init() {
        entraineurMetier = new EntraineurMetierImpl();
        equipeMetier = new EquipeMetierImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtenir la liste de tous les entraîneurs
        List<Entraineur> entraineurs = entraineurMetier.obtenirTousLesEntraineurs();
        // Obtenir la liste de toutes les équipes
        List<Equipe> equipes = equipeMetier.obtenirToutesLesEquipes();
        // Définir les entraîneurs comme attribut de la requête
        request.setAttribute("listOfEntraineurs", entraineurs);
     // Définir les équipes comme attribut de la requête
        request.setAttribute("listOfEquipes", equipes);
        // Rediriger vers la vue de liste des entraîneurs
        request.getRequestDispatcher("entraineurList.jsp").forward(request, response);
    }
}
