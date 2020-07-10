import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    CreateAccount createAccount = new CreateAccount();
    Inventory inventory = new Inventory();
    InvSheet i = new InvSheet();
    String sName = null;

    public void mainMenu() throws IOException {
        System.out.println("Welcome! Choose Menu \n(A)Customer \n(B)Store Owner \n(C)Mall Owner");
        String menuSelect = scanner.next().toLowerCase();

        switch (menuSelect){
            case "a":
                customerMenu();

            case "b":
                System.out.println("What is the name of your store?");
                sName = scanner.next();
                storeOwnerMenu();
            case "c":
                mallOwnerMenu();
        }

    }

    public void customerMenu() throws IOException {
        Order_class orderClass = new Order_class();
        System.out.println("Hello. Choose action: \n(A)Visit Store \n(P)Pay  \n(Q)Logout");
        String menuSelect = scanner.next().toLowerCase();

        switch (menuSelect){
            case "a":
                Customer_class.enterStore();
                customerMenu();
                break;
            case "q":
                mainMenu();
                break;
            case "p":
                orderClass.payment();
                customerMenu();
                break;
            default:
                System.out.println( menuSelect + " is not an action!");
                customerMenu();
                break;

        }
    }

    public void mallOwnerMenu() throws IOException {
      MallOwner M1 = new MallOwner();
    }

    public void storeOwnerMenu() throws IOException {
        Inventory inventory = new Inventory();
        InvSheet i = new InvSheet();
        CreateAccount c = new CreateAccount();

        for (String storeName :MallOwner.storeOwnerWarnings.keySet()) {
            if (storeName.equalsIgnoreCase(sName) ) {
                System.out.println("This is a warning from the Mall Owner for " + sName + ":");
                System.out.println(MallOwner.storeOwnerWarnings.get(storeName));
            }
        }

        System.out.println("Hello. Choose action: \n(A)Request New Store  \n(B)Inventory " +
                "\n(C)Close Store \n(Q)Logout");

        String menuSelect = scanner.next().toLowerCase();

        switch (menuSelect){
            case "a":
               StoreOwner.sendStoreRequest();
               storeOwnerMenu();
                break;
            case "b":
                System.out.println("(A)Search Items  \n(B)Get list of Items \n(C)Add Items \n(D)Set Item Price \n(E)Set Item Qty \n(S)Discount Item");
                String input = scanner.next().toLowerCase();
                  switch (input){
                      case "a":
                          inventory.searchItem();
                          storeOwnerMenu();
                          break;
                      case "b":
                         i.StoreOwnerINV(sName);
                         storeOwnerMenu();
                         break;
                      case "c":
                          inventory.addStoreItem(sName);
                          storeOwnerMenu();
                          break;
                      case "d":
                          inventory.setPrice();
                          storeOwnerMenu();
                          break;
                      case "e":
                          inventory.setQuantity();
                          storeOwnerMenu();
                          break;
                      case "s":
                          i.getAllStoreListInv();
                          System.out.println("Choose item to put on sale (Row Number): ");
                          int row = scanner.nextInt();
                          i.setSalePrice(row);
                          i.getAllStoreListInv();
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
