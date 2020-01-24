package connect4;

import java.util.ArrayList;
import javafx.animation.Animation;

public class GameModel
{
    ArrayList<Player> players;
    Player turn;
    int[][] grid;

    public GameModel()
    {
        players = new ArrayList<Player>();
    }

    //Allows the players to have a name
    public void enterPlayer(String name)
    {
        Player player = new Player(name);
        players.add(player);
        turn = players.get(0);
    }

    //Change who's turn it is
    public void changeTurn()
    {
        if (turn.equals(players.get(0)))
        {
            turn = players.get(1);
        }
        else
        {
            turn = players.get(0);
        }
    }

    //Set up the grid
    public void setGrid(int row, int column)
    {
        grid = new int[row][column];
    }

    //Determine who's turn it is
    public String getTurn()
    {
        if (turn.equals(players.get(0)))
        {
            return players.get(0).getName();
        }
        else
        {
            return players.get(1).getName();
        }
    }

    //This updates the grid.
    public int updateGrid(int column)
    {
       int row;
       boolean lastGrid = false;

       if (lastGrid)
       {
           return -1;
       }

       for (row = grid.length-1; row >= 0; row--)
       {
           if (turn.equals(players.get(0)))
           {
               if(grid[row][column] == 0)
               {
                   if (grid[row][column] == 0)
                   {
                       grid[row][column] = 1;
                       break;
                   }
               }
           }
           else if(grid[row][column] == 0)
           {
               grid[row][column] =2;
               break;
           }
       }

       //where is the breaking where I am not reaching here???
       if(row == 0)
       {
           lastGrid = true;
           return row;
       }
       return row;
    }

    /**
    * The following checks to see if a connection has been made.
    * @param winCondition is the number or consecutive pieces in
    *     a row needed to win.
    * @return The player number of the winner or 0 if no winner was found
    */

    public int checkWin(int  winCondition)
    {
        int currentPlayer;
        int player;
        int streak;
        int columnHeight = 7;
        int rowLength = 6;

        //checkWin should return player and indexes (for flashing the discs)
            //I did not return the indexes to flash the discs. I popped up an alert.
                //If I were to flash the discs as well, I would return the grid indexes for each of the winning discs.
                //I had little success figuring out the logic with my code that already existed to make it work.

        // check rows
        //WORKS
        for (int rows = 0; rows < grid.length; rows++)
        {
            player = streak = 0;
            for (int columns = 0; columns < grid[rows].length; columns++)
            {
                currentPlayer = grid[rows][columns];
                if (currentPlayer != 0 && player == currentPlayer)
                {
                    if (streak++ == winCondition - 1)
                    {
                        return player;
                    }
                }
                else
                {
                    player = currentPlayer;
                    streak = 0;
                }
            }
        }



        //check columns WORKS!
        for(int col = 0; col < grid[0].length; col++)
        {
            player = streak = 0;
            for(int row = 0; row < grid.length; row++)
            {
                currentPlayer = grid[row][col];
                if(currentPlayer != 0 && player == currentPlayer)
                {
                    if(++streak == winCondition) {
                        return player;
                    }
                }
                else
                {
                    player = currentPlayer;
                    streak = 0;
                }
            }
        }


    /**MOST OF THE DIAGONAL LOGIC IS WORKING*/

         //check \ diagonals, lower half
        for(int rows = 0; rows < grid.length; rows++){
            player = streak = 0;
            int rowIndex = rows;
            for (int cols = 0; cols < grid[rows].length; cols++){
                if (rowIndex >= grid.length){
                    break;
                }
                currentPlayer = grid[rowIndex][cols];
                if (currentPlayer != 0 && player == currentPlayer){
                    if(streak++ == winCondition){
                        return player;
                    }
                }
                else{
                    player = currentPlayer;
                    streak = 0;
                }
                rowIndex++;
            }
        }

        //check \ diagonals, upper half
        for(int cols = 0; cols < grid[0].length; cols++) {
            player = streak = 0;
            int colIndex = cols;
            for(int row = 0; row < grid.length ; row++) {
                if(colIndex >= grid[0].length)
                    break;
                currentPlayer = grid[row][colIndex];
                if(currentPlayer != 0 && player == currentPlayer) {
                    if(streak++ == winCondition - 1)
                        return player;
                } else {
                    player = currentPlayer;
                    streak = 0;
                }
                colIndex++;
            }
        }

        // check / diagonals, upper half
        for(int rows = grid.length - 1; rows >= 0; rows--) {
            player = streak = 0;
            int rowIndex = rows;
            for(int columns = 0; columns < grid[0].length; columns++) {
                if(rowIndex < 0)
                    break;
                currentPlayer = grid[rowIndex][columns];
                if(currentPlayer != 0 && player == currentPlayer) {
                    if(streak++ == winCondition - 1)
                        return player;
                } else {
                    player = currentPlayer;
                    streak = 0;
                }
                rowIndex--;
            }
        }

        // check / diagonals, lower half
        //WORKS
        for(int rows = grid.length - 1; rows >= 0; rows--) {
            player = streak = 0;
            int rowIndex = rows;
            int colsIndex = grid[0].length - 1;
            for(int cols = grid[rows].length - 1; cols < grid[rows].length; cols--) {
                if(rowIndex >= grid.length)
                    break;
                currentPlayer = grid[rowIndex][colsIndex];
                if(currentPlayer != 0 && player == currentPlayer) {
                    if(streak++ == winCondition - 1)
                        return player;
                } else {
                    player = currentPlayer;
                    streak = 0;
                }
                rowIndex++;
                colsIndex--;
            }
        }

        //if other is not true, return 0
        return 0;
    }

}
