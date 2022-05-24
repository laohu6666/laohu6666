package com.sxt;

import java.awt.Color;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
public class GamePanel extends JFrame {

    //窗口长宽
    int width = 800;
    int height = 610;
    //指针图片
    Image select = Toolkit.getDefaultToolkit().getImage("D:\\坦克大战\\【尚学堂】Java游戏项目之1小时做出Java坦克大战小游戏\\【尚学堂】Java游戏项目之1小时做出Java坦克大战小游戏_源码课件\\images\\selecttank.gif");
    //指针初始纵坐标
   int y = 150;
   //游戏模式 0 游戏开始， 1 单人模式，2 双人模式
   int state = 0;
    public void launch(){
        //标题
        setTitle("坦克大战");
        //窗口初始大小
        setSize(width, height);
        //使屏幕居中
        setLocationRelativeTo(null);
        //添加关闭事件
        setDefaultCloseOperation(3);
        //用户不能调整大小
        setResizable(false);
        //使窗口可见
        setVisible(true);
        //添加键盘事件
        this.addKeyListener(new GamePanel.KeyMonitor());
       
        //重绘
        while(true) {
        	repaint();
        	try {
        		Thread.sleep(100);
        		
        	}catch(Exception e) {
        		e.printStackTrace();
        		}
        }
    }
    //paint()方法
    @Override
    public void paint(Graphics g) {
        //设置背景颜色
        g.setColor(Color.gray);
        //填充整个画布
        g.fillRect(0, 0, width, height);
  //挂变画笔颜色
    g.setColor(Color.BLUE);
    //改变文字大小和样式
    g.setFont(new Font("仿宋",Font.BOLD,50));
    //添加文字
    if(state==0) {
    g.drawString("选择游戏模式",220,100);
    g.drawString("单人游戏",220,200);
    g.drawString("双人游戏",220,300);
    //绘制指针
    g.drawImage(select,160, y,null);}
}
    //state == 0/1, 游戏开始
     
    //键盘监视器
    class KeyMonitor extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            //super.keyPressed(e);
            int key = e.getKeyCode();
            System.out.println(key);
            System.out.println(e.getKeyChar());
        }
    }

    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();
        gamePanel.launch();
    }
}