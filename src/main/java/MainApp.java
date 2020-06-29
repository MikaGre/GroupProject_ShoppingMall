import java.io.IOException;
import java.util.Scanner;

public class MainApp {

    //Scanner scanner = new Scanner(System.in);
    public static void main (String[] args) throws IOException {
        //StoreOwner s1 = new StoreOwner();
        //s1.inventory.setQuantity();
        //Inventory i = new Inventory();
        InvSheet is = new InvSheet();
        is.getStoreListInv();
        //is.setPrice(2,"5.87");
        is.setQty(2,"-10");
        is.getStoreListInv();
        //i.setQuantity();
//        do {
//            Menu menu = new
//            ();
//            menu.mainMenu();
//        }while (true);


    }
}
