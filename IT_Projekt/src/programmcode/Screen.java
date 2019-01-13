package programmcode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Screen extends Canvas{
	private Steuerung steuerung;
	private JFrame frame = new JFrame("BBTan");
	private JButton buttonEnde = new JButton();
	private JButton btnNeuesSpiel = new JButton();
	private JButton btnSpeichern = new JButton();
	private JButton[] btnSpielstaende = new JButton[5];
	private JButton btnSpielstandSpeichern = new JButton();
	private JButton btnSpielstandLaden = new JButton();
	public JFrame getFrame() {
		return frame;
	}
	
	public JButton getBtnSpielstandSpeichern() {
		return btnSpielstandSpeichern;
	}
	
	public JButton getBtnSpielstandLaden() {
		return btnSpielstandLaden;
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
	
	public JButton[] getBtnSpielstaende() {
		return btnSpielstaende;
	}
	
	public Screen(Steuerung pS, KeyEvt e){
		
		steuerung = pS;
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
	    
	    btnSpielstandSpeichern.setBounds( Toolkit.getDefaultToolkit().getScreenSize().width/2-100, Toolkit.getDefaultToolkit().getScreenSize().height-600,200,50);
	    btnSpielstandSpeichern.setMargin(new Insets(2,2,2,2));
	    btnSpielstandSpeichern.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		steuerung.spielstandXSpeichern();
	    	}
	    });
	    btnSpielstandSpeichern.setText("Spielstand Error speichern");
	    btnSpielstandSpeichern.setEnabled(false);
	    btnSpielstandSpeichern.setVisible(false);
	    btnSpielstandSpeichern.setFocusable(false);
	    
	    btnSpielstandLaden.setBounds( Toolkit.getDefaultToolkit().getScreenSize().width/2-100, Toolkit.getDefaultToolkit().getScreenSize().height-700,200,50);
	    btnSpielstandLaden.setMargin(new Insets(2,2,2,2));
	    btnSpielstandLaden.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		steuerung.spielstandLaden();
	    	}
	    });
	    btnSpielstandLaden.setText("Spielstand Error laden");
	    btnSpielstandLaden.setEnabled(false);
	    btnSpielstandLaden.setVisible(false);
	    btnSpielstandLaden.setFocusable(false);
	    
	    btnSpeichern.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2-100, Toolkit.getDefaultToolkit().getScreenSize().height-400,200,50);
	    btnSpeichern.setMargin(new Insets(2,2,2,2));
	    btnSpeichern.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		steuerung.setSpeichern();
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
	    		steuerung.neuesSpiel();
	    	}
	    });
	    
	    Icon imgNeuesSpiel =  new ImageIcon(this.getClass().getResource("btnNeueRunde.png"));
	    btnNeuesSpiel.setIcon((Icon) imgNeuesSpiel);
	    btnNeuesSpiel.setEnabled(false);
	    btnNeuesSpiel.setVisible(false);
	    btnNeuesSpiel.setFocusable(false);
	    
	    for(int i = 0; i<5; i++) {
	    	int j = i;
	    	btnSpielstaende[i] = new JButton();
	    	btnSpielstaende[i].setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2-100, Toolkit.getDefaultToolkit().getScreenSize().height-800+i*100,200,50);
	    	btnSpielstaende[i].setMargin(new Insets(2,2,2,2));
	    	btnSpielstaende[i].addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		steuerung.spielstandSpeichern(btnSpielstaende[j].getY());
		    	}
		    
	    });
	    btnSpielstaende[i].setText("Spielstand " + (i+1));
	    btnSpielstaende[i].setEnabled(false);
	    btnSpielstaende[i].setVisible(false);
	    btnSpielstaende[i].setFocusable(false);
	    frame.add(btnSpielstaende[i]);
	    }
	    
	    frame.add(btnSpielstandLaden);
	    frame.add(btnSpielstandSpeichern);
	    frame.add(btnNeuesSpiel);
	    frame.add(buttonEnde);
	    frame.add(btnSpeichern);
	    frame.setLayout(new BorderLayout());
	    frame.add(this,BorderLayout.CENTER);
	    this.addKeyListener(e);	    
	    frame.setUndecorated(true);
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    frame.setUndecorated(true);
	    frame.setVisible(true);
}
}

