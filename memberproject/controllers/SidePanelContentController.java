package memberproject.controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SidePanelContentController implements Initializable{

    @FXML
    private JFXButton btnEvents;

    @FXML
    private JFXButton btnMembers;

    @FXML
    private JFXButton btnCreateMember;
    
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
    @FXML
    private void actionClick(ActionEvent event) {
    	
    	 JFXButton btn = (JFXButton) event.getSource();
         System.out.println(btn.getText());
    	

			 switch(btn.getId())
		        {
		            case "home": 
		                ContentNavigator.loadContent(ContentNavigator.MEMBERS_SCREEN);
		                break;
		            case "member": 
		                ContentNavigator.loadContent(ContentNavigator.CREATE_MEMBER_SCREEN);
		                break;
		            case "evetns": 
		            	ContentNavigator.loadContent(ContentNavigator.MEMBERS_SCREEN);
		                break;
		        }
    }

    /**
     * Exit application
     * @param event
     */
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

		
 
}
