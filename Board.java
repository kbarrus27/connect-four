package connectfour;
public class Board {
    private String[][] boardList;
    private String emptySpace;

    public Board(int rows, int columns, String emptySpace)
    {
        /* Create a rows*columns 2D array and populate each element with the value of emptySpace.*/
        boardList = new String[rows][columns];
        this.emptySpace = emptySpace;
        for (int i = 0; i < boardList.length; i++)
        {
            for (int j = 0; j < boardList[0].length; j++)
            {
                boardList[i][j] = emptySpace;
            }
        }
    }

    public int getNumRows()
    {
        return boardList.length;
    }

    public int getNumCols()
    {
        return boardList[0].length;
    }

    public String getStatus(int row, int column)
    {
        return boardList[row][column];
    }

    public String[][] getList()
    {
        return boardList;
    }

    public boolean setPiece(int row, int column, String piece)
    {
        /* If boardList[row][column] is unoccupied, set it to the value of piece and return true.
        Otherwise, return false.
        */
        if (this.getStatus(row, column).equals(emptySpace)) {
            boardList[row][column] = piece;
            return true;
        } else {
            return false;
        }
    }

    public String toString()
    /* Return the board in a grid format, with each slot separated by a space: " "*/
    {
        String boardString = "";
        for (int i = 0; i < boardList.length; i++)
        {
            for (int j = 0; j < boardList[0].length; j++)
            {
                boardString += boardList[i][j] + " ";
            }
            boardString += "\n";
        }
        return boardString;
    }
}
