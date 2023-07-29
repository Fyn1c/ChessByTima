package mychess.domen;

public class Elephant extends GameObject {

    public Elephant(int locationX, int locationY, int side, String imagePath) {
        super(locationX, locationY, imagePath);
        this.side = side;
    }

    @Override
    public void move() {
    }
}
