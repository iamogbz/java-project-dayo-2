package org.ogunsola.sheridan.java2;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionsDAO {

  private static final String QUESTION_FILE_DELIMITER = ",";

  public List<Question> load(final URL fileURL) throws IOException {
    final List<Question> questions = new ArrayList<>();
    final Scanner scanner = new Scanner(fileURL.openStream());
    while (scanner.hasNext()) {
      final String questionLine = scanner.nextLine();
      String[] question = questionLine.split(QUESTION_FILE_DELIMITER);
      questions.add(new Question(question[0], question[1]));
    }
    scanner.close();
    return questions;
  }

  public static class Question {

    public final String questionText;
    public final String answerText;

    public Question(final String questionText, final String answerText) {
      this.questionText = questionText;
      this.answerText = answerText;
    }

    @Override
    public String toString() {
      return this.questionText;
    }
  }
}
