package mychess.controller;

import mychess.domen.GameObject;
import mychess.domen.Player;
import mychess.service.GameMaster;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MouseController extends MouseAdapter {

    private final Player player;
    private final GameMaster gameMaster;

    public MouseController(Player player) {
        this.player = player;
        this.gameMaster = GameMaster.getInstance();
    }


    @Override
    public void mousePressed(MouseEvent e) {
        int startX = e.getX();
        int startY = e.getY();
        int goX = startX / 64 - 64;
        int goY = startY / 64 - 64;


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }
}
