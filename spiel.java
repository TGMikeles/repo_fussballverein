import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Das ist eine Klasse die mir die Insert für die Semesteraufgabe in einem File speichert 
 * @author Ibrahim
 *
 */
public class spiel {
	public static void main(String[] args) {
		try {


		

			//Erzeugen eines Files
			File file = new File("C:/Users/Ibrahim/Desktop/TestJava/spiel.sql");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();

			}

			

			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			//mit der schleife erzeuge ich zufaellige Geburstdatumen und die Insert wobei ich sie in einem File speicher
			

			for(int i=0;i<=100000;i++){
				
				

				
				GregorianCalendar gc = new GregorianCalendar();

				
				int year = randBetween(2006, 2010 );
				
				gc.set(gc.YEAR, year);

				int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

				gc.set(gc.DAY_OF_YEAR, dayOfYear);
			
				
					
		     

				bw.write("insert into person(bezeichnung,manschaft,datum,gegner,ergebnis) values('Bezeichnung"+i+"','"+randomMan()+","+gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH)+"',"+randomG()+"','"+randomEr()+
						" ');"+System.getProperty("line.separator"));
	
			}
			
			//Test ob wirklich das geburstdatum zwischen 1900 und 2010 ist	
				//System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));
			
			
			
			
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 
	 *
	 */
	public static int randBetween(int start, int end) {
		return start + (int)Math.round(Math.random() * (end - start));
	}
	public enum gegner{
		
		gegner1,
		gegner2,
		gegner3,
		gegner4,
		
	}

public enum ergebnis
{
	ergebnis1,
	ergebnis2,
	ergebnis3,
	ergebnis4,
}
	
	public enum mannschaft {
	mannschaft1,
	mannschaft2,
	mannschaft3,
	mannschaft4,
		
	}
	
	public  static gegner randomG() {
	    int pick = new Random().nextInt(gegner.values().length);
	    return gegner.values()[pick];
	}
	public  static mannschaft randomMan() {
	    int pick = new Random().nextInt(mannschaft.values().length);
	    return mannschaft.values()[pick];
	}
	public  static ergebnis randomEr() {
	    int pick = new Random().nextInt(ergebnis.values().length);
	    return ergebnis.values()[pick];

}
}

