package components;



import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import db.InfoModel;

public class MyToolBar extends JPanel {
	public MyToolBar() {
	 modeldb = InfoModel.getInstance();
	 javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this);
     setLayout(jPanel1Layout);
     NumberFormat nf = NumberFormat.getInstance();
	 NumberFormatter formatter = new NumberFormatter(nf);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(1);
		formatter.setMaximum(1001);
		formatter.setAllowsInvalid(false);
		formatter.setCommitsOnValidEdit(true);
    xElLabel = new JLabel("X Elements:");
		//mainFrame.add(new JLabel("X Elements:"));
	xElementsTxt = new JFormattedTextField(formatter);
	xElementsTxt.setText("1");
	xElementsTxt.setPreferredSize(new Dimension(50, 20));
		//mainFrame.add(xElementsTxt);
	add(xElementsTxt);
	yElLabel = new JLabel("Y Elements: ");
		//mainFrame.add(new JLabel("Y Elements:"));
		yElementsTxt = new JFormattedTextField(formatter);
		yElementsTxt.setText("1");
		yElementsTxt.setPreferredSize(new Dimension(50, 20));
		//mainFrame.add(yElementsTxt);
	add(yElementsTxt);
		
		btnMesh = new JButton("Set Mesh");
	//	mainFrame.add(btnMesh);
	add(btnMesh);
		btnMesh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
			
				modeldb.setFishnet_x(Integer.valueOf(xElementsTxt.getText()));
				modeldb.setFishnet_y(Integer.valueOf(yElementsTxt.getText()));
				btnMesh.setEnabled(false);
			}
		});
		
     jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
             .addContainerGap(27, Short.MAX_VALUE)
             .addComponent(xElLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
             .addGap(38, 38, 38)
             .addComponent(xElementsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
             .addGap(35, 35, 35)
             .addComponent(yElLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
             .addGap(25, 25, 25)
             .addComponent(yElementsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
             .addGap(32, 32, 32)
             .addComponent(btnMesh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
             .addContainerGap(28, Short.MAX_VALUE))
     );
     jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
             .addContainerGap()
             .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                 .addComponent(yElLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(xElLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(yElementsTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(xElementsTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(btnMesh, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
             .addContainerGap(14, Short.MAX_VALUE))
     );
	
	
	}
	
	
private InfoModel modeldb;
private JTextField xElementsTxt;
private JTextField yElementsTxt;
private JLabel xElLabel;
private JLabel yElLabel;
private int xElements;
private int yElements;
private JButton btnMesh;	
}
