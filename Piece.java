// class Piece - one peg in the game
public class Piece
{ // start class Piece
    private static final int REMOVED = -1; // final so that it the REMOVED value is always the same
    private int place; // determines whether or not it is in use (could be a boolean, but i'm lazy)

    private int moves[]; // all the pieces moves
    private int midle[]; // all midle pieces for each move
    private int total;   // number of moves and midle pieces
    
    public Piece() // no args constructer
    { // start constructor
        place = 1; // set the pieces in use
        moves = new int[4]; // initialize the array
        midle = new int[4]; // initialize the array
        total = 0; // set total moves to zero
    } // end constructor
    
    public Piece(int x) // int arg constructor
    { // start constructor
        place = x; // set the place equal to the param
        SetMoves(); // set up the piece's moves
    } // end constructor
    
    // this function returns the piece that is the midle of a jump
    public int getMidle(int m)
    { // start getMidle function
        return midle[m]; // return the value the user wants
    } // end getMidle function
    
    // this function returns the value of the piece's place
    public int getPlace()
    { // start getPlace function
        return place; // return the piece's place
    } // end getPlace function
    
    // this function returns the piece that is the end of jump
    public int getMoves(int m)
    { // start getMoves function
        return moves[m]; // return the move
    } // end getMoves function
    
    // returns the total number of moves for this piece
    public int getTotal()
    { // start getTotal function
        return total; // return the number of moves
    } // end getTotal function
    
    // this function sets this Piece equal to P
    public void SetTo(Piece p)
    { // start SetTo function
        this.place = p.place; // set this equal to p
    } // end SetTo function
    
    // return true if the piece is alive, false otherwise
    public boolean IsAlive() // in bounds -1 < x < 15
    { // start IsAlive function
        return ((place >= 0) && (place < 15)); // return true if alive false otherwise
    } // end IsAlive function
    
    // changes the pieces place
    public void NewPos(int x)
    { // start NewPos function
        place = x; // change this Piece's place value to x
    } // end NewPos function
    
    // sets the pieces value to -1, therefore it is not in use
    public void Remove()
    { // start Remove function
        place = REMOVED; // make the Piece out of use
    } // end Remove function
    
    // sets this pieces moves, midle, and total moves values
    public void SetMoves()
    { // start SetMoves function
        int[] moves = new int[4]; // array that will hold the moves for this piece
		int[] midle = new int[4]; // array that will hold the midle pieces for each move
		int total = 0; // will hold total number of moves for this piece
		int x = place; // didn't feel like changing x to place b/c I'm lazy

		// switch statement for each piece
		switch (x)
		{ // start switch
			case 0: // first piece
				/*
					Possible Moves:
						3, 5
				*/
				moves[0] = 3; moves[1] = 5; // set moves
				midle[0] = 1; midle[1] = 2; // set midle
				total = 2; // set total
			break; // end first piece
			case 1: // second piece
				/*
					Possible Moves:
						6, 8
				*/
				moves[0] = 6; moves[1] = 8; // set moves
				midle[0] = 3; midle[1] = 4; // set midle
				total = 2; // set total
			break; // end second piece
			case 2: // third piece
				/*
					Possible Moves:
						7, 9
				*/
				moves[0] = 7; moves[1] = 9; // set moves
				midle[0] = 4; midle[1] = 5; // set midle
				total = 2; // set total
			break; // end third piece
			case 3: // fourth piece
				/*
					Possible Moves:
						10, 0, 5, 12
				*/
				moves[0] = 10; moves[1] = 0; moves[2] = 5; moves[3] = 12; // set moves
				midle[0] = 6;  midle[1] = 1; midle[2] = 4; midle[3] = 7; // set midle
				total = 4; // set total
			break; // end fourth piece
			case 4: // fifth piece
				/*
					Possible Moves:
						11, 13
				*/
				moves[0] = 11; moves[1] = 13; // set moves
				midle[0] = 7;  midle[1] = 8; // set midle
				total = 2; // set total
			break; // end fifth piece
			case 5: // sixth piece
				/*
					Possible Moves:
						12, 3, 0, 14
				*/
				moves[0] = 12; moves[1] = 3; moves[2] = 0; moves[3] = 14; // set moves
				midle[0] = 8;  midle[1] = 4; midle[2] = 2; midle[3] = 9; // set midle
				total = 4; // set total
			break; // end sixth piece
			case 6: // seventh piece
				/*
					Possible Moves:
						1, 8, 
				*/
				moves[0] = 1; moves[1] = 8; // set moves
				midle[0] = 3; midle[1] = 7; // set midle
				total = 2; // set total
			break; // end seventh piece
			case 7: // eighth piece
				/*
					Possible Moves:
						2
				*/
				moves[0] = 2; moves[1] = 9; // set moves
				midle[0] = 4; midle[1] = 8; // set midle
				total = 2; // set total
			break; // end eighth piece
			case 8: // ninth piece
				/*
					Possible Moves:
						1
				*/
				moves[0] = 1; moves[1] = 6; // set moves
				midle[0] = 4; midle[1] = 7; // set midle
				total = 2; // set total
			break; // end ninth piece
			case 9: // tenth piece
				/*
					Possible Moves:
						7, 2
				*/
				moves[0] = 7; moves[1] = 2; // set moves
				midle[0] = 8; midle[1] = 5; // set midle
				total = 2; // set total
			break; // end tenth piece
			case 10: // eleventh piece
				/*
					Possible Moves:
						3, 12
				*/
				moves[0] = 3; moves[1] = 12; // set moves
				midle[0] = 6; midle[1] = 11; // set midle
				total = 2; // set total
			break; // end eleventh piece
			case 11: // twelfth piece
				/*
					Possible Moves:
						4, 13
				*/
				moves[0] = 4; moves[1] = 13; // set moves
				midle[0] = 7; midle[1] = 12; // set midle
				total = 2; // set total
			break; // end twelfth piece
			case 12: // thirteenth piece
				/*
					Possible Moves:
						10, 3, 5, 14
				*/
				moves[0] = 10; moves[1] = 3; moves[2] = 5; moves[3] = 14; // set moves
				midle[0] = 11; midle[1] = 7; midle[2] = 8; midle[3] = 13; // set midle
 				total = 4; // set total
			break; // end thirteenth piece
			case 13: // fourteenth piece
				/*
					Possible Moves:
						11, 4
				*/
				moves[0] = 11; moves[1] = 4; // set moves
				midle[0] = 12; midle[1] = 8; // set midle
				total = 2; // set total
			break; // end fourteenth piece
			case 14: // fifteenth piece
				/*
					Possible Moves:
						12, 5
				*/
				moves[0] = 12; moves[1] = 5; // set moves
				midle[0] = 13; midle[1] = 9; // set midle
				total = 2; // set total
			break; // end fifteenth piece
		} // end switch

		this.moves = moves; // set this piece's moves equal to the possible moves
		this.midle = midle; // set this piece's midle equal to the possible midle
		this.total = total; // set this piece's total equal to the total moves
	} // end SetMoves function
} // end Piece class 