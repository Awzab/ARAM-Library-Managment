/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagments;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AceGa
 */
public class LoginController implements Initializable {

    @FXML
    private JFXButton clickLogin;
    @FXML
    private JFXTextField txtUser;
    @FXML
    private JFXPasswordField txtPass;
    @FXML
    private Label lblOut;
    @FXML
    private Label lblOut1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void lbllogin(ActionEvent event) throws IOException, SQLException {

        boolean temp = false;

        Members mem = new Members();

        temp = mem.mLogin(txtUser.getText(), txtPass.getText());
        if (txtUser.getText().isEmpty() && txtPass.getText().isEmpty()) {
            lblOut.setText("Pleas Enter User Name*");
            lblOut1.setText("Pleas Enter Password*");

        } else if (txtUser.getText().isEmpty()) {
            lblOut.setText("Please Enter User Name*");
            lblOut1.setText(null);

        } else if (txtPass.getText().isEmpty()) {
            lblOut.setText(null);
            lblOut1.setText("Please Enter Password*");

        } else if (temp == false) {
            lblOut.setText("Check UserName*");
            lblOut1.setText("Check Password*");

        } else if (temp == true) {
            toHomePage(event);
        }

    }

    private void toHomePage(ActionEvent event) throws IOException {

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



}
