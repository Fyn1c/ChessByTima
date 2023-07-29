package mychess.domen;

public class Pawn extends GameObject {

    public Pawn(int locationX, int locationY, int side, String imagePath) {
        super(locationX, locationY, imagePath);
        this.side = side;
    }

    @Override
    public void move() {
        if(locationY != 7 && locationY != 0) {
            if (side == 0) {
                moves.put(locationY--, locationX);
                moves.put(locationY - 2, locationX);
            }
            if (side == 1) {
                moves.put(locationY++, locationX);
                moves.put(locationY + 2, locationX);
            }
        }
    }


}
