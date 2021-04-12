import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Timer;

public class character extends gameObject {
	Timer characterJump;
	boolean isJumping=false;
	boolean isFalling=false;
	int defaultHeight=50;
	int defaultwidth=50;
	character(int X, int Y, int Width1, int Height1) {
		super(X, Y, Width1, Height1);
		speed = 10;
	}

	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
	}

	public void right() {
		x += speed;
	}

	public void left() {
		x -= speed;
	}

	public void jump() {
		isJumping=true;
		
	}
}
