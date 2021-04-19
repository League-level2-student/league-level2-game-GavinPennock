import java.awt.Rectangle;

public class gameObject {
	int x;
	int y;
	int width;
	int height;
	int speed = 0;
	boolean isActive = true;
	Rectangle collisionBox;
	boolean isColliding = true;

	gameObject(int X, int Y, int Width1, int Height1) {
		x = X;
		y = Y;
		width = Width1;
		height = Height1;
		collisionBox = new Rectangle(x, y, width, height);
	}

	public void setColliding(boolean b) {
		isColliding = b;
		
	}

	public void update() {

	}
}
