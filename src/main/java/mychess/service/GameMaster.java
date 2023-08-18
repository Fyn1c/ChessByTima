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
        for(int i = 1; i < map.length + 1; i++){
            if(i == 1){
                for(int j = 1; j < map.length + 1; j++){
                    switch (j) {
                        case 1 -> addGameObject.accept(new Rook(j, i, 0, FILE_BLACK_ROOK));
                        case 2 -> addGameObject.accept(new Horse(j, i, 0, FILE_BLACK_HORSE));
                        case 3 -> addGameObject.accept(new Elephant(j, i, 0, FILE_BLACK_ELEPHANT));
                        case 4 -> addGameObject.accept(new Queen(j, i, 0, FILE_BLACK_QUEEN));
                        case 5 -> addGameObject.accept(new King(j, i, 0, FILE_BLACK_KING));
                        case 6 -> addGameObject.accept(new Elephant(j, i, 0, FILE_BLACK_ELEPHANT));
                        case 7 -> addGameObject.accept(new Horse(j, i, 0, FILE_BLACK_HORSE));
                        case 8 -> addGameObject.accept(new Rook(j, i, 0, FILE_BLACK_ROOK));
                    }
                }
            }
            if(i == 2){
                for(int t = 1; t < map.length + 1; t++){
                    addGameObject.accept(new Pawn(t, i, 0, FILE_BLACK_PAWN));
                }
            }
            if(i == 7){
                for(int k = 1; k < map.length + 1; k++){
                        addGameObject.accept(new Pawn(k, i, 1, FILE_WHITE_PAWN));
                }
            }
            if(i == 8){
                for(int d = 1; d < map.length + 1; d++){
                    switch (d) {
                        case 1 -> addGameObject.accept(new Rook(d, i, 1, FILE_WHITE_ROOK));
                        case 2 -> addGameObject.accept(new Horse(d, i, 1, FILE_WHITE_HORSE));
                        case 3 -> addGameObject.accept(new Elephant(d, i, 1, FILE_WHITE_ELEPHANT));
                        case 4 -> addGameObject.accept(new Queen(d, i, 1, FILE_WHITE_QUEEN));
                        case 5 -> addGameObject.accept(new King(d, i, 1, FILE_WHITE_KING));
                        case 6 -> addGameObject.accept(new Elephant(d, i, 1, FILE_WHITE_ELEPHANT));
                        case 7 -> addGameObject.accept(new Horse(d, i, 1, FILE_WHITE_HORSE));
                        case 8 -> addGameObject.accept(new Rook(d, i, 1, FILE_WHITE_ROOK));
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

    public void deleteGameObject(GameObject gameObject){
        gameObjects.remove(gameObject);
    }

    public GameObject findGameObject(GameObject gameObject){
        return gameObjects.stream()
                .filter(g -> g.getLocationX() == gameObject.getLocationX() && g.getLocationY() == gameObject.getLocationY())
                .findFirst().orElse(null);
    }

    public GameObject findGameObject(int x, int y){
        return gameObjects.stream()
                .filter(g -> g.getLocationX() == x && g.getLocationY() == y)
                .findFirst().orElse(null);
    }

    public void addDynamicObject(GameObject dynamicObject){
        this.dynamicObject = dynamicObject;
    }
    public void deleteDynamicObject(){
        this.dynamicObject = null;
    }

}
