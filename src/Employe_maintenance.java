
import java.util.Date;

public class Employe_maintenance extends Employe_apres_vente{
    //Attributs
private final String specialite_technique;
    public Employe_maintenance(String nom, String prenom, double CIN, Date date_naissance, Date date_recrut, String email, float score, int taux_extraH, float note_intég,String specialite_technique) {
        super(nom, prenom, CIN, date_naissance, date_recrut, email, score, taux_extraH, note_intég);
        this.specialite_technique=specialite_technique;
    }
    
}
