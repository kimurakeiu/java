import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.FileReader;
import javax.swing.JFileChooser;

public class DrawPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	BufferedImage bufferImage = null;
	Graphics2D bufferGraphics = null;
	
	//色
	Color currentColor = Color.black;
	public void setPenColor(Color newColor){
		currentColor = newColor;
	}
	
	//太さ
	Float currentWidth = 5.0f;
	public void setPenWidth(float newWidth){
		currentWidth = newWidth;
	}
	/*
	//消しゴム
	Color eraseColor = Color.white;
	public void setEraseColor(Color newColor){
		eraseColor = newColor;
	}
	
	//太さ
		Float currentEraseWidth = 10.0f;
		public void setEraseWidth(float newWidth){
			currentEraseWidth = newWidth;
		}*/
	
	private void createBuffer(int width, int height) {
		bufferImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		bufferGraphics = bufferImage.createGraphics();
		bufferGraphics.setBackground(Color.white);
		bufferGraphics.clearRect(0, 0, width, height); 
	}
	
	//ファイルを開く
	public void openFile(File file2open){
		BufferedImage pictureImage;
		try{
			pictureImage = ImageIO.read(file2open);
		}
		catch(Exception e){
			System.out.println("Error: reading file = " + file2open.getName());
			return;
		}
		this.createBuffer(pictureImage.getWidth(), pictureImage.getHeight());
		bufferGraphics.drawImage(pictureImage, 0, 0, this);
		repaint();
	}
	
	//ファイルを保存
	public void saveFile(File file2save){
		try{
			ImageIO.write(bufferImage, "jpg", file2save);
		}
		catch (Exception e){
			System.out.println("Error: writing file = " + file2save.getName());
			return;
		}
	}
	
	//線を描く
	public void drawLine(int x1, int y1, int x2, int y2){
		Graphics g = this.getGraphics();
		
		if(null == bufferGraphics) {
		 	this.createBuffer(this.getWidth(),this.getHeight());
		}
		
		bufferGraphics.setColor(currentColor);
		
		bufferGraphics.setStroke(new BasicStroke(currentWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
		bufferGraphics.drawLine(x1, y1, x2, y2);
	
		repaint();
	}
	
	/*//消しゴムを描く
		public void drawEraseLine(int x1, int y1, int x2, int y2){
			Graphics g = this.getGraphics();
			
			if(null == bufferGraphics) {
			 	this.createBuffer(this.getWidth(),this.getHeight());
			}
			
			bufferGraphics.setColor(eraseColor);
			
			bufferGraphics.setStroke(new BasicStroke(currentEraseWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
			bufferGraphics.drawLine(x1, y1, x2, y2);
		
			repaint();
		}*/
		
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(null != bufferImage) g.drawImage(bufferImage, 0, 0, this);
	}
	
}
