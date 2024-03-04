package ponggame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class gamepanel extends JPanel implements Runnable{

	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.55));
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	paddles paddle1;
	paddles paddle2;
	ball Ball;
	score Score;
	
	gamepanel(){
		newPaddles();
		newBall();
		Score = new score(GAME_WIDTH,GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void newBall() {
		random = new Random();
		Ball = new ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
	}
	public void newPaddles() {
		paddle1 = new paddles(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
		paddle2 = new paddles(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
	}
	public void paint(Graphics g) {
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
	}
	public void draw(Graphics g) {
		paddle1.draw(g);
		paddle2.draw(g);
		Ball.draw(g);
		Score.draw(g);
  Toolkit.getDefaultToolkit().sync();

	}
	public void move() {
		paddle1.move();
		paddle2.move();
		Ball.move();
	}
	public void checkCollision() {
		

		if(Ball.y <=0) {
			Ball.setYvelocity(-Ball.yVelocity);
		}
		if(Ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
			Ball.setYvelocity(-Ball.yVelocity);
		}

		if(Ball.intersects(paddle1)) {
			Ball.xVelocity = Math.abs(Ball.xVelocity);
			Ball.xVelocity++; 
			if(Ball.yVelocity>0)
				Ball.yVelocity++; 
			else
				Ball.yVelocity--;
			Ball.setXvelocity(Ball.xVelocity);
			Ball.setYvelocity(Ball.yVelocity);
		}
		if(Ball.intersects(paddle2)) {
			Ball.xVelocity = Math.abs(Ball.xVelocity);
			Ball.xVelocity++; 
			if(Ball.yVelocity>0)
				Ball.yVelocity++; 
			else
				Ball.yVelocity--;
			Ball.setXvelocity(-Ball.xVelocity);
			Ball.setYvelocity(Ball.yVelocity);
		}

		if(paddle1.y<=0)
			paddle1.y=0;
		if(paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
			paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
		if(paddle2.y<=0)
			paddle2.y=0;
		if(paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
			paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;

		if(Ball.x <=0) {
			Score.player2++;
			newPaddles();
			newBall();
		}
		if(Ball.x >= GAME_WIDTH-BALL_DIAMETER) {
			Score.player1++;
			newPaddles();
			newBall();
		}
	}
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}
	}
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
	}
}