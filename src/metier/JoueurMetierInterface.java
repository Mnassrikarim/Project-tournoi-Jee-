package metier;

import java.util.List;

public interface JoueurMetierInterface {
    void ajouterJoueur(Joueur joueur);
    void modifierJoueur(Joueur joueur);
    void supprimerJoueur(int joueurId);
    Joueur obtenirJoueur(int joueurId);
    List<Joueur> obtenirTousLesJoueurs();
    List<Joueur> retrieveJoueursForEquipe(int equipeId);
}
