package mychess.controller;

import mychess.domen.GameObject;
import mychess.domen.King;
import mychess.domen.Pawn;
import mychess.domen.Player;
import mychess.service.GameMaster;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;

public class MouseController extends MouseInputAdapter {


    private final Player player;
    private final GameMaster gameMaster;
    private GameObject g;
    private int firstYPosition;
    private int firstXPosition;
    private boolean bBeginDrag = false;

    public MouseController(Player player) {
        this.player = player;
        this.gameMaster = GameMaster.getInstance();
        //this.addMouseListener(this);
        //this.addMouseMotionListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int goX = (int) Math.ceil((e.getX() - 64) / 64.0);
        int goY = (int) Math.ceil((e.getY() - 64) / 64.0);
        GameObject gameObject = gameMaster
                .getGameObjects().stream()
                .filter(g -> g.getLocationX() == goX && g.getLocationY() == goY).findFirst().orElse(null);
        if(gameObject != null) {
            this.g = gameObject;
            bBeginDrag = true;
            firstXPosition = g.getLocationX();
            firstYPosition = g.getLocationY();
            gameMaster.getGameObjects().remove(g);
            gameMaster.addDynamicObject(g);
            g.move();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(g != null) {
            bBeginDrag = false;
            int x = (int) Math.ceil((e.getX() - 64) / 64.0);
            int y = (int) Math.ceil((e.getY() - 64) / 64.0);

            if (canMove(x, y)) {
                if (haveFigureOnField(x, y)) {
                    if (canTakeFigure(x, y)) {
                        g.setLocationY(y);
                        g.setLocationX(x);
                        if(g instanceof Pawn && ((Pawn) g).firstMove) ((Pawn) g).firstMove = false;
                        gameMaster.deleteGameObject(gameMaster.findGameObject(x, y));
                        gameMaster.deleteDynamicObject();
                        gameMaster.getGameObjects().add(g);
                        g.getMoves().clear();
                        g = null;
                        return;
                    }
                }else {
                    g.setLocationY(y);
                    g.setLocationX(x);
                    if (g instanceof Pawn && ((Pawn) g).firstMove) ((Pawn) g).firstMove = false;
                    gameMaster.deleteDynamicObject();
                    gameMaster.getGameObjects().add(g);
                    g.getMoves().clear();
                    g = null;
                    return;
                }
            }
            gameMaster.deleteDynamicObject();
            gameMaster.getGameObjects().add(g);
            g.setLocationX(firstXPosition);
            g.setLocationY(firstYPosition);
            g.getMoves().clear();
            g = null;
        }
    }

    private boolean canMove(int imX, int imY){
        if(g != null){
            for(Float y : g.getMoves().keySet()){
                if (y.intValue() == imY && g.getMoves().get(y) == imX){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean haveFigureOnField(int imX, int imY){
        for(GameObject gm : gameMaster.getGameObjects()){
            if(imY == gm.getLocationY() && imX == gm.getLocationX()){
                return true;
            }
        }
        return false;
    }

    private boolean canTakeFigure(int x, int y){
        GameObject gameObject = gameMaster.findGameObject(x, y);
        if(gameObject.getSide() == g.getSide()){
            return false;
        }
        return true;
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        if (!bBeginDrag || (e.getX() > 64*9 || e.getY() > 64*9)) return;
        g.setLocationX(e.getX() - 32);
        g.setLocationY(e.getY() - 60);

    }

}
