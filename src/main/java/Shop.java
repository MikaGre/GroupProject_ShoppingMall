import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    ArrayList<Item> cart = new ArrayList<>();
    String itemName;
    double itemPrice, fSubTotal, fTotal, fTax;
    int quantity;
    String keepShopping;
    Item item = new Item();
    Scanner scan = new Scanner(System.in);

public void shop () {
   while (keepShopping.equals("y"))
    System.out.print("Enter the name of the item: ");
    itemName = scan.next();
    itemPrice = this.item.getPrice();
    System.out.print("Enter the quantity: ");
    quantity = scan.nextInt();

    cart.add(new Item(itemName, itemPrice, quantity));

    System.out.println("==================== Your Cart ==================");
    System.out.println("Item    \t\tPrice\t   Quantity\t   Item Total");
    System.out.println("***************************************************");

    fSubTotal = 0;

    for (Item item : cart) {
        System.out.println(String.format("%s\t\t        $%.2f      %d\t\t   $%.2f", item.getName(), item.getPrice(), item.getQuantity(), item.getPrice() * item.getQuantity()));
        fSubTotal += item.getPrice();
    }

    fTax = fSubTotal * 0.09;
    fTotal = fSubTotal + fTax;

    System.out.println("***************************************************");
    System.out.println(String.format("Subtotal\t\t\t\t\t\t       $%.2f", fSubTotal));
    System.out.println(String.format("Tax\t\t\t\t\t\t\t\t       $%.2f", fTax));
    System.out.println(String.format("Total\t\t\t\t\t\t\t       $%.2f", fTotal));
    System.out.println("==============================================");


    System.out.print("Continue shopping (y/n)? ");
    keepShopping = scan.next().toLowerCase();
  }
}


