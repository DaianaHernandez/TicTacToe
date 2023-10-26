/**
 * The board class represents the game board in the TicTacToe game.
 * It contains methods to check the game state, insert symbols on the board,
 * and determine if there is a winner or if the game ended in a draw.
 * @author Ashley
 */
public class Board {

    private char[][] board;
    public static char empty = '-';
    private char winner;

    /**
     * The board class constructor. Initializes the board with empty cells. 
     */
    public Board(){
        this.board = new char[3][3];
        initializeBoard();

    }
    
    /**
     * Initializes the game board with empty cells.
     */

    private void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
            board[i][j] = empty;
            }
        }
    }
    
    /**
     * Checks if the game has ended either due to a win or a draw.
     * @return True if the game has ended, false otherwise.
     */
    
    public boolean endGame(){
        return fullBoard()|| lineMatch() != empty || 
                columnMatch() != empty || diagonalMatch() != empty;
    }
      
    /**
     * Checks if the game board is full, indicating a draw.
     * @return True if the board is full, false otherwise.
     */
    
    public boolean fullBoard(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == empty){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Checks for a winning condition in rows.
     * @return The winning symbol (X / 0) if a win is found; otherwise, 
     * returns a empty character (-).
     */
    public char lineMatch() {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] != empty && board[i][0] == board[i][1]
                && board[i][0] == board[i][2]){
            return board[i][0];
            }
        }
        return empty;
    }
    
    /**
     * Checks for a winning condition in columns.
     * @return The winning symbol (X / 0) if a win is found; otherwise, 
     * returns a empty character (-).
     */
    public char columnMatch(){
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] != empty && board[0][i] == board[1][i]
                && board[0][i] == board[2][i]){
            return board[0][i];
            }
        }
        return empty;
    }
    
    
    /**
     * Checks for a winning condition in diagonals.
     * @return The winning symbol (X / 0) if a win is found; otherwise, 
     * returns a empty character (-).
     */
    public char diagonalMatch(){
        
         if (board[0][0] != empty && board[0][0] == board[1][1]
                && board[0][0] == board[2][2]){
            return board[0][0];
            }
          if (board[0][2] != empty && board[0][2] == board[1][1]
                && board[0][2] == board[2][0]){
            return board[0][2];
            }
        return empty;
    }

    /**
     * Insert a player's symbol into the specified position on the board.
     * @param row The row where the symbol is inserted.
     * @param column The column where the symbol is inseerted.
     * @param symbol The player's symbol (X / 0) to be inserted.
     */
    public void insertInto(int row, int column,char symbol){
        board[row][column] = symbol;
    }
    
    
    /**
     * Validates if a position on the board is within bounds empty.
     * @param row The row to be validated.
     * @param column The column to be validated.
     * @return True if the position is valid and empty, false otherwise.
     */
    public boolean validatePosition(int row, int column){
        return row >= 0 && row < board.length && column < board.length;
    }
    
    
    /**
     * Checks if a position on the board is occupied.
     * @param row The row to be checked.
     * @param column The column to be checked.
     * @return True if the position is occupied, false otherwise.
     */
    public boolean valuePosition(int row, int column){
        return board[row][column] != empty;
    }
    
    /**
     * Sets the winner of the game.
     * @param winner The winning symbol (X / 0).
     */
    public void setWinner (char winner){
        this.winner = winner;
    }

    /**
     * Displays the current state of the game board.
     */
    public void showBoard() {
        for(int i =0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
