package breakout;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends GameObject {
	
	int speed;

	Paddle(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 25;
	}
	
	void update() {
		super.update();
	}
	
	void draw(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(x, y, width, height);
	}

}
