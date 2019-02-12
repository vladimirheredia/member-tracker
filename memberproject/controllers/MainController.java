package memberproject.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

public class MainController implements Initializable {

	private String stageName;
	@FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;
    
    @FXML
    private AnchorPane root;

    public static AnchorPane rootP;
    
    @FXML
    public AnchorPane membersPane;
    
    @FXML
    public AnchorPane rootPane;
    
    public MainController(){
   	
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
        rootP = root;
        
        try {
            VBox box = FXMLLoader.load(getClass().getResource("../../memberproject/views/controls/SidePanelContent.fxml"));
            drawer.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            transition.setRate(transition.getRate()*-1);
            transition.play();
            
            if(drawer.isShown())
            {
                drawer.close();
            }else
                drawer.open();
        });
	}

	/**
	 * @return the stageName
	 */
	public String getStageName() {
		return stageName;
	}
	
	public void setContent (AnchorPane anchorPane){
        List<Node> nodes = anchorPane.getChildren();
        rootPane.getChildren().clear();
        rootPane.getChildren().addAll(nodes);
    }

	/**
	 * @param stageName the stageName to set
	 */
	public void setStageName(String stageName) {
		this.stageName = stageName;
		
		ContentNavigator.loadContent("../../memberproject/views/" + stageName + ".fxml");
	}
}
