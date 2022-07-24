package org.ogunsola.sheridan.java2;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public enum SceneLayout {
  MAIN("main");

  public final String name;

  SceneLayout(final String name) {
    this.name = name;
  }

  public Parent loadFXML() throws IOException {
    final String resourceName = String.format("resources/%s.fxml", this.name);
    final URL resourceURL = getClass().getResource(resourceName);
    final FXMLLoader fxmlLoader = new FXMLLoader(resourceURL);
    return fxmlLoader.load();
  }
}
