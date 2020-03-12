package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener{

	private boolean play = false;
	private int delay = 8;
	private Timer timer;
	
	private int playerX = 250;
	private int playerY = 325;
	private int playerXdir = -2;
	private int playerYdir = 2;
	
	public Gameplay() { 
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}

	public void paint(Graphics g) {
		//BG
		g.setColor(Color.black);
		g.fillRect(0, 0 , 1000, 700);
		//Player
		g.setColor(Color.yellow);
		g.fillOval(playerX, playerY, 30, 30);
		
		g.dispose();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		
		if(play) {
			if(playerY >= 640) playerY = 640;
			if(playerY <= 0) playerY = 0;
			move(playerXdir,playerYdir);
		}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			
			moveUp(2,2);
		}
	}
	
	public void move(int moveUp, int moveDown) {
		play = true;
		playerY -= moveUp;
		playerX += moveDown;	
	}
	public void moveUp(int moveUp, int moveDown) {
		play = true;
		
		playerY -= moveUp;
		playerX += moveDown;	
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}
