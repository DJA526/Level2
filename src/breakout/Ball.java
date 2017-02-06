package Breakout;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject {

	int xspeed = 3;
	int yspeed = -3;
	int direction = 1;

	Ball(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	void update() {
		x += xspeed;
		y += yspeed;
		if (blockBounce) {
			yspeed = 3;
			System.out.println("hi");
			blockBounce = false;
		}
		if (paddleBounce) {
			y -= 7;
			yspeed = -yspeed;
			paddleBounce = false;
		}
		if (x + width > Breakout.WIDTH || x < 0) {
			xspeed = -xspeed;
		}
		if (y - height < 0) {
			yspeed = -yspeed;
		}
		super.update();
	}

	void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, width, height);
	}

}
