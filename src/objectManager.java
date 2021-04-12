import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class objectManager implements ActionListener{
	character character;
	ArrayList<platform> platforms = new ArrayList<platform>();
	Random random=new Random();

	objectManager(character character1) {
		character = character1;
	}
	public void addPlatform() {
		platforms.add(new platform(random.nextInt(SkyJump.WIDTH-100),0,50,50));
	}
	public void update() {
		for (int i = 0; i < platforms.size(); i++) {
			platforms.get(i).update();
		}
	}
	public void draw(Graphics g) {
		character.draw(g);
		for (platform platform : platforms) {
			platform.draw(g);
		}
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
