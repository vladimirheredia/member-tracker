/**
 * 
 */
package memberproject.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 * Date: 8/13/2017
 * @author Vladimir Heredia
 *
 */
public class CreateMemberController implements Initializable {

	  @FXML
	    private TextField txtPhone;

	    @FXML
	    private TextField txtCity;

	    @FXML
	    private JFXCheckBox chkIsMember;

	    @FXML
	    private TextField txtZip;

	    @FXML
	    private TextField txtMemberType;

	    @FXML
	    private DatePicker dtAge;

	    @FXML
	    private TextField txtLastName;

	    @FXML
	    private TextField txtFirstName;

	    @FXML
	    private TextField txtHouseNumber;

	    @FXML
	    private TextField txtOffering;

	    @FXML
	    private TextField txtStreet;

	    @FXML
	    private TextField txtState;

	    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	

	    
	    @FXML
	    void saveMember(ActionEvent event) {

	    }

}
