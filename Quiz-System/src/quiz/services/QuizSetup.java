package quiz.services;
import quiz.interfaces.Quiz;
import quiz.models.Question;
import java.util.Scanner;

public class QuizSetup implements Quiz{
  private Question[] questions;
  private String[] userAnswers;
  private int score;

  public QuizSetup(Question[] questions) {
    this.questions = questions;
    this.userAnswers = new String[questions.length];
  }

  @Override
  public void startQuiz() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to the Console Quiz...");
    for (int i = 0; i < questions.length; i++) {
      System.out.println("\nQ" +(i+1)+ ". " +questions[i].getQuestion());
      System.out.println();
      String[] options = questions[i].getOptions();
      for (int j = 0; j < options.length; j++) {
        System.out.println((j+1)+ ". " +options[j]);
      }
      System.out.println();
      System.out.print("Enter your answer (1-" +options.length+ "): ");
      String ans = sc.nextLine();
      int answer;
      try {
      answer = Integer.parseInt(ans);
      if (answer < 1 || answer > options.length) {
        System.out.println("\nInvalid option! Answer recorded as blank.");
        userAnswers[i] = "";
      } else {
        userAnswers[i] = options[answer - 1];
      }
      } catch (NumberFormatException e) {
          System.out.println("\nInvalid input! Answer is recorded as blank.");
           userAnswers[i] = ""; 
      }
    }
  }

  @Override
  public void showResults() {
    score = 0;
    for(int i = 0; i < questions.length; i++) {
      if (questions[i].getCorrectAnswer().equalsIgnoreCase(userAnswers[i])) {
        score++;   
      }
    }
    System.out.println("\nQuiz Completed...");
    System.out.println("Your score: " +score+ " out of " +questions.length);
  }
}
