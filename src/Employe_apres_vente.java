
import java.util.Date;

public class Employe_apres_vente {
    //Attributs 
    private final String nom;
    private final String prenom;
    private final double CIN;
    private final Date date_naissance;
    private final Date date_recrut;
    private final String email;
    private final float score;
    private final int taux_extraH;
    private final float note_intég;  
    //Constructeur 

    public Employe_apres_vente(String nom, String prenom, double CIN, Date date_naissance, Date date_recrut, String email, float score, int taux_extraH, float note_intég) {
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.date_naissance = date_naissance;
        this.date_recrut = date_recrut;
        this.email = email;
        this.score = score;
        this.taux_extraH = taux_extraH;
        this.note_intég = note_intég;
    }
    
    
}
