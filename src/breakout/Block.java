package Breakout;

import java.awt.Color;
import java.awt.Graphics;

public class Block extends GameObject {
	
	Color color;
	
	Block(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	void update() {
		super.update();
	}
	
	void setColor(Color c) {
		color = c;
	}
	
	void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(Color.white);
		g.drawRect(x, y, width, height);
	}

}
