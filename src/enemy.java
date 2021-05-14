import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class enemy extends gameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

	enemy(int X, int Y, int Width1, int Height1) {
		super(X, Y, Width1, Height1);
		speed = 4;
		if (needImage) {
		    loadImage ("plane.png");
		}
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}

	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, 50, 50, null);
		} else {
			g.setColor(Color.RED);
			g.fillRect(x, y, 50, 50);
		}
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
