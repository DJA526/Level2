package breakout;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {
	
	int x;
	int y;
	int width;
	int height;
	int speed;
	
	Paddle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 20;
	}
	
	void update() {
				
	}
	
	void draw(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(x, y, width, height);
	}

}
