import java.awt.Color;
import java.awt.Graphics;

public class platform extends gameObject {
	platform(int X, int Y, int Width1, int Height1) {
		super(X, Y, Width1, Height1);
		speed = 1;
	}

	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}

	public void update() {
		y+=speed;
	}
}
