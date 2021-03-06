import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;

/**
 * Das ist eine Klasse die mir die Insert f�r die Semesteraufgabe in einem File speichert 
 * @author Ibrahim
 *
 */
public class angestellter {
	public static void main(String[] args) {
		try {



			//Erzeugen eines Files
			File file = new File("C:/Users/Ibrahim/Desktop/TestJava/traineramk.sql");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();

			}




			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			//mit der schleife erzeuge ich zufaellige Geburstdatumen und die Insert wobei ich sie in einem File speicher


			for(int i=200000;i<=400000;i++){



				GregorianCalendar gc = new GregorianCalendar();
				GregorianCalendar gz = new GregorianCalendar();


				int year = randBetween(1996, 2005 );
				int kes=zufallD(50000);
				int zufall=zufallD(10);

				gc.set(gc.YEAR, year);

				int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

				gc.set(gc.DAY_OF_YEAR, dayOfYear);
				
				int jahr = randBetween(2013, 2016 );
				

				gz.set(gz.YEAR, jahr);

				int dayOYear = randBetween(1, gz.getActualMaximum(gz.DAY_OF_YEAR));

				gz.set(gz.DAY_OF_YEAR, dayOYear);
				
				
				if(i%2==0){

					bw.write("insert into persnr(persnr,vname,nname,geschlecht,gebdat) values("+i+",'"+"Vorname"+i+"'"+"'Nachname"+i+"','M'"+"',"+"'"+gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH)+
							" ');"+System.getProperty("line.separator"));

					bw.write("insert into Angestellter(persnr,gehalt,ueberstunden,e_mail) values("+i+","+kes+","+gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH)+"',"+gz.get(gz.YEAR) + "-" + (gz.get(gz.MONTH) + 1) + "-" + gz.get(gz.DAY_OF_MONTH)+"');"+System.getProperty("line.separator"));


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
	/*
	 * 
	 *
	 */
	public static int randBetween(int start, int end) {
		return start + (int)Math.round(Math.random() * (end - start));
	}
	public static int zufallD(int anzahl) {
		return anzahl + (int)Math.round(Math.random() * anzahl);
	}
	
}



