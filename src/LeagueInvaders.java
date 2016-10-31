import javax.swing.JFrame;

public class LeagueInvaders {
	
	JFrame window;
	final int WIDTH = 500;
	final int HEIGHT = 800;
	GamePanel gamePanel;
	
	public static void main(String[] args) {
		LeagueInvaders a = new LeagueInvaders();
	}
	
	LeagueInvaders() {
		window = new JFrame();
		gamePanel = new GamePanel();
		setup();
	}
	
	void setup() {
		window.add(gamePanel);
		window.addKeyListener(gamePanel);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WIDTH, HEIGHT);
		gamePanel.startGame();
	}
}