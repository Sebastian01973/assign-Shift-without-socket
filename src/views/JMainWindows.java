package views;
import models.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JMainWindows extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMainPanel jMainPanel;
	
	public JMainWindows(ActionListener actionListener) {
		this.setTitle(Constant.TITTLE_APP);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(900,650));
		this.setIconImage(new ImageIcon(getClass().getResource(Constant.IMG_APP)).getImage());
		initComponents(actionListener);
		this.setVisible(true);
	}
	private void initComponents(ActionListener actionListener) {
		jMainPanel = new JMainPanel(actionListener);
		this.getContentPane().add(jMainPanel,BorderLayout.CENTER);
	}

	public void setUser(String user,String code){
		jMainPanel.setUser(code,user);
	}

	public void setLastClient(String code,String name){
		jMainPanel.setLastClient(code,name);
	}

	public void setLabels(String[] users,String[] code){
		jMainPanel.setLabels(users,code);
	}

	public Client createClient(){
		return jMainPanel.createClient();
	}

	public void setValues(){
		jMainPanel.setValues();
	}

}
