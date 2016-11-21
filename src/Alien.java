import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	
	int counter;
	static boolean endGame = false;
	
	Alien(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		counter = 0;
	}

	void update() {
		super.update();
		if (counter < 50) {
			x++;
			y++;
			counter++;
		} else if (counter >= 50) {
			x--;
			y++;
			counter++;
		} if (counter >= 100) {
			counter = 0;
		} if (y >= 800) {
			endGame = true;
		}
	}
	
	void draw(Graphics g) {
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}
}
