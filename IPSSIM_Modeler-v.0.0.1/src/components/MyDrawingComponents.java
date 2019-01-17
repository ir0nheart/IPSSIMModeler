package components;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class MyDrawingComponents extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String myShape = "";
	private Rectangle myRectangle = null;
	private boolean status = false;
	
	public void setStatus(boolean st) {status =st;}
	public boolean getStatus() {return status;}
	
	public Rectangle getRectangle() {
		return myRectangle;
	}
	
	public String getShape() {
		return myShape;
	}
	public MyDrawingComponents(Rectangle r) {
		myShape = "rectangle";
		myRectangle = r;
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				String infoMessage = "Mouse entered in my Region babe ";
				String titleBar = "Component Informer";
				System.out.println("Mouse entered in my Region babe ");
				JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	

}
