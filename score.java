package ponggame;

import java.awt.*;

public class score extends Rectangle{

	static int GAME_WIDTH;
	static int GAME_HEIGHT;
	int player1;
	int player2;
	
	score(int GAME_WIDTH, int GAME_HEIGHT){
		score.GAME_WIDTH = GAME_WIDTH;
		score.GAME_HEIGHT = GAME_HEIGHT;
	}
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.setFont(new Font("consolas",Font.BOLD,60));
		Graphics2D G= (Graphics2D)g;
		G.setStroke(new BasicStroke(3));
		G.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
		
		g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (GAME_WIDTH/2)-85, 50);
		g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), (GAME_WIDTH/2)+20, 50);
	}
}