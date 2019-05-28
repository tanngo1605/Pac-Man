import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy extends Rectangle {
	public int x;
	public int y;
	//dimension 800*640
	Player player;
	public Enemy(Player p)
	{
		this.player=p;
		Random r = new Random();
		int randomValueX = r.nextInt();
		int randomValueY = r.nextInt();
		setBounds (randomValueX,randomValueY,15,15);
	
	}

	public void update (Graphics g)
	{
		g.drawRect(0, 0, 15, 15);
		g.setColor(Color.red);
		
	}
	public void move()
	{
		//find shortest way to player
	}

}
