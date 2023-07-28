package mychess.domen;

public abstract class Figure extends GameObject {

    protected char side;

    public Figure(int locationX, int locationY, String imagePath) {
        super(locationX, locationY, imagePath);
    }

    protected void move(){}


}
