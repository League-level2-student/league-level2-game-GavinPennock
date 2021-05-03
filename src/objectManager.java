import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class objectManager implements ActionListener{
	character character;
	ArrayList<platform> platforms = new ArrayList<platform>();
	Random random=new Random();
	platform startPlatform=new platform(0,50,SkyJump.WIDTH,500);
	objectManager(character character1) {
		character = character1;
	}
	
	public void checkCollision() {
		boolean fall= true;
		for (platform platform : platforms) {
			if(platform.collisionBox.intersects(character.collisionBox)
					&&character.height<=character.defaultHeight) {
				character.isColliding=true;
				fall=false;
			}
		}
		if(startPlatform.collisionBox.intersects(character.collisionBox)&&character.height<=character.defaultHeight) {
			character.isColliding=true;
			fall=false;
		}
		if(character.height<=50) {
		character.isFalling=fall;
		}
	}
	public void addPlatform() {
		platforms.add(new platform(random.nextInt(SkyJump.WIDTH-100),100,100,100));
	}
	public void update() {
		checkCollision();
		for (int i = 0; i < platforms.size(); i++) {
			platforms.get(i).update();
		}
		character.move();
		character.update();
		startPlatform.update();
		
	}
	public void draw(Graphics g) {
		
		for (platform platform : platforms) {
			platform.draw(g);
		}
		startPlatform.draw(g);
		character.draw(g);
	}
	public void purgeObjects() {
		for (int i = 0; i < platforms.size(); i++) {
			if (!platforms.get(i).isActive ) {
				platforms.remove(i);
			}
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		addPlatform();
		
	}
}
