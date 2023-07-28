package mychess.domen;

public class Pawn extends Figure{

    public Pawn(int locationX, int locationY, char side, String imagePath) {
        super(locationX, locationY, imagePath);
        this.side = side;
    }

    @Override
    protected void move() {
        locationY--;
    }

    @Override
    protected void moveToMouse(int mouseX, int mouseY) {
        locationY = mouseY;
        locationX = mouseX;
    }
}
