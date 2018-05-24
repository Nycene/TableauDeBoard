
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Test extends javax.swing.JFrame {

    /**
     * Creates new form Test
     */
    public Test() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
                Fenetre fenetre=new Fenetre();
                fenetre.setSize(500,400);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public static class Connecter{
    public  Connection connexion=null;
    public Connection Connecter() throws SQLException{
   
   String hostdb = "localhost:3306";  			// MySQl host
   String userdb = "root";  			        // MySQL username
   String passdb = "1234";  			        // MySQL password
   String namedb = "tableaudebord";  	// MySQL database name

    // Establish a connection to the database
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e){
        System.err.println("Echec1");
    }
    try{
        connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/tableaudebord","root","1234");
    } catch(SQLException e){
        System.err.println("Echec2");
    }
     return connexion;
    }}
   
    public static class Fenetre extends JFrame implements ActionListener {
        public static Connecter C=new Connecter();
        
        public Fenetre() {
        this.setVisible(true);
        this.setTitle("Gestion des employes");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JFXPanel Jfx=new JFXPanel();
        Jfx.setBackground(Color.yellow);
        Jfx.setVisible(true);
        Jfx.setLayout(null);
        this.setContentPane(Jfx);
        JButton b1 = new JButton();
        JButton b2 = new JButton();
        JButton b3 = new JButton();
        Jfx.add(b1);
        Jfx.add(b2);
        Jfx.add(b3);
        b1.setVisible(true);
        b2.setVisible(true);
        b3.setVisible(true);
        b1.setText("Score des employés");
        b2.setText("Rendement des employés");
        b3.setText("Statistiques");
        b1.setBounds(150, 100, 190, 20);
        b2.setBounds(150, 140, 190, 20);
        b3.setBounds(150, 180, 190, 20);
        b1.addActionListener(this);
   }
        @Override
        public void actionPerformed(ActionEvent ae) {
             try {
                Stage stage = null;
                Connection con=C.Connecter();
                Statement state = con.createStatement();
                ResultSet rs =state.executeQuery("SELECT * FROM `employe_apres_vente`");
                ResultSetMetaData result= rs.getMetaData();     
                
                //CHART!!!!!!!!!!!!!!!!!!
                //DEFINE THE AXES
                final NumberAxis xAxis = new NumberAxis();
                final NumberAxis yAxis = new NumberAxis();
                xAxis.setLabel("Numero des employés");
                yAxis.setLabel("Score des employés");
                //CREATE THE CHART
                final LineChart<Number, Number> LN = new LineChart<>(xAxis, yAxis);
                LN.setTitle("Courbe des scores des employés");
                //DEFINE A SERIES
                XYChart.Series series = new XYChart.Series();
                series.setName("Courbe1");
                    while (rs.next()) {
                        series.getData().add(new XYChart.Data(rs.getInt(1), rs.getInt(7)));
                    }
                //CREATE A SCENE
                Scene scene = new Scene(LN, 400, 300);
                LN.getData().add(series);
                stage.setScene(scene);
                System.out.println("Hii");  
                stage.show();
               } catch (SQLException ex) {
               System.out.println("Cest lerreur");
                
            }  
        } 
    }
    

}


