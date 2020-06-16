package Project;

public class Inventory {
    public static int productID = 0;
    public String productName;
    //public int quantity;
    int onHandQuantity;
    public int price;
    public int orderQuantity;
    public int requiredQuantity;
    public void addStoreItem(int productID, String productName)
    {
        this.productName = productName;
        int ID = productID++;
        System.out.println("Product Name is "   + productName);

    }
    public void removeStoreItem()
    {

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
    public void getStoreItems(int requiredQuantity, int productID)
    {
        if(onHandQuantity<10)
        {
            this.requiredQuantity = requiredQuantity;
            this.productID = productID;
        }

    }

}
