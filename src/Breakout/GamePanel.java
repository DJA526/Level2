package breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
	Timer timer;
	Font titleFont;
	Font subFont;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	final int INSTRUCTIONS_STATE = 3;
	int currentState = MENU_STATE;
	
	GamePanel() {
		timer = new Timer(1000/60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		subFont = new Font("Arial", Font.PLAIN, 25);
	}
	
	void startGame() {
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		if(currentState == MENU_STATE) {
			drawMenuState(g);
		} else if(currentState == GAME_STATE) {
			drawGameState(g);
		} else if(currentState == END_STATE) {
			drawEndState(g);
		} else if (currentState == INSTRUCTIONS_STATE) {
			drawInstructionsState(g);
		}
	}
	
	void updateMenuState() {
		repaint();
	}
	
	void updateGameState() {
		repaint();
	}

	void updateEndState() {
		repaint();
	}
	
	void updateInstructionsState() {
		repaint();
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, Breakout.WIDTH, Breakout.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.white);
		g.drawString("BREAKOUT", 610, 250);
		g.setFont(subFont);
		g.drawString("Press ENTER to start", 615, 350);
		g.drawString("Press SPACE for instructions", 570, 450);
	}
	
	void drawGameState(Graphics g) {

	}
	
	void drawEndState(Graphics g) {
		
	}
	
	void drawInstructionsState(Graphics g) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (currentState == MENU_STATE) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				currentState = GAME_STATE;
			} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				currentState = INSTRUCTIONS_STATE;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(currentState == MENU_STATE) {
			updateMenuState();
		} else if(currentState == GAME_STATE) {
			updateGameState();
		} else if(currentState == END_STATE) {
			updateEndState();
		} else if (currentState == INSTRUCTIONS_STATE) {
			updateInstructionsState();
		}		
	}

}
