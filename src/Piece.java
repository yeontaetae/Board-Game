import java.awt.*;

public class Piece {
    //initialize the name, colour, and position
    private String name;
    private String colour;
    private Point position;

    /**
     * Constructor method of piece
     * @param name name of the piece
     * @param colour colour of the piece
     * @param position position of the piece
     */
    public Piece(String name, String colour, Point position){
        //fix the position between 0 and 8.
        if (position.getX() >= 8 || position.getX() < 0 || position.getY() >= 8 || position.getY() < 0) {
            return;
        }
        this.name = name;
        this.colour = colour;
        this.position = position;
    }

    //getter and setter methods
    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public Point getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * move method for slow & slow flexible piece
     * @param d direction of the piece's movement
     * @return null
     */
    public Point move(String d) {
        return null;
    }

    /**
     * move method for slow & slow flexible piece
     * @param d direction of the piece's movement
     * @param n represents how far the piece should go
     * @return null
     */
    public Point move(String d, int n) {
        return null;
    }

    /**
     * toString method that print the information of piece
     * @return print of information of piece
     */
    @Override
    public String toString() {
        return "Piece{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", position=" + position +
                '}';
    }
}
