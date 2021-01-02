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
    public void set_points(int points){
        this.points = points;
    }
    public void set_id(int id){
        this.id = id;
    }
    public void set_total_fouls_count(int total_fouls_count){
        this.total_fouls_count = total_fouls_count;
    }
    public void set_recent_unsuccessful_attempts(int recent_unsuccessful_attempts){
        this.recent_unsuccessful_attempts = recent_unsuccessful_attempts;
    }
    public int get_points(){
        return this.points;
    }
    public int get_total_fouls_count(){
        return this.total_fouls_count;
    }
    public int get_recent_unsuccessful_attempts(){
        return this.recent_unsuccessful_attempts;
    }
    public int get_id(){
        return this.id;
    }
}