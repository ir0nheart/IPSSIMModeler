package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import db.InfoModel;
import gui.MainGUI;

public class DrawingUniverse extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<MyDrawingComponents> myComponents = new ArrayList<>();
	
	public DrawingUniverse(JLabel status) {
		super();
		modeldb = InfoModel.getInstance();
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				String infoMessage = "Mouse Entered in Universe";
				String titleBar = "Mouse Event Informer";
			//	JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
				System.out.println("InfoBox: " + titleBar +"\n"+"\t"+infoMessage);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				String infoMessage = "Mouse Exited in Universe";
				String titleBar = "Mouse Event Informer";
			//	JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
				System.out.println("InfoBox: " + titleBar +"\n"+"\t"+infoMessage);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(SwingUtilities.isLeftMouseButton(arg0)) {
				String infoMessage = "Left Mouse Pressed in Universe";
				String titleBar = "Mouse Event Informer";
			//	JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
				
				
			//	JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
				System.out.println("InfoBox: " + titleBar +"\n"+"\t"+infoMessage);
				if(isDomain) {
					infoMessage = "Mouse Clicked in Universe";
					
					Rectangle selRect = new Rectangle(arg0.getX()-5,arg0.getY()-5,10,10);
					for(Point p: myComponents.get(0).getCorners()) {
						if(selRect.contains(p)) {
							MyPopupFrame mf =  new MyPopupFrame(arg0.getXOnScreen(),arg0.getYOnScreen(),p);
							mf.setVisible(true);
							MainGUI.getInstance().getContentPane().add(mf);
							 try {
						            mf.setSelected(true);
						        } catch (java.beans.PropertyVetoException e) {}
							 
						//	JOptionPane.showMessageDialog(null, infoMessage + " Point (" +p.x +","+p.y+")" , "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				
				if(!isDomain) {
				System.out.println("InfoBox: " + titleBar +"\n"+"\t"+infoMessage);
				if(firstPoint == null)
					firstPoint = new Point(arg0.getX(), arg0.getY());
				else
					secondPoint = new Point(arg0.getX(), arg0.getY());
				
				if(firstPoint!=null && secondPoint!=null) {
					int width = Math.max(firstPoint.x,secondPoint.x) - Math.min(firstPoint.x,secondPoint.x);
					int height = Math.max(firstPoint.y,secondPoint.y) - Math.min(firstPoint.y,secondPoint.y);					
					Rectangle rect = new Rectangle(Math.min(firstPoint.x,secondPoint.x),Math.min(firstPoint.y,secondPoint.y),width,height);
					MyDrawingComponents myDrawingComponent = new MyDrawingComponents(rect);
					myComponents.add(myDrawingComponent);
					modeldb.setDomain(rect);
					modeldb.addCommand("Domain created.");
					isDomain = true;
					firstPoint = null;
					secondPoint = null;
					repaint();
				}
				
				}
				
					
				}
				else if(SwingUtilities.isRightMouseButton(arg0)) {
					String infoMessage = "Right Mouse Pressed in Universe";
					String titleBar = "Mouse Event Informer";
				//	JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
					System.out.println("InfoBox: " + titleBar +"\n"+"\t"+infoMessage);
					firstPoint = null;
					secondPoint = null;
					repaint();
				}
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				String infoMessage = "Mouse Released in Universe";
				String titleBar = "Mouse Event Informer";
				System.out.println("InfoBox: " + titleBar +"\n"+"\t"+infoMessage);
//				JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				String infoMessage = "Mouse Is Moving ";
				String titleBar = "Mouse Motion Informer ";
				status.setText("Status -> InfoBox: " + titleBar +"\t"+infoMessage + "\t X-Coord : " + e.getX() + " -- Y-Coord : "+e.getY());
				System.out.println("InfoBox: " + titleBar +"\n"+"\t"+infoMessage);
				System.out.println("\t X-Coord : " + e.getX() + "-- Y-Coord : "+e.getY());
				if(firstPoint != null) {
					secondPoint = new Point(e.getX(),e.getY());
					repaint();
				}else{
					for(MyDrawingComponents s:myComponents) {
						Point p = new Point(e.getX(),e.getY());
						if(s.getRectangle().contains(p)) {
							infoMessage = "Mouse entered in my Region babe ";
							titleBar = "Component Informer";
							System.out.println("Mouse entered in my Region babe ");
							s.setDrawColor(Color.RED);
							repaint();
							//JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
						}else {
							s.setDrawColor(Color.BLACK);
							repaint();
						}
					}
				}
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				String infoMessage = "Mouse Is Being Dragged";
				String titleBar = "Mouse Motion Informer";
				System.out.println("InfoBox: " + titleBar +"\n"+"\t"+infoMessage);
				//	JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		if(firstPoint !=null) {
			Graphics2D g2d = (Graphics2D) g;
			int width = Math.max(firstPoint.x,secondPoint.x) - Math.min(firstPoint.x,secondPoint.x);
			int height = Math.max(firstPoint.y,secondPoint.y) - Math.min(firstPoint.y,secondPoint.y);			
			Rectangle rect = new Rectangle(Math.min(firstPoint.x,secondPoint.x),Math.min(firstPoint.y,secondPoint.y),width,height);
			g2d.draw(rect);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		for(MyDrawingComponents aComp:myComponents) {
			if(!aComp.getStatus()) {			
				add(aComp);		
				aComp.setStatus(true);
			}
			g2d.setColor(aComp.getDrawColor());
			g2d.draw(aComp.getRectangle());
			}
	}
	

	private Point firstPoint = null;
	private Point secondPoint = null;
	private boolean isDomain = false;
	private InfoModel modeldb = null;
	// For Visual Dbg MessageBox Set
	//	JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);

}
