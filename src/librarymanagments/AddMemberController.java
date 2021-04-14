/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagments;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AceGa
 */
public class AddMemberController implements Initializable {

    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane mainContainer;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtMobile;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXTextField txtPass;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private Label lblOut;
    @FXML
    private CheckBox AdminCheck;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/Styles.css");
        Stage stage = new Stage();
        stage.setTitle("Main Page");
        stage.getIcons().add(new Image("/images/ARAMicon.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    private void AddMember(ActionEvent event) throws SQLException {

        String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        String phoneRegex = "(?:\\+?0*?966)?0?5[0-9]{8}";

        Members member = new Members();

        String name = txtName.getText();
        String pass = txtPass.getText();
        String address = txtAddress.getText();
        String phone = txtMobile.getText();
        String email = txtEmail.getText();
        if (txtName.getText().isEmpty() && txtPass.getText().isEmpty() && txtAddress.getText().isEmpty() && txtMobile.getText().isEmpty() && txtEmail.getText().isEmpty()) {
            lblOut.setText("Please Enter Informations*");
        } else if (txtName.getText().isEmpty()) {
            lblOut.setText("Please Enter Name*");
        } else if (txtPass.getText().isEmpty()) {
            lblOut.setText("Please Enter Password*");
        } else if (txtAddress.getText().isEmpty()) {
            lblOut.setText("Please Enter Address*");
        } else if (txtMobile.getText().isEmpty()) {
            lblOut.setText("Please Enter Mobile*");
        } else if (txtMobile.getText().matches(phoneRegex) == false) {
            lblOut.setText("Mobile is Invalid*");
        } else if (txtEmail.getText().isEmpty()) {
            lblOut.setText("Please Enter Email*");
        } else if (txtEmail.getText().matches(emailRegex) == false) {
            lblOut.setText("Email is Invalid*");
        } else {
            BooleanProperty Check = AdminCheck.selectedProperty();
            if (Check.getValue()) {
                member.addAdmin(name, pass, address, email, phone);
            } else {
                member.addMemeber(name, pass, address, email, phone);
            }
            lblOut.setText("Added Successfully");
            txtName.setText(null);
            txtPass.setText(null);
            txtAddress.setText(null);
            txtMobile.setText(null);
            txtEmail.setText(null);
        }

    }

}
