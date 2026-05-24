import java.util.Scanner;

public class Books {
  Book theBooks[] = new Book[100];
  static int count = 0; 
  Scanner input = new Scanner(System.in);

  public int compareBookObjects(Book b1, Book b2) {
    if (b1.bookName.equalsIgnoreCase(b2.bookName)) {
      System.out.println("Book of this Name Already Exists.\n");
      return 0;
    }
    if (b1.sNo == b2.sNo) {
      System.out.println("Book of this Serial No Already Exists.\n");
      return 0;
    }
    return 1;
  }

  public void addBook(Book b) {
    for (int i = 0; i < count; i++) {
      if (this.compareBookObjects(b, this.theBooks[i]) == 0)
          return;
    }
    if (count < 100) {
      theBooks[count] = b;
      count++;
      System.out.println("Book Added Successfully...\n");
    } else {
      System.out.println("No space to Add More Books.\n");
    }
  }

  public void searchBySno() {
    System.out.println("\nSearch By Serial Number\n");
    System.out.print("Enter Serial No of Book: ");
    int sNo = input.nextInt();
    int flag = 0;
     System.out.println("S.No\tName\t\tAuthor\t\tAvailabe Quantity\tTotal Quantity");
    for (int i = 0; i < count; i++) {
      if (sNo == theBooks[i].sNo) {
        System.out.println(
          theBooks[i].sNo+"\t"
          + theBooks[i].bookName + "\t"
          + theBooks[i].authorName + "\t"
          + theBooks[i].availableBookQty + "\t\t\t"
          + theBooks[i].totalBookQty
        );
        System.out.println();
        flag++;
        return;
      }
    }
    if (flag == 0) {
      System.out.println("\nNo Book for Serial No " + sNo + " Found.\n");
    }
  }

  public void searchByBookName() {
    System.out.println("\nSearch By Book Name\n");
    input.nextLine();
    System.out.print("Enter Book Name: ");
    String bookName = input.nextLine();
    int flag = 0;
     System.out.println("S.No\tName\t\tAuthor\t\tAvailabe Quantity\tTotal Quantity");
    for (int i = 0; i < count; i++) {
      if (bookName.equalsIgnoreCase(theBooks[i].bookName)) {
        System.out.println(
          theBooks[i].sNo+"\t"
          + theBooks[i].bookName + "\t"
          + theBooks[i].authorName + "\t"
          + theBooks[i].availableBookQty + "\t\t\t"
          + theBooks[i].totalBookQty
        );
        System.out.println();
        flag++;
        return;
      }
    }
    if (flag == 0) {
      System.out.println("\nNo Books of " + bookName + " Found.\n");
    }
  }

  public void showAllBooks() {
    System.out.println("\n                               Showing All Books\n");
    System.out.println("==================================================================================");
    System.out.println("S.No\tName\t\tAuthor\t\tAvailabe Quantity\tTotal Quantity");
    System.out.println("==================================================================================");
    for (int i = 0; i < count; i++) {
      System.out.println(
        theBooks[i].sNo+"\t"
        + theBooks[i].bookName + "\t"
        + theBooks[i].authorName + "\t"
        + theBooks[i].availableBookQty + "\t\t\t"
        + theBooks[i].totalBookQty
      );
    }
    System.out.println("==================================================================================");
    System.out.println();
  }

  public void addBookQty() {
    System.out.println("\nAdd Quantity of a Book\n");
    System.out.print("Enter Serial No of Book: ");
    int sNo = input.nextInt();
    for (int i = 0; i < count; i++) {
      if (sNo == theBooks[i].sNo) {
        System.out.print("Enter No of Books to be Added: ");
        int addQty = input.nextInt();
        System.out.println();
        theBooks[i].totalBookQty += addQty;
        theBooks[i].availableBookQty += addQty;
        System.out.println("Book Quantity Added Successfully...\n");
        return;
      }
    }
    System.out.println("\nNo Book for Serial No " + sNo + " Found.\n");
  }

  public void displayMenu() {
    System.out.println("----------------------------------------");
    System.out.println("Press 1 to Add new Book.");
    System.out.println("Press 2 to Add Quantity of a Book.");
    System.out.println("Press 3 to Search a Book.");
    System.out.println("Press 4 to Show All Books.");
    System.out.println("Press 5 to Register Student.");
    System.out.println("Press 6 to Show All Registered Students.");
    System.out.println("Press 7 to Check Out Book.");
    System.out.println("Press 8 to Check In Book.");
    System.out.println("Press 9 to Exit Application.");
    System.out.println("----------------------------------------");
  }

  public int isAvailable(int sNo) {
    for (int i = 0; i < count; i++) {
      if (sNo == theBooks[i].sNo) {
        if (theBooks[i].availableBookQty > 0) {
          System.out.println("Book is Available.");
          return i;
        }
        System.out.println("Book is Unavailable.");
        return -1;
      }
    }
    System.out.println("No Book of Serial Number "+ sNo +" Available in Library.");
    return -1;
  }

  public Book checkOutBook() {
    System.out.println("Enter Serial No of Book to be Checked Out.");
    int sNo = input.nextInt();
    int bookIndex = isAvailable(sNo);
    if (bookIndex != -1) {
      theBooks[bookIndex].availableBookQty--;
      return theBooks[bookIndex];
    }
    return null;
  }

  public void checkInBook(Book b) {
    for (int i = 0; i < count; i++) {
      if (b.equals(theBooks[i])) {
        theBooks[i].availableBookQty++;
        return;
      }
    } 
  }
}

