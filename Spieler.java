
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
public class Spieler {
	public static void main(String[] args) {
		try {


			//Erzeugen eines Files
			File file = new File("C:/Users/Ibrahim/Desktop/TestJava/insertSpielerperson.sql");
			

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();

			}



		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());

			BufferedWriter bw = new BufferedWriter(fw);
			
			//mit der schleife erzeuge ich zufaellige Geburstdatumen und die Insert wobei ich sie in einem File speicher


			for(int i=10000;i<=1500000;i++){




				GregorianCalendar gc = new GregorianCalendar();


				int year = randBetween(1979, 2005 );

				gc.set(gc.YEAR, year);

				int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

				gc.set(gc.DAY_OF_YEAR, dayOfYear);
				int b =1;
				if(i%2==0){



					bw.write("insert into person(persnr,vname,nname,geschlecht,gebdat) values("+i+",'"+randomGiv()+"',"+"'"+randomLas()+"','"+randomGe()+"'"+"',"+"'"+gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH)+
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
	public enum givenname{

		Ibrahim,
		Patrick,
		Seyyid,
		Eren,
		Ahmet,
		Yunus,
		Samet,
		Mehmet,
		Marion,
		Gabi,
		Bianca,
		Ayse,
		Oryal,
		Osama,
		Oscar,
		Osiris,
		Osmond,
		Ossama,
		Otakar,
		Otfried,

	}

	public enum geschlecht
	{
		M,
		N,
		W,
	}

	public enum lastname {
		Keles,
		Wichert,
		Sefer,
		Husain,
		Husarewych,
		Hussain,
		Hussein,
		Hussey,
		Huszar,

	}
	public enum postion{
		Torwart,
		Verteidiger,
		Mittelfeld,
		Sturm,
	}

	public  static givenname randomGiv() {
		int pick = new Random().nextInt(givenname.values().length);
		return givenname.values()[pick];
	}
	public  static lastname randomLas() {
		int pick = new Random().nextInt(lastname.values().length);
		return lastname.values()[pick];
	}
	public  static geschlecht randomGe() {
		int pick = new Random().nextInt(geschlecht.values().length);
		return geschlecht.values()[pick];

	}

}

