package metier;

import java.util.List;

public class TestMetier {
    public static void main(String[] args) {
        EquipeMetierInterface equipeMetier = new EquipeMetierImpl();
        
        // Test obtaining all equipes
        List<Equipe> equipes = equipeMetier.obtenirToutesLesEquipes();
        System.out.println("Liste des équipes :");
        for (Equipe equipe : equipes) {
            System.out.println(equipe.toString());
        }
    }
}
