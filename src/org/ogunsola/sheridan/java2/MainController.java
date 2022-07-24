package org.ogunsola.sheridan.java2;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import org.ogunsola.sheridan.java2.QuestionsDAO.Question;

public class MainController {

  private static String QUESTIONS_CSV = "questions";

  private final ObservableList<Question> questions;
  private final QuestionsDAO questionsDAO;
  private boolean showAnswer = false;

  @FXML
  private QuestionListView questionListView;

  @FXML
  private Text questionText;

  @FXML
  private Text answerText;

  @FXML
  private Button answerToggle;

  public MainController() {
    this(new QuestionsDAO());
  }

  public MainController(final QuestionsDAO questionsDAO) {
    this(questionsDAO, FXCollections.observableArrayList());
  }

  public MainController(
    final QuestionsDAO questionsDAO,
    final ObservableList<Question> questionList
  ) {
    this.questionsDAO = questionsDAO;
    this.questions = questionList;
  }

  public void initialize() {
    this.questionListView.setItems(this.questions);
    this.questionListView.getSelectionModel()
      .selectedItemProperty()
      .addListener(
        new ChangeListener<Question>() {
          @Override
          public void changed(
            ObservableValue<? extends Question> observable,
            Question oldValue,
            Question newValue
          ) {
            MainController.this.updateDisplayState();
          }
        }
      );

    try {
      this.reloadQuestions();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  private Question getSelectedQuestion() {
    return this.questions.get(this.questionListView.getSelectedQuestionIndex());
  }

  private void updateDisplayState() {
    this.questionText.setText(this.getSelectedQuestion().questionText);
    this.answerText.setText(this.getSelectedQuestion().answerText);
    this.answerText.setVisible(this.showAnswer);
    this.answerToggle.setText((this.showAnswer ? "Hide" : "Show") + " Answer");
  }

  @FXML
  private void reloadQuestions() throws IOException {
    final URL questionsFileURL = StaticResource.CSV.url(QUESTIONS_CSV);
    this.questions.setAll(this.questionsDAO.load(questionsFileURL));
    this.questionListView.selectQuestion(0);
    this.updateDisplayState();
  }

  @FXML
  private void shuffleQuestions() throws IOException {
    Collections.shuffle(this.questions);
    this.updateDisplayState();
  }

  @FXML
  private void nextQuestion() {
    this.questionListView.selectNextQuestion();
    this.showAnswer = false;
    this.updateDisplayState();
  }

  @FXML
  private void toggleAnswer() {
    this.showAnswer = !this.showAnswer;
    this.updateDisplayState();
  }
}
