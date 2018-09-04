package display;

import java.awt.Graphics;

public class EnemyMotor {
	private int x;
	private int y;
	private Motor motor;
	public EnemyMotor(Motor motor,int x,int y){
		this.motor=motor;
		this.x=x;
		this.y=y;
	}
	public void tick(){
		y+=1;
	}
	public void render(Graphics g){
		g.drawImage(loadImage.enemyMotor, x, y-motor.getOfset(),40,70, null);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

}
