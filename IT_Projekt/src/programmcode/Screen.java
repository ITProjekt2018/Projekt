package programmcode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Screen extends Canvas{
	private Hintergrund hintergrund;
	private JFrame frame = new JFrame("BBTan");
	private JButton buttonEnde = new JButton();
	private JButton btnNeuesSpiel = new JButton();
	private JButton btnSpeichern = new JButton();
	public JFrame getFrame() {
		return frame;
	}
	public JButton getBtnEnde() {
		return buttonEnde;
	}
	
	public JButton getBtnNeuesSpiel() {
		return btnNeuesSpiel;
	}
	
	public JButton getBtnSpeichern() {
		return btnSpeichern;
	}
	
	public Screen(Hintergrund h, KeyEvt e){
		
		hintergrund = h;
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	   
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(screenSize);
	   // this.setBackground(new Color(0,0,100));
	    buttonEnde.setBounds( Toolkit.getDefaultToolkit().getScreenSize().width/2-100, Toolkit.getDefaultToolkit().getScreenSize().height-500,200,50);
	    buttonEnde.setMargin(new Insets(2,2,2,2));
	    buttonEnde.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		System.exit(0);
	    	}
	    });
	    Icon imgEnde =  new ImageIcon(this.getClass().getResource("btnEnde.png"));
	    buttonEnde.setIcon((Icon) imgEnde);
	    buttonEnde.setEnabled(false);
	    buttonEnde.setVisible(false);
	    buttonEnde.setFocusable(false);
	    
	    btnSpeichern.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2-100, Toolkit.getDefaultToolkit().getScreenSize().height-400,200,50);
	    btnSpeichern.setMargin(new Insets(2,2,2,2));
	    btnSpeichern.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    	}
	    });
	    Icon imgSpeichern =  new ImageIcon(this.getClass().getResource("btnSpeichern.png"));
	    btnSpeichern.setIcon((Icon) imgSpeichern);
	    btnSpeichern.setEnabled(false);
	    btnSpeichern.setVisible(false);
	    btnSpeichern.setFocusable(false);
	    btnSpeichern.setText("test");
	    
	    btnNeuesSpiel.setBounds( Toolkit.getDefaultToolkit().getScreenSize().width/2-100, Toolkit.getDefaultToolkit().getScreenSize().height-600,200,50);
	    btnNeuesSpiel.setMargin(new Insets(2,2,2,2));
	    btnNeuesSpiel.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		hintergrund.neuesSpiel();
	    	}
	    });
	    
	    Icon imgNeuesSpiel =  new ImageIcon(this.getClass().getResource("btnNeueRunde.png"));
	    btnNeuesSpiel.setIcon((Icon) imgNeuesSpiel);
	    btnNeuesSpiel.setEnabled(false);
	    btnNeuesSpiel.setVisible(false);
	    btnNeuesSpiel.setFocusable(false);
	    
	    frame.add(btnNeuesSpiel);
	    frame.add(buttonEnde);
	    frame.setLayout(new BorderLayout());
	    frame.add(this,BorderLayout.CENTER);
	    this.addKeyListener(e);	    
	    frame.setUndecorated(true);
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    frame.setUndecorated(true);
	    frame.setVisible(true);
}
}
