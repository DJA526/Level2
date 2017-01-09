package breakout;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject {
	
	int xspeed = 2;
	int yspeed = -2;
	
	Ball(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	void update() {
		super.update();
		x += xspeed;
		y += yspeed;
		if (bounce) {
			yspeed = -yspeed;
			bounce = false;
		}
		if (x + width > Breakout.WIDTH || x - width < 0) {
			xspeed = -xspeed;
		}
		if ( y - height > 0) {
			yspeed = -yspeed;
		}
	}
	
	void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, width, height);
	}

}
