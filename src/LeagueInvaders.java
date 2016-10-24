import javax.swing.JFrame;

public class LeagueInvaders {
	
	JFrame window;
	final int WIDTH = 500;
	final int HEIGHT = 800;
	
	public static void main(String[] args) {
		LeagueInvaders a = new LeagueInvaders();
	}
	
	LeagueInvaders() {
		window = new JFrame();
		setup();
	}
	
	void setup() {
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WIDTH, HEIGHT);
	}
}
