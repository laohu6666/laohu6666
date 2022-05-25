package com.sxt;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public abstract class GameObject {

    //图片
    public Image img;
    //游戏元素的横坐标
    public int x;
    //游戏元素的纵坐标
   public int y;
    //界面
    private GamePanel gamePanel;

   
    public GameObject(String img, int x, int y, GamePanel gamePanel) {
        this.img = Toolkit.getDefaultToolkit().getImage(img);
        this.x = x;
        this.y = y;
        this.gamePanel = gamePanel;
    }

    public abstract void paintSelf(Graphics g);

   
    public abstract Rectangle getRec();
}
