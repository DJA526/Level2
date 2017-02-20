package Breakout;

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
	ObjectManager manager = new ObjectManager();
	Paddle paddle;
	Ball ball;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	final int INSTRUCTIONS_STATE = 3;
	int currentState = MENU_STATE;

	GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		subFont = new Font("Arial", Font.PLAIN, 25);
		paddle = new Paddle(750, 730, 110, 25);
		ball = new Ball(750, 400, 25, 25);
		manager.addObject(paddle);
		manager.addObject(ball);
		manager.addBlocks();
	}

	void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
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
		manager.update();
		manager.checkCollision();
		if (manager.gameOver == true) {
			currentState = END_STATE;
		}
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
		g.setColor(Color.black);
		g.fillRect(0, 0, Breakout.WIDTH, Breakout.HEIGHT);
		g.setFont(subFont);
		manager.draw(g);
		g.setColor(Color.white);
		String lives = "Lives: " + manager.lives;
		g.drawString(lives, 20, 760);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(0, 0, Breakout.WIDTH, Breakout.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.black);
		if (manager.win == true) {
			g.drawString("YOU WIN!", 620, 250);
		} else {
			g.drawString("YOU LOSE", 620, 250);
		}
		g.setFont(subFont);
		g.drawString("Press ENTER to play again.", 590, 350);
	}

	void drawInstructionsState(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, Breakout.WIDTH, Breakout.HEIGHT);
		g.setColor(Color.white);
		g.setFont(subFont);
		g.drawString("Use the left and right arrow keys to move your paddle back and forth and hit the ball.", 250,
				250);
		g.drawString("Each time the ball goes past the bottom of the screen, you lose one of your 3 lives.", 257, 300);
		g.drawString("If you lose all your lives, the game ends.", 490, 350);
		g.drawString("If you break all the blocks at the top of the screen, you win the game.", 340, 400);
		g.drawString("Press ENTER to begin playing!", 530, 450);
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

		if (currentState == INSTRUCTIONS_STATE && e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState = GAME_STATE;
		}

		if (currentState == END_STATE && e.getKeyCode() == KeyEvent.VK_ENTER) {
			manager.reset();
			paddle.setPosition(750, 730);
			currentState = GAME_STATE;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			paddle.isMoving = true;
			paddle.moveLeft = true;
		} else {
			paddle.moveLeft = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			paddle.moveRight = true;
			paddle.isMoving = true;
		} else {
			paddle.moveRight = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		paddle.isMoving = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		} else if (currentState == INSTRUCTIONS_STATE) {
			updateInstructionsState();
		}
	}

}
