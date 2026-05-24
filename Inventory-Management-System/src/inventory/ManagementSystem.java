package inventory;

import java.util.Scanner;

public class ManagementSystem {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Inventory inventory = new Inventory();
    boolean exit = false;
    while (!exit) {
      System.out.println("\nInventory Management System");
      System.out.println("1. Add Item");
      System.out.println("2. Remove Item");
      System.out.println("3. View Items");
      System.out.println("4. Exit");
      System.out.print("Enter your choice: ");
      int choice = sc.nextInt();
      sc.nextLine();
      System.out.println();
      switch (choice) {
        case 1:
          System.out.print("Enter item name to add: ");
          String name = sc.nextLine();
          System.out.print("Enter item quantity: ");
          int quantity = sc.nextInt();
          System.out.print("Enter item price: ");
          double price = sc.nextDouble();
          sc.nextLine();
          Item item = new Item(name, quantity, price);
          inventory.addItem(item);
          break;
        case 2:
          System.out.print("Enter item name to remove: ");
          String nameToRemove = sc.nextLine();
          Item itemToRemove = null;
          for (Item itemRemove: inventory.getItems()) {
            if (itemRemove.getName().equalsIgnoreCase(nameToRemove)) {
              itemToRemove = itemRemove;
              break;
            }
          }
          if (itemToRemove != null) {
            inventory.removeItem(itemToRemove);
          } else {
            System.out.println("Item not found in inventory.");
          }
          break;
        case 3:
          inventory.viewItems();
          break;
        case 4:
          exit = true;
          System.out.println("Exiting Inventory Management System...");
          break;
        default:
          System.out.println("Invalid choice! Please enter choice between 1 to 4");    
      }
    }
    sc.close();
  }
}
