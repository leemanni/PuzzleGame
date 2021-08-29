package com.leemanni.puzzle;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseListenerTest extends JFrame {
	
	JPanel panel1 = new  JPanel();
	JPanel panel2 = new  JPanel();
	
	

	public MouseListenerTest() {
		
		// Frame
		setTitle("MouseListener");
		setBounds(400, 100, 400, 450);
		
		setLayout(new GridLayout(2,1));
		
		panel2.setBackground(Color.orange);
		
		add(panel1);
		add(panel2);
		
		
		panel2.addMouseListener(new MouseListener() {
			
			@Override
//			mouseReleased() 메소드가 mouseClicked() 메소드보다 먼저 실행된다.
			public void mouseReleased(MouseEvent e) {
				System.out.println("MouseListener가 지정된 영역에서 마우스 버튼에서 손가락을 땔 때");
				panel1.setBackground(Color.BLACK);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("MouseListener가 지정된 영역에서 마우스 버튼을 누르고 때");
				panel1.setBackground(Color.RED);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("MouseListener가 지정된 영역에서 마우스 포인터가 사라질  때");
				panel1.setBackground(Color.green);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("MouseListener가 지정된 영역에서 마우스 포인터가 올라갈 때");
				panel1.setBackground(Color.blue);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("MouseListener가 지정된 영역에서 마우스 버튼이 클릭될 때");
				panel1.setBackground(Color.pink);
				
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		MouseListenerTest window = new MouseListenerTest();
	}



}
