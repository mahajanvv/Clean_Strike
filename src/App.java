// import model.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // Player P = new Player();
        // P.get_points();
        try {

            File myObj = new File("./src/model/input1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
