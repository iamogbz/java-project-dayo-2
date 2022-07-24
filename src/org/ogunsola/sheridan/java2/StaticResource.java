package org.ogunsola.sheridan.java2;

import java.net.URL;

public enum StaticResource {
  CSV("csv"),
  FXML("fxml");

  private final String type;

  StaticResource(final String type) {
    this.type = type;
  }

  public URL url(final String name) {
    return getClass()
      .getResource(String.format("resources/%s.%s", name, this.type));
  }
}
