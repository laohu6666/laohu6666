package com.sxt;

import java.awt.Color;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
public class GamePanel extends JFrame {

    //���ڳ���
    int width = 800;
    int height = 610;
    //ָ��ͼƬ
    Image select = Toolkit.getDefaultToolkit().getImage("D:\\̹�˴�ս\\����ѧ�á�Java��Ϸ��Ŀ֮1Сʱ����Java̹�˴�սС��Ϸ\\����ѧ�á�Java��Ϸ��Ŀ֮1Сʱ����Java̹�˴�սС��Ϸ_Դ��μ�\\images\\selecttank.gif");
    //ָ���ʼ������
   int y = 150;
   //��Ϸģʽ 0 ��Ϸ��ʼ�� 1 ����ģʽ��2 ˫��ģʽ
   int state = 0;
    public void launch(){
        //����
        setTitle("̹�˴�ս");
        //���ڳ�ʼ��С
        setSize(width, height);
        //ʹ��Ļ����
        setLocationRelativeTo(null);
        //��ӹر��¼�
        setDefaultCloseOperation(3);
        //�û����ܵ�����С
        setResizable(false);
        //ʹ���ڿɼ�
        setVisible(true);
        //��Ӽ����¼�
        this.addKeyListener(new GamePanel.KeyMonitor());
       
        //�ػ�
        while(true) {
        	repaint();
        	try {
        		Thread.sleep(100);
        		
        	}catch(Exception e) {
        		e.printStackTrace();
        		}
        }
    }
    //paint()����
    @Override
    public void paint(Graphics g) {
        //���ñ�����ɫ
        g.setColor(Color.gray);
        //�����������
        g.fillRect(0, 0, width, height);
  //�ұ仭����ɫ
    g.setColor(Color.BLUE);
    //�ı����ִ�С����ʽ
    g.setFont(new Font("����",Font.BOLD,50));
    //�������
    if(state==0) {
    g.drawString("ѡ����Ϸģʽ",220,100);
    g.drawString("������Ϸ",220,200);
    g.drawString("˫����Ϸ",220,300);
    //����ָ��
    g.drawImage(select,160, y,null);}
}
    //state == 0/1, ��Ϸ��ʼ
     
    //���̼�����
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