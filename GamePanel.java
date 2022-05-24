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
     //����˫����ͼƬ
	Image offScreemImage = null;
    //���ڳ���
    int width = 800;
    int height = 610;
    //ָ��ͼƬ
    Image select = Toolkit.getDefaultToolkit().getImage("D:\\̹�˴�ս\\����ѧ�á�Java��Ϸ��Ŀ֮1Сʱ����Java̹�˴�սС��Ϸ\\����ѧ�á�Java��Ϸ��Ŀ֮1Сʱ����Java̹�˴�սС��Ϸ_Դ��μ�\\images\\selecttank.gif");
    //ָ���ʼ������
   int y = 150;
   //��Ϸģʽ 0 ��Ϸ��ʼ�� 1 ����ģʽ��2 ˫��ģʽ
   int state = 0;
   int a = 1;
   //���ڵ���������
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
        //��Ӽ��̼�����
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
    	//����������һ����С��ImageͼƬ
    	if(offScreemImage == null) {
    		offScreemImage =this.createImage(width,height);
    	}
    	//��ø�ͼƬ�Ļ���
    	Graphics gImage = offScreemImage.getGraphics();
        //���ñ�����ɫ
    	gImage.setColor(Color.gray);
        //�����������
    	gImage.fillRect(0, 0, width, height);
  //�ұ仭����ɫ
    	gImage.setColor(Color.BLUE);
    //�ı����ִ�С����ʽ
    	gImage.setFont(new Font("����",Font.BOLD,50));
    //�������
    if(state==0) {
    	gImage.drawString("ѡ����Ϸģʽ",220,100);
    	gImage.drawString("������Ϸ",220,200);
    	gImage.drawString("˫����Ϸ",220,300);
    	gImage.drawString("��1��2ѡ��ģʽ�����س���ʼ��Ϸ",0,400);
    //����ָ��
    	gImage.drawImage(select,160, y,null);
}
    //state == 0/1, ��Ϸ��ʼ;
    else if(state == 1||state == 2){
       
    	gImage.drawString("��Ϸ��ʼ",220,100);
        if(state == 1){
        	gImage.drawString("����ģʽ",220,200);
        }
        else{
        	gImage.drawString("˫��ģʽ",220,200);
        }
    }
    g.drawImage(offScreemImage,0,0,null);
}
   
  //���̼�����
    private class KeyMonitor extends KeyAdapter {
    	//���¼���
        @Override
        public void keyPressed(KeyEvent e) {
            //���ؼ�ֵ
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