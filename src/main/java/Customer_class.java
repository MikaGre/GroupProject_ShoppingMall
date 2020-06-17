import java.util.Scanner;

public class Customer_class {
String customerName;
String address;
String email;
String creditCardInfo;



public static void accountDetails(){
    Scanner input = new Scanner(System.in);
    System.out.println("please enter full name");
    String name = input.next();
    System.out.println("please enter address");
    String address = input.next();
    System.out.println("please enter your email");
    String email = input.next();
    System.out.println("please enter your credit card information");
    String creditCardInfo = input.next();
    System.out.println("you are successfully enter to the store");


}
public static void leaveStore(){
    mainManu();


}
public static void enterStore(){
    getListStore();

}
}
