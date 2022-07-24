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
    int questionNumber = 1;
    while (scanner.hasNext()) {
      final String questionLine = scanner.nextLine();
      String[] question = questionLine.split(QUESTION_FILE_DELIMITER);
      questions.add(new Question(questionNumber++, question[0], question[1]));
    }
    scanner.close();
    return questions;
  }

  public static class Question {

    public final int number;
    public final String prompt;
    public final String answer;

    public Question(
      final int number,
      final String prompt,
      final String answer
    ) {
      this.number = number;
      this.prompt = prompt;
      this.answer = answer;
    }

    @Override
    public String toString() {
      return String.format(
        "%s%s. %s",
        this.number < 10 ? "0" : "",
        this.number,
        this.prompt
      );
    }
  }
}
