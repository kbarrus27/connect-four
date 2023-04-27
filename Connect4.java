package connectfour;
public class Connect4
{
    /* A program to allow two people to play Connect 4.
    Empty spot: ( )
    Player 1's pieces: (#)
    Player 2's pieces: (O)
    Example row: ( ) (#) ( ) (O) (#) (#) (O) ( )
    */

    public void playPiece(int player) {
        //Fill board from the bottom up
    }

    public static void main(String[] args)
    {
        Board gameBoard = new Board(7, 6, "( )");
        System.out.println(gameBoard);
    }
}