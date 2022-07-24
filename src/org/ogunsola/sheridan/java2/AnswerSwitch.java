package org.ogunsola.sheridan.java2;

import javafx.scene.control.Button;

public class AnswerSwitch extends Button {

  public static String TEXT_ON = "Hide Answer";
  public static String TEXT_OFF = "Show Answer";

  private boolean on = false;

  public boolean isOn() {
    return on;
  }

  public void setOn(boolean on) {
    this.on = on;
    this.setText(this.on ? TEXT_ON : TEXT_OFF);
    super.fire();
  }

  public void toggle() {
    this.setOn(!this.isOn());
  }

  @Override
  public void fire() {
    this.toggle();
  }
}
