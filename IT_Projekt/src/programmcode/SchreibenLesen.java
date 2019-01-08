package programmcode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.image.BufferStrategy;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.awt.*;

public class SchreibenLesen {
	
	private Rechteck[][] spielfeld = new Rechteck[10][10];
	private int kreise;
	private int spiel;
	
	public void schreiben(Rechteck[][] pSpielfeld, int pKreise, int pSpiel) {
		spielfeld = pSpielfeld;
		kreise = pKreise;
		spiel = pSpiel;
		OutputStream writer = null;
		ObjectOutputStream oos = null;
		System.out.println("Test");
		try {
			writer = new FileOutputStream("spielstand" + spiel + ".tmp");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		//oos = new ObjectOutputStream(writer);
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				if(spielfeld[i][j]!=null) {
					for(int k = 0; k < Integer.toString(spielfeld[i][j].getLeben()).length(); k++) {
						writer.write(Integer.toString(spielfeld[i][j].getLeben()).charAt(k));
					}
					
				}else {
					writer.write('0');
				}
				writer.write(',');
				System.out.println("Test1");
			}
		writer.write(kreise);
		}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		if(oos != null) {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void lesen(int spiel) throws IOException {
		spielfeld = new Rechteck[10][10];
		
		Reader reader = new FileReader("spielstand" + spiel + ".tmp");
		String test = "";
		for(int c; (c = reader.read() ) != -1;)
		test = test + (char) c;
		String[] angaben = test.split(",");
		for(int i = 0; i<angaben.length; i++) {
			//System.out.println(angaben[i]);
		}
		for(int i = 0; i< angaben.length; i++){
			int leben = 0;
			try {
				leben = Integer.parseInt(angaben[i]);	
				System.out.println(leben);
				spielfeld[(int)i%10][(int)i/10] = new Rechteck(100*(i%10)+(int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2-500),10,50,50,leben); 
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
		}
		System.out.println(test);
		reader.close();
	}
}
