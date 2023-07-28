package mychess.domen;

public class Horse extends Figure{

    public Horse(int locationX, int locationY, char side, String imagePath) {
        super(locationX, locationY, imagePath);
        this.side = side;
    }

    @Override
    protected void moveToMouse(int mouseX, int mouseY) {
        super.moveToMouse(mouseX, mouseY);
    }
}
