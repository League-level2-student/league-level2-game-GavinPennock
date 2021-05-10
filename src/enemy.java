import java.awt.Color;
import java.awt.Graphics;

public class enemy extends gameObject {

	enemy(int X, int Y, int Width1, int Height1) {
		super(X, Y, Width1, Height1);
		speed = 4;
	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}

	public void update() {
		super.update();
		y+=3;
		x-=speed;
		if(x<=1) {
			speed*=-1;
		}
		if(x>=SkyJump.WIDTH-50) {
			speed*=-1;
		}
		
		
	}

}
