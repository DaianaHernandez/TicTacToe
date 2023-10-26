
import java.util.Scanner;


/** 
 * The TicTacToe class contains the main logic for the TicTacToe game.
 * It allows two players to play the game until there is a winner or the game 
 * ends in a draw.
 * @author Ashley
 */
public class TicTacToe {

    private boolean turnPlayer1;

    private Player player1;
    
    private Player player2;

    private Board board;
    
   /**
    * TicTacToe class constructor. Initializes the game with an empty board 
    * and assigns players with their respective symbols (X & 0).
    */
    
    public TicTacToe(){
        this.board = new Board();
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.turnPlayer1 = true;
    }

    /**
     * Initiates and manages the gameplay until a winner is determined or 
     * the game ends in a draw.
     */
    public void play (){
        while(!board.endGame()){
           board.showBoard();
           Player currentPlayer = turnPlayer1 ? player1 : player2;
           System.out.println("TURNO DEL JUGADOR " + 
                   (turnPlayer1 ? " 1 (X)" : "2 (O)"));
           int row, column;
           
           do{
               System.out.println("INGRESE LA FILA (0,1,2):");
               row = obtainInput();
               System.out.println("INGRESE LA COLUMNA (0,1,2):");
               column = obtainInput();
    
           }while (!board.validatePosition(row, column)|| 
           board.valuePosition(row, column));
           board.insertInto(row, column, currentPlayer.getSymbol());
           turnPlayer1 = !turnPlayer1;
           
        }
        board.showBoard();
        char winner = verifyWinner();
        if (winner != Board.empty){
            System.out.println("JUGADOR" + (winner == 'X' ? "1 (X)" : "2 (0)")
                    + "HA GANADO!");    
        }else{
            System.out.println("EMPATE");
        }
    }
    
    /** 
     * Checks the board for a winning condition by examinig rows, columns,
     * and diagonals.
     * @return The winning symbol (X / 0) if a winner is found; otherwise, 
     * returns empty character (-).
     */
     public char verifyWinner() {
        char winner = board.lineMatch();
        if(winner != Board.empty){
            board.setWinner(winner);
           return winner;
    }
        winner = board.columnMatch();
        if(winner != Board.empty){
            board.setWinner(winner);
            return winner;
        }
       winner = board.diagonalMatch(); 
       if(winner != Board.empty){
            board.setWinner(winner);
           return winner;
       }
       return Board.empty;
    }
     
     /**
      * Obtains and validates user input for rows and columns (0,1,2).
      * @return The validated user input as an integer.
      */
    
    private int obtainInput(){
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNextInt()){
            System.out.println("INGRESE UN NÚMERO VALIDO");
            scanner.next();
        }
        return scanner.nextInt();
    }
    
    public static void main(String[] args){
        TicTacToe tictactoe = new TicTacToe();
        tictactoe.play();
    }
    }

