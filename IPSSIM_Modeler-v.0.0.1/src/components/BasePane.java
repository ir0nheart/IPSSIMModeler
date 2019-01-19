package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import db.InfoModel;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTree;
import javax.swing.Box;

public class BasePane extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDesktopPane desktopPane;
	public JDesktopPane getDesktopPane() {return desktopPane;}
	
	
	public BasePane() {
		modeldb = InfoModel.getInstance();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				
		JPanel textsAndButton = new MyToolBar();
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JLabel status = new JLabel("Status Text:");
		
		
		drawingUniverse = new components.DrawingUniverse(status);
		drawingUniverse.setBorder(BorderFactory.createLoweredBevelBorder());
		drawingUniverse.setBackground(Color.WHITE);
		
	
		
	
		
		JTree tree = new JTree();
		
		
		
		Box horizontalBox = Box.createHorizontalBox();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(textsAndButton, GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tree, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horizontalBox, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(drawingUniverse, GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(textsAndButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(286)
							.addComponent(horizontalBox, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(drawingUniverse, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
								.addComponent(tree, GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE))))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(status, GroupLayout.PREFERRED_SIZE, 1024, GroupLayout.PREFERRED_SIZE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(status)
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		
		setVisible(true);
	//	setSize(screenSize.width-100,screenSize.height-100);
		//	setBounds(0,0,screenSize.width-100,screenSize.height-100);	
	}
	
		
		
	private InfoModel modeldb;
	private JTextField xElementsTxt;
	private JTextField yElementsTxt;
	private int xElements;
	private int yElements;
	private JPanel drawingUniverse;
	private JButton btnMesh;	
}
