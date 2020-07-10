

import java.io.IOException;
import java.util.*;

public class MallOwner {
    static Scanner scanner = new Scanner(System.in);
    static int input;

    public static Map<String, Integer[]> allStore = new HashMap<>();
    public static Map<String,String> storeOwnerWarnings = new HashMap<>();

    public MallOwner() throws IOException {
        Menu m = new Menu();
        do {
            System.out.println("Please choose an option:" +
                    "\n" + "|(1)to see new store request| \n|(2)to approve a new store request| " +
                    "\n|(3)to send warning to store owner| \n|(4)to close a store| " +
                    "\n|(5)to view current stores list| " +
                    "\n|(6)to view inventory for a store| \n|(7)to logout|");
            input = scanner.nextInt();
            if (input > 0 && input <= 7) {
                switch (input) {
                    case 1:
                        getStoreRequest();
                        m.mallOwnerMenu();
                        break;
                    case 2:
                        setStore();
                        m.mallOwnerMenu();
                        break;
                    case 3:
                        sendWarning();
                        m.mallOwnerMenu();
                        break;
                    case 4:
                        forceStoreClose();
                        m.mallOwnerMenu();
                        break;
                    case 5:
                        getStoreList();
                        m.mallOwnerMenu();
                        break;
                    case 6:
                        getInventory();
                        m.mallOwnerMenu();
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

    public static void getStoreRequest() {
        System.out.println("\nNew Store Request");
        for (Integer names: StoreOwner.storeRequestList.keySet())
        {
            System.out.println(Arrays.toString(StoreOwner.storeRequestList.get(names)));
        }
    }

    public static void setStore () {
            System.out.println("Choose owner to approve");
            String storeOwnerName = scanner.next();
            System.out.println("Name of Store Owner's Store");
            String storeName = scanner.next();
            for (Integer k : StoreOwner.storeRequestList.keySet()) {
                if (StoreOwner.storeRequestList.get(k)[0].contains(storeOwnerName)) {
                    String approveStore;
                    System.out.println("to approve please choose option 'yes' or to reject choose option 'no'");
                    approveStore = scanner.next();
                    if (approveStore.equalsIgnoreCase("yes")) {
                        StoreOwner.storeID++;
                        allStore.put(StoreOwner.storeOwnerName, new Integer[]{StoreOwner.storeID});
                        System.out.println("Approved new store for " + StoreOwner.storeOwnerName + " with the Id : " + StoreOwner.storeID);
                        CreateAccount c = new CreateAccount();
                        c.addAccount("Store Owner",storeOwnerName,storeName);
                    } else if (approveStore.equalsIgnoreCase("no")) {
                        System.out.println("Request for new store by " + StoreOwner.storeOwnerName + " is rejected");

                    }
                } else {
                    System.out.println(storeOwnerName + " has not requested a store");
                }
            }
        }

        public static void sendWarning () {
            System.out.println("Enter Store Name");
            String storeName = scanner.next();
            System.out.println("Enter warning message");
            String message = scanner.next();
            storeOwnerWarnings.put(storeName,message);
        }

        public static void forceStoreClose () {
        CreateAccount c = new CreateAccount();
        c.storeList();
        System.out.println("\nSelect Store to Force Close(Select Row#)");
        int rowRemove = scanner.nextInt();
        c.removeStore(rowRemove);

        }

        public static void getStoreList () {
            CreateAccount c = new CreateAccount();
            c.storeList();
        }

        public static void getInventory() {
        InvSheet i = new InvSheet();
        i.getAllStoreListInv();
    }

        public static void toLogout () throws IOException {
            Menu m1 = new Menu();
            System.out.println("going back to login part");
            m1.mainMenu();
        }
    }


