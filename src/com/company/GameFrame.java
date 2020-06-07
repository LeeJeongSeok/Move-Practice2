package com.company;

import com.sun.xml.internal.ws.org.objectweb.asm.ByteVector;
import sun.swing.SwingAccessor;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame() {

        add(new GamePanel());

        setResizable(false);
        pack();

        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setVisible(true);
    }
}
