package ponggame;

import java.awt.*;
import java.util.*;

public class ball extends Rectangle{

	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 2;
	
	ball(int x, int y, int width, int height){
		super(x,y,width,height);
		random = new Random();
		int randomXvelocity = random.nextInt(2);
		if(randomXvelocity == 0)
			randomXvelocity--;
		setXvelocity(randomXvelocity*initialSpeed);
		
		int randomYvelocity = random.nextInt(2);
		if(randomYvelocity == 0)
			randomYvelocity--;
		setYvelocity(randomYvelocity*initialSpeed);
		
	}
	
	public void setXvelocity(int randomXvelocity) {
		xVelocity = randomXvelocity;
	}
	public void setYvelocity(int randomYvelocity) {
		yVelocity = randomYvelocity;
	}
	public void move() {
		x += xVelocity;
		y += yVelocity;
	}
	public void draw(Graphics g) {
		g.setColor(Color.orange);
		g.fillOval(x, y, height, width);
	}
}