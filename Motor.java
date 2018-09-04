package display;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Motor implements KeyListener{
	private int x,y;
	private int ofset;
	
	private double speed;
	
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	private int health;
	private int gare;
	//constructor
	public Motor(){
		x=Display.width/2;
		y=Tile.tileHeight*120;
		ofset =0;
		
		speed=0.3f;
		health=3;
		gare=0;
	}
	public void init(){
		Display.frame.addKeyListener(this);
	}
	public void tick(){
		//System.out.println(y);
		if(health>0){
		ofset=y -(Display.height-100);
		if(right){
			if(x<=343)
			x+=2;
		}
		if(left){
			if(x>=127)
			x-=2;
		}
		if(up){
			if(y>1700){
			speed+=0.05f;
			//System.out.println("You reached the maximum distance");
			if(speed>=7){
				speed=7;
				
			}
		}
		}
		if(y>700)
		y-=speed;
		if(down){
			speed-=0.030f;
			if(speed<=0){
				speed=0;
			}
		}
		}
		
	}
	public double getSpeed(){
		return speed;
	}
	public int getX(){
		return x;
	}
	
	
	public int getY(){
		return y;
	}
	public int getOfset(){
		return ofset;
	}
	public void setSpeed(double speed){
		this.speed=speed;
		
	}
	public void setHealth(int health){
		this.health=health;
	}
	
	public void drawBoard(Graphics g){
		int speed1=(int)speed;
		switch(speed1){
		
		case 0:gare=0;break;
		case 2:gare=1;break;
		case 4:gare=2;break;
		case 6:gare=3;break;
		
		
		}
		g.setColor(Color.white);
		g.fillRect(10, 10, 150, 80);
		
		
		//draw gare;
		g.setColor(Color.black);
		String Sgare=Integer.toString(gare);
		g.setFont(new Font("arial",Font.BOLD,30));
		g.drawString("Gare :"+Sgare, 20, 40);
		g.drawString("Health: "+health, 20, 80);
	}
	
	public void GameOver(Graphics g){
		
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.BOLD,33));
		g.drawString("Game over", Display.width/3, Display.height/2);
	}
	
	
	
	
	public void render(Graphics g){
		if(health>0){
		g.setColor(Color.red);
		g.drawImage(loadImage.playerMotor,x, y-ofset, 40, 70,null);
		}else{
			GameOver(g);
		}
		
		//draw board
		drawBoard(g);
		
	}
	public void keyPressed(KeyEvent e) {
		int source=e.getKeyCode();
		if(source== KeyEvent.VK_RIGHT){
		right=true;
		}
		if(source==KeyEvent.VK_LEFT){
		left=true;
		}
		if(source==KeyEvent.VK_DOWN){
		down=true;
		}
		if(source==KeyEvent.VK_UP){
		up=true;
		}
	}
	public void keyReleased(KeyEvent e) {
		int source=e.getKeyCode();
		
		if(source== KeyEvent.VK_RIGHT){
			right=false;
			}
			if(source==KeyEvent.VK_LEFT){
			left=false;
			}
			if(source==KeyEvent.VK_DOWN){
			down=false;
			}
			if(source==KeyEvent.VK_UP){
			up=false;
			}
	}
		
		
	
	public void keyTyped(KeyEvent e) {
		
		
	}
	

}
