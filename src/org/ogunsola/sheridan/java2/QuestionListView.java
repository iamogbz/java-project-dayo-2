package org.ogunsola.sheridan.java2;

import javafx.scene.control.ListView;
import org.ogunsola.sheridan.java2.QuestionsDAO.Question;

public class QuestionListView extends ListView<Question> {

  public int getSelectedQuestionIndex() {
    return this.getSelectionModel().getSelectedIndex();
  }

  public void selectQuestion(final int selectedQuestionIndex) {
    this.getSelectionModel().select(selectedQuestionIndex);
    this.scrollTo(selectedQuestionIndex);
  }

  public void selectNextQuestion() {
    final int nextQuestionIndex =
      (this.getSelectedQuestionIndex() + 1) % this.getItems().size();
    this.selectQuestion(nextQuestionIndex);
  }
}
