package com.sxt;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayerOne extends Tank {

    private boolean left;
	private boolean down;
	private boolean right;
	private boolean up;

	public PlayerOne(String img, int x, int y, String upImage, String downImage, String leftImage, String rightImage, GamePanel gamePanel){
        super(img, x, y, upImage, downImage, leftImage, rightImage, gamePanel);
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_A:
                left = true;
                break;
            case KeyEvent.VK_S:
                down = true;
                break;
            case KeyEvent.VK_D:
                right = true;
                break;
            case KeyEvent.VK_W:
                up = true;
                break;
            default:
                break;
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_A:
                 left = false;
                break;
            case KeyEvent.VK_S:
                down = false;
                break;
            case KeyEvent.VK_D:
                right = false;
                break;
            case KeyEvent.VK_W:
                up = false;
                break;
            default:
                break;
        }
    }
    

    public void paintSelf(Graphics g) {
        g.drawImage(img, x, y, null);
    }

    public Rectangle getRec() {
        return new Rectangle(x, y, width, height);
    }
}