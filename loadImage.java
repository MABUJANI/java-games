package display;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class loadImage {
	
	public static BufferedImage Motors,playerMotor,enemyMotor,fullImage,road,grass;
	public static BufferedImage footPath;
	public static void init(){
		fullImage=imageLoader("/road.jpg");
		Motors =imageLoader("/car.jpg");
		crop();
	}
	public static BufferedImage imageLoader(String path){
		try {
			return ImageIO.read(loadImage.class.getResource(path));
		} catch (IOException e) {
			
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	public static void crop(){
		//subImage1 =fullImage.getSubimage(10, 20, 20, 20);
		//subImage2=fullImage.getSubimage(20, 30, 30, 30);
		grass=fullImage.getSubimage(0, 0, 130, 119);
		road =fullImage.getSubimage(130, 0, 130, 119);
		footPath=fullImage.getSubimage(260, 0,130, 119);
		
		playerMotor=Motors.getSubimage(0, 0, 240, 460);
		enemyMotor=Motors.getSubimage(245, 0, 240, 460);
	}

}
