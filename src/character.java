import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.Timer;

public class character extends gameObject {
	Timer characterJump;
	boolean isJumping = false;
	boolean isFalling = false;
	boolean Left = false;
	boolean Right = false;
	int defaultHeight = 50;
	int defaultwidth = 50;
	int Z = 0;

	character(int X, int Y, int Width1, int Height1) {
		super(X, Y, Width1, Height1);
		speed = 5;
	}

	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
	}

	public void jump() {
		isJumping = true;

	}

	@Override
	public void update() {
		super.update();
		//if (!isColliding && isJumping == false) {
		//	Z--;
		
		//}
	}

	public void move() {
		if (Right) {
			x += speed;
		}
		if (Left) {
			x -= speed;
		}
		if (isJumping) {
				if (height == 70 && !isFalling) {
					isFalling = true;
					isJumping = false;
				}
				if (height >= defaultHeight && !isFalling) {
					isFalling = false;
					height++;
					width++;
					y -= 2;
					Z++;
					System.out.println(height + " " + width + " " + y);
				}
		}
				if (isFalling) {
					height--;
					width--;
					Z--;
					y += 2;
					System.out.println(height + " " + width + " " + y);
				
				}
	}
	}

