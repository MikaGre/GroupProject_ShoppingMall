import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;



public class Order_class extends Inventory {
    static int orderID = 0;
    String customerName;
    int CustomerID;
    static int priceOfTheItem;
    static double itemPrice, fSubTotal, fTotal, fTax;



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
                int creditNum = input.nextInt();
                System.out.println("enter 3-digit security code");
                int scode = input.nextInt();
                System.out.println("enter expiration  date XX/XX");
                String expDate = input.next();
                //  fTotal=priceOfTheItem +  price/100*9 + (price/100*9)/100 * 3;
                break;
            case "b":
                System.out.println("Logging to PayPal...");
                // fTotal=priceOfTheItem+price/100*9 + (priceOfTheItem+priceOfTheItem/100*9)/100*2.5 + 0,35;
                break;
            default:
                System.out.println("error: please choose Credit card or Paypal");

                System.out.println("==================== Your Cart ==================");
                System.out.println("Item    \t\tPrice\t   Quantity\t   Item Total");
                System.out.println("***************************************************");
                System.out.println("***************************************************");
                System.out.println(String.format("Subtotal\t\t\t\t\t\t       $%.2f", fSubTotal));
                System.out.println(String.format("Tax\t\t\t\t\t\t\t\t       $%.2f", fTax));
                System.out.println(String.format("Total\t\t\t\t\t\t\t       $%.2f", fTotal));
                System.out.println("==============================================");
Menu menu=new Menu();
menu.customerMenu();

        }
    }
}


















