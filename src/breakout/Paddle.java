package breakout;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends GameObject {

	int speed;
	boolean moveLeft = false;
	boolean moveRight = false;
	boolean isMoving = false;

	Paddle(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 12;
	}

	void update() {
		if (isMoving) {
			if (moveLeft) {
				x -= speed;
			} else if (moveRight) {
				x += speed;
			}
		}
		super.update();
	}

	void draw(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(x, y, width, height);
	}

}
