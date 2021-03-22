import java.awt.Color;
import java.awt.Graphics;

public class walkingEnemy extends gameObject{
	walkingEnemy(int X, int Y, int Width1, int Height1) {
		super(X, Y, Width1, Height1);
		speed=10;
	}
	public void draw(Graphics g) {
		g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
	}
	public void update() {
		//walking back and fourth on platforms
	}
}
