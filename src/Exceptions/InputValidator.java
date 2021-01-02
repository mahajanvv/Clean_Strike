package Exceptions;

import Constants.Coin_Type;
import Constants.Game_Constants;
import controller.Game_Controller;

public class InputValidator {
    public static void validate(String data, Game_Controller game) throws InvalidMoveException{
        String[] inputs = data.split(" ");
        if(inputs.length>2){
            throw new InvalidMoveException("Invalid move only 2 parameters has to be passed");
        }else{
            switch(inputs[0]){
                case "STRIKE":
                    if(game.getCoinsCount(Coin_Type.BLACK)<1){
                        throw new InvalidMoveException("Invalid move there is no BLACK COIN present on the board");
                    }
                break;
                case "MULTI_STRIKE":
                    int coins_count = Integer.parseInt(inputs[1]);
                    if(coins_count < Game_Constants.MAX_COINS_ACCEPTED_IN_MULTI_STRIKE_MOVE){
                        throw new InvalidMoveException("You should pocket atleast "+Game_Constants.MAX_COINS_ACCEPTED_IN_MULTI_STRIKE_MOVE+" coins in MULTI_STRIKE move");
                    }
                    if(game.getCoinsCount(Coin_Type.BLACK)<coins_count){
                        throw new InvalidMoveException("Invalid move, BLACK COINs count is less than the requested count");
                    }
                break;
                case "RED_STRIKE":
                    if(inputs.length>1){
                        int black_coins_count = Integer.parseInt(inputs[1]);
                        if(game.getCoinsCount(Coin_Type.BLACK) < black_coins_count){
                            throw new InvalidMoveException("Invalid move, BLACK COINs count is less than the requested count");
                        }
                    }
                    if(game.getCoinsCount(Coin_Type.RED)<1){
                        throw new InvalidMoveException("There is no RED coin present on the board");
                    }
                break;
                case "NONE":
                    if(game.isBoardEmpty()){
                        throw new InvalidMoveException("There is not a single coin present on the board");
                    }
                break;
                case "DEFUNCT_COIN":
                    if(game.isBoardEmpty()){
                        throw new InvalidMoveException("There is not a single coin present on the board");
                    }
                break;
            }
        }
    }    
}
