package quiz;
import quiz.models.Question;
import quiz.services.QuizSetup;

public class Main {
  public static void main(String[] args) {
    Question[] questions = new Question[] {
      new Question("What is the size of an int data type in Java?", new String[] {"8 bit", "16 bit", "32 bit", "64 bit"}, "32 bit"),
      new Question("Which method is the entry point of a Java Program?", new String[] {"start()", "main()", "run()", "init()"}, "main()"),
      new Question("Which of these is not a vaild access modifier in Java?", new String[] {"public", "private", "protected", "package"}, "package"),
      new Question("Which keyword is used to create a class in Java?", new String[] {"define", "class", "struct", "object"}, "class"),
      new Question("Which symbol is used to end a statement in Java?", new String[] {":", ".", ";", ","}, ";"),
    };
    QuizSetup quiz = new QuizSetup(questions);
    quiz.startQuiz();
    quiz.showResults();
  }
}
