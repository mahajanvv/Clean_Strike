import controller.Player_Controller;

public class Test_Player_Controller {
    private static boolean test_Decrease_Points(Player_Controller player){
        // Test-1 checking with the value 0
            // Value Before points = 0
        player.Decrease_Points(0);
        if(player.get_Points() != 0){
            System.out.println("Test-1 checking with the value 0 is Failed");
            return false;
        }
        System.out.println("Test-1 checking with the value 0 is Passed");
            // Value After points = 0
        // Test-2 Checking for value 50
            // Value Before points = 0
        player.Decrease_Points(50);
        if(player.get_Points() != -50){
            System.out.println("Test-2 Checking for value 50 is Failed");
            return false;
        }
        System.out.println("Test-2 Checking for value 50 is Passed");
            // Value after points = -50
        return true;
    }
    private static boolean test_Increase_Fouls_Count(Player_Controller player){
        // Test1 calling increase fouls count function
            // Value before fouls_count = 0
        player.Increase_Fouls_Count();
        if(player.get_Total_Fouls_Count() != 1){
            System.out.println("Test-1 calling increase fouls count function is Failed");
            return false;
        }
        System.out.println("Test-1 calling increase fouls count function is Passed");
            // Value after fouls_count = 1
        // Test2 calling increase fouls count function
            // Value before fouls_count = 1
        player.Increase_Fouls_Count();
        if(player.get_Total_Fouls_Count() != 2){
            System.out.println("Test-2 calling increase fouls count function is Failed");
            return false;
        }
        System.out.println("Test-2 calling increase fouls count function is Passed");
            // Value after fouls_count = 2
        return true;
    }
    private static boolean test_Increase_Points(Player_Controller player){
        // Test-1 Increase points by 0
            // Value Before points = 0
            player.Increase_Points(0);
            if(player.get_Points() != 0){
                System.out.println("Test-1 Increase Points by 0 is Failed");
                return false;
            }
            System.out.println("Test-1 Increase Points by 0 is Passed");
                // Value After points = 0
            // Test-2 Increase Points by 50
                // Value Before points = 0
            player.Increase_Points(50);
            if(player.get_Points() != 50){
                System.out.println("Test-2 Increase Points by 50 is Failed");
                return false;
            }
            System.out.println("Test-2 Increase Points by 50 is Passed");
                // Value after points = 50
        return true;
    }
    private static boolean test_Increase_Unsuccessful_attempts(Player_Controller player){
        // Test-1 calling Increase_Unsuccessful_attempts twice
            // Value before 0
        player.Increase_Unsuccessful_attempts();
        player.Increase_Unsuccessful_attempts();
        if(player.get_Recent_Unsuccessful_Attempts_Count() != 2){
            System.out.println("Test-1 calling Increase_Unsuccessful_attempts twice is Falied");
            return false;
        }
        System.out.println("Test-1 calling Increase_Unsuccessful_attempts twice is Passed");
            // Value after 2
        // Test-2 calling Increase_Unsuccessful_attempts once
            // Value before 2
        player.Increase_Unsuccessful_attempts();
        if(player.get_Recent_Unsuccessful_Attempts_Count() != 3){
            System.out.println("Test-2 calling Increase_Unsuccessful_attempts once is Failed");
            return false;
        }
        System.out.println("Test-2 calling Increase_Unsuccessful_attempts once is Passed");
            // Value after 3
        return true;
    }
    public static void main(String [] args){
        Player_Controller player = new Player_Controller(0);
        System.out.println("Running test_suite-> test_Decrease_Points");
        boolean test1 = test_Decrease_Points(player);
        if(test1){
            System.out.println("test_suite-> test_Decrease_Points is Passed");
        }else{
            System.out.println("test_suite-> test_Decrease_Points is Failed");
        }
        player = new Player_Controller(0);
        System.out.println("Running test_suite-> test_Increase_Fouls_Count");
        boolean test2 = test_Increase_Fouls_Count(player);
        if(test2){
            System.out.println("test_suite-> test_Increase_Fouls_Count is Passed");
        }else{
            System.out.println("test_suite-> test_Increase_Fouls_Count is Failed");
        }
        player = new Player_Controller(0);
        System.out.println("Running test_suite-> test_Increase_Points");
        boolean test3 = test_Increase_Points(player);
        if(test3){
            System.out.println("test_suite-> test_Increase_Points is Passed");
        }else{
            System.out.println("test_suite-> test_Increase_Points is Failed");
        }
        player = new Player_Controller(0);
        System.out.println("Running test_suite-> test_Increase_Unsuccessful_attempts");
        boolean test4 = test_Increase_Unsuccessful_attempts(player);
        if(test4){
            System.out.println("test_suite-> test_Increase_Unsuccessful_attempts is Passed");
        }else{
            System.out.println("test_suite-> test_Increase_Unsuccessful_attempts is Failed");
        }
    }    
}
