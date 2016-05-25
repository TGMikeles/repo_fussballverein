import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Random;



public class Person {
 FileWriter writer;
 File file;
 
 /*Unter Verwendung des SDF & GregorianCalender erstelle ich mir ein Zufallsdatum,
 dass ich für die Geburtsdaten verwende.
 */
 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

 GregorianCalendar von = new GregorianCalendar();
 GregorianCalendar bis = new GregorianCalendar();
 GregorianCalendar zufall = new GregorianCalendar();
 
 
 

 
 public void person(){
  //Erstellung des SQL Files
  file = new File("insertPerson.sql"); 
  /*
   * Ich setze mir das von & das bis Datum, anschließend hole ich mir 
   * die Millisekunden der Daten und dann lass ich mir eine Random 
   * Anzahl der Millisekunden mittels Random berechnen, die zwischen der 
   * Anzahl der Millisekunden der beiden Daten liegt
   */
  try {
   von.setTime(df.parse("1930-01-01"));
  } catch (ParseException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  try {
   bis.setTime(df.parse("2005-01-01"));
  } catch (ParseException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  
  long l = von.getTimeInMillis();
  long l1 = bis.getTimeInMillis();
  long lg = (l1 - l);
  
  try {
   writer = new FileWriter(file, true);

  /*
   * Nun schreibe ich mit per For-Schleife 100000 INSERTS in die SQL Datei.
   * Mit der if, bekomme ich nur gerade Zahlen. 
   */
  for (int i = 10000; i < 100000; i++) {
   if (i % 2 == 1) {
    i++;
    Random random = new Random();
   long gesamt= Math.abs(random.nextLong() % lg) + l;
   //System.out.println(Math.abs(random.nextLong() % lg) + l);
   zufall.setTimeInMillis(gesamt);
   //System.out.println(df.format(zufall.getTime())); 
   writer.write("INSERT INTO person (persnr, vname, nname, geschlecht, gebdat) VALUES ('"+i+"','"+zufallsVorname()+"','"+zufallsNachname()+"','"+zufallsGeschlecht()+"','"+df.format(zufall.getTime())+"');");
   writer.write(System.getProperty("line.separator"));
   
   }
   }
  }catch (IOException e) {
   e.printStackTrace();
  }
  
  
 }
 /*
  * Hier erstelle ich meine enums
  * Davon werden Random Inhalte genommen und 
  * ins File gespeichert.
  * Ich hab nur ein paar Namen genommen, weil es im Prinzip 
  * egal ist, ob Spieler den gleichen Namen haben, da jeder
  * eine andere Personennummer hat.
  */
 public enum geschlecht {
  M, 
  W, 
  N
 }
 public enum nachname{
  Gruber,
  Huber,
  Wagner,
  Hofer,
  Müller,
  Schwarz,
  Fuchs,
  Schneider,
  Leitner,
  Reiter,
  Winter
 }
 public enum vorname{ 
  Georg, 
  Jakob, 
  Fritz, 
  Dominik, 
  Lorennz, 
  Matthias,
  Alexander, 
     Michael, 
     Phillip,
     Marco, 
     Simon, 
     Bennedikt, 
     Paul, 
     Stefan,
    
    }
 /*
  * Hier hole ich mir die Random Inhalte der Enums.
  */
 public static vorname zufallsVorname() {
  int pick = new Random().nextInt(vorname.values().length);
  return vorname.values()[pick];
 }
 public static nachname zufallsNachname() {
  int pick = new Random().nextInt(nachname.values().length);
  return nachname.values()[pick];
 }
 public static geschlecht zufallsGeschlecht() {
  int pick = new Random().nextInt(geschlecht.values().length);
  return geschlecht.values()[pick];

 }
 
 public static void main(String [] args){
  Person p = new Person();
  p.person();
 }
}