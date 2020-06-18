public class StoreOwner {
    int storeID;
    String storeOwnerName;
    int price;
  double sellingPrice;

    public void requestNewStore(String storeName, String storeOwnerName)
    {}

    public void setItemPrice(int productId, double price)
    {
        double markup = .15;
       sellingPrice = price* markup;
    }
    public void closeStore()//
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
    }


