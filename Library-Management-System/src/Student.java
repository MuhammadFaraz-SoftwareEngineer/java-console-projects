import java.util.Scanner;

public class Student {
  String studentName;
  String regNum;
  Book borrowedBooks[] = new Book[3];
  int booksCount = 0;

  Scanner input = new Scanner(System.in);

  public Student() {
    System.out.print("\nEnter Student Name: ");
    this.studentName = input.nextLine();
    System.out.print("Enter Registration Number: ");
    this.regNum = input.nextLine();
    System.out.println();
  }
}
