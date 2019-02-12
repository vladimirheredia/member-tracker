/*

 */

package memberproject.controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**

 */
public class ContentNavigator {
    
    //fxml files
    public static final String MEMBER_PROFILE = "../../memberproject/views/MemberProfile.fxml";
    public static final String SPLASH_SCREEN = "../../memberproject/views/SplashScreen.fxml";
    public static final String MAIN_SCREEN = "../../memberproject/views/main.fxml";
    public static final String MEMBERS_SCREEN = "../../memberproject/views/Members.fxml";
    public static final String LOGIN_SCREEN = "../../memberproject/views/login.fxml";
    public static final String CREATE_MEMBER_SCREEN = "../../memberproject/views/CreateMember.fxml";
   
    
    
    private static MainController mainController;
    
    public static void setController(MainController controller){
        ContentNavigator.mainController = controller;
    }
    
    public static void loadContent(String fxmlFile){
        try {
            mainController.setContent((AnchorPane) FXMLLoader.load(ContentNavigator.class.getResource(fxmlFile)));
        } catch (IOException ex) {
            Logger.getLogger(ContentNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
