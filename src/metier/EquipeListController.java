package metier;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Equipe;
import metier.EquipeMetierImpl;
@WebServlet("/equipeList")
public class EquipeListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EquipeMetierImpl equipeMetier;

    public void init() {
        equipeMetier = new EquipeMetierImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtenir la liste de toutes les équipes
        List<Equipe> equipes = equipeMetier.obtenirToutesLesEquipes();

        // Définir les équipes comme attribut de la requête
        request.setAttribute("listOfEquipes", equipes);

        // Rediriger vers la vue de liste des équipes
        request.getRequestDispatcher("equipeList.jsp").forward(request, response);
    }
}
