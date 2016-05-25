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
public class standort {
	public static void main(String[] args) {
		try {


		

			//Erzeugen eines Files
			File file = new File("C:/Users/Ibrahim/Desktop/TestJava/standort.sql");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();

			}

			

			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			//mit der schleife erzeuge ich zufaellige Geburstdatumen und die Insert wobei ich sie in einem File speicher
			

			for(int i=0;i<=100000;i++){
				
				

				
				GregorianCalendar gc = new GregorianCalendar();

				
				int year = randBetween(1979, 2005 );
				
				gc.set(gc.YEAR, year);

				int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

				gc.set(gc.DAY_OF_YEAR, dayOfYear);
				int b =1;
				if(i%2==0){
					
		     

				bw.write("insert into person(sid,land,ort,plz) values("+i+",'"+randomLa()+"',"+"'"+randomOr()+"','"+randomP()+"" + 
						" ');"+System.getProperty("line.separator"));
	
			}
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
	public enum land{
		
	Land1,
	land2,
	land3,
	land4,
	land5,
		
	}

public enum ort
{
	ort1,
	or2,
	ort3,
	ort4,
	ort5,
}
	
	public enum plz {
	plz1,
	plz2,
	pl3,
	plz4,
	plz5,
	}
	
	public  static land randomLa() {
	    int pick = new Random().nextInt(land.values().length);
	    return land.values()[pick];
	}
	public  static plz randomP() {
	    int pick = new Random().nextInt(plz.values().length);
	    return plz.values()[pick];
	}
	public  static ort randomOr() {
	    int pick = new Random().nextInt(ort.values().length);
	    return ort.values()[pick];

}
}

