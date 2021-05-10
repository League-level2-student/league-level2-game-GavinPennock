import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	int currentState = MENU;
	Font titleFont;
	Font instructionFont;
	Font playFont;
	Font heightFont;
	Timer frameDraw;
	
	character character = new character(250, SkyJump.HEIGHT / 2, 50, 50);
	objectManager objectmanager = new objectManager(character);
	 
	   

	GamePanel() {
		instructionFont = new Font("Arial", Font.PLAIN, 16);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		playFont = new Font("Arial", Font.PLAIN, 12);
		heightFont = new Font("Arial", Font.PLAIN, 16);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	public void updateMenuState() {

	}

	public void startGame() {
		objectmanager.start();
	}

	public void updateGameState() {
		objectmanager.update();
		if(character.Z<-5) {
			currentState=MENU;
		}
		if(character.isActive==false) {
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
		//instruction text
		g.setFont(instructionFont);
		g.setColor(Color.YELLOW);
		g.drawString("press space for instructions", 155, 475);
		// play text
		g.fillRect(200, 350, 100, 40);
		g.setFont(playFont);
		g.setColor(Color.BLUE);
		g.drawString("press enter to play", 200, 375);
	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, SkyJump.WIDTH, SkyJump.HEIGHT);
		objectmanager.draw(g);
		// height text
		g.setFont(heightFont);
		g.setColor(Color.WHITE);
		g.drawString("DISTANCE ____", 350, 50);
		// character draw

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
		if(e.getKeyCode()== KeyEvent.VK_SPACE&&currentState==MENU) {
			JOptionPane.showMessageDialog(null, "use the arrow keys to move and jump. Don't get hit by the enemies");
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == MENU) {
				character=new character(250, SkyJump.HEIGHT/2,50,50);
				objectmanager=new objectManager(character);
				currentState = GAME;
				startGame();
			} else if (currentState == GAME) {
				currentState = MENU;
				//platformSpawn.stop();
			}
			
		}
		if (currentState == GAME) {
			if (e.getKeyCode() == KeyEvent.VK_UP && !character.isJumping&&!character.isFalling) {
				System.out.println("UP");
				character.isColliding = false;
				character.isJumping=true;
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				System.out.println("LEFT");
				character.Left = true;
				if (character.x < 0) {
					currentState = MENU;
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				System.out.println("RIGHT");
				character.Right = true;
				if (character.x > 450) {
					currentState = MENU;
				}
			}
			
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			character.Left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			character.Right = false;
		}

	}

}
