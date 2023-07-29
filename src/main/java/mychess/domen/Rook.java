package mychess.domen;

public class Rook extends GameObject {

    public Rook(int locationX, int locationY, int side, String imagePath) {
        super(locationX, locationY, imagePath);
        this.side = side;
    }


}
