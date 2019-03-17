import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;


public class Game extends Canvas implements Runnable,KeyListener{

	
	private static final long serialVersionUID = 1L;
	public static final int width = 800,height = 640;
	public boolean isRunning = false;
	public Thread thread;
	public Player player;
	public Game(){  //constructor
		Dimension dimension = new Dimension(Game.width,Game.height);
		setPreferredSize(dimension);
		setMinimumSize(dimension);
		setMaximumSize(dimension);
		addKeyListener(this);
	}
	
	private void update(){ //update the graphics
		BufferStrategy bs = getBufferStrategy();
		if (bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, Game.width,Game.height);
		g.dispose();
		bs.show();
	}

	private void move(){     //movement of components
	}

	public synchronized void start(){
		if(isRunning) return;
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop(){
		if(!isRunning) return;
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void run() {   //        game loop
		int fps = 0;
		double timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
		double target = 60.0;
		double delta = 0;
		double ns = 1000000000/target;
		
		
		while(isRunning){
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while(delta > 1){
				update();
				move();
				fps++;
				delta--;
			}
			if (System.currentTimeMillis() - timer >= 1000){
				System.out.println(fps);
				fps = 0;
				timer += 1000;
			}
			update();
			move();
		}
		stop();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	public static int clamp(int var,int min,int max){
		if (var >= max){
			return var = max;
		} else if (var <= min){
			return var = min;
		}
		else {
			return var;
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.add(game);
		frame.setTitle("Pacman");
		frame.setResizable(false);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();
	}

	

}
