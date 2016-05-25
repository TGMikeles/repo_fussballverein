



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;

/**
 * Das ist eine Klasse die mir die Insert für die Semesteraufgabe in einem File speichert 
 * @author Ibrahim
 *
 */
public class InsertsMannschaft {
	public static void main(String[] args) {
		InsertsMannschaft k =new InsertsMannschaft();
		try {



			//Erzeugen eines Files
			File file = new File("C:/Users/Ibrahim/Desktop/TestJava/mannschaftinsert.sql");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();

			}
		

			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			//mit der schleife erzeuge ich zufaellige Geburstdatumen und die Insert wobei ich sie in einem File speicher

			for(int i=1;i<=100000;i++){
			

				GregorianCalendar gc = new GregorianCalendar();

				
				int year = randBetween(2015, 2019);

				gc.set(gc.YEAR, year);

				int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

				gc.set(gc.DAY_OF_YEAR, dayOfYear);
			
			
				bw.write("insert into mannschaft(bezeichnung,klasse,naechstes_spiel) values('Bezeichnung"+i+"','"+"Klasse"+i+"',"+"'"+gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH)+
						" ');"+System.getProperty("line.separator"));

			//Test ob wirklich das geburstdatum zwischen 1900 und 2010 ist	
				//System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));
			}
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

	
}
	
