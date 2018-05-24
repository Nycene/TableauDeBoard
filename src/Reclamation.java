
import java.util.Date;

public class Reclamation {
    //Attributs 
    private final double num__tel_client;
    private final String type;
    private final int cin_employe; 
    private final String nom_emp;
    private final String etat_prob;
    private final int note_apreciation;
    private final Date date_reclamation;

    public Reclamation(double num__tel_client, String type, int cin_employe, String nom_emp, String etat_prob, int note_apreciation, Date date_reclamation) {
        this.num__tel_client = num__tel_client;
        this.type = type;
        this.cin_employe = cin_employe;
        this.nom_emp = nom_emp;
        this.etat_prob = etat_prob;
        this.note_apreciation = note_apreciation;
        this.date_reclamation = date_reclamation;
    }

    
    
}
