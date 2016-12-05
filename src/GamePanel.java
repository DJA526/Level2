import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
	Timer timer;
	Font titleFont;
	Font subFont;
	Rocketship rocketship;
	ObjectManager manager = new ObjectManager();
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	final int INSTRUCTIONS_STATE = 3;
	int currentState = MENU_STATE;
	int score;
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;
	
	GamePanel() {
		timer = new Timer(1000/60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		subFont = new Font("Arial", Font.PLAIN, 25);
		rocketship = new Rocketship(250, 700, 50, 50);
		manager.addObject(rocketship);
		try {
			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		if (rocketship.isAlive == false || Alien.endGame == true) {
			endGame();
		}
		score = manager.getScore();
	}
	
	void endGame() {
		currentState = END_STATE;
		manager.reset();
		rocketship = new Rocketship(250, 700, 50, 50);
		manager.addObject(rocketship);
	}
	
	void updateEndState() {
		repaint();
	}
	
	void updateInstructionsState() {
		repaint();
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.white);
		g.drawString("LEAUGE INVADERS", 20, 200);
		g.setFont(subFont);
		g.drawString("Press ENTER to start", 110, 300);
		g.drawString("Press SPACE for instructions", 65, 400);
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		manager.draw(g);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.black);
		g.drawString("GAME OVER", 100, 100);
		g.setFont(subFont);
		g.drawString("You killed " + score + " aliens.", 135, 300);
		g.drawString("Press BACKSPACE to restart.", 80, 500);
	}
	
	void drawInstructionsState(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(subFont);
		g.setColor(Color.white);
		g.drawString("Use the arrow keys to move your rocketship.", 5, 200);
		g.drawString("Use the space bar to shoot the aliens.", 25, 300);
		g.drawString("If an alien gets past the bottom of the screen", 1, 400);
		g.drawString("or touches your rocketship, the game ends.", 7, 425);
		g.drawString("Press ENTER to start.", 105, 525);
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

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocketship.x -= rocketship.speed;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocketship.x += rocketship.speed;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocketship.y -= rocketship.speed;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocketship.y += rocketship.speed;
		} 
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			manager.addObject(new Projectile(rocketship.x + 20, rocketship.y, 10, 10));
		}
		if (currentState == MENU_STATE) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				currentState = GAME_STATE;
			} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				currentState = INSTRUCTIONS_STATE;
			}
		}
		if (currentState == END_STATE && e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			currentState = GAME_STATE;
			manager.setScore(0);
		}
		if (currentState == INSTRUCTIONS_STATE && e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState = GAME_STATE;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
