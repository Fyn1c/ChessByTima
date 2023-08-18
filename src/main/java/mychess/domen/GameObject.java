package mychess.domen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static mychess.configuration.Configuration.*;

public class GameObject {
    protected int side;
    private final Image image;
    protected int locationX;
    protected int locationY;
    protected HashMap<Float, Integer> moves = new HashMap<>();

    public GameObject(int locationX, int locationY, String imagePath){
        this.locationX = locationX;
        this.locationY = locationY;
        this.image = new ImageIcon(imagePath).getImage();
    }

    public void move(){}

    public void render(Graphics graphics) {
        graphics.drawImage(image, locationX * SPRITE_SIZE, locationY * SPRITE_SIZE, null);
    }
    public void render1(Graphics graphics) {
        graphics.drawImage(image, locationX, locationY, null);
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public HashMap<Float, Integer> getMoves() {
        return moves;
    }

    public int getSide() {
        return side;
    }


}
