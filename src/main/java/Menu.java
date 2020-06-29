import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    CreateAccount createAccount = new CreateAccount();
    Inventory inventory = new Inventory();
    public int userID = -1;


    public void mainMenu() {
        System.out.println("Welcome! Choose Menu \n(A)Customer \n(B)Store Owner \n(C)Mall Owner");
        String menuSelect = scanner.next().toLowerCase();

        switch (menuSelect){
            case "a":
                customerMenu();
            case "b":
                storeOwnerMenu();
            case "c":
                mallOwnerMenu();
        }

    }

    public void customerMenu() {
        Order_class orderClass = new Order_class();
        System.out.println("Hello. Choose action: \n(A)Visit Store \n(B)View Shopping Cart  \n(D)Edit account details \n(P)Payment  \n(Q)Logout");
        String menuSelect = scanner.next().toLowerCase();

        switch (menuSelect){
            case "a":
                MallOwner.getStoreList();
                customerMenu();
                break;
            case "b":
                orderClass.order();
                customerMenu();
            case "q":
                mainMenu();
                break;
            case "p":
                Order_class.payment();
                customerMenu();
                break;
            case "d":
                Customer_class.accountDetails();
                customerMenu();
                break;
            default:
                System.out.println( menuSelect + " is not an action!");
                customerMenu();
                break;

        }
    }

    public void mallOwnerMenu() {
      MallOwner M1 = new MallOwner();
    }

    public void storeOwnerMenu() {
        Inventory inventory=new Inventory();
        InvSheet i = new InvSheet();
        CreateAccount c = new CreateAccount();
        for (Integer storeID :MallOwner.storeOwnerWarnings.keySet()) {
            if (storeID == userID ) {
                System.out.println(MallOwner.storeOwnerWarnings.get(storeID));
            }
        }

        System.out.println("Hello. Choose action: \n(A)Request New Store  \n(B)Inventory " +
                "\n(C)Close Store \n(Q)Logout");

        String menuSelect = scanner.next().toLowerCase();

        switch (menuSelect){
            case "a":
              //  storeRequest();
                break;
            case "b":
                System.out.println("(A)Search Items  \n(B)Get list of Items \n(C)Add Items");
                String input = scanner.next().toLowerCase();
                  switch (input){
                      case "a":
                          inventory.searchItem();
                          storeOwnerMenu();
                          break;
                      case "b":
                          System.out.println("Enter your store name:");
                          String store = scanner.next();
                         c.verfiyStore(store);
                         storeOwnerMenu();
                         break;
                      case "c":
                          inventory.addStoreItem();
                          storeOwnerMenu();
                          break;
                      default:
                          System.out.println( menuSelect + " is not an action!");
                          storeOwnerMenu();
                  }
                break;
            case "c":
                MallOwner.forceStoreClose();
                mainMenu();
            case "q":
                mainMenu();
                break;
            default:
                System.out.println( menuSelect + " is not an action!");
                storeOwnerMenu();
                break;

        }
    }
}
