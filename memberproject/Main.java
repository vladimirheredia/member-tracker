package memberproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import memberproject.common.IRepository;
import memberproject.common.Repository;
import memberproject.common.SQLiteJDBCDriverConnector;
import memberproject.controllers.MainController;
import memberproject.models.Member;
import memberproject.controllers.ContentNavigator;


import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

//        FXMLLoader loader = new FXMLLoader();
//        AnchorPane mainWindow = (AnchorPane) loader.load(getClass().getResourceAsStream("../memberproject/views/main.fxml"));
//        Scene scene = new Scene(mainWindow);
//        
//        MainController controller = loader.getController();
//        ContentNavigator.setController(controller);
//        ContentNavigator.loadContent(ContentNavigator.LOGIN_SCREEN);
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../memberproject/views/SplashScreen.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.setScene(scene);
        //show main window
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
