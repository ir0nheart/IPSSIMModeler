package gui;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

import components.BasePane;
import components.MyDesktopPane;
import components.MyMenuBar;
import db.InfoModel;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
public class MainGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2328834943343699540L;
	private static MainGUI instance = null;
	public static MainGUI getInstance() {
		if(instance == null)
			instance = new MainGUI();
		return instance;
	}
	private MainGUI() {
		modeldb = InfoModel.getInstance();
		modeldb.setMeshType("Fishnet");
		modeldb.setMeshDimension("2D");
		
		initializeComponents();	
		addWindowStateListener(new WindowStateListener() {
			
			@Override
			public void windowStateChanged(WindowEvent e) {
				// TODO Auto-generated method stub
				((MyDesktopPane)jdp).getMyMainPanel().setBounds(0, 0,getBounds().width, getBounds().height-60);	
			}
		});
		addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				((MyDesktopPane)jdp).getMyMainPanel().setBounds(0, 0,getBounds().width, getBounds().height-60);	
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private void initializeComponents() {
		int inset = 50;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLayout(new BorderLayout());
		jdp =new MyDesktopPane();//new JDesktopPane();	
//		JPanel mainPanel = new BasePane();
//		jdp.add(mainPanel);
		setContentPane(jdp);
		setJMenuBar(new MyMenuBar());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setTitle("IPSSIM Modeler");
		setSize(screenSize.width-100,screenSize.height-100);
		((MyDesktopPane)jdp).getMyMainPanel().setBounds(0, 0,getBounds().width, getBounds().height-60);
		setVisible(true);

	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				MainGUI myGUI = getInstance();
			}
		
		});

	}

	
	// Parameters and Variables
	
	private InfoModel modeldb;
	private JTextField xElementsTxt;
	private JTextField yElementsTxt;
	private int xElements;
	private int yElements;
	private JPanel drawingUniverse;
	private JButton btnMesh;
	private JDesktopPane jdp;

	
}


