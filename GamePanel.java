package com.sxt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePanel extends JFrame {

    /** 定义双缓存图片 */
    Image offScreenImage = null;
    //游戏状态 0 游戏未开始， 1 单人模式， 2 双人模式， 3 游戏暂停， 4 游戏失败， 5 游戏胜利
    int state= 0;
    //游戏是否开始
    private boolean start = false;
    //临时变量
    int a = 1;
    //重绘次数
    public int count = 0;
    //窗口长宽
    int width = 800;
    int height = 610;
    //物体集合
    public List<Bullet> bulletList = new ArrayList<>();
    public List<Tank> tankList = new ArrayList<>();
    public List<Bot> botList = new ArrayList<>();
    public List<Bullet> removeList = new ArrayList<>();
    public List<Wall> wallList = new ArrayList<>();
    //游戏指针
    Image select = Toolkit.getDefaultToolkit().getImage("src/images/P2tankR.gif");
    //指针初始高度
    int y = 150;
    //玩家
    private PlayerOne playerOne = new PlayerOne("src/images/p1tankU.gif", 125, 510,
            "src/images/p1tankU.gif","src/images/p1tankD.gif",
            "src/images/p1tankL.gif","src/images/p1tankR.gif", this);

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
        //添加键盘事件
        this.addKeyListener(new GamePanel.KeyMonitor());
        //添加围墙
        for(int i = 0; i< 14; i ++){
            wallList.add(new Wall("src/images/walls.gif", i*60 ,170, this ));
        }
        wallList.add(new Wall("src/images/walls.gif", 305 ,560,this ));
        wallList.add(new Wall("src/images/walls.gif", 305 ,500,this ));
        wallList.add(new Wall("src/images/walls.gif", 365 ,500,this ));
        wallList.add(new Wall("src/images/walls.gif", 425 ,500,this ));
        wallList.add(new Wall("src/images/walls.gif", 425 ,560,this ));

        while (true){
            if (count % 100 == 1) {
                Random r = new Random();
                int rnum =r.nextInt(800);
                botList.add(new Bot("src/images/enemy1U.gif", rnum, 110,
                        "src/images/enemy1U.gif","src/images/enemy1D.gif",
                        "src/images/enemy1L.gif","src/images/enemy1R.gif", this));
               
            }
            repaint();
            try {
                //线程休眠  1秒 = 1000毫秒
                Thread.sleep(25);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public void paint(Graphics g) {
        //创建和容器一样大小的Image图片
        if(offScreenImage ==null){
            offScreenImage=this.createImage(width, height);
        }
        //获得该图片的画布
        Graphics gImage= offScreenImage.getGraphics();
        //设置背景颜色
        gImage.setColor(Color.BLACK);
        //填充整个画布
        gImage.fillRect(0, 0, width, height);
        //挂变画笔颜色
        gImage.setColor(Color.RED);
        //改变文字大小和样式
        gImage.setFont(new Font("仿宋",Font.BOLD,50));
        if(state == 0){
            //添加文字
            gImage.drawString("选择游戏模式",220,100);
            gImage.drawString("单人游戏",220,200);
            gImage.drawString("双人游戏",220,300);
            gImage.drawString("按1，2选择模式，按回车开始游戏",0,400);
            gImage.drawImage(select,160,y,null);
        }
        else if(state == 1||state == 2){
            //添加文字
            gImage.drawString("游戏开始",220,300);
            if(state == 1){
                gImage.drawString("单人模式",220,200);
            }
            else{
                gImage.drawString("双人模式",220,200);
            }
            //paint重绘游戏元素
            for(Tank player: tankList){
                player.paintSelf(gImage);
            }
            for(Bullet bullet: bulletList){
                bullet.paintSelf(gImage);
            }
            bulletList.removeAll(removeList);
            for(Bot bot: botList){
                bot.paintSelf(gImage);
            }
            for (Wall wall: wallList){
                wall.paintSelf(gImage);
            }
            //重绘次数+1
            count++;
        }
        /** 将缓冲区绘制好哦的图形整个绘制到容器的画布中 */
        g.drawImage(offScreenImage, 0, 0, null);
    }
    private class KeyMonitor extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            //super.keyPressed(e);
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_1:
                    if(!start){
                        y = 150;
                        a = 1;
                    }
                    //System.out.println(state);
                    break;
                case KeyEvent.VK_2:
                    if(!start){
                        y = 250;
                        a = 2;
                    }
                    //System.out.println(state);
                    break;
                case KeyEvent.VK_ENTER:
                    tankList.add(playerOne);
                    state = a;
                    start = true;
                    //System.out.println("state:"+""+state);
                    break;
                default:
                    playerOne.keyPressed(e);
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e){
            playerOne.keyReleased(e);
        }
    }

    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();
        gamePanel.launch();
    }
}