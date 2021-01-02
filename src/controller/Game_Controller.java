package controller;

import Constants.Coin_Type;
import Constants.Game_Constants;
import Constants.Points;
// What if coins exhausted write some exception handling cases
public class Game_Controller implements Points{
    private Board_Controller board;
    public Game_Controller(int black_coins_count, int red_coins_count){
        this.board = new Board_Controller(black_coins_count, red_coins_count);
    }
    public void Strike(Player_Controller player){
        // Black coins count is decreased by one and player gets one point
        this.board.Decrease_Coins(Coin_Type.BLACK, 1);
        player.Increase_Points(Points.Strike_Points);
        player.reset_Unsuccessful_attempts();
    }
    public void Multi_Strike(Player_Controller player, int count){
        // Black coins count decreased by two and Player gets two points
        this.board.Decrease_Coins(Coin_Type.BLACK, Game_Constants.max_number_of_coins_accepted);
        player.Increase_Points(Points.Multi_Strike_Points);
        player.reset_Unsuccessful_attempts();
    }
    public void Red_Strike(Player_Controller player){
        // Red coins count decreased by one and Player gets three points
        this.board.Decrease_Coins(Coin_Type.RED, 1);
        player.Increase_Points(Points.Red_Strike_Points);
        player.reset_Unsuccessful_attempts();
    }
    public void Striker_Strike(Player_Controller player){
        // Player loses one point
        player.Decrease_Points(Points.Strike_Points);
        player.Increase_Unsuccessful_attempts();
        if(player.get_Recent_Unsuccessful_Attempts_Count()>=3){
            player.Decrease_Points(Points.Unscuccessful_Attempts_Points);
            player.Increase_Fouls_Count();
        }
        player.Increase_Fouls_Count();
        if(player.get_Total_Fouls_Count() >= 3){
            player.Decrease_Points(Points.Foul_Points);
        }
    }
    public void Defunct_Coin(Player_Controller player, Coin_Type coin){
        // Here coin goes out of play the coin might be red or black
        // and player loses 2 points
        this.board.Decrease_Coins(coin, 1);
        player.Decrease_Points(Points.Defunct_Strike_Points);
        player.Increase_Unsuccessful_attempts();
        if(player.get_Recent_Unsuccessful_Attempts_Count()>=3){
            player.Decrease_Points(Points.Unscuccessful_Attempts_Points);
            player.Increase_Fouls_Count();
        }
        player.Increase_Fouls_Count();
        if(player.get_Total_Fouls_Count() >= 3){
            player.Decrease_Points(Points.Foul_Points);
        }
    }
    public void None(Player_Controller player){
        player.Increase_Unsuccessful_attempts();
        if(player.get_Recent_Unsuccessful_Attempts_Count()>=3){
            player.Decrease_Points(Points.Unscuccessful_Attempts_Points);
            player.Increase_Fouls_Count();
        }
        if(player.get_Total_Fouls_Count() >= 3){
            player.Decrease_Points(Points.Foul_Points);
        }
    }
    public boolean Is_Board_Empty(){
        return this.board.Is_Board_Emplty();
    }
    public int get_coins_count(Coin_Type coin){
        return this.board.get_coins_count(coin);
    }
}
