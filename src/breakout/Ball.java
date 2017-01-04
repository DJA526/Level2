package breakout;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject {
	
	Ball(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	void update() {
		super.update();
	}
	
	void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, width, height);
	}

}
