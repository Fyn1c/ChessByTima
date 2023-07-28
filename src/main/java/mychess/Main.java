package mychess;

import mychess.configuration.Configuration;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame(Configuration.GAME_NAME);
        frame.setSize(640, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new GameFrame(frame));
        frame.setVisible(true);
    }
}