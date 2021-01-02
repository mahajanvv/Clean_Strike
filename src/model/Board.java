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
    public void set_black_coins_count(int black_coins){
        this.black_coins = black_coins;
    }
    public void set_red_coins_count(int red_coins){
        this.red_coins = red_coins;
    }
    public int get_black_coins_count(){
        return this.black_coins;
    }
    public int get_red_coins_count(){
        return this.red_coins;
    }
}
