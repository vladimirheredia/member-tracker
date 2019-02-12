package memberproject.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import memberproject.common.IRepository;
import memberproject.common.Repository;
import memberproject.common.SQLiteJDBCDriverConnector;
import memberproject.models.Member;

public class MembersController implements Initializable {

    @FXML
    private TableView<Member> tbvMembers;
	
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//get list of members from DB
		 IRepository repo = Repository.Instance();
	     repo.setDataProvider(new SQLiteJDBCDriverConnector());
		ObservableList<Member> members = FXCollections.observableArrayList(repo.getAllMembers());
		
		tbvMembers.setItems(members);

		tbvMembers.setRowFactory(tv -> {
            TableRow<Member> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if ((!row.isEmpty())) {
                	//do something on row clicked
                }
                //when row is double clicked
                if(event.getClickCount() == 2 && (!row.isEmpty())){
                	System.out.println("You clicked " + row.getItem().getFirstName());
                	loadProfile(row.getItem().getId());
                }
            });
            return row;
        });
	}
	
	private void loadProfile(int memberId){
			MemberProfileController.memberId = memberId;
			ContentNavigator.loadContent(ContentNavigator.MEMBER_PROFILE);

	}

}