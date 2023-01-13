import java.awt.Point;
import java.util.Scanner;

public class GameDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //initialize the board, and command for piece.
        Board board = new Board();
        String commands = "";
        String[] command;

        //Enter a command until "exit"
        while(!commands.equals("exit")) {
            System.out.println("Enter a command (type help for details):");
            commands = in.nextLine();
            command = commands.split(" ");

            //Enter a command "help", "print", "create", or "move"
            if(command[0].equals("help")) {
                System.out.println("Possible commands are as follows:\ncreate location [fast] [flexible]: Creates a new" +
                        " piece\nmove location direction [spaces]: Moves a piece.\nprint: Displays the board.\nhelp: Displays" +
                        " help.\nexit: Exits the program.");
            } else if(command[0].equals("print")) {
                board.display();
            } else if(command[0].equals("create")) {
                int x = Integer.parseInt(command[1]);
                int y = Integer.parseInt(command[2]);
                System.out.println("Input a name for the new piece:");
                String name = in.nextLine();
                System.out.println("Input a colour for the new piece:");
                String colour = in.nextLine();

                Piece piece = new SlowPiece(name, colour, new Point(x,y));

                //for fast command
                if (command.length == 4) {
                    if (command[3].equals("fast")) {
                        piece = new FastPiece(name, colour, new Point(x,y));
                    } else {
                        piece = new SlowFlexible(name, colour, new Point(x,y));
                    }
                //for fast flexible command
                } else if(command.length == 5){
                    piece = new FastFlexible(name, colour, new Point(x,y));
                }

                board.addANewPiece(piece);
            } else if(command[0].equals("move")) {
                board.move(commands);
            }
        }
        //print "Done.", when the command said "exit".
        System.out.println("Done.");
    }
}
