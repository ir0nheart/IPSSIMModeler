package gui;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

import db.InfoModel;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
public class MainGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2328834943343699540L;
	public MainGUI() {
		modeldb = InfoModel.getInstance();
		modeldb.setMeshType("Fishnet");
		modeldb.setMeshDimension("2D");
		
		initializeComponents();	
	}
	
	private void initializeComponents() {
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		//Add A Label
		NumberFormat nf = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(nf);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(1);
		formatter.setMaximum(1001);
		formatter.setAllowsInvalid(false);
		formatter.setCommitsOnValidEdit(true);
		cp.add(new JLabel("X Elements:"));
		xElementsTxt = new JFormattedTextField(formatter);
		xElementsTxt.setText("1");
		xElementsTxt.setPreferredSize(new Dimension(50, 20));
		cp.add(xElementsTxt);
		cp.add(new JLabel("Y Elements:"));
		yElementsTxt = new JFormattedTextField(formatter);
		yElementsTxt.setText("1");
		yElementsTxt.setPreferredSize(new Dimension(50, 20));
		cp.add(yElementsTxt);
		//tfCount.setEditable(false);
		//cp.add(tfCount);
		btnMesh = new JButton("Set Mesh");
		cp.add(btnMesh);
		//
		//btnCount = new JButton("Count");
		//cp.add(btnCount);
		
		btnMesh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				//++Count;
				//tfCount.setText(Count + "");
				modeldb.setFishnet_x(Integer.valueOf(xElementsTxt.getText()));
				modeldb.setFishnet_y(Integer.valueOf(yElementsTxt.getText()));
				btnMesh.setEnabled(false);
			}
		});
		
		drawingUniverse = new components.DrawingUniverse();
		drawingUniverse.setBorder(BorderFactory.createLoweredBevelBorder());
		drawingUniverse.setBackground(Color.WHITE);
		drawingUniverse.setSize(100, 724);
		drawingUniverse.setPreferredSize(new Dimension(1000,724));
//		drawingUniverse.addMouseListener(new MouseListener() {
//
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				String infoMessage = "Mouse Clicked in Universe";
//				String titleBar = "Mouse Event Informer";
//			//	JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
//				System.out.println("InfoBox: " + titleBar +"\n"+"\t"+infoMessage);
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				String infoMessage = "Mouse Entered in Universe";
//				String titleBar = "Mouse Event Informer";
//			//	JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
//				System.out.println("InfoBox: " + titleBar +"\n"+"\t"+infoMessage);
//			}
//
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				String infoMessage = "Mouse Exited in Universe";
//				String titleBar = "Mouse Event Informer";
//			//	JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
//				System.out.println("InfoBox: " + titleBar +"\n"+"\t"+infoMessage);
//			}
//
//			@Override
//			public void mousePressed(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				String infoMessage = "Mouse Pressed in Universe";
//				String titleBar = "Mouse Event Informer";
//			//	JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
//				System.out.println("InfoBox: " + titleBar +"\n"+"\t"+infoMessage);
//				firstPoint = new Point(arg0.getX(), arg0.getY());
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				String infoMessage = "Mouse Released in Universe";
//				String titleBar = "Mouse Event Informer";
//				System.out.println("InfoBox: " + titleBar +"\n"+"\t"+infoMessage);
////				JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
//			}
//			
//		});
		
//		drawingUniverse.addMouseMotionListener(new MouseMotionListener() {
//			
//			@Override
//			public void mouseMoved(MouseEvent e) {
//				// TODO Auto-generated method stub
//				String infoMessage = "Mouse Is Moving";
//				String titleBar = "Mouse Motion Informer";
//				System.out.println("InfoBox: " + titleBar +"\n"+"\t"+infoMessage);
//				System.out.println("\t X-Coord : " + e.getX() + "-- Y-Coord : "+e.getY());
////				JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
//				if(firstPoint != null) {
//					secondPoint = new Point(e.getX(),e.getY());
//					Graphics g = drawingUniverse.getGraphics();
//					Graphics2D g2d = (Graphics2D)g;
//					int width = Math.max(firstPoint.x,secondPoint.x) - Math.min(firstPoint.x,secondPoint.x);
//					int height = Math.max(firstPoint.y,secondPoint.y) - Math.min(firstPoint.y,secondPoint.y);
//					
//					Rectangle rect = new Rectangle(Math.min(firstPoint.x,secondPoint.x),Math.min(firstPoint.y,secondPoint.y),width,height);
//					//g2d.drawRect(rect);
//					drawingUniverse.paint(g);
//					
//					g2d.draw(rect);
//					//drawingUniverse.update(g2d);;
//				}
//			}
//			
//			@Override
//			public void mouseDragged(MouseEvent e) {
//				// TODO Auto-generated method stub
//				String infoMessage = "Mouse Is Being Dragged";
//				String titleBar = "Mouse Motion Informer";
//				System.out.println("InfoBox: " + titleBar +"\n"+"\t"+infoMessage);
//				//	JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
//			}
//		});
		
				
		cp.add(drawingUniverse);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Swing Counter");
		setSize(1024,768);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				MainGUI myGUI = new MainGUI();
			}
		
		});

	}

	
	// Parameters and Variables
	private JTextField xElementsTxt;
	private JTextField yElementsTxt;
	private int xElements;
	private int yElements;
	private JButton btnMesh;
	private InfoModel modeldb;
	private JPanel drawingUniverse;
	

	
}
