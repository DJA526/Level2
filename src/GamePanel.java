import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
	Timer timer;
	GameObject gameObject;
	
	GamePanel() {
		timer = new Timer(1000/60, this);
		gameObject = new GameObject();
	}
	
	void startGame() {
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		gameObject.draw(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		gameObject.update();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("hello!");		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			gameObject.x += 5;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			gameObject.x -= 5;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			gameObject.y -= 5;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			gameObject.y += 5;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("hello!");
	}

}
