public class Client {
    //Attributs 
    private final int cin;
    private final String nom;
    private final String prenom;
    private int num_tel;
    //Constructeur 
    public Client(int cin, String nom, String prenom) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
    }
    //Setters
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }
            
}
