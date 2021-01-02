package controller;
import model.Board;
import Constants.Coin_Type;

public class Board_Controller{
    private Board board;
    public Board_Controller(int black_coins_count, int red_coins_count){
        this.board = new Board(black_coins_count, red_coins_count);
    }
    public void Increase_Coins(Coin_Type coin, int count){
        int old_count = 0;
        int new_count = 0;
        switch(coin){
            case RED:
                old_count = this.board.get_red_coins_count();
                new_count = old_count + count;
                this.board.set_red_coins_count(new_count);
                break;
            case BLACK:
                old_count = this.board.get_black_coins_count();
                new_count = old_count + count;
                this.board.set_black_coins_count(new_count);
                break;
        }
    }
    public void Decrease_Coins(Coin_Type coin, int count){
        // It could be redundant if we pass the count as + then using above function we 
        // can increase the count of perticular coin type
        // and if we pass -ve count then it will decrease that count
        int old_count = 0;
        int new_count = 0;
        switch(coin){
            case RED:
                old_count = this.board.get_red_coins_count();
                new_count = old_count - count;
                this.board.set_red_coins_count(new_count);
                break;
            case BLACK:
                old_count = this.board.get_black_coins_count();
                new_count = old_count - count;
                this.board.set_black_coins_count(new_count);
                break;
        }
    }
    public int get_coins_count(Coin_Type coin){
        int coin_count = -1;
        switch(coin){
            case RED:
                coin_count = this.board.get_red_coins_count();
                break;
            case BLACK:
                coin_count =  this.board.get_black_coins_count();
                break;
        }
        return coin_count;
    }
    public boolean Is_Board_Emplty(){
        if(this.board.get_black_coins_count() <= 0 && this.board.get_red_coins_count() <= 0){
            return true;
        }
        return false;
    }
}
