import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CreateAccount {
    Scanner scanner = new Scanner(System.in);


    public static void main (String[] args) {
        Map<Integer,Object[]> userData = new HashMap<Integer, Object[]>();
        userData.put(1, new Object[]{"ID","AccountType","Customer Name", "Password" });
        userData.put(2, new Object[]{1,"Customer","Bob Blue", "Password123"});
    }


}
