package mychess.domen;

public class Queen extends GameObject {

    public Queen(int locationX,int locationY, int side, String imagePath) {
        super(locationX, locationY, imagePath);
        this.side = side;
    }


}
