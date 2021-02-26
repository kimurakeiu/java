import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

public class SimpleDraw extends JFrame implements ActionListener, MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;
	
	int lastx, lasty, newx, newy;
	DrawPanel panel;
	static JFileChooser fileChooser;
	Graphics g;
	
	private void addMenuItem
	(JMenu targetMenu, String itemName, String actionName, ActionListener listener){
		JMenuItem menuItem = new JMenuItem(itemName);
		menuItem.setActionCommand(actionName);
		menuItem.addActionListener(listener);
		targetMenu.add(menuItem);
	}	

	private void initMenu() {
		JMenuBar menubar = new JMenuBar();
		
		JMenu menuFile = new JMenu("ファイル");
		this.addMenuItem(menuFile, "開く", "open", this);
		this.addMenuItem(menuFile, "保存", "save", this);
		
		JMenu menuPen = new JMenu("ペン");
		JMenu menuColor = new JMenu("色");
		this.addMenuItem(menuColor, "黒", "black", this);
		this.addMenuItem(menuColor, "赤", "red", this);
		this.addMenuItem(menuColor, "青", "blue", this);
		this.addMenuItem(menuColor, "黄", "yellow", this);
		this.addMenuItem(menuColor, "緑", "green", this);
		this.addMenuItem(menuColor, "その他の色", "pallet", this);
		
		JMenu menuWidth = new JMenu("太さ");
		this.addMenuItem(menuWidth, "極細", "width2", this);
		this.addMenuItem(menuWidth, "細", "width5", this);
		this.addMenuItem(menuWidth, "中", "width10", this);
		this.addMenuItem(menuWidth, "太", "width20", this);
		this.addMenuItem(menuWidth, "塗りつぶし", "width5000", this);
		
		JMenu menuEraser = new JMenu("消しゴム");
		JMenu menuWidth2 = new JMenu("太さ");
		this.addMenuItem(menuWidth2, "極細", "widthss", this);
		this.addMenuItem(menuWidth2, "細", "widths", this);
		this.addMenuItem(menuWidth2, "中", "widthm", this);
		this.addMenuItem(menuWidth2, "太", "widthl", this);
		this.addMenuItem(menuWidth2, "全部消す", "widthll", this);
		
		menubar.add(menuFile);
		
		menubar.add(menuPen);
		menuPen.add(menuColor);
		menuPen.add(menuWidth);
		
		menubar.add(menuEraser);
		menuEraser.add(menuWidth2);
		
		this.setJMenuBar(menubar);
	} 
	
	public void actionPerformed(ActionEvent arg0){
		String command = arg0.getActionCommand(); 
		
		//ファイル
		if(arg0.getActionCommand().equals("open")){
			
			int returnVal = fileChooser.showOpenDialog(this);
	        if(returnVal == JFileChooser.APPROVE_OPTION){
	        	panel.openFile(fileChooser.getSelectedFile());
	        }
		}
		else if(arg0.getActionCommand().equals("save")){
			
			int returnVal = fileChooser.showSaveDialog(this);
	        if(returnVal == JFileChooser.APPROVE_OPTION){
	        	panel.saveFile(fileChooser.getSelectedFile());
	        }
		}
		
		//色
		if(command == "black") panel.setPenColor(Color.black); 
		if(command == "red") panel.setPenColor(Color.red); 
		if(command == "blue") panel.setPenColor(Color.blue); 
		if(command == "yellow") panel.setPenColor(Color.yellow); 
		if(command == "green") panel.setPenColor(Color.green);
		
		//パレット
		if(command == "pallet"){
			JColorChooser colorchooser = new JColorChooser();
		    Color color = colorchooser.showDialog(this,"choose a color",Color.red);
			panel.setPenColor(color);
		}
		
		//太さ
		if(command == "width2") panel.setPenWidth(2);
		if(command == "width5") panel.setPenWidth(5);
		if(command == "width10") panel.setPenWidth(10);
		if(command == "width20") panel.setPenWidth(20);
		if(command == "width5000") panel.setPenWidth(5000);
		
		//消しゴム
		if(command == "widthss"){
			panel.setPenColor(Color.white);
			panel.setPenWidth(2);
		}
		if(command == "widths"){
			panel.setPenColor(Color.white);
			panel.setPenWidth(5);
		}
		if(command == "widthm"){
			panel.setPenColor(Color.white);
			panel.setPenWidth(10);
		}
		if(command == "widthl"){
			panel.setPenColor(Color.white);
			panel.setPenWidth(20);
		}
		if(command == "widthll"){
			panel.setPenColor(Color.white);
			panel.setPenWidth(5000);
		}
		
	}

	public void mouseDragged(MouseEvent arg0){
		
		//String command = arg0.getActionCommand(); 
		
		newx = arg0.getX()+5;
		newy = arg0.getY()-40;
		
		//ペン
		panel.drawLine(lastx, lasty, newx, newy);
		//消しゴム
		//panel.drawEraseLine(lastx, lasty, newx, newy);
		
		lastx = newx;
		lasty = newy;
	}

	public void mouseMoved(MouseEvent arg0){}

	public void mouseClicked(MouseEvent arg0){}

	public void mousePressed(MouseEvent arg0){
		lastx = arg0.getX()+5;
	 	lasty = arg0.getY()-40;
	}

	public void mouseReleased(MouseEvent arg0){}

	public void mouseEntered(MouseEvent arg0){}

	public void mouseExited(MouseEvent arg0){}
	
	private void init(){
		
		this.setTitle("お絵かき");
		panel = new DrawPanel();
		this.setSize(1200,900);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		panel.setPenColor(Color.black);
		this.getContentPane().add(panel);
		panel.setBackground(Color.white);
		this.initMenu();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args){
		
		SimpleDraw frame = new SimpleDraw();
		fileChooser = new JFileChooser(); 
		frame.init();
		
	}

}
