package display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	private String title;
	public static  int width;
	public static int height;
	public static JFrame frame;
	Canvas canvas;
	
	public Display(String title,int width,int height){
		this.title=title;
		this.width=width;
		this.height=height;
		createDisplay();
	}
	
	public void createDisplay(){
		frame=new JFrame(title);
		frame.setSize(width,height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		canvas =new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setBackground(Color.gray);
		canvas.setFocusable(false);
		frame.add(canvas);
		frame.pack();
	}

}
