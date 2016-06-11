import javax.swing.JTextArea;

import controller.FussballvereinController;
import javafx.scene.control.TextArea;

public class SpieltThreads extends Thread {
	private Thread t;
	private String Wert;
	FussballvereinController fU;
	public SpieltThreads(String wert,FussballvereinController fu)
	{
		Wert=wert;
		fU=fu;


	}

		@Override
		public void run() {
			try
			{
				synchronized (fU) {
					fU.abrufenderKlasse();
				Thread.sleep(5);
				}
			}catch(Exception e)
			{
				System.out.println(e);	
			}
			
				
			}
		


	
		public void start()
		{
			if(t==null)
			{
				fU.spielstandKlasse();
				t=new Thread();
				t.start();
			}
		}
	}








