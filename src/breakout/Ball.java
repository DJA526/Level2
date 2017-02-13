package Breakout;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject {

	int xspeed = 6;
	int yspeed = -6;
	int direction = 1;
	final int PADDLE_Y = 705;

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
			yspeed = 6;
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
		if (y > Breakout.HEIGHT) {
			x = 750;
			y = 400;
			loseLife = true;
		}
		super.update();
	}

	void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, width, height);
	}

}
