package controller;
import model.Player;
// This class is handling all kind modifications that can happen on Player Object.
// such as increasing points, decreasing points, increasing fouls count, etc...
public class Player_Controller{
    private Player player;
    public Player_Controller(int id){
        this.player = new Player(id);
    }
    public void increasePoints(int points){
        int old_points = this.player.getPoints();
        int new_points = old_points + points;
        this.player.setPoints(new_points);
        
    }
    public void decreasePoints(int points){
        int old_points = this.player.getPoints();
        int new_points = old_points - points;
        this.player.setPoints(new_points);
    }
    public void increaseFoulsCount(){
        int old_fouls_count = this.player.getTotalFoulsCount();
        int new_fouls_count = old_fouls_count + 1;
        this.player.setTotalFoulsCount(new_fouls_count);
    }
    public void increaseUnsuccessfulAttempts(){
        int old_attempts = this.player.getRecentUnsuccessfulAttempts();
        int new_attempts = old_attempts + 1;
        this.player.setRecentUnsuccessfulAttempts(new_attempts);
    }
    public void resetUnsuccessfulAttempts(){
        this.player.setRecentUnsuccessfulAttempts(0);
    }
    public int getPoints(){
        return this.player.getPoints();
    }
    public int getTotalFoulsCount(){
        return this.player.getTotalFoulsCount();
    }
    public int getRecentUnsuccessfulAttemptsCount(){
        return this.player.getRecentUnsuccessfulAttempts();
    }
    public int getPlayerId(){
        return this.player.getId();
    }
}
