package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import db.InfoModel;

public class BasePane extends JPanel {
	private JDesktopPane desktopPane;
	public JDesktopPane getDesktopPane() {return desktopPane;}
	
	
	public BasePane() {
		modeldb = InfoModel.getInstance();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLayout(new BorderLayout());
		NumberFormat nf = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(nf);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(1);
		formatter.setMaximum(1001);
		formatter.setAllowsInvalid(false);
		formatter.setCommitsOnValidEdit(true);
		
		JPanel textsAndButton = new MyToolBar();
		
		drawingUniverse = new components.DrawingUniverse();
		drawingUniverse.setBorder(BorderFactory.createLoweredBevelBorder());
		drawingUniverse.setBackground(Color.WHITE);
		drawingUniverse.setSize(100, 724);
		drawingUniverse.setPreferredSize(new Dimension(1000,724));
		
		add(textsAndButton,BorderLayout.NORTH);		
		add(drawingUniverse,BorderLayout.CENTER);
		setPreferredSize(new Dimension(1024,768));
		setBounds(0,0,screenSize.width,screenSize.height);
		setVisible(true);
	}
	
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(1100,800);
		}
		
	private InfoModel modeldb;
	private JTextField xElementsTxt;
	private JTextField yElementsTxt;
	private int xElements;
	private int yElements;
	private JPanel drawingUniverse;
	private JButton btnMesh;	
	
}
