package gui.iposca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class IPOS_CA extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(IPOS_CA.class.getResource("merchantLoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 920, 670);
        stage.setTitle("Merchant login!");
        stage.setScene(scene);
        stage.show();
    }
}
