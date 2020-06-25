import java.util.Scanner;

public class MainApp {

    //Scanner scanner = new Scanner(System.in);
    public static void main (String[] args) {

       StoreOwner sO1 = new StoreOwner();
       StoreOwner sO2 = new StoreOwner();

       sO1.inventory.addStoreItem();
       sO2.inventory.addStoreItem();

       MallOwner.getInventory();


      // Customer_class.enterStore();

//        do {
//            Menu menu = new
//            ();
//            menu.mainMenu();
//        }while (true);


    }
}
