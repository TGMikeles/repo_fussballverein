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
public class SqlInsert {
	public static void main(String[] args) {
		try {



			//Erzeugen eines Files
			File file = new File("/users/Ibrahim/Desktop/TestJava/inserts_person.sql");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();

			}



			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			//mit der schleife erzeuge ich zufaellige Geburstdatumen und die Insert wobei ich sie in einem File speicher
			for(int i=1;i< 100000;i++){


				GregorianCalendar gc = new GregorianCalendar();

				
				int year = randBetween(1900, 2010);

				gc.set(gc.YEAR, year);

				int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

				gc.set(gc.DAY_OF_YEAR, dayOfYear);
			
			
				bw.write("insert into person(persnr,vname,nname,geschlecht,gebdat) values("
						+ i+"," + "'Vorname" + i+"'," +  "'Nachname"+i+"'"+ ","+"'M',"+"'"+gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH)+"'"+
						");" +System.getProperty("line.separator"));
			//Test ob wirklich das geburstdatum zwischen 1900 und 2010 ist	
				System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));
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