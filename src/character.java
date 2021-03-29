import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Timer;

public class character extends gameObject {
	Timer characterJump;

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
		for (int i = 0; i < 13; i++) {
			y -= speed;
		}
		System.out.println("jumped");
		for (int i = 0; i < 13; i++) {
			y += speed;
		}
	}
}
