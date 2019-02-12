package memberproject.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;

public class FXMLController implements Initializable {
    
        
    @FXML
    private AnchorPane content;
    @FXML
    private Menu mnuHelp;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setContent (AnchorPane anchorPane){
        List<Node> nodes = anchorPane.getChildren();
        content.getChildren().clear();
        content.getChildren().addAll(nodes);
    }

//    @FXML
//    private void loadHelp(ActionEvent event) {
//        ContentNavigator.loadContent(ContentNavigator.CONTENT2);
//    }
}
