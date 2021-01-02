package model;

public class Player{
    private int id;
    private int points;
    private int total_fouls_count;
    private int recent_unsuccessful_attempts;
    public Player(int id){
        this.id = id;
        this.points = 0;
        this.total_fouls_count = 0;
        this.recent_unsuccessful_attempts = 0;
    }
    public void setPoints(int points){
        this.points = points;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setTotalFoulsCount(int total_fouls_count){
        this.total_fouls_count = total_fouls_count;
    }
    public void setRecentUnsuccessfulAttempts(int recent_unsuccessful_attempts){
        this.recent_unsuccessful_attempts = recent_unsuccessful_attempts;
    }
    public int getPoints(){
        return this.points;
    }
    public int getTotalFoulsCount(){
        return this.total_fouls_count;
    }
    public int getRecentUnsuccessfulAttempts(){
        return this.recent_unsuccessful_attempts;
    }
    public int getId(){
        return this.id;
    }
}