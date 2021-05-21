import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class objectManager implements ActionListener{
	Timer enemySpawn;
	Timer platformSpawn;
	character character;
	ArrayList<platform> platforms = new ArrayList<platform>();
	ArrayList<enemy> enemies = new ArrayList<enemy>();
	Random random=new Random();
	platform startPlatform=new platform(0,50,SkyJump.WIDTH,500);
	objectManager(character character1) {
		character = character1;
	}
	
	
		
	public void checkCollision() {
		for(enemy enemy : enemies) {
			if(enemy.collisionBox.intersects(character.collisionBox)&&character.isJumping==false&&character.isFalling==false) {
				enemy.isActive=false;
				character.isActive=false;
			}
		}
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
	public void start() {
		enemySpawn = new Timer(2500 , this);
		enemySpawn.start();
		platformSpawn = new Timer(1200, this);
		platformSpawn.start();
	}
	
	public void addPlatform() {
		platforms.add(new platform(random.nextInt(SkyJump.WIDTH-100),100,100,100));
	}
	
	public void addEnemy() {
		enemies.add(new enemy(random.nextInt(SkyJump.WIDTH-100),100,50,50));
	}
	public void update() {
		for (int i = 0; i < platforms.size(); i++) {
			platforms.get(i).update();
			if(platforms.get(i).y>=850) {
				platforms.get(i).isActive=false;
			}
		}
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).update();
			if(enemies.get(i).y>850) {
				enemies.get(i).isActive=false;
			}
		}
		character.move();
		character.update();
		startPlatform.update();
		checkCollision();
		purgeObjects();
		
	}
	public void draw(Graphics g) {
		
		for (platform platform : platforms) {
			platform.draw(g);
		}
		for (enemy enemy : enemies) {
			enemy.draw(g);
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
		for (int i = 0; i < enemies.size(); i++) {
			if (!enemies.get(i).isActive ) {
				enemies.remove(i);
			}
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==platformSpawn) {
		addPlatform();
		}
		if(e.getSource()==enemySpawn) {
			addEnemy();
		}
	}
}
