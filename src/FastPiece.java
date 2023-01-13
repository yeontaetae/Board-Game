import java.awt.*;

public class FastPiece extends Piece{
    /**
     * Constructor method of fast piece
     * @param name name of the piece
     * @param colour colour of piece
     * @param position position of piece
     */
    public FastPiece(String name, String colour, Point position){
        super(name, colour, position);
    }

    /**
     * move method of fast type of piece that moves the piece
     * @param direction direction of piece where the piece goes
     * @return new position after piece moves
     */
    @Override
    public Point move(String direction, int n){
        //moves the piece left or right
        if(direction.equals("left")){
            if (getPosition().x - n >= 0) {
                setPosition(new Point(getPosition().x - n, getPosition().y));
            }
        }else if(direction.equals("right")){
            if (getPosition().x + n < 8) {
                setPosition(new Point(getPosition().x + n, getPosition().y));
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
