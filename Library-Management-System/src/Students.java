import java.util.Scanner;

public class Students {
  Scanner input = new Scanner(System.in);
  Student theStudents[] = new Student[100];
  static int count = 0;

  public void addStudent(Student s) {
    for (int i = 0; i < count; i++) {
      if (s.regNum.equalsIgnoreCase(theStudents[i].regNum)) {
        System.out.println("Student of this Registration Number "+ s.regNum +" is Already Registered.\n");
        return;
      }
    }
    if (count < 100) {
      theStudents[count] = s;
      count++;
      System.out.println("Student Added Successfully...\n");
    } else {
      System.out.println("No space to Add More Students.\n");
    }
  }

  public void showAllStudents() {
    System.out.println();
    System.out.println("Student Name\t\tRegistration Number");
    for (int i = 0; i < count; i++) {
      System.out.println(theStudents[i].studentName +"\t"+ theStudents[i].regNum);
    }
    System.out.println();
  }

  public int isStudent() {
    System.out.print("\nEnter Registration Number: ");
    String regNum = input.nextLine();
    for (int i = 0; i < count; i++) {
      if (theStudents[i].regNum.equalsIgnoreCase(regNum)) {
        return i;
      }
    }
    System.out.println("Student is not Registered.");
    System.out.println("Get Registered First.\n");
    return -1;
  }

  public void checkOutBook(Books book) {
    int studentIndex = this.isStudent();
    if (studentIndex != -1) {
      System.out.println("Checking Out...");
      book.showAllBooks();
      Book b = book.checkOutBook();
      System.out.println("Checking Out...");
      if (b != null) {
        if (theStudents[studentIndex].booksCount < 3) {
          System.out.println("Adding Book...\n");
          theStudents[studentIndex].borrowedBooks[theStudents[studentIndex].booksCount] = b;
          theStudents[studentIndex].booksCount++;
          return;
        } else {
          System.out.println("Student can not Borrow more than 3 Books.\n");
          return;
        }
      }
      System.out.println("Book is not Available.\n");
    }
  }

  public void checkInBook(Books book) {
    int studentIndex = this.isStudent();
    if (studentIndex != -1) {
      System.out.println("Checking In...");
      System.out.println("\nS.No\tBook Name\tAuthor Name");
      Student s = theStudents[studentIndex];
      for (int i = 0; i < s.booksCount; i++) {
        System.out.println(
          s.borrowedBooks[i].sNo + "\t"
          + s.borrowedBooks[i].bookName + "\t"
          + s.borrowedBooks[i].authorName
        );
      }
      System.out.println();
      System.out.print("Enter Serial Number of Book to be Checked In: ");
      int sNo = input.nextInt();
      System.out.println("Checking In...\n");
      for (int i = 0; i < s.booksCount; i++) {
        if (sNo == s.borrowedBooks[i].sNo) {
          book.checkInBook(s.borrowedBooks[i]);
          s.borrowedBooks[i] = null;
          return;
        }
      }
      System.out.println("Book of Serial No "+ sNo +" not Found.\n");
    }
  }
}
