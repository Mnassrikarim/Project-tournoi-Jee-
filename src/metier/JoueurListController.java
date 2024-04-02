package metier;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/joueurList")
public class JoueurListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private JoueurMetierImpl joueurMetier;
    private EquipeMetierImpl equipeMetier;

    public void init() {
        joueurMetier = new JoueurMetierImpl();
        equipeMetier = new EquipeMetierImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the list of all joueurs
        List<Joueur> joueurs = joueurMetier.obtenirTousLesJoueurs();

        // Get the list of all equipes
        List<Equipe> equipes = equipeMetier.obtenirToutesLesEquipes();

        // Set the list of joueurs as a request attribute
        request.setAttribute("listOfJoueurs", joueurs);

        // Set the list of equipes as a request attribute
        request.setAttribute("listOfEquipes", equipes);

        // Forward the request to the joueurList.jsp view
        request.getRequestDispatcher("joueurList.jsp").forward(request, response);
    }
}
