import java.util.HashMap;
import java.util.Scanner;

public class StoreOwner {
    static int storeID=1;
    static String storeOwnerName;
    String storeName;
    int price;
    double sellingPrice;
    Inventory inventory;
    Scanner S1 = new Scanner(System.in);

    public static HashMap <Integer, String[]> storeRequestList = new HashMap<>();

    public StoreOwner()
    {
        CreateAccount createAccount = new CreateAccount();
        ++storeID;
        System.out.println("Please enter your name");
        this.storeOwnerName = S1.next();
        System.out.println("Please enter your Store name");
        this.storeName = S1.next();
        //System.out.println("Store request has been sent to Mall Owner");
        storeRequestList.put(storeID,new String[]{storeOwnerName,storeName});
        inventory = new Inventory(storeID);
        createAccount.addAccount("Store Owner",storeOwnerName,storeName);

    }

    public void sendStoreRequest() {
        ++storeID;
        System.out.println("Youre Name");
        String storeOwnerName = S1.next();
        System.out.println("Enter Name of Store");
        String nameOfStore = S1.next();
        storeRequestList.put(storeID,new String[]{storeOwnerName,nameOfStore});
    }

    public void sale()
    {
        //item price brand , item price brand , item price brand
            Object[] inv = inventory.storeInventory.values().toArray();
        for (int i = 1; i < inv.length ; i+=3) {
           double salePrice = (double) inv[i];
           inv[i] = salePrice*(0.5);
        }

        }
    }


