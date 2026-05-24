import java.util.Scanner;

public class Library {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("******** Welcome to the Library ********");
    System.out.println("    Select From The Following Options   ");
    System.out.println("****************************************");
    Books objBooks = new Books();
    Students objStudents = new Students();
    int choice;
    int searchChoice;
    do {
      objBooks.displayMenu();
      choice = input.nextInt();
      switch (choice) {
        case 1:
          Book b = new Book();
          objBooks.addBook(b);          
          break;
        case 2:
          objBooks.addBookQty();
          break;
        case 3:
          System.out.println("\nPress 1 to Search with Book Serial No.");
          System.out.println("Press 2 to Search with Books's Author Name.");
          searchChoice = input.nextInt();
          if (searchChoice == 1) {
            objBooks.searchBySno();
          } else if (searchChoice == 2) {
            objBooks.searchByBookName();
          } else {
            System.out.println("Invalid Choice");
          }
          break;
        case 4:
          objBooks.showAllBooks();
          break;
        case 5:
          Student s = new Student();
          objStudents.addStudent(s);
          break;
        case 6:
          objStudents.showAllStudents();
          break;
        case 7:
          objStudents.checkOutBook(objBooks);
          break;
        case 8:
          objStudents.checkInBook(objBooks);
          break;
        case 9:
          System.out.println("\nExiting...");
          break;            
        default:
          System.out.println("\nInvalid Number! Enter Between 1 to 9.\n");
      }
    }
    while (choice != 9);
  }
}
