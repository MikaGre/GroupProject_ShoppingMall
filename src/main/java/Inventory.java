import java.io.IOException;
import java.util.*;

public class Inventory{

    static int productID = 0;
    static int ID = 0;
    static double price;
    public Inventory(int storeid) {}
    public Inventory(){}

    Map<Integer, Object[]> storeInventory = new HashMap<>();


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
                //foundItem = true;
                System.out.println("Item found");
                // break;
                System.out.println("\nProduct Name: " + storeInventory.get(k)[0] +
                        "\nPrice: $" + storeInventory.get(k)[1] +
                        "\nQty: " + storeInventory.get(k)[2]);
                break;
            }
            else {
                System.out.println("No such item found");
                break;
            }
        }
    }

    public void setPrice() throws IOException {
        InvSheet i = new InvSheet();
        Scanner scanner = new Scanner(System.in);
        i.getAllStoreListInv();
        System.out.print("Select Item row num:");
        int row = scanner.nextInt();
        System.out.print("Updated Price amount:");
        String setQTY = scanner.next();
        i.setPrice(row,setQTY);
    }

    public void setQuantity () throws IOException {
       InvSheet invSheet = new InvSheet();
       Scanner s = new Scanner(System.in);
        invSheet.getAllStoreListInv();
        System.out.print("Select Item by row num:");
        int row = s.nextInt();
        System.out.print("Add or Subtract Qty (Example:-10 or 20):");
        String setQTY = s.next();
        invSheet.setQty(row,setQTY);
    }

}
