package ponggame;


import java.awt.*;
import java.awt.event.*;

public class paddles extends Rectangle{

	int id;
	int yVelocity;
	int speed = 10;
	
	paddles(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
		super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
		this.id=id;
	}
	
	public void keyPressed(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYvelocity(-speed);
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYvelocity(speed);
			}
			break;
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYvelocity(-speed);
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYvelocity(speed);
			}
			break;
		}
	}
	public void keyReleased(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYvelocity(0);
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYvelocity(0);
			}
			break;
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYvelocity(0);
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYvelocity(0);
			}
			break;
		}
	}
	public void setYvelocity(int yDirection) {
		yVelocity = yDirection;
	}
	public void move() {
		y= y + yVelocity;
	}
	public void draw(Graphics g) {
		if(id==1)
			g.setColor(Color.red);
		else
			g.setColor(Color.green);
		g.fillRect(x, y, width, height);
	}
}