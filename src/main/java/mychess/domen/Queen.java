package mychess.domen;

public class Queen extends Figure {

    public Queen(int locationX,int locationY, char side, String imagePath) {
        super(locationX, locationY, imagePath);
        this.side = side;
    }

    @Override
    protected void moveToMouse(int mouseX, int mouseY) {
        super.moveToMouse(mouseX, mouseY);
    }
}
