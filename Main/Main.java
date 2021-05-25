package Main;

import javafx.application.Application;
import javafx.stage.Stage;
import View.StartView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        StartView sv = new StartView();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
