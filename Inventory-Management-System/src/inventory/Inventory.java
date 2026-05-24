package inventory;

import java.util.*;

public class Inventory {
  private List<Item> items;
  public Inventory() {
    items = new ArrayList<>();
  }

  public void addItem(Item item) {
    try {
      items.add(item);
      System.out.println("Item added successfully: " +item);
    } catch (Exception e) {
          System.out.println("Error adding item: " +e.getMessage());
    }
  }

  public void removeItem(Item item) {
    try {
      if (!items.contains(item)) {
          throw new IllegalArgumentException("Item not found in inventory.");
      }
      items.remove(item);
      System.out.println("Item removed successfully: " +item);
    } catch (Exception e) {
          System.out.println("Error removing item: " +e.getMessage());
    }
  }

  public void viewItems() {
    if (items.isEmpty()) {
        System.out.println("Inventory is empty.");
    } else {
        System.out.println("Inventory items:");
        for (Item item : items) {
          System.out.println(item);
        }
    }
  }

  public List<Item> getItems() {
    return items;
  }
}
