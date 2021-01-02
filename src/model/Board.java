package model;
public class Board {
    private int black_coins;
    private int red_coins;
    public Board(){
        this.black_coins = 0;
        this.red_coins = 0;
    }
    public Board(int black_coins, int red_coins){
        this.black_coins = black_coins;
        this.red_coins = red_coins;
    }
    public void setBlackCoinsCount(int black_coins){
        this.black_coins = black_coins;
    }
    public void setRedCoinsCount(int red_coins){
        this.red_coins = red_coins;
    }
    public int getBlackCoinsCount(){
        return this.black_coins;
    }
    public int getRedCoinsCount(){
        return this.red_coins;
    }
}
