package ponggame;

import java.awt.*;
import javax.swing.*;

public class gameframe extends JFrame{

	gamepanel panel;
	
	gameframe(){
		panel = new gamepanel();
		this.add(panel);
		this.setTitle("Game of pong");
		this.setResizable(false);
		this.setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}