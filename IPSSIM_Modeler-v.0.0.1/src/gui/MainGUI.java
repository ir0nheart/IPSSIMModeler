package gui;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

import components.BasePane;
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
	}
	
	private void initializeComponents() {
//		int inset = 50;
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		setJMenuBar(new MyMenuBar());
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLayout(new BorderLayout());
//		setContentPane(new BasePane());
//		//add(new BasePane());
//		pack();
//		setTitle("IPSSIM Modeler");
//		setBounds(inset,inset,screenSize.width-inset*2,screenSize.height-inset*2);
//		setSize(1024,768);
//		setVisible(true);
//	
		
		int inset = 50;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLayout(new BorderLayout());
		jdp =new JDesktopPane();
		
		
		JPanel mainPanel = new BasePane();
//		mainPanel.setLayout(new BorderLayout());
//	    Container cp =getContentPane();
//		cp.setLayout(new FlowLayout());
//		cp.setLayout(new BorderLayout());
//		NumberFormat nf = NumberFormat.getInstance();
//		NumberFormatter formatter = new NumberFormatter(nf);
//		formatter.setValueClass(Integer.class);
//		formatter.setMinimum(1);
//		formatter.setMaximum(1001);
//		formatter.setAllowsInvalid(false);
//		formatter.setCommitsOnValidEdit(true);
//		
//		JPanel textsAndButton = new JPanel(new GridLayout(0,5));
//		textsAndButton.add(new JLabel("X Elements:"));
//		//mainFrame.add(new JLabel("X Elements:"));
//		xElementsTxt = new JFormattedTextField(formatter);
//		xElementsTxt.setText("1");
//		xElementsTxt.setPreferredSize(new Dimension(50, 20));
//		//mainFrame.add(xElementsTxt);
//		textsAndButton.add(xElementsTxt);
//		textsAndButton.add(new JLabel("Y Elements: "));
//		//mainFrame.add(new JLabel("Y Elements:"));
//		yElementsTxt = new JFormattedTextField(formatter);
//		yElementsTxt.setText("1");
//		yElementsTxt.setPreferredSize(new Dimension(50, 20));
//		//mainFrame.add(yElementsTxt);
//		textsAndButton.add(yElementsTxt);
//		
//		btnMesh = new JButton("Set Mesh");
//	//	mainFrame.add(btnMesh);
//		textsAndButton.add(btnMesh);
//		btnMesh.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent evt) {
//			
//				modeldb.setFishnet_x(Integer.valueOf(xElementsTxt.getText()));
//				modeldb.setFishnet_y(Integer.valueOf(yElementsTxt.getText()));
//				btnMesh.setEnabled(false);
//			}
//		});
//		
//		drawingUniverse = new components.DrawingUniverse();
//		drawingUniverse.setBorder(BorderFactory.createLoweredBevelBorder());
//		drawingUniverse.setBackground(Color.WHITE);
//		drawingUniverse.setSize(100, 724);
//		drawingUniverse.setPreferredSize(new Dimension(1000,724));
//		textsAndButton.setPreferredSize(new Dimension(screenSize.width,30));
//		mainPanel.add(textsAndButton,BorderLayout.NORTH);		
//		mainPanel.add(drawingUniverse,BorderLayout.CENTER);
//		mainPanel.setPreferredSize(new Dimension(1024,768));
//		mainPanel.setBounds(0,0,screenSize.width,screenSize.height);
//		mainPanel.setVisible(true);
				
		jdp.add(mainPanel);
		setContentPane(jdp);
		setJMenuBar(new MyMenuBar());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setTitle("IPSSIM Modeler");
		setSize(screenSize.width,screenSize.height);
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
