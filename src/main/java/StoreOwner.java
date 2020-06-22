public class StoreOwner {
    static int storeID=1;
    String storeOwnerName;
    String storeName;
    int price;
  double sellingPrice;


    public void requestNewStore()
    {
        ++storeID;
        System.out.println("Hello " + storeOwnerName + ", Welcome to XYZ mall. congrats on opening of "+ storeName);
    }

    public StoreOwner(String storeName, String storeOwnerName)
    {
        this.storeOwnerName = storeOwnerName;
        this.storeName = storeName;
    }


    public void closeStore()
    {}
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
       public static void Main()
       {
           StoreOwner S1 = new StoreOwner("Facebook","Bob");
           S1.requestNewStore();
       }
    }


