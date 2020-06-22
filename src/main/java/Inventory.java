import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

    static int productID = 0;
    static int ID = 0;
    private double price;
    private int quantity;

    public Inventory() {
    }


    static Map<Integer, Object[]> storeInventory = new HashMap<>();


    public int inventoryId(String productName, double price, int onHandQuantity) {

        storeInventory = new HashMap<>();
        ID = ID++;
        return ID;
    }

   //take quantity
    // check if an id is present warning are you sure? remove only if is zero
    public void removeStoreItem() {
        String val = "yes";
        Scanner S3 = new Scanner(System.in);
       /* System.out.println("Please enter the product name that you want to remove");
        String name1 = S3.next();*/
        System.out.println("Please enter the product id");
        int id = S3.nextInt();

        for (Integer k : storeInventory.keySet()) {
            if (id == k) {
                System.out.println("Are you sure you want to remove this product? yes/no");
                String name2 = S3.next();
                if(name2.equalsIgnoreCase(val))
                {
                    ID = id;
                    storeInventory.remove(ID);

                }

                break;
            }
        }
        System.out.println(storeInventory.keySet());
        }


    public void addStoreItem() {

        String productName;
        int onHandQuantity = 0;
        Scanner S2 = new Scanner(System.in);
        System.out.println("How many items will you like to add?");
        Integer val1 = S2.nextInt();
        for (int i = 0; i < val1; i++) {
            ID = ++productID;
            System.out.println("Please enter product Name: ");
            productName = S2.next().toLowerCase();
            System.out.println("Please enter product price: ");
            price = S2.nextDouble();
            System.out.println("Please enter product Quantity");
            onHandQuantity += S2.nextInt();
            storeInventory.put(ID, new Object[]{productName, price, onHandQuantity});
        }
        System.out.println(storeInventory.keySet());
        for (Integer k : storeInventory.keySet()) {
            Object[] itemsInfo = storeInventory.get(k);
            System.out.println("\nProduct Name: " + itemsInfo[0]);
            System.out.println("Price: $" + itemsInfo[1]);
            System.out.println("Qty: " + itemsInfo[2]);
        }
        /*Menu menu = new Menu();
        menu.storeOwnerMenu();*/
    }

    public static void searchItem() {
        Scanner S3 = new Scanner(System.in);
        System.out.println("Please enter the item you are looking for");
        String item = S3.next().toLowerCase();
        Integer foundItem = -1;
        for (Integer k : storeInventory.keySet()) {
            Object[] itemsInfo = storeInventory.get(k);
            if (itemsInfo[0] == item) {
                foundItem=k;
                break;
            }
        }
        if(foundItem!=-1)
        {
            System.out.println("\nProduct Name: " + storeInventory.get(foundItem)[0] +
                    "\nPrice: $" + storeInventory.get(foundItem)[1] +
                    "\nQty: " + storeInventory.get(foundItem)[2]);
        }
        else
        {
            System.out.println("No such item found");
        }
    }
    public static void main(String[] args) {
        {
            Inventory invent = new Inventory();
            invent.addStoreItem();
            invent.removeStoreItem();
        }
    }
}
//    Store owner
//    a. Can file for new store
//        b. Once approved can create:
//        c. new items
//        d. Remove items
//        e. Each item has a set quantity
//        f. Item has a cost amount
//        g. Store owner can have a sale on all items
//        h. Close the store
//        i. If any warning message it will show upon logon
//        j. Logout function will bring back to login screen

 /*public String toString ()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return (productName + "\t" + fmt.format(price) + "\t" + quantity + "\t"
                + fmt.format(price*quantity));
    }*/
//   Returns the unit price of the item
    /*public double getPrice()
    {
        return price;
    }

    //   Returns the quantity of the item
    public String getName()
    {
        return productName;
    }

    public int getQuantity()
    {
        return quantity;
    }*/
