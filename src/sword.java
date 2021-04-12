import java.awt.Color;
import java.awt.Graphics;

public class sword extends gameObject{

	sword(int X, int Y, int Width1, int Height1) {
		super(X, Y, Width1, Height1);
		speed=50;
	}
	public void draw(Graphics g) {
		g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
	}
	public void update() {
		y-=speed;
	}

}
