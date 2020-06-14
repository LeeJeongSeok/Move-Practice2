package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        EventQueue.invokeLater(() -> {
            JFrame ex = new GameFrame();
            ex.setVisible(true);
        });
    }
}
