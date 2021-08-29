package com.leemanni.puzzle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ImagePuzzleGame extends JFrame implements ActionListener, MouseListener {

	JPanel puzzlePanel = new JPanel(new GridLayout(4, 4, 1, 1)); // 퍼즐버튼을 올려서 center에 배치
	JButton[] puzzleButtons = new JButton[16]; // 퍼즐버튼
	String[] numbers = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "11", "12", "13", "14", "15", "16" };
	JButton startBtn = new JButton("Start"); // 시작버튼

	// 퍼즐에 사용할 이미지를 저장할 Image 배열을 선언한다.
	Image[] images = new Image[16];

	Font font = new Font("D2coding", Font.BOLD, 50); // 글자통일
	Random random = new Random();

	public ImagePuzzleGame() {

		// Frame
		setTitle("Puzzle..!");
		setBounds(400, 100, 400, 450);

		String [] puzzleName = {"뽀로로" ,
								"보노보노", 
								"코난",
								"인형",
								"영웅",
								"미니언즈",
								"나루토",
								"숫자", 
								"원피스", 
								"피카츄",
								"푸", 
								"호랑이형님"};
		
		String imageName = (String)JOptionPane.showInputDialog(null, "퍼즐 이미지 선택", "퍼즐선택" , JOptionPane.PLAIN_MESSAGE,
				new ImageIcon("./src/puzzleImage/mini/original.jpg"),puzzleName, "미니언즈");
		
		
		
		switch (imageName) {
			case "뽀로로":
				for (int i = 0; i < images.length; i++) {
					images[i] = Toolkit.getDefaultToolkit()
							.getImage(String.format(".\\src\\puzzleImage\\bbororo\\%02d.jpg", i + 1));
				}
				break;
			case "보노보노":
				for (int i = 0; i < images.length; i++) {
					images[i] = Toolkit.getDefaultToolkit()
							.getImage(String.format(".\\src\\puzzleImage\\bonobono\\%02d.jpg", i + 1));
				}
				break;
			case "코난":
				for (int i = 0; i < images.length; i++) {
					images[i] = Toolkit.getDefaultToolkit()
							.getImage(String.format(".\\src\\puzzleImage\\conan\\%02d.jpg", i + 1));
				}
				break;
			case "숫자":
				for (int i = 0; i < images.length; i++) {
					images[i] = Toolkit.getDefaultToolkit()
							.getImage(String.format(".\\src\\puzzleImage\\number\\%02d.jpg", i + 1));
				}
				break;
			case "영웅":
				for (int i = 0; i < images.length; i++) {
					images[i] = Toolkit.getDefaultToolkit()
							.getImage(String.format(".\\src\\puzzleImage\\hero\\%02d.png", i + 1));
				}
				break;
			case "인형":
				for (int i = 0; i < images.length; i++) {
					images[i] = Toolkit.getDefaultToolkit()
							.getImage(String.format(".\\src\\puzzleImage\\doll\\%02d.jpg", i + 1));
				}
				break;
			case "나루토":
				for (int i = 0; i < images.length; i++) {
					images[i] = Toolkit.getDefaultToolkit()
							.getImage(String.format(".\\src\\puzzleImage\\naruto\\%02d.png", i + 1));
				}
				break;
			case "원피스":
				for (int i = 0; i < images.length; i++) {
					images[i] = Toolkit.getDefaultToolkit()
							.getImage(String.format(".\\src\\puzzleImage\\onfice\\%02d.jpg", i + 1));
				}
				break;
			case "푸":
				for (int i = 0; i < images.length; i++) {
					images[i] = Toolkit.getDefaultToolkit()
							.getImage(String.format(".\\src\\puzzleImage\\poo\\%02d.jpg", i + 1));
				}
				break;
			case "피카츄":
				for (int i = 0; i < images.length; i++) {
					images[i] = Toolkit.getDefaultToolkit()
							.getImage(String.format(".\\src\\puzzleImage\\pika\\%02d.jpg", i + 1));
				}
				break;
			case "호랑이형님":
				for (int i = 0; i < images.length; i++) {
					images[i] = Toolkit.getDefaultToolkit()
							.getImage(String.format(".\\src\\puzzleImage\\tiger\\tiger%02d.png", i + 1));
				}
				break;
			case "미니언즈":
				for (int i = 0; i < images.length; i++) {
					images[i] = Toolkit.getDefaultToolkit()
							.getImage(String.format(".\\src\\puzzleImage\\mini\\%02d.jpg", i + 1));
				}
				break;
	
			default:
				break;
		}
		
		
		
		
		// Panel
		puzzlePanel.setPreferredSize(new Dimension(400, 400));

		viewPuzzle();

		// StartBtn
		startBtn.setBackground(Color.black);
		startBtn.setForeground(Color.pink);
		startBtn.setFont(font);
		startBtn.addActionListener(this);

		// Add
		add(puzzlePanel);
		add(startBtn, BorderLayout.SOUTH);
		

		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setVisible(true);
	}

	public static void main(String[] args) {
		ImagePuzzleGame window = new ImagePuzzleGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Start")) {
			for (int i = 0; i < 100000; i++) {
				int r = random.nextInt(15) + 1;
				String temp = numbers[0];
				numbers[0] = numbers[r];
				numbers[r] = temp;
			}
		} 
		resetPuzzleTemplet();

	}

