

import java.util.*;

public class MallOwner {
    static Scanner scanner = new Scanner(System.in);
    static int input;
    //static List<Integer> storeOwnerList = new ArrayList<>();
    public  static Map<String, Integer[]> allStore = new HashMap<>();

    public MallOwner() {
        do {
            System.out.println("Please choose an option:" +
                    "\n" + "|(1)to see new store request| |(2)to approve a new store request| " +
                    "|(3)to send warning to store owner| |(4)to close a store| " +
                    "\n|(5)to view current stores list| " +
                    "|(6)to view inventory for a store| |(7)to logout|");
            input = scanner.nextInt();
            if (input > 0 && input <= 7) {
                switch (input) {
                    case 1:
                        getStoreRequest();
                        break;
                    case 2:
                        setStore();
                        break;
                    case 3:
                        sendWarning();
                        break;
                    case 4:
                        forceStoreClose();
                        break;
                    case 5:
                        getStoreList();
                        break;
                    case 6:
                        getInventory();
                        break;
                    case 7:
                        toLogout();
                        break;
                }
            } else {
                System.out.println(input + " is not a valid command, choose the right option");
            }
        } while (true);

    }
    public void getStoreRequest(){
    StoreOwner s1 = new StoreOwner();
    String name;
    String ownerName;
        System.out.println("select 'store name'");
    name = scanner.next();
        System.out.println("select 'Store owner name'");
    ownerName=scanner.next();
    s1.requestNewStore(name, ownerName);

    }
    public static void setStore() {
       // allStore.put("bob", new Integer[]{22, 23});
        StoreOwner s1 = new StoreOwner();
        String approveStore;
        System.out.println("to approve please choose option 'yes' || to reject choose option 'no'");
        approveStore = scanner.next();
        if (approveStore.equalsIgnoreCase("yes")) {
            s1.storeID++;
            allStore.put(s1.storeOwnerName, new Integer[] {s1.storeID});
            System.out.println("Approved new store for "+ s1.storeOwnerName + " with the Id : " + s1.storeID);
        } else if (approveStore.equalsIgnoreCase("no")) {
            System.out.println("Request for new store by " + s1.storeOwnerName + " is rejected");
        }
    }
    public static void sendWarning(){
    String warning;
        System.out.println("to send a warning to a store choose option 'yes' || else choose option 'no'");
        warning = scanner.next();
        if (warning.equalsIgnoreCase("yes")) {
            String storeWarned;
            System.out.println("select the 'Store owner's name to send the warning");
            storeWarned = scanner.next();

        }

    }
    public static void forceStoreClose(){
        String toClose;
        System.out.println("select the 'Store owner's name to close store");
        toClose= scanner.next();
        StoreOwner s1 = new StoreOwner();
     //   s1.closeStore();
    }
    public static void getStoreList(){
        StoreOwner s1 = new StoreOwner();


        System.out.println(allStore);
    }
    public static void getInventory(){
        Inventory i1 = new Inventory();

        System.out.println(i1.storeInventory);
    }
    public static void toLogout(){
        Menu m1 = new Menu();
        System.out.println("going back to login part");
     m1.mainMenu();
    }
}
