
import java.io.IOException;
import java.util.*;

public class Order_class {

    static int orderID = 0;
    private static double quantity;
    static double itemPrice, fSubTotal, fTotal, fTax;
    String productName = null;
    InvSheet i = new InvSheet();

    Scanner scanner = new Scanner(System.in);
    Map<String, Double[]> cart = new HashMap<>();
    boolean keepShopping = true;

    public void order () throws IOException {
        Scanner scanner = new Scanner(System.in);
        InvSheet invSheet = new InvSheet();


        while (keepShopping) {
            System.out.print("\nEnter the name of the item: ");
            productName = scanner.next();
            itemPrice = invSheet.getItemPrice(productName);
            System.out.print("Enter the quantity: ");
            String q = scanner.next();
            quantity = Double.parseDouble(q);
            int iqty = invSheet.getItemQTY(productName,quantity);
            invSheet.buyingSubtractQty(iqty,q);
            cart.put(productName, new Double[]{quantity, itemPrice});

            System.out.println("==================== Your Cart ==================");
            System.out.println("Item    \t\tPrice\t   Quantity\t   Item Total");
            System.out.println("***************************************************");

            fSubTotal = 0;

            for (String k : cart.keySet()) {
                Double[] itemsInfo = cart.get(k);
                System.out.println(String.format("%-15s      $%-15.2f      %.1f\t\t   $%.2f", k, itemsInfo[1], itemsInfo[0], itemsInfo[1] * itemsInfo[0]));
                fSubTotal += itemsInfo[1] * itemsInfo[0];
            }

            fTax = fSubTotal * 0.09;
            fTotal = fSubTotal + fTax;

            System.out.println("***************************************************");
            System.out.println(String.format("Subtotal\t\t\t\t\t\t       $%.2f", fSubTotal));
            System.out.println(String.format("Tax\t\t\t\t\t\t\t\t       $%.2f", fTax));
            System.out.println(String.format("Total\t\t\t\t\t\t\t       $%.2f", fTotal));
            System.out.println("==============================================");

            System.out.print("Continue shopping (y/n) ==> Would you like to remove an item(r)? ");
            String shop = scanner.next().toLowerCase();

            switch (shop) {
                case "y":
                    break;
                case "n":
                    keepShopping = false;
                    break;
                case "r":
                    System.out.println("Provide item name:");
                    removeItem(scanner.next());
                    System.out.println("****Item removed from cart****");
                    iqty = invSheet.getItemQTY(productName,quantity);
                    invSheet.setQty(iqty, String.valueOf(quantity));
                    break;
                default:
                    System.out.println(shop + " <= That is not an option");
                    order();
            }
        }
        payment();

    }

    public void removeItem(String productName) {
        cart.remove(productName);
        for (String k : cart.keySet()) {
            Double[] itemsInfo = cart.get(k);
            System.out.println(String.format("%s\t\t      $%.2f      %.1f\t\t   $%.2f", k, itemsInfo[1], itemsInfo[0], itemsInfo[1] * itemsInfo[0]));
            fSubTotal += itemsInfo[1] * itemsInfo[0];
        }

    }

    public void payment () throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter full name");
        String name = input.next();

        System.out.println("please enter your shipping address");
        String shippingAddress = input.next();

        System.out.println("system is processing...");

        fTax = fSubTotal * 0.09;
        fTotal = fSubTotal + fTax;


        System.out.println("please enter payment method \n(A)Credit card \n(B)Paypal");
        String payment = input.next().toLowerCase();

        switch (payment) {
            case "a":
                System.out.println("Enter the credit card number");
                String creditNum = input.next();
                if (!creditNum.matches("\\d{16}")) {
                    System.out.println(creditNum + " <= Invalid card number");
                    payment();
                } else {
                    System.out.println("Enter 3-digit security code(###)");
                    String scode = input.next();
                    if (!scode.matches("\\d{3}")) {
                        System.out.println(scode + " <= Invalid security code. Must enter 3 digits (###) ");
                        payment();
                    } else {
                        System.out.println("enter expiration date (Format: XX/XX)");
                        String expDate = input.next();
                        if (!expDate.matches("\\d{2}/\\d{2}")) {
                            System.out.println(expDate + " <= Invalid expiration date");
                            payment();
                        } else {
                            double creditTotal = fTotal + fTotal / 100 * 3;
                            System.out.println("==================== Ordered Processed ==================");
                            System.out.println("Item    \t\tPrice\t   Quantity\t   Item Total");
                            System.out.println("***************************************************");
                            System.out.println("***************************************************");
                            System.out.println(String.format("Subtotal\t\t\t\t\t\t       $%.2f", fSubTotal));
                            System.out.println(String.format("Tax\t\t\t\t\t\t\t\t       $%.2f", fTax));
                            System.out.println(String.format("Fee\t\t\t\t\t\t\t\t       $%.2f", (fTotal / 100 * 3)));
                            System.out.println(String.format("Total\t\t\t\t\t\t\t       $%.2f", creditTotal));
                            System.out.println("==============================================");
                            break;
                        }
                    }
                }
                case "b":
                                System.out.println("Logging to PayPal...");
                                double payPalTotal = fTotal + fTotal / 100 * 2.5 + 0.35;

                                System.out.println("==================== Ordered Processed ==================");
                                System.out.println("Item    \t\tPrice\t   Quantity\t   Item Total");
                                System.out.println("***************************************************");
                                System.out.println("***************************************************");
                                System.out.println(String.format("Subtotal\t\t\t\t\t\t       $%.2f", fSubTotal));
                                System.out.println(String.format("Tax\t\t\t\t\t\t\t\t       $%.2f", fTax));
                                System.out.println(String.format("Fee\t\t\t\t\t\t\t\t       $%.2f", (fTotal / (100 * 2.5) + 0.35)));
                                System.out.println(String.format("Total\t\t\t\t\t\t\t       $%.2f", payPalTotal));
                                System.out.println("==============================================");
                                break;



                        default:
                                System.out.println("error: please choose Credit card or Paypal");
                                break;

                        }

        Menu menu = new Menu();
        menu.customerMenu();
    }
}





















