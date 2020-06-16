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
        System.out.print("UserID: ");
        String name = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
        createAccount.verfiyAccount(name,password);

    }

    public void createAccountMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter First Name: ");
        String fullName = scanner.next();
        System.out.print("Enter Last Name: ");
        fullName += scanner.next();
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
        createAccount.addAccount(accType,fullName,password);
        System.out.println("***Account has been created***");
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

/*
    public void mallOwnerMenu() {
        System.out.println("Hello. Choose action: \n(A)Approve Store Request  \n(B)Send Warning " +
                "\n(C)Close a Store \n(D)Store List \n(Q)Logout");

        String menuSelect = scanner.next().toLowerCase();

        switch (menuSelect){
            case "a":
                approveStoreRequest();
                break;
            case "b":
                sendStoreOwnerWarning();
                break;
            case "c":
                closeAStore();
                break;
            case "d":
                getStoreList();
                break;
            case "q":
                logout();
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
                storeRequest();
                break;
            case "b":
                setInventory();
                break;
            case "c":
                closeStore();
                break;
            case "q":
                logout();
                break;
            default:
                System.out.println( menuSelect + " is not an action!");
                storeOwnerMenu();
                break;


        }
    }
*/

    public void storeList() {

    }

    public void cartDetails () {

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.getShoppingCart();
    }


}
