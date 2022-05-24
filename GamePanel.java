package com.sxt;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
public class GamePanel extends JFrame {
     //定义双缓存图片
	Image offScreemImage = null;
    //窗口长宽
    int width = 800;
    int height = 610;
    //指针图片
    Image select = Toolkit.getDefaultToolkit().getImage("D:\\坦克大战\\【尚学堂】Java游戏项目之1小时做出Java坦克大战小游戏\\【尚学堂】Java游戏项目之1小时做出Java坦克大战小游戏_源码课件\\images\\selecttank.gif");
    //指针初始纵坐标
   int y = 150;
   //游戏模式 0 游戏开始， 1 单人模式，2 双人模式
   int state = 0;
   int a = 1;
   //窗口的启动方法
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
        //添加键盘监视器
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
    	//创建和容器一样大小的Image图片
    	if(offScreemImage == null) {
    		offScreemImage =this.createImage(width,height);
    	}
    	//获得该图片的画笔
    	Graphics gImage = offScreemImage.getGraphics();
        //设置背景颜色
    	gImage.setColor(Color.gray);
        //填充整个画布
    	gImage.fillRect(0, 0, width, height);
  //挂变画笔颜色
    	gImage.setColor(Color.BLUE);
    //改变文字大小和样式
    	gImage.setFont(new Font("仿宋",Font.BOLD,50));
    //添加文字
    if(state==0) {
    	gImage.drawString("选择游戏模式",220,100);
    	gImage.drawString("单人游戏",220,200);
    	gImage.drawString("双人游戏",220,300);
    	gImage.drawString("按1，2选择模式，按回车开始游戏",0,400);
    //绘制指针
    	gImage.drawImage(select,160, y,null);
}
    //state == 0/1, 游戏开始;
    else if(state == 1||state == 2){
       
    	gImage.drawString("游戏开始",220,100);
        if(state == 1){
        	gImage.drawString("单人模式",220,200);
        }
        else{
        	gImage.drawString("双人模式",220,200);
        }
    }
    g.drawImage(offScreemImage,0,0,null);
}
   
  //键盘监视器
    private class KeyMonitor extends KeyAdapter {
    	//按下键盘
        @Override
        public void keyPressed(KeyEvent e) {
            //返回键值
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_1:
                         a = 1;
                        y = 150;
                       
                    
                    break;
                case KeyEvent.VK_2:
                        a = 2;
                        y = 250;
                        
                    break;
                case KeyEvent.VK_ENTER:
                    state = a;
                    break;
                
            }
        }
    }

    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();
        gamePanel.launch();
    }
}