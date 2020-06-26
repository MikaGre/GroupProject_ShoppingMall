import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Customer_class  extends Order_class{
String customerName;
String address;
String email;
String creditCardInfo;
Order_class order;

static int accID = 0;
static Map<Integer,String[]> custAccountInfo = new HashMap<>();

public void Customer_Class(){
    orderID++;
    order = new Order_class();
}

public static void accountDetails(){
    Scanner input = new Scanner(System.in);
    System.out.println("please enter full name");
    String name = input.next();
    System.out.println("please enter address");
    String address = input.next();
    System.out.println("please enter your email");
    String email = input.next();
    System.out.println("please enter your credit card information");

    int id = accID++;
custAccountInfo.put(id,new String[]{name,address,email});

}
public static void leaveStore(){


   // mainManu();

   // menu.mainManu();



}
public static void enterStore(){
    CreateAccount ca = new CreateAccount();
    MallOwner.getStoreList();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Choose Store");
    String storeName = scanner.next();
    ca.verfiyStore(storeName);


}


}
