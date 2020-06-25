import java.util.HashMap;
import java.util.Scanner;

public class StoreOwner extends Inventory{
    static int storeID=1;
    String storeOwnerName;
    String storeName;
    int price;
  double sellingPrice;
    Scanner S1 = new Scanner(System.in);

    public static HashMap <Integer, String[]> storeRequestList = new HashMap<>();

    public StoreOwner()
    {

        ++storeID;
        System.out.println("Please enter your name");
        this.storeOwnerName = S1.next();
        System.out.println("Please enter your Store name");
        this.storeName = S1.next();
        System.out.println("Store request has been sent to Mall Owner");
        storeRequestList.put(storeID,new String[]{storeOwnerName,storeName});

        Inventory inventory = new Inventory();
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
      Inventory inventory = new Inventory();
            Object[] inv = inventory.storeInventory.values().toArray();
        for (int i = 1; i < inv.length ; i+=3) {
           double salePrice = (double) inv[i];
           inv[i] = salePrice*(0.5);
        }

        }
//       public static void Main()
//       {
//           StoreOwner S1 = new StoreOwner("Facebook","Bob");
//           S1.requestNewStore();
//       }
    }


