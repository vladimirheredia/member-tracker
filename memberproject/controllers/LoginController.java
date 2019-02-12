package memberproject.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController implements Initializable {

	@FXML
	private AnchorPane paneLogin;
	@FXML
	private JFXTextField txtUserName;
	
	@FXML
	private JFXPasswordField txtPassword;
	
	@FXML
	private Text lblMessage;
	
	@Override
	public void initialize(URL url, ResourceBundle rs) {
	
		
	}
	
	@FXML
	protected void onClick(ActionEvent event){
		if(this.txtUserName.getText().equals("vheredia") && this.txtPassword.getText().equals("test")){
			Parent root = null;
			try{
			  // root = 	FXMLLoader.load(getClass().getResource("../../memberproject/views/main.fxml"));
			   
			    FXMLLoader loader = new FXMLLoader();
		        AnchorPane mainWindow = (AnchorPane) loader.load(getClass().getResourceAsStream("../../memberproject/views/main.fxml"));
		        Scene scene = new Scene(mainWindow);
		        
		        MainController controller = loader.getController();
		        ContentNavigator.setController(controller);
		        ContentNavigator.loadContent(ContentNavigator.MEMBERS_SCREEN);
			   
			   // Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.initStyle(StageStyle.UNDECORATED);
				stage.setScene(scene);
				stage.show();
				
				paneLogin.getScene().getWindow().hide();
				
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}else{
			this.lblMessage.setText("Your login information is not found. Please try again!");
			this.lblMessage.setVisible(true);
		}
	}
}
