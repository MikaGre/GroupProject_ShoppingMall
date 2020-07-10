import java.io.IOException;
import java.util.Scanner;

public class Customer_class  extends Order_class{

Order_class order;

public void Customer_Class(){
    orderID++;
    order = new Order_class();
}


public static void leaveStore() throws IOException {
    System.out.println("******Thanks for Shopping*****");
     Menu m = new Menu();
     m.customerMenu();
}

public static void enterStore() throws IOException {
    CreateAccount ca = new CreateAccount();
    MallOwner.getStoreList();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Choose Store");
    String storeName = scanner.next();
    ca.verfiyStore(storeName);
    Order_class o = new Order_class();
    o.order();
}


}
