///*
//
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class MallOwnerPractice {
//    static Scanner scanner = new Scanner(System.in);
//    static int input;
//
//    public MallOwnerPractice() {
//        do {
//            System.out.println("Please choose an option:" +
//                    "\n" + "|(1)to see new store request| |(2)to approve a new store request| " +
//                    "|(3)to send warning to store owner| |(4)to close a store| " +
//                    "\n|(5)to view current stores list| " +
//                    "|(6)to view inventory for a store| |(7)to logout|");
//            input = scanner.nextInt();
//            if (input > 0 && input <= 7) {
//                switch (input) {
//                    case 1:
//                        getStoreRequest();
//                        break;
//                    case 2:
//                        setStore();
//                        break;
//                    case 3:
//                        sendWarning();
//                        break;
//                    case 4:
//                        forceStoreClose();
//                        break;
//                    case 5:
//                        getStoreList();
//                        break;
//                    case 6:
//                        getInventory();
//                        break;
//                    case 7:
//                        toLogout();
//                        break;
//                }
//            } else {
//                System.out.println(input + " is not a valid command, choose the right option");
//            }
//        } while (true);
//
//    }
//    public static  void getStoreRequest(){
//        StoreOwner.requestNewStore();
//    }
//    public static void setStore() {
//        String approveStore;
//        System.out.println("to approve please choose option 'yes' || to reject choose option 'no'");
//        approveStore = scanner.next();
//        if (approveStore.equalsIgnoreCase("yes")) {
//            StoreOwner.storeId++;
//            System.out.println("Approved new store for "+ StoreOwner.StoreOwnerName + " with the Id : " + StoreOwner.storeId);
//        } else if (approveStore.equalsIgnoreCase("no")) {
//            System.out.println("Request for new store by " + StoreOwner.StoreOwnerName + " is rejected");
//        }
//    }
//    public static void sendWarning(){
//    String warning;
//        System.out.println("to send a warning to a store choose option 'yes' || else choose option 'no'");
//        warning = scanner.next();
//        if (warning.equalsIgnoreCase("yes")) {
//            String storeWarned;
//            System.out.println("select the 'Store owner's name to send the warning");
//            storeWarned = scanner.next();
//
//        }
//
//    }
//    public static void forceStoreClose(){
//
//    }
//    public static void getStoreList(){
//        Map<String, Integer> allStore = new HashMap<>();
//        allStore.put(StoreOwner.StoreOwnerName, StoreOwner.storeId);
//        System.out.println(allStore);
//    }
//    public static void getInventory(){
//
//    }
//    public static void toLogout(){
//        System.out.println("going back to login part");
//     //   mainManu();
//    }
//}
//*/
