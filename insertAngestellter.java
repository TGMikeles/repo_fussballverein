
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
public class insertAngestellter {
	public static void main(String[] args) {
		try {



			//Erzeugen eines Files
			File file = new File("C:/Users/Ibrahim/Desktop/TestJava/sangetellter.sql");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();

			}




			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			//mit der schleife erzeuge ich zufaellige Geburstdatumen und die Insert wobei ich sie in einem File speicher


			for(int i=1900000;i<2100000;i++){



				GregorianCalendar gc = new GregorianCalendar();
				GregorianCalendar gz = new GregorianCalendar();


				int year = randBetween(1996, 2005 );
				int kes=zufallD(50000);
				int zufallueber=zufallD(10);

				gc.set(gc.YEAR, year);

				int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

				gc.set(gc.DAY_OF_YEAR, dayOfYear);
				
				int jahr = randBetween(2013, 2016 );
				

				gz.set(gz.YEAR, jahr);

				int dayOYear = randBetween(1, gz.getActualMaximum(gz.DAY_OF_YEAR));

				gz.set(gz.DAY_OF_YEAR, dayOYear);
				
				
				if(i%2==0){

					bw.write("insert into Angestellter(persnr,gehalt,ueberstunden,e_mail) values("+i+","+kes+","+zufallueber+"," +randomEm()+"');"+System.getProperty("line.separator"));


					


				}
				//Test ob wirklich das geburstdatum zwischen 1900 und 2010 ist	
				System.out.println(gz.get(gc.YEAR) + "-" + (gz.get(gz.MONTH) + 1) + "-" + gz.get(gz.DAY_OF_MONTH));
			}



			bw.close();
			System.out.println("Done");


		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public enum email {
		
		maxmustermannhotmailcom,
		elisamusterfrauhotmailcom,
		fussballverinmaxhotmailcom,
	}
	
	public static int randBetween(int start, int end) {
		return start + (int)Math.round(Math.random() * (end - start));
	}
	public static int zufallD(int anzahl) {
		return anzahl + (int)Math.round(Math.random() * anzahl);
	}
	public  static email randomEm() {
		int pick = new Random().nextInt(email.values().length);
		return email.values()[pick];

	}
}