//	패널에 버튼을 올려서 BoderLayout의 CENTER에 올려주는 메소드
	public void viewPuzzle() {
		for (int i = 0; i < puzzleButtons.length; i++) {
			int index = Integer.parseInt(numbers[i]) - 1;
			puzzleButtons[i] = new JButton(new ImageIcon(images[index]));

			puzzlePanel.add(puzzleButtons[i]);
			puzzleButtons[i].addMouseListener(this);

			puzzleButtons[i].setName(numbers[i]);

			if (puzzleButtons[i].getName().equals("16")) {
				puzzleButtons[i].setVisible(false);
			}
		}
	}
	
	private void resetPuzzleTemplet() {
		for (int i = 0; i < puzzleButtons.length; i++) {
			puzzleButtons[i].setVisible(true);
			puzzlePanel.remove(puzzleButtons[i]);
		}
		viewPuzzle();
		add(puzzlePanel);
		revalidate();
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		int selectIndex = 0; // 클릭한 index
		JButton button = (JButton) e.getSource();
		for (int i = 0; i < puzzleButtons.length; i++) {
			if (button.getName().equals(puzzleButtons[i].getName())) {
				selectIndex = i;
				break;
			}
		}

//					# 왼쪽
		if (selectIndex % 4 != 0) {
			if (puzzleButtons[selectIndex - 1].getName().equals("16")) {
				String temp = numbers[selectIndex - 1];
				numbers[selectIndex - 1] = numbers[selectIndex];
				numbers[selectIndex] = temp;
			}
		}
//					# 오른쪽
		if (selectIndex % 4 != 3) {
			if (puzzleButtons[selectIndex + 1].getName().equals("16")) {
				String temp = numbers[selectIndex + 1];
				numbers[selectIndex + 1] = numbers[selectIndex];
				numbers[selectIndex] = temp;
			}
		}
//					# 위쪽
		if (selectIndex / 4 != 0) {
			if (puzzleButtons[selectIndex - 4].getName().equals("16")) {
				String temp = numbers[selectIndex - 4];
				numbers[selectIndex - 4] = numbers[selectIndex];
				numbers[selectIndex] = temp;
			}
		}
//					# 아래쪽
		if (selectIndex / 4 != 3) {
			if (puzzleButtons[selectIndex + 4].getName().equals("16")) {
				String temp = numbers[selectIndex + 4];
				numbers[selectIndex + 4] = numbers[selectIndex];
				numbers[selectIndex] = temp;
			}
		}
		
		resetPuzzleTemplet();

		good: // 레이블
		while (true) {
			for (int i = 0; i < puzzleButtons.length - 1; i++) {
				if (i + 1 != Integer.parseInt(puzzleButtons[i].getName())) {
					break good; // good 라는 레이블의 지정된 반복(while)을 탈출시킨다.
				}
			}
			JOptionPane.showMessageDialog(puzzlePanel, "정답 축하해요~~");
			System.exit(0);
		} 
	}

	
	@Override
	public void mouseExited(MouseEvent e) {}

}

