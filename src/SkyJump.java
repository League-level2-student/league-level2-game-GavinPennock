import javax.swing.JFrame;

public class SkyJump {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	JFrame jFrame;
	GamePanel gamepanel;

	SkyJump() {
		jFrame = new JFrame();
		gamepanel = new GamePanel();
		jFrame.addKeyListener(gamepanel);
	}

	void setup() {
		jFrame.setVisible(true);
		jFrame.add(gamepanel);
		jFrame.setSize(WIDTH, HEIGHT);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SkyJump skyjump = new SkyJump();
		skyjump.setup();
	}

}
