import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

public class Order_class{

    static int orderID = 0;
    private static double quantity;

    String customerName;
    int CustomerID;
    static int priceOfTheItem;
    static double itemPrice, fSubTotal, fTotal, fTax;
    String productName = null;

    Scanner scanner = new Scanner(System.in);
    //List<Object> cart = new ArrayList<>();
    Map<String,Double[]> cart = new HashMap<>();
    boolean keepShopping = true;

    public void order (){
        Scanner scanner = new Scanner(System.in);
        //ArrayList<Inventory> cart = new ArrayList<>();
        InvSheet invSheet = new InvSheet();


        while (keepShopping){
            System.out.print("\nEnter the name of the item: ");
            productName = scanner.next();
            System.out.print("Enter the price: ");
            //itemPrice = scanner.nextDouble();
            itemPrice = scanner.nextDouble();
            System.out.print("Enter the quantity: ");
            quantity = scanner.nextInt();

            cart.put(productName,new Double[]{quantity,itemPrice});

        System.out.println("==================== Your Cart ==================");
        System.out.println("Item    \t\tPrice\t   Quantity\t   Item Total");
        System.out.println("***************************************************");

        fSubTotal = 0;

//   for (Object item : cart) {
//        System.out.println(String.format("%s       $%.2f      %d\t\t   $%.2f", productName, itemPrice, quantity, itemPrice * quantity));
//        fSubTotal += itemPrice*quantity;
//    }
            for (String k : cart.keySet()) {
                Double[] itemsInfo = cart.get(k);
                System.out.println(String.format("%s       $%.2f      %.1f\t\t   $%.2f", k, itemsInfo[1], itemsInfo[0], itemsInfo[1] * itemsInfo[0]));
                fSubTotal += itemsInfo[1] * itemsInfo[0];
            }

        fTax = fSubTotal * 0.09;
        fTotal = fSubTotal + fTax;

        System.out.println("***************************************************");
        System.out.println(String.format("Subtotal\t\t\t\t\t\t       $%.2f", fSubTotal));
        System.out.println(String.format("Tax\t\t\t\t\t\t\t\t       $%.2f", fTax));
        System.out.println(String.format("Total\t\t\t\t\t\t\t       $%.2f", fTotal));
        System.out.println("==============================================");

            System.out.print("Continue shopping (y/n)? ");
            String shop = scanner.next().toLowerCase();

            switch (shop) {
                case "y":
                    break;
                case "n":
                    keepShopping = false;
                    break;
            }
        }
        Customer_class.payment();


    }

    public static void payment() {
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

                System.out.println("enter 3-digit security code");
                String scode = input.next();

                System.out.println("enter expiration  date XX/XX");
                String expDate = input.next();

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

Menu menu=new Menu();
menu.customerMenu();

        }
    }



















