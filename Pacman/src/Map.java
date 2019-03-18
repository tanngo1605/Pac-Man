import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Map extends JPanel{
	
	Image map;
	public Map(){
		map = new ImageIcon(this.getClass().getResource("images/map.png")).getImage();
		
	}
	public void update(Graphics g){
		super.paintComponent(g);
		g.drawImage(map, 0, 0, null);
	}
}
