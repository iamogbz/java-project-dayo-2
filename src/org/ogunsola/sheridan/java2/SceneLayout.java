package org.ogunsola.sheridan.java2;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public enum SceneLayout {
  MAIN("main");

  public final String name;

  SceneLayout(final String name) {
    this.name = name;
  }

  public Parent loadFXML() throws IOException {
    return new FXMLLoader(StaticResource.FXML.url(this.name)).load();
  }
}
