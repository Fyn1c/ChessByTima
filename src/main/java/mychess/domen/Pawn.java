package mychess.domen;

public class Pawn extends GameObject {

    public boolean firstMove = true;

    public Pawn(int locationX, int locationY, int side, String imagePath) {
        super(locationX, locationY, imagePath);
        this.side = side;
    }

    @Override
    public void move() {
        if (locationY != 8 && locationY != 1) {
            if (side == 0) {
                moves.put((float) (locationY + 1), locationX);
                if(firstMove) {
                    moves.put((float) (locationY + 2), locationX);
                }
            }
            if (side == 1) {
                moves.put((float) (locationY - 1), locationX);
                if(firstMove) {
                    moves.put((float) (locationY - 2), locationX);
                }
            }
        }
    }



}
