
import java.io.IOException;

import org.ogunsola.sheridan.java2.SceneLayout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static SceneLayout DEFAULT_SCENE_LAYOUT = SceneLayout.MAIN;
    private static Scene scene;

    public static void main(final String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final Scene scene = new Scene(DEFAULT_SCENE_LAYOUT.loadFXML());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static void setLayout(SceneLayout layout) throws IOException {
        scene.setRoot(layout.loadFXML());
    }
}
