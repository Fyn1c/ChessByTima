package mychess.domen;

public class Rook extends Figure{

    public Rook(int locationX, int locationY, char side, String imagePath) {
        super(locationX, locationY, imagePath);
        this.side = side;
    }

    @Override
    protected void moveToMouse(int mouseX, int mouseY) {
        super.moveToMouse(mouseX, mouseY);
    }
}
