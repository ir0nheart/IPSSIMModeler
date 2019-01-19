package components;

import javax.swing.JDesktopPane;
import javax.swing.JPanel;


public class MyDesktopPane extends JDesktopPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel mainPanel;
	public JPanel getMyMainPanel() {return mainPanel;}
	public void dalga() {
		System.out.println("dalge");
	}
	public MyDesktopPane() {
		mainPanel = new BasePane();
		add(mainPanel);	
	}
	
	
	
}
