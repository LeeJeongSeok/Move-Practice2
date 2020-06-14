package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    private final int B_WIDTH = 300;
    private final int B_HEIGHT = 300;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = 29;

    // x,y 좌표값
    // 왜 배열을 쓸까?
    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private int dots;
    private int apple_x;
    private int apple_y;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Image head;
    private Image tail;
    private Image apple;


    public GamePanel() {
        System.out.println("생성자 호출");

        initBoard();
    }

    private void initBoard() {

        System.out.println("initBoard 호출");

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

       doDrawing(g);

    }

    private void doDrawing(Graphics g) {

        if (true) {

            g.drawImage(apple, apple_x, apple_y, this);

            for (int i = 0; i < dots; i++) {
                if (i == 0) {
                    g.drawImage(head, x[i], y[i], this);
                }else {
                    g.drawImage(tail, x[i], y[i], this);
                }
            }
        } else {
            System.out.println("doDrawing 실패");
        }

    }

    private void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }


    // 위치값만 설정
    private void locateApple() {

        int x = (int) (Math.random() * RAND_POS);
        apple_x = ((x * DOT_SIZE));

        int y = (int) (Math.random() * RAND_POS);
        apple_y = ((y * DOT_SIZE));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("test");

        move();


    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());

        if (e.getKeyCode() ==  KeyEvent.VK_RIGHT) {
            rightDirection = true;
            leftDirection = false;
            upDirection = false;
            downDirection = false;
        }

        if (e.getKeyCode() ==  KeyEvent.VK_LEFT) {
            rightDirection = false;
            leftDirection = true;
            upDirection = false;
            downDirection = false;
        }

        if (e.getKeyCode() ==  KeyEvent.VK_UP) {
            rightDirection = false;
            leftDirection = false;
            upDirection = true;
            downDirection = false;
        }

        if (e.getKeyCode() ==  KeyEvent.VK_DOWN) {
            rightDirection = false;
            leftDirection = false;
            upDirection = false;
            downDirection = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
