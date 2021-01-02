// This is a driver class. From here all the files from tests->inputs folder are read
// and Match is carried out
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import controller.Match_Controller;

public class App {
    public static void main(String[] args) throws Exception {
      File myObj = new File("./tests/inputs");
      File files[] = myObj.listFiles();
      for(File file: files){
        Match_Controller match = new Match_Controller();
        System.out.println("\n\nReading Inputs From:"+file.getName());
        try{
          Scanner myReader = new Scanner(file);
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            if(match.validateMoveAndPlay(data) == false){
              break;
            }
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        System.out.println("Reading Completed for:"+file.getName()+" \n\n");
      }
    }
}
