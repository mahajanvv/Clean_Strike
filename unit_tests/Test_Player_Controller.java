// Here testing of players points, fouls count and unsuccessfull attempts count 
// Is working fine or not

import controller.Player_Controller;

public class Test_Player_Controller {
    private static boolean test_decreasePoints(Player_Controller player){
        // Test-1 checking with the value 0
            // Value Before points = 0
        player.decreasePoints(0);
        if(player.getPoints() != 0){
            System.out.println("Test-1 checking with the value 0 is Failed");
            return false;
        }
        System.out.println("Test-1 checking with the value 0 is Passed");
            // Value After points = 0
        // Test-2 Checking for value 50
            // Value Before points = 0
        player.decreasePoints(50);
        if(player.getPoints() != -50){
            System.out.println("Test-2 Checking for value 50 is Failed");
            return false;
        }
        System.out.println("Test-2 Checking for value 50 is Passed");
            // Value after points = -50
        return true;
    }
    private static boolean test_increaseFoulsCount(Player_Controller player){
        // Test1 calling increase fouls count function
            // Value before fouls_count = 0
        player.increaseFoulsCount();
        if(player.getTotalFoulsCount() != 1){
            System.out.println("Test-1 calling increase fouls count function is Failed");
            return false;
        }
        System.out.println("Test-1 calling increase fouls count function is Passed");
            // Value after fouls_count = 1
        // Test2 calling increase fouls count function
            // Value before fouls_count = 1
        player.increaseFoulsCount();
        if(player.getTotalFoulsCount() != 2){
            System.out.println("Test-2 calling increase fouls count function is Failed");
            return false;
        }
        System.out.println("Test-2 calling increase fouls count function is Passed");
            // Value after fouls_count = 2
        return true;
    }
    private static boolean test_increasePoints(Player_Controller player){
        // Test-1 Increase points by 0
            // Value Before points = 0
            player.increasePoints(0);
            if(player.getPoints() != 0){
                System.out.println("Test-1 Increase Points by 0 is Failed");
                return false;
            }
            System.out.println("Test-1 Increase Points by 0 is Passed");
                // Value After points = 0
            // Test-2 Increase Points by 50
                // Value Before points = 0
            player.increasePoints(50);
            if(player.getPoints() != 50){
                System.out.println("Test-2 Increase Points by 50 is Failed");
                return false;
            }
            System.out.println("Test-2 Increase Points by 50 is Passed");
                // Value after points = 50
        return true;
    }
    private static boolean test_increaseUnsuccessfulAttempts(Player_Controller player){
        // Test-1 calling increaseUnsuccessfulAttempts twice
            // Value before 0
        player.increaseUnsuccessfulAttempts();
        player.increaseUnsuccessfulAttempts();
        if(player.getRecentUnsuccessfulAttemptsCount() != 2){
            System.out.println("Test-1 calling increaseUnsuccessfulAttempts twice is Falied");
            return false;
        }
        System.out.println("Test-1 calling increaseUnsuccessfulAttempts twice is Passed");
            // Value after 2
        // Test-2 calling increaseUnsuccessfulAttempts once
            // Value before 2
        player.increaseUnsuccessfulAttempts();
        if(player.getRecentUnsuccessfulAttemptsCount() != 3){
            System.out.println("Test-2 calling increaseUnsuccessfulAttempts once is Failed");
            return false;
        }
        System.out.println("Test-2 calling increaseUnsuccessfulAttempts once is Passed");
            // Value after 3
        return true;
    }
    public static void main(String [] args){
        Player_Controller player = new Player_Controller(0);
        System.out.println("Running test_suite-> test_decreasePoints");
        boolean test1 = test_decreasePoints(player);
        if(test1){
            System.out.println("test_suite-> test_decreasePoints is Passed");
        }else{
            System.out.println("test_suite-> test_decreasePoints is Failed");
        }
        player = new Player_Controller(0);
        System.out.println("Running test_suite-> test_increaseFoulsCount");
        boolean test2 = test_increaseFoulsCount(player);
        if(test2){
            System.out.println("test_suite-> test_increaseFoulsCount is Passed");
        }else{
            System.out.println("test_suite-> test_increaseFoulsCount is Failed");
        }
        player = new Player_Controller(0);
        System.out.println("Running test_suite-> test_increasePoints");
        boolean test3 = test_increasePoints(player);
        if(test3){
            System.out.println("test_suite-> test_increasePoints is Passed");
        }else{
            System.out.println("test_suite-> test_increasePoints is Failed");
        }
        player = new Player_Controller(0);
        System.out.println("Running test_suite-> test_increaseUnsuccessfulAttempts");
        boolean test4 = test_increaseUnsuccessfulAttempts(player);
        if(test4){
            System.out.println("test_suite-> test_increaseUnsuccessfulAttempts is Passed");
        }else{
            System.out.println("test_suite-> test_increaseUnsuccessfulAttempts is Failed");
        }
    }    
}
