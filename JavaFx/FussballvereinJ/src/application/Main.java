package application;

import controller.FussballvereinController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;


public class Main extends Application  {

	@Override

	public void start(Stage primaryStage) {
		//FussballvereinController fu =new FussballvereinController();
		//SpielThreads T1 ,T2;
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/fussballverein.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);

			primaryStage.setTitle("Fussballverein");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)  {

	//	Thread T1 = new SpieltThreads(wert, fU);
		//Thread spielt =new SpieltThreads(wert,fU);
		 // T1.start();
	   //   T2.start();

	      // wait for threads to end
	      //try {
	     //    T1.join();
	   //      T2.join();
	  //    } catch( Exception e) {
	  //       System.out.println("Interrupted");
	   //   }

		launch(args);

		
		
	}
}
