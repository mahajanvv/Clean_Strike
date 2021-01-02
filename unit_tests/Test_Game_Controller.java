// Here testing of all the possible moves of a player is being done

import Constants.Coin_Type;
import controller.Game_Controller;
import controller.Player_Controller;

public class Test_Game_Controller {
    private static boolean Test_Strike(Game_Controller game){
        // Test Playing a Strike move
            // Before values => Player points = 0 and Black coins = 9
        Player_Controller player = new Player_Controller(0);
        game.strike(player);
        if(player.getPoints() != 1 && game.getCoinsCount(Coin_Type.BLACK) != 8){
            System.out.println("Test Playing a Strike move is Failed");
            return false;
        }
        System.out.println("Test Playing a Strike move is Passed");
            // Before values => Player points = 1 and Black coins = 8
        return true;
    }
    private static boolean Test_Multi_Strike(Game_Controller game){
        // Test Playing a multi strike move
            // Before values => Player points = 0 and Black coins = 9
        Player_Controller player = new Player_Controller(0);
        game.multiStrike(player, 4);
        if(player.getPoints() != 2 && game.getCoinsCount(Coin_Type.BLACK) != 7){
            System.out.println("Test Playing a multi strike move is Failed");
            return false;
        }
        System.out.println("Test Playing a multi strike move is Passed");
            // After values => player points = 2 and Black coins = 7
        return true;
    }
    private static boolean Test_Defunct_Coin(Game_Controller game){
        Player_Controller player = new Player_Controller(0);
        // Test1 playing a defunct move on black coin 
            // Before values => player points = 0 and Black coins = 9
        game.defunctCoin(player, Coin_Type.BLACK);
        if(player.getPoints() != -2 && player.getTotalFoulsCount() != 1 
            && player.getRecentUnsuccessfulAttemptsCount() != 1 && game.getCoinsCount(Coin_Type.BLACK) != 9){
            System.out.println("Test1 playing a defunct move on black coin is Failed");
            return false;                
        }
        System.out.println("Test1 playing a defunct move on black coin is Passed");
            // After values => player points = -2 and Black coins = 9
        // Test2 playing a defunct move on red coin
            // Before values => player points = -2, fouls = 1, unsuccessful_attempts = 1 and red_coins = 1
        game.defunctCoin(player, Coin_Type.RED);
        if(player.getPoints() != -4 && player.getRecentUnsuccessfulAttemptsCount() != 2 
            && player.getTotalFoulsCount() != 2 && game.getCoinsCount(Coin_Type.RED) != 1){
            System.out.println("Test2 playing a defunct move on red coin is Failed");
            return false;
        }
        System.out.println("Test2 playing a defunct move on red coin is Passed");
            // After values => player points = -4, fouls = 2, unsuccessful_attempts = 2 and red_coins = 1
        return true;
    }
    private static boolean Test_None(Game_Controller game){
        Player_Controller player = new Player_Controller(0);
        // Test playing None move 
            // Before values => board red_coins = 9 and black_coins = 1 and player unsuccessful_attempts = 0
        game.none(player);
        if(player.getRecentUnsuccessfulAttemptsCount() != 1 && game.getCoinsCount(Coin_Type.BLACK) != 9 
            && game.getCoinsCount(Coin_Type.RED) != 1 && player.getTotalFoulsCount() != 0 
            && player.getPoints() != 0){
            System.out.println("Test playing None move is Failed");
            return false;
        }
        System.out.println("Test playing None move is Passed");
            // Before values => board red_coins = 9 and black_coins = 1 and player unsuccessful_attempts = 1
        
        return true;
    }
    private static boolean Test_Red_Strike(Game_Controller game){
        Player_Controller player = new Player_Controller(0);
        // Test playing Red_Strike move
        game.redStrike(player);
            // Before values => player points = 0, red_coins = 1
        if(player.getPoints() != 2 && game.getCoinsCount(Coin_Type.RED) != 0){
            System.out.println("Test playing Red_Strike move is Failed");
            return false;
        }
        System.out.println("Test playing Red_Strike move is Passed");
            // After values => player points = 2, red_coins = 0
        return true;
    }
    public static void main(String[] args) {
        // Test Suite-> Test_Strike Function
        System.out.println("Running Test_Strike Function");
        Game_Controller game = new Game_Controller(9, 1);
        boolean test1 = Test_Strike(game);
        if(test1){
            System.out.println(" Test_Strike Function is Passed");
        }else{
            System.out.println(" Test_Strike Function is Failed");
        }
        // Test Suite => Testing Defunct Coin move
        game = new Game_Controller(9, 1);
        System.out.println("Running Testing Defunct Coin move");
        boolean test2 = Test_Defunct_Coin(game);
        if(test2){
            System.out.println("Testing Defunct Coin move is Passed");
        }else{
            System.out.println("Testing Defunct Coin move is Failed");
        }
        // Test Suite => Testing MultiStrike move
        game = new Game_Controller(9, 1);
        System.out.println("Running Testing MultiStrike move");
        boolean test3 = Test_Multi_Strike(game);
        if(test3){
            System.out.println("Testing MultiStrike move is Passed");
        }else{
            System.out.println("Testing MultiStrike move is Failed");
        }
        // Test Suite => Testing None move
        game = new Game_Controller(9, 1);
        System.out.println("Running Testing None move");
        boolean test4 = Test_None(game);
        if(test4){
            System.out.println("Testing None move is Passed");
        }else{
            System.out.println("Testing None move is Failed");
        }
        // Test Suite => Testing red strike move
        System.out.println("Running Testing red strike move");
        game = new Game_Controller(9, 1);
        boolean test5 = Test_Red_Strike(game);
        if(test5){
            System.out.println("Testing red strike move is Passed");
        }else{
            System.out.println("Testing red strike move is Failed");
        }
    }
}
