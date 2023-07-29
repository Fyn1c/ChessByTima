package mychess.service;

import mychess.GameFrame;
import mychess.domen.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static mychess.configuration.Configuration.*;
import static mychess.configuration.Configuration.FILE_WHITE_KING;

public class GameMaster {
    private GameFrame gameFrame;
    private Player player;
    private static GameMaster instance;
    private final Map map;
    private List<GameObject> gameObjects;
    private GameObject dynamicObject;

    public static synchronized GameMaster getInstance() {
        if (instance == null) {
            instance = new GameMaster();
        }
        return instance;
    }
    private GameMaster(){
        this.map = new Map();
        this.gameObjects = initObject(map.getMap());
    }
    private List<GameObject> initObject(int map[][]){
        List<GameObject> gameObjects = new ArrayList<>();
        Consumer<GameObject> addGameObject = gameObjects::add;
        for(int i = 0; i < map.length; i++){
            if(i == 0){
                for(int j = 0; j < map.length; j++){
                    switch (j) {
                        case 0 -> addGameObject.accept(new Rook(j, i, 0, FILE_BLACK_ROOK));
                        case 1 -> addGameObject.accept(new Horse(j, i, 0, FILE_BLACK_HORSE));
                        case 2 -> addGameObject.accept(new Elephant(j, i, 0, FILE_BLACK_ELEPHANT));
                        case 3 -> addGameObject.accept(new Queen(j, i, 0, FILE_BLACK_QUEEN));
                        case 4 -> addGameObject.accept(new King(j, i, 0, FILE_BLACK_KING));
                        case 5 -> addGameObject.accept(new Elephant(j, i, 0, FILE_BLACK_ELEPHANT));
                        case 6 -> addGameObject.accept(new Horse(j, i, 0, FILE_BLACK_HORSE));
                        case 7 -> addGameObject.accept(new Rook(j, i, 0, FILE_BLACK_ROOK));
                    }
                }
            }
            if(i == 1){
                for(int t = 0; t < map.length; t++){
                    addGameObject.accept(new Pawn(t, i, 0, FILE_BLACK_PAWN));
                }
            }
            if(i == 6){
                for(int k = 0; k < map.length; k++){
                        addGameObject.accept(new Pawn(k, i, 1, FILE_WHITE_PAWN));
                }
            }
            if(i == 7){
                for(int d = 0; d < map.length; d++){
                    switch (d) {
                        case 0 -> addGameObject.accept(new Rook(d, i, 1, FILE_WHITE_ROOK));
                        case 1 -> addGameObject.accept(new Horse(d, i, 1, FILE_WHITE_HORSE));
                        case 2 -> addGameObject.accept(new Elephant(d, i, 1, FILE_WHITE_ELEPHANT));
                        case 3 -> addGameObject.accept(new Queen(d, i, 1, FILE_WHITE_QUEEN));
                        case 4 -> addGameObject.accept(new King(d, i, 1, FILE_WHITE_KING));
                        case 5 -> addGameObject.accept(new Elephant(d, i, 1, FILE_WHITE_ELEPHANT));
                        case 6 -> addGameObject.accept(new Horse(d, i, 1, FILE_WHITE_HORSE));
                        case 7 -> addGameObject.accept(new Rook(d, i, 1, FILE_WHITE_ROOK));
                    }
                }
            }
        }
        return gameObjects;
    }



    public void renderFrame(Graphics graphics){
        getMap().render(graphics);
        gameObjects.forEach(gm -> gm.render(graphics));
        if(dynamicObject != null) {
            dynamicObject.render1(graphics);
        }
    }
    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    public Player getPlayer(){
        return player;
    }

    public Map getMap(){
        return map;
    }


    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void addDynamicObject(GameObject dynamicObject){
        this.dynamicObject = dynamicObject;
    }
    public void deleteDynamicObject(){
        this.dynamicObject = null;
    }
}
