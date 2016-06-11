package controller;

import java.awt.Label;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import org.postgresql.ds.PGSimpleDataSource;
import org.postgresql.jdbc2.optional.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.collections.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.*;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;

import javafx.scene.control.TableColumn.CellDataFeatures;


public class FussballvereinController  {

	private ObservableList<ObservableList> data;
	private PGSimpleDataSource  ds ;
	private Connection con;

	@FXML
	private Label dbinformation,dauerLabel;
	@FXML
	private  TextField dbname,dbuser,dbpasswd,dbip,dbport,createneTab,datumInsert,gegnerTab,spieleTab,valueHin,updateTab,alttabel,newColm,newValue;

	@FXML
	private Button  connect  ;
	



	@FXML 
	private TableView tableZeichen,tablezwei;


	public void connection(ActionEvent e )
	{

		// Datenquelle erzeugen und konfigurieren
		ds = new PGSimpleDataSource();
		ds.setServerName(dbip.getText()); 
		ds.setDatabaseName(dbname.getText());
		ds.setUser(dbuser.getText());
		ds.setPassword(dbpasswd.getText());
	



		try {
			// Verbindung herstellen
			System.out.println("Esgeht");
			con= ds.getConnection();
			



			// Abfrage vorbereiten und ausfuehren

			//table();

			tableSpielt();
			

			con.close();
		} catch (Exception se ) {
			System.out.println("kes"+se);
		}
	}





