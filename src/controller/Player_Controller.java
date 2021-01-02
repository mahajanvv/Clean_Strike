package controller;
import model.Player;

public class Player_Controller{
    private Player player;
    public Player_Controller(int id){
        this.player = new Player(id);
    }
    public void Increase_Points(int points){
        int old_points = this.player.get_points();
        int new_points = old_points + points;
        this.player.set_points(new_points);
        
    }
    public void Decrease_Points(int points){
        int old_points = this.player.get_points();
        int new_points = old_points - points;
        this.player.set_points(new_points);
    }
    public void Increase_Fouls_Count(){
        int old_fouls_count = this.player.get_total_fouls_count();
        int new_fouls_count = old_fouls_count + 1;
        this.player.set_total_fouls_count(new_fouls_count);
    }
    public void Increase_Unsuccessful_attempts(){
        int old_attempts = this.player.get_recent_unsuccessful_attempts();
        int new_attempts = old_attempts + 1;
        this.player.set_recent_unsuccessful_attempts(new_attempts);
    }
    public void reset_Unsuccessful_attempts(){
        this.player.set_recent_unsuccessful_attempts(0);
    }
    public int get_Points(){
        return this.player.get_points();
    }
    public int get_Total_Fouls_Count(){
        return this.player.get_total_fouls_count();
    }
    public int get_Recent_Unsuccessful_Attempts_Count(){
        return this.player.get_recent_unsuccessful_attempts();
    }
    public int get_player_id(){
        return this.player.get_id();
    }
}
