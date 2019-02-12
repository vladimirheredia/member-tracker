package memberproject.controllers;


import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import memberproject.common.IRepository;
import memberproject.common.Repository;
import memberproject.common.SQLiteJDBCDriverConnector;
import memberproject.models.Member;

public class MemberProfileController implements Initializable{
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
    
    public static int memberId;
    
    
	public MemberProfileController(){
    	

    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//hard code values for now.. .needs to come from the DB
		

        IRepository repo = Repository.Instance();
        repo.setDataProvider(new SQLiteJDBCDriverConnector());
        //connector.createMember(member);

        System.out.println("Members in the DB: " + repo.getAllMembers().size());

        Member mem = repo.getMemberById(memberId);
        
       
        
        
		this.txtFirstName.setText(mem.getFirstName());
    	this.txtLastName.setText(mem.getLastName());
    	this.dtAge.setValue(null);
    	this.txtPhone.setText("555-55-5555");
    	this.txtHouseNumber.setText("" + mem.getAddress().getHouseNumber());
    	this.txtStreet.setText(mem.getAddress().getStreetName());
    	this.txtCity.setText(mem.getAddress().getCity());
    	this.txtState.setText(mem.getAddress().getState());
    	this.txtZip.setText(mem.getAddress().getZipCode());
    	this.txtMemberType.setText("Musician");
    	this.chkIsMember.setSelected(mem.isActive());
		
	}
	
	 @FXML
	    void editMember(ActionEvent event) {
		    //enable controls
		    enableDisalbleControls(true);
	    }

	    @FXML
	    void saveMember(ActionEvent event) {
	    	System.out.println("user info will be saved when clicked");
	    	enableDisalbleControls(false);
	    }
	    
	    /**
	     * Helper method to enable disable control
	     * @param isEnabled
	     */
	    private void enableDisalbleControls(boolean isEnabled){
	    	if(isEnabled){
	    		this.txtFirstName.setDisable(false);
		    	this.txtLastName.setDisable(false);
		    	this.dtAge.setDisable(false);
		    	this.txtPhone.setDisable(false);
		    	this.txtHouseNumber.setDisable(false);
		    	this.txtStreet.setDisable(false);
		    	this.txtCity.setDisable(false);
		    	this.txtState.setDisable(false);
		    	this.txtZip.setDisable(false);
		    	this.txtMemberType.setDisable(false);
		    	this.chkIsMember.setDisable(false);
	    	}else{
	    		this.txtFirstName.setDisable(true);
		    	this.txtLastName.setDisable(true);
		    	this.dtAge.setDisable(true);
		    	this.txtPhone.setDisable(true);
		    	this.txtHouseNumber.setDisable(true);
		    	this.txtStreet.setDisable(true);
		    	this.txtCity.setDisable(true);
		    	this.txtState.setDisable(true);
		    	this.txtZip.setDisable(true);
		    	this.txtMemberType.setDisable(true);
		    	this.chkIsMember.setDisable(true);
	    	}
	    }
}
