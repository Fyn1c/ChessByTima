package mychess.domen;

import mychess.configuration.Configuration;

import javax.swing.*;
import java.awt.*;

public class Map {
    private static final Image blackField = new ImageIcon(Configuration.FILE_BLACK_FIELD).getImage();
    private static final Image whiteField = new ImageIcon(Configuration.FILE_WHITE_FIELD).getImage();

    private int[][] map;

    public Map() {
        this.map = createMap();
    }

    private int[][] createMap(){
        int[][] map = new int[8][8];

        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if((i + j) % 2 == 0) {
                    map[i][j] = Configuration.WHITE_FIELD;
                }else{
                    map[i][j] = Configuration.BLACK_FIELD;
                }
            }
        }
        return map;
    }
    public void render(Graphics graphics){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if (map[i][j] == 0){
                    graphics.drawImage(whiteField, i * Configuration.SPRITE_SIZE + 64, j * Configuration.SPRITE_SIZE + 64, null);
                }else{
                    graphics.drawImage(blackField, i * Configuration.SPRITE_SIZE + 64, j * Configuration.SPRITE_SIZE + 64, null);

                }
            }
        }
    }

    public int[][] getMap(){
        return map;
    }
}
