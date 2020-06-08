package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {

    private final int B_WIDTH = 300;
    private final int B_HEIGHT = 300;
    private final int ALL_DOTS = 900;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private Image head;
    private Image tail;
    private Image apple;

    private int dots;
    private int apple_x;
    private int apple_y;


    public GamePanel() {
        initBoard();
    }

    private void initBoard() {

        addKeyListener(this);
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();

    }

    private void loadImages() {

        ImageIcon ihead = new ImageIcon("src/resources/head.png");
        head = ihead.getImage();

        ImageIcon itail = new ImageIcon("src/resources/dot.png");
        tail = itail.getImage();

        ImageIcon iapple = new ImageIcon("src/resources/apple.png");
        apple = iapple.getImage();
    }

    private void initGame() {

        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }

        locateApple();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(head, 150, 100, this);
        g.drawImage(tail, 200, 100, this);

        g.drawImage(apple, apple_x, apple_y, this);
    }

    // 위치값만 설정
    private void locateApple() {

        apple_x = 50;
        apple_y = 50;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
