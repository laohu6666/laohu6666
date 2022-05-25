package com.sxt;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

public abstract class Tank extends GameObject{
    //�ߴ�
	 int width = 40;
     int height = 50;
     //̹���ٶ�
    private int speed = 3;
     //̹�˳�ʼ����
    private Direction direction = Direction.UP;
    //�ĸ�����ͼƬ
    private String upImage; 
    private String downImage;
    private String rightImage;
    private String leftImage;
   
    //̹�����꣬����ͼƬ���������
    public Tank(String img, int x, int y, String upIMG,String downImage, String leftImage, String rightImage, GamePanel gamePanel) {
        super(img,x,y,gamePanel);
        this.upImage = upImage;
        this.leftImage = leftImage;
        this.downImage = downImage;
        this.rightImage = rightImage;
    }
   
    public void leftward(){
        direction = Direction.LEFT;
        setImg(leftImage);
        this.x -= speed;
        
    }
    public void rightward(){
        direction = Direction.RIGHT;
        setImg(rightImage);
        this.x += speed;

    }
    public void upward(){
        direction = Direction.UP;
        setImg(upImage);
        this.y -= speed;

    }
    public void downward(){
        direction = Direction.DOWN;
        setImg(downImage);
         this.y += speed;
         
    }
    public void setImg(String img) {
       	  this.img = Toolkit.getDefaultToolkit().getImage(img);

    }

    @Override
    public abstract void paintSelf(Graphics g);

    @Override
    public abstract Rectangle getRec();
   
}