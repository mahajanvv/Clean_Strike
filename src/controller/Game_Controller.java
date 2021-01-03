package controller;
import constants.Coin_Type;
import constants.Game_Constants;
import constants.Points;

// This class is used to make a move on the board for a particular player.
// This class will change the state of board and also calls for Player_Controller
// which will change the state of player. either by increasing points or by decreasing 
// points.
public class Game_Controller{
    private Board_Controller board;
    public Game_Controller(int black_coins_count, int red_coins_count){
        this.board = new Board_Controller(black_coins_count, red_coins_count);
    }
    public void strike(Player_Controller player){
        // Black coins count is decreased by one and player gets one point
        this.board.decreaseCoins(Coin_Type.BLACK, 1);
        player.increasePoints(Points.STRIKE_POINTS);
        player.resetUnsuccessfulAttempts();
    }
    public void multiStrike(Player_Controller player, int count){
        // Black coins count decreased by two and Player gets two points
        this.board.decreaseCoins(Coin_Type.BLACK, Game_Constants.MAX_COINS_ACCEPTED_IN_MULTI_STRIKE_MOVE);
        player.increasePoints(Points.MULTI_STRIKE_POINTS);
        player.resetUnsuccessfulAttempts();
    }
    public void redStrike(Player_Controller player){
        // Red coins count decreased by one and Player gets three points
        this.board.decreaseCoins(Coin_Type.RED, 1);
        player.increasePoints(Points.RED_STRIKE_POINTS);
        player.resetUnsuccessfulAttempts();
    }
    public void strikerStrike(Player_Controller player){
        // Player loses one point
        player.decreasePoints(Points.STRIKER_STRIKE_POINTS);
        player.increaseUnsuccessfulAttempts();
        if(player.getRecentUnsuccessfulAttemptsCount()>=3){
            player.decreasePoints(Points.UNSUCCESSFUL_ATTEMPTS_POINTS);
            player.increaseFoulsCount();
        }
        player.increaseFoulsCount();
        if(player.getTotalFoulsCount() >= 3){
            player.decreasePoints(Points.FOUL_POINTS);
        }
    }
    public void defunctCoin(Player_Controller player, Coin_Type coin){
        // Here coin goes out of play the coin might be red or black
        // and player loses 2 points
        this.board.decreaseCoins(coin, 1);
        player.decreasePoints(Points.DEFUNCT_STRIKE_POINTS);
        player.increaseUnsuccessfulAttempts();
        if(player.getRecentUnsuccessfulAttemptsCount()>=3){
            player.decreasePoints(Points.UNSUCCESSFUL_ATTEMPTS_POINTS);
            player.increaseFoulsCount();
        }
        player.increaseFoulsCount();
        if(player.getTotalFoulsCount() >= 3){
            player.decreasePoints(Points.FOUL_POINTS);
        }
    }
    public void none(Player_Controller player){
        player.increaseUnsuccessfulAttempts();
        if(player.getRecentUnsuccessfulAttemptsCount()>=3){
            player.decreasePoints(Points.UNSUCCESSFUL_ATTEMPTS_POINTS);
            player.increaseFoulsCount();
        }
        if(player.getTotalFoulsCount() >= 3){
            player.decreasePoints(Points.FOUL_POINTS);
        }
    }
    public boolean isBoardEmpty(){
        return this.board.isBoardEmpty();
    }
    public int getCoinsCount(Coin_Type coin){
        return this.board.getCoinsCount(coin);
    }
}
