import java.io.IOException;
import java.util.Scanner;

public class MainApp {

    //Scanner scanner = new Scanner(System.in);
    public static void main (String[] args) throws IOException {

        do {
            Menu menu = new Menu();
            menu.mainMenu();
        }while (true);


    }
}
