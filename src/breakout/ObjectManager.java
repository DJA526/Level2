package breakout;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;
	
	private int score = 0;
	
	public ObjectManager() {
		objects = new ArrayList<GameObject>();
	}

	public void addObject(GameObject o) {
		objects.add(o);
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
		}
		
		purgeObjects();	
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}
	
	public void addBlocks() {
		for (int i = 0; i < 300; i+= 25) {
			for (int j = 0; j < Breakout.WIDTH; j+= 125) {
				Block b = new Block(j, i, 125, 25);
				if (i % 2 == 0) {
					if (j%2 == 0) {
						b.setColor(Color.blue);
					} else {
						b.setColor(Color.red);
					}
				} else {
					if (j%2 == 0) {
						b.setColor(Color.red);
					} else {
						b.setColor(Color.blue);
					}
				}
				objects.add(b);
			}
		}
	}

	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				
				if (o1.collisionBox.intersects(o2.collisionBox)){
					if ((o1 instanceof Block && o2 instanceof Ball)) {
						score++;
						System.out.println(score);
						o1.isAlive = false;
					} else if ((o2 instanceof Block && o1 instanceof Ball)) {
						score++;
						System.out.println(score);
						o2.isAlive = false;
					} else if ((o1 instanceof Ball && o2 instanceof Paddle)){

					} else if ((o2 instanceof Ball && o1 instanceof Paddle)) {

					}
	
				}
			}
		}
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int s){
		score = s;
	}
	
	public void reset(){
		objects.clear();
	}
}
