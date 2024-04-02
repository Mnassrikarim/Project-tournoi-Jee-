package metier;

import java.util.List;

public interface EquipeMetierInterface {
    void ajouterEquipe(Equipe equipe);
    void modifierEquipe(Equipe equipe);
    void supprimerEquipe(int equipeId);
    Equipe obtenirEquipe(int equipeId);
    List<Equipe> obtenirToutesLesEquipes();
}
