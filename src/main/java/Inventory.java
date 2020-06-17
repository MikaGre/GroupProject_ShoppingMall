
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    public static int productID = 0;
    public String productName;
    //public int quantity;
    int onHandQuantity;
    public int price;
    public int orderQuantity;
    public int requiredQuantity;
    int ID;

    public Map<Integer,Object[]> storeInventory = new HashMap<>();
    //Add scanner
    public void addStoreItem(String productName, double price, String brand)
    {
        this.productName = productName;

        ID = productID++;
        System.out.println("Product Name is "   + productName);
        storeInventory.put(ID,new Object[]{"Lip stick", 8.99, "Loreal"});

    }
    public void removeStoreItem()
    {
        storeInventory.remove(ID);

    }

    public void addQuantity(String productName, int productID, int orderQuantity)
    {

        this.orderQuantity = orderQuantity;
        onHandQuantity = onHandQuantity + orderQuantity;
    }
    public void setProductCost()
    {
        int totalCost = price *onHandQuantity;
    }
    public void getStoreItems()
    {
        for(Integer k: storeInventory.keySet())
        {
            System.out.println(storeInventory.get(k));
        }

    }

}
