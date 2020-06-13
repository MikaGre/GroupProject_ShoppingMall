import java.util.*;

public class ShoppingCart {
Scanner scanner = new Scanner(System.in);
private int cartID = 0000;
 Map<Integer,Object[]> cart = new HashMap<>();


public ShoppingCart (String productName,int productID, int quantity){
 this.cart.put(cartID++,new Object[]{productName,productID,quantity});
}

 public ShoppingCart() {};

 public void addItemToCart (String productName,int productID, int quantity) {
  this.cart.put(this.cartID,new Object[]{productName,productID,quantity});
 }

 public void removeItemToCart (int cartID ) {
   this.cart.remove(cartID);
 }

 public void setItemQuantity (String productName,int productID, int quantity) {
 this.cart.put(this.cartID,new Object[]{productName,productID,quantity});
 }

 public void getShoppingCart () {
   this.cart.forEach((k,v) -> System.out.println(k + Arrays.toString(v)));
  }
 }

