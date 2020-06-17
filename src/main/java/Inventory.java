
import java.util.*;

public class Inventory {
    public static int productID = 0;
    public String productName;
    //public int quantity;
    int onHandQuantity;
    public int price;
    public int orderQuantity;
    public int requiredQuantity;
    int ID;

     Map<Integer,Object[]> storeInventory = new HashMap<>();
    //Add scanner


    public Inventory (){
        this.storeInventory = new HashMap<>();
    }

    public void addStoreItem(String productName, double price, int onHandQuantity)
    {
        this.productName = productName;
        ID = productID++;
        this.storeInventory.put(ID,new Object[]{productName,price,onHandQuantity});
        //System.out.println("Product Name is "   + productName);
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

    public void getStoreItems() {

        for(Integer k: storeInventory.keySet())
        {
          Object[] itemsInfo = storeInventory.get(k);
            //System.out.println(Arrays.toString(itemsInfo));
            System.out.println("\nProduct Name: " + itemsInfo[0]);
            System.out.println("Price: $" + itemsInfo[1]);
            System.out.println("Qty: " + itemsInfo[2]);
        }
      }
    }


