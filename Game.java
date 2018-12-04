/* Through recursion, runs through all possible beginning states and all possible win conditions.*/
/* The output shows each movement, from one peg position to another, until only one remsins.*/

import javax.swing.*;

// This class simulates the peg game in Cracker Barrel stores
public class Game
{ // start Game class
    private static int total = 0; // Keeps track of total solutions

    public static void main(String[] args) // sets up the game and solves it
    { // start main function
        Piece game[] = new Piece[15]; // the game, 15 pieces

        SetUp(game, 0); // set the board up (open piece at top)
        System.out.println ("Game Set Up Complete...\nSolving..."); // show the user where we are
        Solve(game, ""); // Solve the game
        System.out.println("Complete: " + total + " total solutions."); // show the user that we are done
    } // end main function
    
    // Solves the game showing output on its way through
    private static void Solve(Piece g[], String s)
    { // start Solve function
        Piece game[] = CopyGame(g); // create a copy of the board so we don't change the original
        Piece copy[]; // another copy for later
        
        if (Won(game)) // check if we won the game
        { // start if statement
            // we won
            System.out.println (s + " " + total); // print out the moves we made to win and the total
                
            total++; // add one to the total
        } // end if statement
        
        if (Stuck(game)) // check if we are stuck, no moves left
        { // start if statement
            return; // get out of the function
        } // end if statement
        
        // loop through the Pieces
        for (int p = 0; p < game.length; p++) // loop through pieces
        { // start for loop
            // loop through each Piece's moves
            for (int m = 0; m < game[p].getTotal(); m++) // loop through each piece's moves
            { // start for loop
                // check if it's a valid move               
                if (ValidMove(game, p, m)) // make sure it's a valid move
                { // start if statement
                    String temp = s; // temp copy of s
                    copy = CopyGame(game); // copy of game so we don't change original

                    // this is a good move...move to it
                    s += p + "|" + game[p].getMoves(m) + " "; // add the move to the string keeping track of the moves
                    
                    // Recurse, BUT keep current value in game
                    Solve(MakeMove(CopyGame(game), p, m), s); // Recurse, and MakeMove at the same time
                                        
                    // restore original
                    s = temp; // restore the original string (in case it changed during recursion)
                    game = CopyGame(copy); // restore original game (in case it changed during recursion)
                } // end if statement
            } // end for loop
        } // end for loop
    } // end Solve function
    
    // this function returns the string version of the game board
    // 1 means the piece is in use, 0 means no piece is therer
    private static String PrintGame(Piece game[])
    { // start PrintGame function
        String output = ""; // hold output
        
        for (int c = 0; c < game.length; c++) // loop through pieces
        { // start for loop
            if (game[c].IsAlive()) // check if the piece is there
                output += "1 "; // piece is there, add a 1
            else // piece not here
                output += "0 "; // add a 0 for no piece
        } // end for loop
        
        return output; // return the output
    } // end PrintGame function
    
    // return true if the game is stuck (no moves left), false otherwise
    private static boolean Stuck(Piece game[])
    { // start Stuck function
        for (int c = 0; c < game.length; c++) // loop through pieces
               for (int d = 0; d < game[c].getTotal(); d++) // loop through each piece's moves
                    if (ValidMove(game, c, d)) // check if it's a vlid move
                        return false; // there is a move, we aren't stuck yet
                        
        return true; // if we reach this, we are stuck
    } // end Stuck function
    
    // return true if the game is solved, false otherwise
    private static boolean Won(Piece game[])
    { // start Won function
        int total = 0; // keeps track of how many pieces are left
        
        // check to see how many pieces are still left
        for (int c = 0; c < game.length; c++) // loop through pieces
        { // start for loop
            if (game[c].IsAlive()) // check if the piece is there
                total++; // piece is there, add one to total
        } // end for loop
        
        return (total == 1); // if total is 1 then we Won, didn't win if it's not 1
    } // end Won function
    
    // makes p's mth move
    private static Piece[] MakeMove(Piece g[], int p, int m)
    { // start MakeMove function
        Piece game[] = CopyGame(g); // create copy of g so we don't change it
        
        // make sure this is a ValidMove just in case
        if (ValidMove(game, p, m)) // check if it's a valid move
        { // start if statement
            // okay good to go
            // set p's NewPos to the value in game[p].move[m]
            // Remove the midle piece, and the old piece
            game[game[p].getMoves(m)].NewPos(1); // add a piece to the place that was jumped to
            game[game[p].getMidle(m)].Remove(); // get rid of the piece that was jumped
            game[p].Remove(); // get rid of piece in original spot
        } // end if statment
        
        return game; // return new board
    } // end MakeMove function
    
    // true if this is a valid move, false otherwise
    private static boolean ValidMove(Piece g[], int p, int m)
    { // start ValidMove function
        Piece game[] = CopyGame(g); // create a copy of g so we don't change it
        
        // valid move IF
        // the Piece we are on EXISTS
        // the Piece we are moving to DOES NOT EXISTS
        // the midle Piece EXISTS
        if (game[p].IsAlive()) // make sure the piece is alive
            // the current Piece is good
            if (!game[game[p].getMoves(m)].IsAlive()) // make sure move to square is empty
                // the move to square is empty
                if (game[game[p].getMidle(m)].IsAlive()) // make sure midle piece is there
                    // the midle piece is there as well...good move
                    return true; // return true b/c it is a valid move
        
        return false; // if we reach this, the move is not good
    } // end ValidMove function
    
    // This function returns a copy of the parameter
    public static Piece[] CopyGame (Piece game[])
    { // start CopyGame function
        Piece to[] = new Piece[game.length]; // create another array same length as the parameter
        SetUp(to, 0); // set the array up w/ moves, midle and total
        
        for (int c = 0; c < game.length; c++) // loop through the pieces in the parameter
        { // start for loop
            to[c].SetTo(game[c]); // set the piece's values to the same as in parameter
        } // end for loop
        
        return to; // return the copy
    } // end CopyGame function
    
    // set the game up
    private static void SetUp(Piece game[], int open)
    { // start SetUp function
        // set the game up with the open piece at open
        for (int c = 0; c < game.length; c++) // loop through pieces
        { // start for loop
            game[c] = new Piece(c); // create the new pieces
        } // end for loop
        
        game[open].Remove(); // remove the piece, cause it's not in use
    } // end SetUp function
} // end Game class 