package controller;
import constants.Coin_Type;
import model.Board;
// This class is handling all types of modifications that can occur on Board.
// such as Increasing coins count, decreasing coins count, etc...
public class Board_Controller{
    private Board board;
    public Board_Controller(int black_coins_count, int red_coins_count){
        this.board = new Board(black_coins_count, red_coins_count);
    }
    public void increaseCoins(Coin_Type coin, int count){
        int old_count = 0;
        int new_count = 0;
        switch(coin){
            case RED:
                old_count = this.board.getRedCoinsCount();
                new_count = old_count + count;
                this.board.setRedCoinsCount(new_count);
                break;
            case BLACK:
                old_count = this.board.getBlackCoinsCount();
                new_count = old_count + count;
                this.board.setBlackCoinsCount(new_count);
                break;
        }
    }
    public void decreaseCoins(Coin_Type coin, int count){
        // It could be redundant if we pass the count as + then using above function we 
        // can increase the count of perticular coin type
        // and if we pass -ve count then it will decrease that count
        int old_count = 0;
        int new_count = 0;
        switch(coin){
            case RED:
                old_count = this.board.getRedCoinsCount();
                new_count = old_count - count;
                this.board.setRedCoinsCount(new_count);
                break;
            case BLACK:
                old_count = this.board.getBlackCoinsCount();
                new_count = old_count - count;
                this.board.setBlackCoinsCount(new_count);
                break;
        }
    }
    public int getCoinsCount(Coin_Type coin){
        int coin_count = -1;
        switch(coin){
            case RED:
                coin_count = this.board.getRedCoinsCount();
                break;
            case BLACK:
                coin_count =  this.board.getBlackCoinsCount();
                break;
        }
        return coin_count;
    }
    public boolean isBoardEmpty(){
        if(this.board.getBlackCoinsCount() <= 0 && this.board.getRedCoinsCount() <= 0){
            return true;
        }
        return false;
    }
}
