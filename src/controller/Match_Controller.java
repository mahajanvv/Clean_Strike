package controller;
import java.util.Comparator;
import java.util.PriorityQueue;
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
            return (p1.getPoints() > p2.getPoints() ) ? -1: (p1.getPoints() < p2.getPoints()) ? 1:0 ;
          }
        });
        for(int i=0; i<Game_Constants.NUMBER_OF_PLAYERS; i++){
          this.players.add(new Player_Controller(i));
        }
        this.game = new Game_Controller(Game_Constants.BLACK_COINS_COUNT, Game_Constants.RED_COINS_COUNT);
        this.turn = 0;
    }
    public Player_Controller find(int id){
      for(Player_Controller player : this.players){
        if(player.getPlayerId() == id){
          return player;
        }
      }
      return null;
    }
    public Player_Controller getPlayer(){
      int turn = this.turn;
      int NUMBER_OF_PLAYERS = Game_Constants.NUMBER_OF_PLAYERS;
      if(turn%NUMBER_OF_PLAYERS == 0) {
        turn = 0;
      }else{
        turn = turn%NUMBER_OF_PLAYERS;
      }
      Player_Controller player = find(turn);
      return player;
    }
    public String getStateOfPlayer(Player_Controller player){
      String str = "";
      str += "Player ID:"+player.getPlayerId()+" Points-> "+player.getPoints()+" Total_Fouls_Count-> "+ player.getTotalFoulsCount()+ " Recent_Unsuccessful_Attempts_Count -> "+ player.getRecentUnsuccessfulAttemptsCount();
      return str;
    }
    public String getStateOfGame(){
      String str="";
      str += "Black_Coins Count:"+this.game.getCoinsCount(Coin_Type.BLACK) +" Red_Coins Count:"+this.game.getCoinsCount(Coin_Type.RED);
      return str;
    }
    public Player_Controller calculateWinner(){
      Player_Controller player1 = this.players.poll();
      Player_Controller player2 = this.players.poll();
      this.players.add(player1);
      this.players.add(player2);
      if(player1.getPoints() >= player2.getPoints()+Points.MINIMUM_DIFF_POINTS && player1.getPoints() >= Points.MINIMUM_POINTS_REQUIRED){
        return player1;
      }else if(this.game.isBoardEmpty() == true){
        if(player1.getPoints() >= player2.getPoints()+Points.MINIMUM_DIFF_POINTS || player1.getPoints() >= Points.MINIMUM_POINTS_REQUIRED){
          return player1;
        }
      }
      return null;
    }
    public void changeTurn(){
      int turn = this.turn;
      turn++;
      this.turn = turn%Game_Constants.NUMBER_OF_PLAYERS;
    }
    public boolean play(String input_command){
      String[] inputs = input_command.split(" ");
      String move = inputs[0];
      Player_Controller player = getPlayer();
      this.players.remove(player);
      System.out.println("\nPlayer"+player.getPlayerId()+" choosed:"+input_command+" move");
      System.out.println("Before playing move=>"+getStateOfPlayer(player));
      System.out.println("Before playing move=> Game State:"+getStateOfGame());
      switch(move){
        case "STRIKE":
          this.game.strike(player);
          break;
        case "MULTI_STRIKE":
          // We should take one more input that is count of striked coins
          this.game.multiStrike(player, Integer.parseInt(inputs[1]));
          break;
        case "RED_STRIKE":
          this.game.redStrike(player);
          break;
        case "NONE":
          this.game.none(player);
          break;
        case "DEFUNCT_COIN":
          switch(inputs[1]){
            case "BLACK":
              this.game.defunctCoin(player, Coin_Type.BLACK);
            break;
            case "RED":
              this.game.defunctCoin(player, Coin_Type.RED);
            break;
          }
      }
      this.players.add(player);
      System.out.println("After playing move=> Game State:"+getStateOfGame());
      System.out.println("After playing move=>"+getStateOfPlayer(player)+"\n");
      changeTurn();
      Player_Controller winner = calculateWinner();
      if(winner != null){
        System.out.println("Winner is:Player"+winner.getPlayerId()+" having points:"+winner.getPoints());
        return false;
      }else{
        if(this.game.isBoardEmpty() == true){
          System.out.println("Match is draw");
          return false;
        }
      }
      return true;
    }
    public boolean validateMoveAndPlay(String data){
      try{
        InputValidator.validate(data, this.game);
        if(play(data) == false){
          return false;
        }
      }catch(InvalidMoveException e){
        System.out.println("\nDiscarding "+data+ " move because of following exception");
        System.out.println(e.getMessage()+"\n");
      }
      return true;
    }
}
