import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	
	int position = 0;
	
	Alien(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	void update() {
		super.update();
		if (position < 5) {
			y++;
			x++;
			position++;
		} else if (position > 5) {
			y--;
			x--;
			position++;
		} else if (position >= 10) {
			
		}
	}
	
	void draw(Graphics g) {
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}
}
