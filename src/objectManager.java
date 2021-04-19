import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class objectManager implements ActionListener{
	character character;
	ArrayList<platform> platforms = new ArrayList<platform>();
	Random random=new Random();
	platform startPlatform=new platform(0,50,SkyJump.WIDTH,100);
	objectManager(character character1) {
		character = character1;
	}
	
	public void checkCollision() {
		for (platform platform : platforms) {
			if(platform.collisionBox.intersects(character.collisionBox)) {
				character.isColliding=true;
			}
		}
		if(startPlatform.collisionBox.intersects(character.collisionBox)) {
			character.isColliding=true;
		}
	}
	public void addPlatform() {
		platforms.add(new platform(random.nextInt(SkyJump.WIDTH-100),100,50,50));
	}
	public void update() {
		checkCollision();
		for (int i = 0; i < platforms.size(); i++) {
			platforms.get(i).update();
		}
		character.update();
		startPlatform.update();
		
	}
	public void draw(Graphics g) {
		character.draw(g);
		for (platform platform : platforms) {
			platform.draw(g);
		}
		startPlatform.draw(g);
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
