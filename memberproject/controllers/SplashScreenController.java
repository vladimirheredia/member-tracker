package memberproject.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SplashScreenController implements Initializable {

	@FXML
	private AnchorPane rootPaneSplash;

	
	@Override
	public void initialize(URL url, ResourceBundle rb) {

		new SplashScreen().start();
	}
	
	
	class SplashScreen extends Thread{
		
		@Override
		public void run(){
			try{
				Thread.sleep(3000);

				Platform.runLater(new Runnable(){

					@Override
					public void run() {
						Parent root = null;
						try{
						   root = 	FXMLLoader.load(getClass().getResource("../../memberproject/views/login.fxml"));
						   
						    Scene scene = new Scene(root);
							Stage stage = new Stage();
							stage.initStyle(StageStyle.UNDECORATED);
							stage.setScene(scene);
							stage.show();
							
							rootPaneSplash.getScene().getWindow().hide();
							
						}catch(IOException ex){
							ex.printStackTrace();
						}
					}
				});
	
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
		
	}

}
