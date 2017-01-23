package breakout;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

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
		for (int i = 0; i < 300; i += 25) {
			for (int j = 0; j < Breakout.WIDTH; j += 125) {
				Block b = new Block(j, i, 125, 25);
				if (i % 2 == 0) {
					if (j % 2 == 0) {
						b.setColor(Color.blue);
					} else {
						b.setColor(Color.red);
					}
				} else {
					if (j % 2 == 0) {
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
				for (int k = j + 1; k < objects.size(); k ++) {
					GameObject o1 = objects.get(i);
					GameObject o2 = objects.get(j);
					GameObject o3 = objects.get(k);
					
					if (o1.collisionBox.intersects(o2.collisionBox) && o1.collisionBox.intersects(o3.collisionBox)) {
						if ((o1 instanceof Ball && o2 instanceof Block && o3 instanceof Block)) {
							System.out.println(score);
							o1.blockBounce = true;
							o2.isAlive = false;
							o3.isAlive = false;
							score++;
						}
					} else if (o2.collisionBox.intersects(o1.collisionBox) && o2.collisionBox.intersects(o3.collisionBox)) {
						if ((o2 instanceof Ball && o1 instanceof Block && o3 instanceof Block)) {
							System.out.println(score);
							o2.blockBounce = true;
							o1.isAlive = false;
							o3.isAlive = false;
							score++;
						}
					} else if (o3.collisionBox.intersects(o1.collisionBox) && o3.collisionBox.intersects(o2.collisionBox)) {
						if ((o3 instanceof Ball && o1 instanceof Block && o2 instanceof Block)) {
							System.out.println(score);
							o3.blockBounce = true;
							o2.isAlive = false;
							o1.isAlive = false;
							score++;
						}
					} else if (o1.collisionBox.intersects(o2.collisionBox)) {
						if ((o1 instanceof Block && o2 instanceof Ball)) {
							System.out.println(score);
							o1.isAlive = false;
							o2.blockBounce = true;
							score++;
						} else if ((o2 instanceof Block && o1 instanceof Ball)) {
							System.out.println(score);
							o2.isAlive = false;
							o1.blockBounce = true;
							score++;
						} else if ((o1 instanceof Ball && o2 instanceof Paddle)) {
							o1.paddleBounce = true;
						} else if ((o2 instanceof Ball && o1 instanceof Paddle)) {
							o2.paddleBounce = true;
						}
					}
				}
			}
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int s) {
		score = s;
	}

	public void reset() {
		objects.clear();
		addBlocks();
		addObject(new Ball(750, 400, 25, 25));
	}
}
