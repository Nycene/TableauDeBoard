
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Chart extends Application {

    public Connection connexion = null;

    @Override
    public void start(Stage stage) throws SQLException {

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
        Statement state = connexion.createStatement();
        ResultSet rs = state.executeQuery("SELECT * FROM `employe_apres_vente`");
        ResultSetMetaData result = rs.getMetaData();
        


        //CHART!!!!!!!!!!!!!!!!!!
        stage.setTitle("Score des employés");
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
            series.getData().add(new XYChart.Data(rs.getFloat(1),rs.getFloat(7)));
        }
        //CREATE A SCENE
        Scene scene = new Scene(LN, 400, 300);
        LN.getData().add(series);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
