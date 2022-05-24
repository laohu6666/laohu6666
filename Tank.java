package com.sxt;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Tank extends GameObject{
    //尺寸
	int width = 40;
    int height = 50;
     //坦克速度
    private int speed = 3;
     //坦克初始方向
    private Direction direction = Direction.UP;
    //四个方向图片
    private String upImage; 
    private String downImage;
    private String rightImage;
    private String leftImage;
   
    //坦克坐标，方向，图片，方向，面板
    public Tank(String img, int x, int y, String upIMG,String downImage, String leftImage, String rightImage, GamePanel gamePanel) {
        super(img,x,y,gamePanel);
        this.upImage = upImage;
        this.leftImage = leftImage;
        this.downImage = downImage;
        this.rightImage = rightImage;
    }

    @Override
    public abstract void paintSelf(Graphics g);

    @Override
    public abstract Rectangle getRec();
   
}