	public void table()
	{

		try{
			data = FXCollections.observableArrayList();
			con=ds.getConnection();
			String SQL = "SELECT * from Spiel";
			//ResultSet
			ResultSet rs = con.createStatement().executeQuery(SQL);


			for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
				//We are using non property style for making dynamic table
				final int j = i;                
				TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
				col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
					public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
						return new SimpleStringProperty(param.getValue().get(j).toString());                        
					}                    
				});

				tableZeichen.getColumns().addAll(col); 
				System.out.println("Column ["+i+"] ");
			}


			while(rs.next()){
				//Iterate Row
				ObservableList<String> row = FXCollections.observableArrayList();
				for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
					//Iterate Column
					row.add(rs.getString(i));
				}
				System.out.println("Row [1] added "+row );
				data.add(row);

			}

			//FINALLY ADDED TO TableView
			tableZeichen.setItems(data);
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Error keine tabele zum reinschreiben");
		}
	}

	public void tableSpielt()
	{

		try{
			data = FXCollections.observableArrayList();
			con=ds.getConnection();
			String SQL = "SELECT * from spielt";
			//ResultSet
			ResultSet rs = con.createStatement().executeQuery(SQL);


			for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
				//We are using non property style for making dynamic table
				final int j = i;                
				TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
				col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
					public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
						return new SimpleStringProperty(param.getValue().get(j).toString());                        
					}                    
				});

				tablezwei.getColumns().addAll(col); 
				System.out.println("Column ["+i+"] ");
			}


			while(rs.next()){
				//Iterate Row
				ObservableList<String> row = FXCollections.observableArrayList();
				for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
					//Iterate Column
					row.add(rs.getString(i));
				}
				System.out.println("Row [1] added "+row );
				data.add(row);

			}

			//FINALLY ADDED TO TableView
			tablezwei.setItems(data);
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Error keine tabele zum reinschreiben");
		}
	}
	public void insert(ActionEvent e)
	{
		try{
			con=ds.getConnection();
			PreparedStatement pst;
			String statat=datumInsert.getText();
			String insertString = "INSERT INTO Spiel  VALUES (?,'" +statat+"', ?,?)";
			pst = con.prepareStatement(insertString);
			con.setAutoCommit(false);

			// named Person] which in this set of statements we shall call 'p' within the list
			// previously defined and named 'mylist' ... or "For each Person 'p' in 'mylist'"
			String mannschaft = createneTab.getText(); // get the name which corresponds to the Person in this object of 'mylist'

			String gegner =gegnerTab.getText();// ditto, phone. Did as integer here to show how to add to pst below
			String ergebnis=spieleTab.getText();


			pst.setString(1, mannschaft); // replace question mark 1 with value of 'name
			pst.setString(2, gegner); // ditto, 3 and 'phone'
			pst.setString(3, ergebnis);
			pst.executeUpdate();
			con.commit();
			System.out.println("Es geht!");

		}catch(SQLException t )
		{
			System.out.print("Error amk nikis datenbank");
			t.printStackTrace(System.err);
		}


	}

	public void delete(ActionEvent e)
	{
		try{
			con=ds.getConnection();
			PreparedStatement pst;
			String sql = " DELETE FROM Spiel WHERE bezeichnung =?;";
			pst = con.prepareStatement(sql);
			con.setAutoCommit(false);
			String bezeichnung =valueHin.getText();
			// named Person] which in this set of statements we shall call 'p' within the list
			// previously defined and named 'mylist' ... or "For each Person 'p' in 'mylist'"
			String mannschaft = createneTab.getText(); // get the name which corresponds to the Person in this object of 'mylist'
			String gegner =gegnerTab.getText();// ditto, phone. Did as integer here to show how to add to pst below
			String ergebnis=spieleTab.getText();

		
			pst.setString(1, bezeichnung);
			pst.executeUpdate();
			con.commit();
			System.out.println("Delet geht!");

		}catch(SQLException t )
		{
			System.out.print("Error amk nikis datenbank");
			t.printStackTrace(System.err);
		}


	}
	public void update(ActionEvent e)
	{
		try{
			con=ds.getConnection();
			PreparedStatement pst;
		
			String updatesql = "Update Spiel set ?=? where ?=?";
			pst = con.prepareStatement(updatesql);
			con.setAutoCommit(false);

			// named Person] which in this set of statements we shall call 'p' within the list
			// previously defined and named 'mylist' ... or "For each Person 'p' in 'mylist'"
			String neueDaten=newColm.getText();
			String wertneu=newValue.getText();
			String tabelle1 = updateTab.getText(); // get the name which corresponds to the Person in this object of 'mylist
			String tabelle2 =alttabel.getText();// ditto, phone. Did as integer here to show how to add to pst below


			pst.setString(1, neueDaten);
			pst.setString(2, wertneu);
			pst.setString(3, tabelle1); // replace question mark 1 with value of 'name
			pst.setString(4, tabelle2); // ditto, 3 and 'phone'
			pst.executeUpdate();
			con.commit();
			System.out.println("Update geht auch!");

		}catch(SQLException t )
		{
			System.out.print("Error amk nikis datenbank");
			t.printStackTrace(System.err);
		}



	}
	public void aktual()
	{
		tableZeichen.getColumns().clear();
		data.clear();
		data = FXCollections.observableArrayList();


	}
	public void abrufenderKlasse()
	{
		try
		{
			con=ds.getConnection();
			Statement st=con.createStatement();
			ResultSet rs =st.executeQuery("select Spieler.persnr,dauer from spielt inner join Spieler on Spieler.persnr = spielt.persnr;");
			while(rs.next()){

				String wert=rs.getString(2);
				System.out.println(wert);


			}
		}catch(SQLException er)
		{
			System.out.print("d"+er);
		}
	}
	public void spielstandKlasse()
	{
		try
		{
			con=ds.getConnection();
			Statement st=con.createStatement();
			ResultSet rs =st.executeQuery("select Spieler.persnr,Spiel.ergebnis,dauer from spielt inner join Spieler on Spieler.persnr = spielt.persnr"
+"inner join Spiel on Spiel.bezeichnung=spielt.bezeichnung;");
			while(rs.next()){

				String wert1=rs.getString(3);
				System.out.println(wert1);


			}
		}catch(SQLException er)
		{
			System.out.print("d"+er);
		}
	}




}





















