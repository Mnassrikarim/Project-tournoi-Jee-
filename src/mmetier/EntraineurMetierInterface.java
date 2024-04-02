package mmetier;
import java.util.List;

public interface EntraineurMetierInterface {
    void ajouterEntraineur(Entraineur entraineur);
    void modifierEntraineur(Entraineur entraineur);
    void supprimerEntraineur(int entraineurId);
    Entraineur obtenirEntraineur(int entraineurId);
    List<Entraineur> obtenirTousLesEntraineurs();
}
