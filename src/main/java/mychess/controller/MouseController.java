package mychess.controller;

import mychess.configuration.Configuration;
import mychess.domen.GameObject;
import mychess.domen.King;
import mychess.domen.Player;
import mychess.service.GameMaster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.*;

public class MouseController extends MouseAdapter implements ActionListener {

    private Timer timer;

    private final Player player;
    private final GameMaster gameMaster;
    private MouseEvent em;
    private GameObject g;
    private int firstYPosition;
    private int firstXPosition;

    public MouseController(Player player) {
        this.player = player;
        this.gameMaster = GameMaster.getInstance();
    }


    @Override
    public void mousePressed(MouseEvent e) {
        int goX = (int) (e.getX() / 64.0);
        int goY = (int) (e.getY() / 64.0);
        em = e;
        gameMaster.getGameObjects().stream().filter(g -> g.getLocationX() + 1 == goX && g.getLocationY() + 1 == goY).findFirst().ifPresent(g ->{
            this.g = g;
            firstXPosition = g.getLocationX();
            firstYPosition = g.getLocationY();
            timer = new Timer(100, this);
            gameMaster.getGameObjects().remove(g);
            gameMaster.addDynamicObject(g);
            timer.start();
        });
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(g != null) {
            g.move();
            HashMap<Integer, Integer> moves = g.getMoves();
            for (Integer y : moves.keySet()) {
                if (y == (int) Math.ceil(e.getY() / 64.0) && moves.get(y) == (int) Math.ceil(e.getX() / 64.0)) {
                    for (GameObject gm : gameMaster.getGameObjects()) {
                        if (y == gm.getLocationY() && moves.get(y) == gm.getLocationX()) {
                            if (gm.getSide() != g.getSide()) {
                                if (!(gm instanceof King)) {
                                    gameMaster.getGameObjects().remove(gm);
                                    g.setLocationY(y);
                                    g.setLocationX(moves.get(y));
                                    timer.stop();
                                    break;
                                }
                            }
                        } else {
                            g.setLocationY(y);
                            g.setLocationX(moves.get(y));
                            gameMaster.deleteDynamicObject();
                            gameMaster.getGameObjects().add(g);
                            timer.stop();
                            break;
                        }
                    }
                }
            }
            g.setLocationX(firstXPosition);
            g.setLocationY(firstYPosition);
            gameMaster.deleteDynamicObject();
            gameMaster.getGameObjects().add(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        g.setLocationX(em.getX() - 42);
        g.setLocationY(em.getY() - 42);
    }


}
