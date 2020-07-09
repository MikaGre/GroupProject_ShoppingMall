import java.util.HashMap;
import java.util.Scanner;

public class StoreOwner {
    static int storeID=1;
    static String storeOwnerName;
    static String storeName;
    Inventory inventory;
    InvSheet invSheet;
    Scanner S1 = new Scanner(System.in);

    public static HashMap <Integer, String[]> storeRequestList = new HashMap<>();

    public StoreOwner() {
        CreateAccount createAccount = new CreateAccount();
        ++storeID;
        System.out.println("Please enter your name");
        this.storeOwnerName = S1.next();
        System.out.println("Please enter your Store name");
        this.storeName = S1.next();
        storeRequestList.put(storeID,new String[]{storeOwnerName,storeName});
        inventory = new Inventory(storeID);
        createAccount.addAccount("Store Owner",storeOwnerName,storeName);
        invSheet = new InvSheet();
    }

    public static void sendStoreRequest() {
        Scanner S1 = new Scanner(System.in);
        ++storeID;
        System.out.println("Youre Name");
        String storeOwnerName = S1.next();
        System.out.println("Enter Name of Store");
        String nameOfStore = S1.next();
        storeRequestList.put(storeID,new String[]{storeOwnerName,nameOfStore});
    }

    }


