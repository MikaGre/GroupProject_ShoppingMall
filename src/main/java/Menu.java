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

   /* public void loginMenu() {
        System.out.println("Who are you? \n(A)Customer \n(B)Store Owner \n(C)Mall Owner");
        String menuSelect = scanner.next().toLowerCase();
        System.out.print("UserID: ");
        userID = scanner.nextInt();
        System.out.print("Password: ");
        String password = scanner.next();
        boolean isCorrectLogin = createAccount.verfiyAccount(Integer.toString(userID),password);

        if (isCorrectLogin = true) {
            switch (menuSelect) {
                case "a":
                    customerMenu();
                case "b":
                    storeOwnerMenu();
                case "c":
                    mallOwnerMenu();

            }
        }
    }*/

  /*   public void createAccountMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a UserName: ");
        String userName = scanner.next();
        System.out.println("Who are you? \n(A)Customer \n(B)Store Owner \n(C)Mall Owner");
        String menuSelect = scanner.next().toLowerCase();
        String accType = "";

        switch (menuSelect){
            case "a":
                accType = "Customer";
                break;
            case "b":
                accType = "StoreOwner";
                break;
            case "c":
                accType = "MallOwner";
                break;
            default:
                System.out.println( menuSelect + " is not an account type!");
                createAccountMenu();
                break;

        }
        System.out.print("Enter a password: ");
        String password = scanner.next();

        CreateAccount createAccount = new CreateAccount();
        createAccount.addAccount(accType,userName,password);
        System.out.println("***Account has been created***");
        mainMenu();
    }*/

    public void customerMenu() {
        System.out.println("Hello. Choose action: \n(A)Visit Store \n(B)View Shopping Cart  \n(D)Edit account details \n(P)Payment  \n(Q)Logout");
        String menuSelect = scanner.next().toLowerCase();

        switch (menuSelect){
            case "a":
                MallOwner.getStoreList();
                break;
            case "b":

            case "q":
                mainMenu();
                break;
            case "p":
                Order_class.payment();
                break;
            case "d":
                Customer_class.accountDetails();
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
                          break;
                      case "b":
                         inventory.getStoreItems();
                         break;
                      case "c":

                          inventory.addStoreItem();
                          break;
                      default:
                          System.out.println( menuSelect + " is not an action!");
                          storeOwnerMenu();
                  }
                break;
            case "c":
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
