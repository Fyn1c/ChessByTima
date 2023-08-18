package mychess;

import mychess.configuration.Configuration;
import mychess.controller.MouseController;
import mychess.service.GameMaster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JPanel implements ActionListener {
    private Timer timer;
    private final GameMaster gameMaster;


    public GameFrame(JFrame frame) {
        timer = new Timer(Configuration.GAME_FRAMES_PER_SECOND, this);
        this.gameMaster = GameMaster.getInstance();
        gameMaster.setGameFrame(this);
        frame.setLocationRelativeTo(null);
        timer.start();

        MouseController mouseController = new MouseController(gameMaster.getPlayer());
        frame.addMouseListener(mouseController);
        frame.addMouseMotionListener(mouseController);

    }

    public void timerStop(){
        timer.stop();
    }

    @Override
    public void paint(Graphics graphics) {
        gameMaster.renderFrame(graphics);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
