
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class EvolutionChart extends Application{
    public Connection connexion = null;
    @Override
    public void start(Stage stage) throws Exception {
        String hostdb = "localhost:3306";  			// MySQl host
        String userdb = "root";  			        // MySQL username
        String passdb = "1234";  			        // MySQL password
        String namedb = "tableaudebord";  	// MySQL database name

        // Establish a connection to the database
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Echec1");
        }
        try {
           
             connexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tableaudebord", "root", "1234");
        }catch (SQLException e) {
            }
        Statement state1 = connexion.createStatement();
        ResultSet rs1 = state1.executeQuery("SELECT scoreOctobre FROM `employe_apres_vente`");
        ResultSetMetaData result1 = rs1.getMetaData();
        float somme1=0;
        while(rs1.next()){
           somme1=somme1+rs1.getFloat(1);}
        float moy1=somme1/3;
        
         Statement state2 = connexion.createStatement();
        ResultSet rs2 = state2.executeQuery("SELECT scoreNovembre FROM `employe_apres_vente`");
        ResultSetMetaData result2 = rs2.getMetaData();
        float somme2=0;
        while(rs2.next()){
           somme2=somme2+rs2.getFloat(1);}
        float moy2=somme2/3;
        
        Statement state3 = connexion.createStatement();
        ResultSet rs3 = state3.executeQuery("SELECT scoreDecembre FROM `employe_apres_vente`");
        ResultSetMetaData result3 = rs3.getMetaData();
        float somme3=0;
        while(rs3.next()){
           somme3=somme3+rs3.getFloat(1);}
        float moy3=somme3/3;
        
        Statement state4 = connexion.createStatement();
        ResultSet rs4 = state4.executeQuery("SELECT scoreJAnvier FROM `employe_apres_vente`");
        ResultSetMetaData result4 = rs4.getMetaData();
        float somme4=0;
        while(rs4.next()){
           somme4=somme4+rs4.getFloat(1);}
        float moy4=somme4/3;
        
        
        //CREATE A CHART !!!!!!!!!!!!!
         stage.setTitle("Evolution des employés");
        //DEFINE THE AXES
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Mois");
        yAxis.setLabel("Score des employés");
        final LineChart<String, Number> LN = new LineChart<String,Number>(xAxis, yAxis);
        LN.setTitle("Courbe d'evolution des employés durant les 3 mois");
        
        //DEFINE A SERIES
        XYChart.Series series = new XYChart.Series();
        series.setName("Courbe Evolutionnaire");
        series.getData().add(new XYChart.Data("Octobre",moy1));
        series.getData().add(new XYChart.Data("Novembre",moy2));
        series.getData().add(new XYChart.Data("Decembre",moy3));
        series.getData().add(new XYChart.Data("Janvier",moy4));
        
        //CREATE A SCENE
        Scene scene = new Scene(LN, 600, 500);
        LN.getData().add(series);
        stage.setScene(scene);
        stage.show();}
        
    public static void main(String[] args) {
        launch(args);
    }
    
}
