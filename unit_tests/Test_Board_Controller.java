// Here testing of all the fucntions related to decreasing count of coins 
// and increasing count of coins

import Constants.Coin_Type;
import controller.Board_Controller;
public class Test_Board_Controller {
    private static boolean Test_increaseCoins_Count(Board_Controller board){
        // Test-1 Increasing Black coins count by 10
            // Before value = 0
        board.increaseCoins(Coin_Type.BLACK, 10);
        if(board.getCoinsCount(Coin_Type.BLACK) != 10){
            System.out.println("Test-1 Increasing Black coins count by 10 is Failed");
            return false;
        }
        System.out.println("Test-1 Increasing Black coins count by 10 is Passed");
            // After value = 10
        // Test-2 Increasing Red Coins count by 2
            // Before value = 0
        board.increaseCoins(Coin_Type.RED, 2);
        if(board.getCoinsCount(Coin_Type.RED) != 2){
            System.out.println("Test-2 Increasing red coins count by 2 is Failed");
            return false;
        }
        System.out.println("Test-2 Increasing red coins count by 2 is Passed");
            // After value = 2
        return true;
    }
    private static boolean Test_decreaseCoins_Count(Board_Controller board){
        // Test-1 Decreasing Black coins count by 2
            // Before value = 9
        board.decreaseCoins(Coin_Type.BLACK, 2);
        if(board.getCoinsCount(Coin_Type.BLACK) != 7){
            System.out.println("Test-1 Decreasing Black coins count by 2 is Failed");
            return false;
        }
        System.out.println("Test-1 Decreasing Black coins count by 2 is Passed");
            // After value = 7
        // Test-2 Decreasing Red Coins Count by 1
            // Before value = 1
        board.decreaseCoins(Coin_Type.RED, 1);
        if(board.getCoinsCount(Coin_Type.RED) != 0){
            System.out.println("Test-2 Decreasing Red Coins Count by 1 is Failed");
            return false;
        }
        System.out.println("Test-2 Decreasing Red Coins Count by 1 is Passed");
            // After value = 0
        return true;
    }

    public static void main(String []args){
        // Test Suite Increase Count of coins
        System.out.println("Running Test Suite Increase Count of coins");
        Board_Controller board = new Board_Controller(0, 0);
        boolean test1 = Test_increaseCoins_Count(board);
        if(test1){
            System.out.println("Test Suite Increase Count of coins is Passed");
        }else{
            System.out.println("Test Suite Increase Count of coins is Failed");
        }
        // Test Suite Decrease Count of coins
        System.out.println("Running Test Suite Decrease Count of coins");
        board = new Board_Controller(9, 1);
        boolean test2 = Test_decreaseCoins_Count(board);
        if(test2){
            System.out.println("Test Suite Decrease Count of coins is Passed");
        }else{
            System.out.println("Test Suite Decrease Count of coins is Failed");
        }
    }
}
