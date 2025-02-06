import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class graph extends Application{

    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X Axis");
        yAxis.setLabel("Y Axis");
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Sample Line Graph");
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Data Series 1");
        series.getData().add(new XYChart.Data<>(1, 5));
        series.getData().add(new XYChart.Data<>(2, 8));
        series.getData().add(new XYChart.Data<>(3, 12));
        series.getData().add(new XYChart.Data<>(4, 18));
        series.getData().add(new XYChart.Data<>(5, 22));

        lineChart.getData().add(series);

        Scene scene = new Scene(lineChart, 800, 600);
        stage.setScene(scene);

        stage.setTitle("JavaFX Line Graph Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
