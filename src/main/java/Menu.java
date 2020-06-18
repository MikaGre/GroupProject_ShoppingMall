import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    CreateAccount createAccount = new CreateAccount();


    public void mainMenu() {
        System.out.println("Welcome! \n(A)Login \n(B)Create Account");
        String menuSelect = scanner.next().toLowerCase();

        switch (menuSelect){
            case"a":
                loginMenu();
                break;
            case "b":
                createAccountMenu();
                break;
        }

    }

    public void loginMenu() {
        System.out.println("Who are you? \n(A)Customer \n(B)Store Owner \n(C)Mall Owner");
        String menuSelect = scanner.next().toLowerCase();
        System.out.print("UserID: ");
        String userID = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
        boolean isCorrectLogin = createAccount.verfiyAccount(userID,password);

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
    }

    public void createAccountMenu() {
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
    }

    public void customerMenu() {
        System.out.println("Hello. Choose action: \n(A)Visit Store \n(B)View Shopping Cart \n(Q)Logout");
        String menuSelect = scanner.next().toLowerCase();

        switch (menuSelect){
            case "a":
                storeList();
                break;
            case "b":
                cartDetails();
            case "q":
                mainMenu();
                break;
            default:
                System.out.println( menuSelect + " is not an action!");
                customerMenu();
                break;

        }
    }

    public void mallOwnerMenu() {
        System.out.println("Hello. Choose action: \n(A)Approve Store Request  \n(B)Send Warning " +
                "\n(C)Close a Store \n(D)Store List \n(Q)Logout");

        String menuSelect = scanner.next().toLowerCase();

        switch (menuSelect){
            case "a":
               // MallOwnerPractice.getStoreRequest();
                break;
            case "b":
              //  MallOwnerPractice.sendWarning();
                break;
            case "c":
             //   MallOwnerPractice.forceStoreClose();
                break;
            case "d":
             //   MallOwnerPractice.getStoreList();
                break;
            case "q":
                mainMenu();
                break;
            default:
                System.out.println( menuSelect + " is not an action!");
                mallOwnerMenu();
                break;


        }
    }

    public void storeOwnerMenu() {
        System.out.println("Hello. Choose action: \n(A)Request New Store  \n(B)Inventory " +
                "\n(C)Close Store \n(Q)Logout");

        String menuSelect = scanner.next().toLowerCase();

        switch (menuSelect){
            case "a":
              //  storeRequest();
                break;
            case "b":
                System.out.println("(A)List Inventory \n(B)Add Items");
                String input = scanner.next().toLowerCase();
                  switch (input){
                      case "a":
                          Inventory inventory = new Inventory();
                          inventory.getStoreItems();
                      case "b":
                          String itemName = scanner.next();
                          double price = scanner.nextDouble();
                          int qty = scanner.nextInt();
                         // inventory.addStoreItem(itemName,price,qty);
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

    public void storeList() {
        StoreOwner storeOwner = new StoreOwner();
       // System.out.println(storeOwner.store.values());

    }

    public void cartDetails () {

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.getShoppingCart();
    }



}
