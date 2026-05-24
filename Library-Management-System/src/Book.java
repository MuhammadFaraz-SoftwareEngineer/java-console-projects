import java.util.Scanner;

public class Book {
  int sNo;
  String bookName;
  String authorName;
  int totalBookQty;
  int availableBookQty;
  
  Scanner input = new Scanner(System.in);

  public Book(){
    System.out.print("\nEnter Serial No of Book: ");
    this.sNo = input.nextInt();
    input.nextLine();
    System.out.print("Enter Book Name: ");
    this.bookName = input.nextLine();
    System.out.print("Enter Author Name: ");
    this.authorName = input.nextLine();
    System.out.print("Enter Quantity of Books: ");
    this.totalBookQty = input.nextInt();
    this.availableBookQty = this.totalBookQty;
    System.out.println();
  }
}

