import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class platform extends gameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	
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
	
	platform(int X, int Y, int Width1, int Height1) {
		super(X, Y, Width1, Height1);
		speed = 3;
		if (needImage) {
		    loadImage ("grass.jpg");
		}

	}

	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}

	public void update() {
		super.update();
		y+=speed;
		
	}
}
