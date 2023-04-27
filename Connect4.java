package connectfour;
import java.util.Scanner;

/*

Suggestion from Dylan: Make it so you can use the arrow keys to select a column,
display your piece above that column, and press space to drop the piece

*/


public class Connect4
{
    /* A program to allow two people to play Connect 4.
    Empty spot: ( )
    Player 1's pieces: (#)
    Player 2's pieces: (O)
    Example row: ( ) (#) ( ) (O) (#) (#) (O) ( )
    */

    public static boolean playPiece(Board board, int column, int player)
    {
        /*If the column still has empty spots, this plays a piece in the specified column and returns true.
        Otherwise, it returns false.*/

        //If the whole column isn't occupied (i.e. the first row isn't filled)
        if (board.getStatus(0, column).equals("( )"))
        {
            //Fill board from the bottom up
            int currentRow = 0;
            while (currentRow < board.getNumRows() && board.getStatus(currentRow, column).equals("( )"))
            {
                currentRow++;
            }
            //When the above loop ends, currentRow should either point to the first occupied space
            // or currentRow will equal board.getNumRows().
            //In either case, we'll place a piece at the row above currentRow.
            if (player == 1)
            {
                board.setPiece(currentRow - 1, column, "(#)");
            }
            else
            {
                board.setPiece(currentRow - 1, column, "(O)");
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean gameWon(Board board, int player)
    {
        int piecesTogether = 0;
        String pieceToCheck;

        if (player == 1) {
            pieceToCheck = "(#)";
        } else {
            pieceToCheck = "(O)";
        }
        //Check for 4 in a row horizontally
        for (String[] row : board.getList())
        {
            for (String space : row)
            {
                if (space == pieceToCheck)
                {
                    piecesTogether++;
                } else {
                    piecesTogether = 0;
                }
                if (piecesTogether >= 4)
                {
                    return true;
                }
            }
            piecesTogether = 0; //reset piece count at the end of each row
        }
        //Check for 4 in a row vertically
        for (int colIndex = 0; colIndex < board.getList()[0].length; colIndex++)
        {
            for (int rowIndex = 0; rowIndex < board.getList().length; rowIndex++)
            {
                if (board.getStatus(rowIndex, colIndex) == pieceToCheck)
                {
                    piecesTogether++;
                } else {
                    piecesTogether = 0;
                }
                if (piecesTogether >= 4)
                {
                    return true;
                }
            }
            piecesTogether = 0; //reset piece count at the end of each column
        }
        //Check for 4 in a row diagonally (top left to bottom right)
        //The top left piece would have to be in columns 0-3 and rows 0-2
        for (int colIndex = 0; colIndex < 4; colIndex++)
        {
            for (int rowIndex = 0; rowIndex < 3; rowIndex++)
            {
                for(int i = 0; i < 4; i++) //Iterate across diagonals
                {
                    if (board.getStatus(rowIndex+i, colIndex+i) == pieceToCheck)
                    {
                        piecesTogether++;
                    } else {
                        piecesTogether = 0;
                    }
                    if (piecesTogether >= 4)
                    {
                        return true;
                    }
                }
            }
            piecesTogether = 0; //reset piece count at the end of each diagonal
        }
        //Check for 4 in a row diagonally (bottom left to top right)
        //The bottom left piece would have to be in columns 0-3 and rows 3-5
        for (int colIndex = 0; colIndex < 4; colIndex++)
        {
            for (int rowIndex = 3; rowIndex < 6; rowIndex++)
            {
                for(int i = 0; i < 4; i++) //Iterate across diagonals
                {
                    if (board.getStatus(rowIndex-i, colIndex+i) == pieceToCheck)
                    {
                        piecesTogether++;
                    } else {
                        piecesTogether = 0;
                    }
                    if (piecesTogether >= 4)
                    {
                        return true;
                    }
                }
            }
            piecesTogether = 0; //reset piece count at the end of each diagonal
        }
        return false;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int currentPlayer = 1;

        Board gameBoard = new Board(6, 7, "( )");
        System.out.println("Welcome to Connect 4!");
        System.out.println(gameBoard);

        while (!gameWon(gameBoard, 1) && !gameWon(gameBoard, 2))
        {
            System.out.println("Player " + currentPlayer + "'s turn");
            System.out.print("Which column would you like to play in? (1-7) ");
            String playerInput = sc.nextLine();
            if (!playerInput.equals("") && "1234567".contains(playerInput) && Integer.parseInt(playerInput) <= 7)
            {
                playPiece(gameBoard, Integer.parseInt(playerInput) - 1, currentPlayer);
                System.out.println(gameBoard);
                if (currentPlayer == 2)
                {
                    currentPlayer = 1;
                } else
                {
                    currentPlayer = 2;
                }
            }
            
        }
        System.out.println("Player " + (currentPlayer-1) + " won!");
        sc.close();
        
    }
}