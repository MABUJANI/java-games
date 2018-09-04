package display;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tile=new Tile[24];
	
	
	public static Tile roadTile =new roadTile(0);
	public static Tile grassTile=new grassTile(1);
	public static Tile footPathTile=new footPathTile(2);
	public BufferedImage texture;
	
	public static final int tileWidth=64,tileHeight=64;
	public Tile(BufferedImage texture,int id){
		this.texture=texture;
		tile[id]=this;
	}
	public void render(Graphics g,int x ,int y){
		g.drawImage(texture, x, y,null);
		
	}

}
