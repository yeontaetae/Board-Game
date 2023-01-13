import java.awt.*;

public class Board {
    //initialize the board
    private Piece[][] board;

    /**
     * Constructor method of board
     */
    public Board() {
        board = new Piece[8][8];
        initialBoard();
    }

    /**
     * initialBoard method initialize the board
     */
    public void initialBoard(){
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                board[x][y] = new Piece("-", "", new Point(x,y));
            }
        }
    }

    /**
     * this method is for adding a new piece on the board
     * @param p a new piece
     * @return true when it is good to add, otherwise false.
     */
    public boolean addANewPiece(Piece p) {

        //Checking for error cases
        if (p == null) {
            System.out.println("This piece cannot be null!");
            return false;
        } else if (!board[p.getPosition().y][p.getPosition().x].getName().equals("-")) {
            System.out.println("Another piece is already occupying this position!");
            return false;
        }

        //Good case
        board[p.getPosition().y][p.getPosition().x] = p;
        return true;
    }

    /**
     * this method moves the piece on the board
     * @param command command of the piece information
     * @return true when it is good to move, otherwise false.
     */
    public boolean move(String command) {

        //Take input
        String[] commands = command.split(" ");
        int x = Integer.parseInt(commands[1]);
        int y = Integer.parseInt(commands[2]);
        int n = 1;
        if (commands.length == 5) {
            n = Integer.parseInt(commands[4]);
        }

        if(board[y][x].getName().equals("-")){
            System.out.println("Error: no piece at (" + x + ", " + y + ")");
            return false;
        }

        //Move the piece
        int futureX = 0;
        int futureY = 0;
        if (commands[3].equals("left")) {
            futureX = x - n;
        } else if (commands[3].equals("right")) {
            futureX = x + n;
        } else if (commands[3].equals("up")) {
            futureY = y - n;
        } else if (commands[3].equals("down")) {
            futureY = y + n;
        }

        if (!(futureX >= 0 && futureX < 8)) {
            System.out.println("Out of bounds!");
            return false;
        }

        if (!(futureY >= 0 && futureY < 8)) {
            System.out.println("Out of bounds!");
            return false;
        }

        // Check if the new place is empty
        if (board[futureY][futureX].getName().equals("-")) {
            Piece selected = board[y][x];
            board[y][x] = new Piece("-", "", new Point(x,y));
            if (selected instanceof FastPiece) {
                selected.move(commands[3], n);
            } else {
                selected.move(commands[3]);
            }
            if(commands.length == 5) {
                System.out.println("Piece at (" + x + ", " + y + ") moved " + commands[3] + " by " + commands[4] + " spaces");
                return this.addANewPiece(selected);
            }else{
                System.out.println("Piece at (" + x + ", " + y + ") moved " + commands[3] + " by 1 space");
                return this.addANewPiece(selected);
            }
        } else {
            System.out.println("There is another piece that is occupying this spot!");
            return false;
        }
    }

    /**
     * this method displays the piece on the board.
     */
    public void display() {
        //display when it matches the correct type of move
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                String pieceType = "";
                if (board[y][x] instanceof SlowFlexible) {
                    pieceType = "SF";
                } else if (board[y][x] instanceof FastFlexible) {
                    pieceType = "FF";
                } else if (board[y][x] instanceof SlowPiece) {
                    pieceType = "S";
                } else if (board[y][x] instanceof FastPiece) {
                    pieceType = "F";
                }
                System.out.print(board[y][x].getName() + board[y][x].getColour() + pieceType + "\t\t");

            }
            System.out.println();
        }
    }
}
