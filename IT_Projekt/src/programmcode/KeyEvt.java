package programmcode;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyEvt implements KeyListener{
	
	private Steuerung steuerung;
	public KeyEvt(Steuerung pS) {
		steuerung = pS;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			steuerung.setRechts();
			steuerung.rechts();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			steuerung.setLinks();
			steuerung.links();
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			steuerung.setSpace();
			steuerung.setLaeuft();
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			steuerung.pause();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			steuerung.delRechts();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			steuerung.delLinks();
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			steuerung.delSpace();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_0) {
			steuerung.tickMalZehn();
			System.out.println("Test");
		}
		
		
	}

}
