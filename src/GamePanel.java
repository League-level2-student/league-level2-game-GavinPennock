import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	int currentState = MENU;
	Font titleFont;
	Font playFont;
	Font heightFont;
	Timer frameDraw;
	Timer platformSpawn;
	character character = new character(250, SkyJump.HEIGHT/2, 50, 50);
	objectManager objectmanager = new objectManager(character);

	GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		playFont = new Font("Arial", Font.PLAIN, 12);
		heightFont = new Font("Arial", Font.PLAIN, 16);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	public void updateMenuState() {

	}

	public void startGame() {
		platformSpawn = new Timer(2000, objectmanager);
		platformSpawn.start();
	}

	public void updateGameState() {
		if (character.isJumping == true) {
			if(character.height==70&&!character.isFalling) {
				character.isFalling=true;
			}
			if (character.height >= character.defaultHeight&&!character.isFalling) {
				character.isFalling=false;
				character.height++;
				character.width++;
				character.y-=2;
				character.Z++;
				System.out.println(character.height+" "+character.width+" "+character.y);
			}
			
			else if(character.height!=character.defaultHeight) {
				character.isFalling=true;
				character.height--;
				character.width--;
				character.Z--;
				character.y+=2;
				System.out.println(character.height+" "+character.width+" "+character.y);
			}else{
				character.isFalling=false;
				character.isJumping=false;
			}

		}
		objectmanager.update();
		if(character.Z<-2) {
			currentState=MENU;
		}
	}

	public void drawMenuState(Graphics g) {
		// background
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, SkyJump.WIDTH, SkyJump.HEIGHT);
		// title
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Sky   Jump", 135, 100);
		// play text
		g.fillRect(200, 350, 100, 40);
		g.setFont(playFont);
		g.setColor(Color.BLUE);
		g.drawString("press enter to play", 200, 375);
	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, SkyJump.WIDTH, SkyJump.HEIGHT);
		// height text
		g.setFont(heightFont);
		g.setColor(Color.WHITE);
		g.drawString("HEIGHT ____", 350, 50);
		// character draw
		objectmanager.draw(g);
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		}
		
		
		repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == MENU) {
				currentState = GAME;
				startGame();
			} else if (currentState == GAME) {
				currentState = MENU;
				platformSpawn.stop();
			}
		}
		if (currentState == GAME) {
			if (e.getKeyCode() == KeyEvent.VK_UP && !character.isJumping) {
				System.out.println("UP");
				character.jump();
				character.isColliding=false;
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				System.out.println("LEFT");
				character.left();
				if (character.x < 0) {
					currentState = MENU;
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				System.out.println("RIGHT");
				character.right();
				if (character.x > 450) {
					currentState = MENU;
				}
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
