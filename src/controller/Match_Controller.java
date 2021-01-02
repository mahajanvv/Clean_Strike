package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

import Constants.Coin_Type;
import Constants.Game_Constants;
import Constants.Points;
import Exceptions.InputValidator;
import Exceptions.InvalidMoveException;

public class Match_Controller {
    private PriorityQueue<Player_Controller> players;
    private Game_Controller game;
    private int turn;
    public Match_Controller(){
        this.players = new PriorityQueue<Player_Controller>(new Comparator<Player_Controller>(){
          @Override
          public int compare(Player_Controller p1, Player_Controller p2) {
            return (p1.get_Points() > p2.get_Points() ) ? -1: (p1.get_Points() < p2.get_Points()) ? 1:0 ;
          }
        });
        for(int i=0; i<Game_Constants.Number_Of_Players; i++){
          this.players.add(new Player_Controller(i));
        }
        this.game = new Game_Controller(Game_Constants.Black_Coins_Count, Game_Constants.Red_Coins_Count);
        this.turn = 0;
    }
    public Player_Controller find(int id){
      for(Player_Controller player : this.players){
        if(player.get_player_id() == id){
          return player;
        }
      }
      return null;
    }
    public Player_Controller getPlayer(){
      int turn = this.turn;
      int number_of_players = Game_Constants.Number_Of_Players;
      if(turn%number_of_players == 0) {
        turn = 0;
      }else{
        turn = turn%number_of_players;
      }
      Player_Controller player = find(turn);
      return player;
    }
    public void getStateOfPlayer(Player_Controller player){
      String str = "";
      str += "Player ID:"+player.get_player_id()+"Points-> "+player.get_Points()+" Total_Fouls_Count-> "+ player.get_Total_Fouls_Count()+ " Recent_Unsuccessful_Attempts_Count -> "+ player.get_Recent_Unsuccessful_Attempts_Count();
      
      System.out.println(str);
    }
    public Player_Controller Calculate_Winner(){
      Player_Controller player1 = this.players.poll();
      Player_Controller player2 = this.players.poll();
      System.out.println("Player1:"+player1.get_player_id()+" Player2:"+player2.get_player_id());
      this.players.add(player1);
      this.players.add(player2);
      if(player1.get_Points() >= player2.get_Points()+Points.Minimum_Diff_Points && player1.get_Points() >= Points.Minimum_Points_Required){
        return player1;
      }else if(this.game.Is_Board_Empty() == true){
        if(player1.get_Points() >= player2.get_Points()+Points.Minimum_Diff_Points || player1.get_Points() >= Points.Minimum_Points_Required){
          return player1;
        }
      }
      return null;
    }
    public void Change_Turn(){
      int turn = this.turn;
      turn++;
      this.turn = turn%Game_Constants.Number_Of_Players;
    }
    public boolean Play(String input_command){
      String[] inputs = input_command.split(" ");
      String move = inputs[0];
      Player_Controller player = getPlayer();
      this.players.remove(player);
      switch(move){
        case "STRIKE":
          this.game.Strike(player);
          break;
        case "MULTI_STRIKE":
          // We should take one more input that is count of striked coins
          this.game.Multi_Strike(player, Integer.parseInt(inputs[1]));
          break;
        case "RED_STRIKE":
          this.game.Red_Strike(player);
          break;
        case "NONE":
          this.game.None(player);
          break;
        case "DEFUNCT_COIN":
          switch(inputs[1]){
            case "BLACK":
              this.game.Defunct_Coin(player, Coin_Type.BLACK);
            break;
            case "RED":
              this.game.Defunct_Coin(player, Coin_Type.RED);
            break;
          }
      }
      this.players.add(player);
      getStateOfPlayer(player);
      Change_Turn();
      Player_Controller winner = Calculate_Winner();
      if(winner != null){
        System.out.println("Winner is:"+winner.get_player_id()+" having points:"+winner.get_Points());
        return false;
      }else{
        if(this.game.Is_Board_Empty() == true){
          System.out.println("Match is draw");
          return false;
        }
      }
      return true;
    }
    public static void main(String[] args) {
      Match_Controller match = new Match_Controller();
        try {
            File myObj = new File("./tests/inputs/input2.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(data);
              try{
                InputValidator.validate(data, match.game);
                if(match.Play(data) == false){
                  break;
                }
              }catch(InvalidMoveException e){
                System.out.println("Discarding the current move because of following exception");
                System.out.println(e.getMessage());
              }
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
