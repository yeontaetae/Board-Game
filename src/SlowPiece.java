import java.awt.*;

public class SlowPiece extends Piece {
    /**
     * Constructor method of slow piece
     * @param name name of the piece
     * @param colour colour of piece
     * @param position position of piece
     */
    public SlowPiece(String name, String colour, Point position) {
        super(name, colour, position);
    }

    /**
     * move method of slow type of piece that moves the piece
     * @param direction direction of piece where the piece goes
     * @return new position after piece moves
     */
    @Override
    public Point move(String direction){
        //moves the piece left or right
        if(direction.equals("left")){
            if (getPosition().x - 1 >= 0) {
                setPosition(new Point(getPosition().x - 1, getPosition().y));
            }
        }else if(direction.equals("right")){
            if (getPosition().x + 1 < 8) {
                setPosition(new Point(getPosition().x + 1, getPosition().y));
            }
        }
        return getPosition();
    }

    /**
     * toString method that print the information of piece
     * @return print of information of piece
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
