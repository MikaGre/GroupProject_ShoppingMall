import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;

public class Inventory{

    static int productID = 0;
    static int ID = 0;
    static double price;
    private static Scanner scanner;
    private static InvSheet i;
    private int quantity;
    int id; // Being used for scanner class
    static String prouductName;
    public Inventory(int storeid) {}
    public Inventory(){}
    public Inventory(String productName,int onHandQuantity){}

    Map<Integer, Object[]> storeInventory = new HashMap<>();


    public int inventoryId(String productName, double price, int onHandQuantity) {

        storeInventory = new HashMap<>();
        ID = ID++;
        return ID;
    }

    public void removeStoreItem() {
        String val = "yes";
        Scanner S3 = new Scanner(System.in);
       try {
           System.out.println("Please enter the product id");
           id = S3.nextInt();
       }
        catch(InputMismatchException e)
        {
            System.out.println("Please enter only whole number");
        }

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
        InvSheet invSheet = new InvSheet();
        String storeName = null;
        String productName;
        int onHandQuantity = 0;
        Integer val1 = 0;
        Scanner S2 = new Scanner(System.in);
        System.out.println("Enter Your Store Name");
        storeName = S2.next();
        try {
            System.out.println("How many items will you like to add?");
            val1 = S2.nextInt();
            for (int i = 0; i < val1; i++) {
                ID = ++productID;
                System.out.println("Please enter product Name: ");
                productName = S2.next().toLowerCase();
                System.out.println("Please enter product price: ");
                price = S2.nextDouble();
                System.out.println("Please enter product Quantity");
                onHandQuantity = S2.nextInt();
                storeInventory.put(ID, new Object[]{productName, price, onHandQuantity});
                invSheet.addItem(StoreOwner.storeID,storeName,productID,productName,price,onHandQuantity);
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println("Please enter only whole number");
        }
        storeInventory.forEach((key, value) -> {
            System.out.println("\n");
            System.out.print("ID: " + key);
            Object[] itemsInfo = storeInventory.get(key);
            System.out.println("\nProduct Name: " + itemsInfo[0]);
            System.out.println("Price: $" + itemsInfo[1]);
            System.out.println("Qty: " + itemsInfo[2]);
        });
        /*Menu menu = new Menu();
        menu.storeOwnerMenu();*/
    }

    public void searchItem() {
        Scanner S3 = new Scanner(System.in);
        System.out.println("Please enter the name of the item you are looking for");
        String item = S3.next().toLowerCase();
        boolean foundItem = false;
        for (Integer k : storeInventory.keySet()) {
            Object[] itemsInfo = storeInventory.get(k);
            if (itemsInfo[0].equals(item)) {
                foundItem = true;
                System.out.println("Item found");
                break;
                /*System.out.println("\nProduct Name: " + storeInventory.get(foundItem)[0] +
                        "\nPrice: $" + storeInventory.get(foundItem)[1] +
                        "\nQty: " + storeInventory.get(foundItem)[2]);*/
                }
            else {
                System.out.println("No such item found");
            }
        }
    }

    public void getStoreItems() {
        for (Integer k : storeInventory.keySet()) {

            Object[] itemsInfo = storeInventory.get(k);
            System.out.println("\nProduct Name: " + itemsInfo[0]);
            System.out.println("Price: $" + itemsInfo[1]);
            System.out.println("Qty: " + itemsInfo[2]);
        }

    }

    public void setPrice() throws IOException {
        i.getStoreListInv();
        System.out.print("Select Item row num:");
        int row = scanner.nextInt();
        System.out.print("Updated Price amount:");
        String setQTY = scanner.next();
        i.setPrice(row,setQTY);
    }

    public void setQuantity () throws IOException {
        i.getStoreListInv();
        System.out.print("Select Item row num:");
        int row = scanner.nextInt();
        System.out.print("Updated Qty amount(Example:-10 or 20):");
        String setQTY = scanner.next();
        i.setQty(row,setQTY);
    }

}
