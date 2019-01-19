package components;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyMenuBar() {
		JMenu menu = new JMenu("Model");
		add(menu);
		JMenuItem menuItem = new JMenuItem("New");
		menu.add(menuItem);
	}
	

}
