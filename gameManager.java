package display;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class gameManager {
	//private int y;
	private world world;
	private Motor motor;
	
	private long time=System.nanoTime();
	private long delay;
	private int health;
	
	private speedMeter meter;
	private ArrayList<EnemyMotor>eMotor;
	
	
	public gameManager(){
		motor =new Motor();
		world=new world(motor);
		meter=new speedMeter(motor);
		eMotor=new ArrayList<EnemyMotor>();
		
		delay=2000;
		health=3;
	}
	public void init(){
		//motor =new Motor();
		//world=new world();
		//world.init();
		loadImage.init();
		motor.init();
	}
	public void tick(){
		Random rand=new Random();
		int randX=rand.nextInt(300);
		int randY=rand.nextInt(Display.height);
		
		
		while(randX<150){
			randX=rand.nextInt(300);
		}
		
		/*if(r1.x<r2.x+width&&
		 * r1.x+width>r2.x&&
		 * r1.y<r2.y+width&&
		 * r1.y+width>r2.y)
		 */
		for(int i=0;i<eMotor.size();i++){
			
			//player
			int px=motor.getX();
			int py=motor.getY();
			
			//enenmy
			
			int ex=eMotor.get(i).getX();
			int ey=eMotor.get(i).getY();
			
			if(px < ex +40 && px + 40>ex &&
					py<ey +40 && py +40>ey){
				//collided
				
				eMotor.remove(i);
				i--;
				health--;
				//System.out.println(health);
				
				motor.setSpeed(0);
				motor.setHealth(health);
			}
		}
		
		
		
		
		
		long elapsed=(System.nanoTime()-time)/1000000;
		if(elapsed>delay){
			if(motor.getSpeed()>=3){
		
		eMotor.add(new EnemyMotor(motor,randX,(-randY)+motor.getOfset()));
			}
			time=System.nanoTime();
		}
		//motor
		motor.tick();
		
		
		//enemy motor
		
		for(int i=0;i<eMotor.size();i++){
			eMotor.get(i).tick();
		}
		
		
	}
	public void render(Graphics g){
		//g.fillRect(40, y, 60, 60);
		g.drawImage(loadImage.fullImage, 40, 40,100,100,null);
		//g.drawImage(loadImage.subImage1, 50, 50,10,10, null);
		//g.drawImage(loadImage.subImage2, 150, 150,50,50, null);
		world.render(g);
		motor.render(g);
		meter.render(g);
		for(int i=0;i<eMotor.size();i++){
			eMotor.get(i).render(g);
		}
	}

}
