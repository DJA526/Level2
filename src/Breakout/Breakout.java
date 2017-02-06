package Breakout;

import javax.swing.JFrame;

public class Breakout {
	
	JFrame window;
	final static int WIDTH = 1500;
	final static int HEIGHT = 800;
	GamePanel gamePanel;
	
	public static void main(String[] args) {
		Breakout a = new Breakout();
	}
	
	Breakout() {
		window = new JFrame();
		gamePanel = new GamePanel();
		setup();
	}
	
	void setup() {
		window.add(gamePanel);
		window.addKeyListener(gamePanel);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WIDTH, HEIGHT);
		gamePanel.startGame();
	}

}
