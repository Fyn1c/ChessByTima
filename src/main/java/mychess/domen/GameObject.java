package mychess.domen;

import javax.swing.*;
import java.awt.*;

import static mychess.configuration.Configuration.*;

public class GameObject {
    private final Image image;
    protected int locationX;
    protected int locationY;

    public GameObject(int locationX, int locationY, String imagePath){
        this.locationX = locationX;
        this.locationY = locationY;
        this.image = new ImageIcon(imagePath).getImage();
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    protected void moveToMouse(int mouseX, int mouseY){}

    public void render(Graphics graphics) {
        graphics.drawImage(image, locationX * SPRITE_SIZE + 64, locationY * SPRITE_SIZE + 64, null);
    }
}
