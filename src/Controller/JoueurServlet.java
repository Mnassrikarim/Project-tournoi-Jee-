package Controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.DBConnexion;
import metier.EquipeMetierImpl;
import metier.Joueur;
import metier.JoueurMetierImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/JoueurServlet")
public class JoueurServlet extends HttpServlet {
	  private static final long serialVersionUID = 1L;

	    private JoueurMetierImpl joueurMetier;
	    private EquipeMetierImpl equipeMetier;

	    public void init() {
	        joueurMetier = new JoueurMetierImpl();
	        equipeMetier = new EquipeMetierImpl();
	    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the equipeId from the request parameter
        int equipeId = Integer.parseInt(request.getParameter("equipeId"));
        // Here, you should retrieve the list of players (joueurs) for the given equipeId from your data source
        List<Joueur> joueurList = joueurMetier.retrieveJoueursForEquipe(equipeId);

        // Pass the joueurList as a request attribute
        request.setAttribute("joueurList", joueurList);

        // Forward the request to the JSP page for displaying the table of joueurs
        request.getRequestDispatcher("joueur.jsp").forward(request, response);
    }
}
