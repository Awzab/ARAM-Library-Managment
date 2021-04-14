/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagments;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class MemberUpdateController implements Initializable {

    @FXML
    private JFXTextField txtMName;
    @FXML
    private Button btnSubmit;
    @FXML
    private JFXTextField txtMemberID;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtNumber;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void SubmitUpdate(ActionEvent event) throws SQLException, IOException {
        Members con = new Members();
        int ID = Integer.parseInt(txtMemberID.getText());
        String Name = txtMName.getText();
        String Address = txtAddress.getText();
        String Email = txtEmail.getText();
        String PhoneNumber = txtNumber.getText();
        con.updateMember(ID, Name, Address, Email, PhoneNumber);

        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("AllMembers.fxml"));

        Scene scene = new Scene(root);

    }

    public void setData(int ID, String name, String address, String email, String number) {
        String id = Integer.toString(ID);
        txtMemberID.setText(id);
        txtMName.setText(name);
        txtAddress.setText(address);
        txtEmail.setText(email);
        txtNumber.setText(number);

    }
}
