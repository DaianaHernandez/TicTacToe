/**
 * The Player class represents a player in the TicTacToe game.
 * Each player has a symbol (X / 0) used to mark each player´s move on
 * the board.
 * @author Ashley
 */

public class Player {

    private char symbol;
    
    /**
     * The Player class constructor
     * @param symbol The Symbol representing the player on the board (X / 0).
     */
    
    public Player(char symbol){
        this.symbol = symbol;
    }
    
    /**
     * Gets the player's symbol.
     * @return The player's symbol(X / 0).
     */
    public char getSymbol(){
        return symbol;
    }

}
