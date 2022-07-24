package org.ogunsola.sheridan.java2;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import org.ogunsola.sheridan.java2.QuestionsDAO.Question;

public class MainController {

  private static String QUESTIONS_CSV = "questions";

  private final ObservableList<Question> questions;
  private final QuestionsDAO questionsDAO;

  @FXML
  private QuestionListView questionListView;

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

    try {
      this.reloadQuestions();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  @FXML
  private void reloadQuestions() throws IOException {
    final URL questionsFileURL = StaticResource.CSV.url(QUESTIONS_CSV);
    this.questions.setAll(this.questionsDAO.load(questionsFileURL));
    this.questionListView.selectQuestion(0);
  }

  @FXML
  private void shuffleQuestions() throws IOException {
    Collections.shuffle(this.questions);
  }

  @FXML
  private void nextQuestion() {
    this.questionListView.selectNextQuestion();
  }
}
