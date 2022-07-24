package org.ogunsola.sheridan.java2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MainController {

    @FXML
    private void switchToSecondary() throws IOException {
        final Alert alert = new Alert(AlertType.INFORMATION);
        alert.show();
    }
}
