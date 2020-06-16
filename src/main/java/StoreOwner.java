package Project;

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
    {}

}
