package mychess.domen;

public class Horse extends GameObject {

    public Horse(int locationX, int locationY, int side, String imagePath) {
        super(locationX, locationY, imagePath);
        this.side = side;
    }
}
