/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagments;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author AceGa
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private Button addbook;
    @FXML
    private Button allbook;
    @FXML
    private Button allmembers;
    @FXML
    private Button borrbook;
    @FXML
    private Button renew;
    @FXML
    private Button addmember;
    @FXML
    private Button goIssuedList;
    @FXML
    private Button btnOut;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void LoadAddMember(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("AddMember.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/Styles.css");
        Stage stage = new Stage();
        stage.setTitle("Add Member Page");
        stage.getIcons().add(new Image("/images/ARAMicon.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    private void goAddBook(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("AddBook.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/Styles.css");
        Stage stage = new Stage();
        stage.setTitle("Add Book Page");
        stage.getIcons().add(new Image("/images/ARAMicon.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void goAllBooks(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("AllBook.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/Styles.css");
        Stage stage = new Stage();
        stage.setTitle("All Books Page");
        stage.getIcons().add(new Image("/images/ARAMicon.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void goAllMembers(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("AllMembers.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/Styles.css");
        Stage stage = new Stage();
        stage.setTitle("All Members Page");
        stage.getIcons().add(new Image("/images/ARAMicon.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void goIssueBook(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("BookIssue.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/Styles.css");
        Stage stage = new Stage();
        stage.setTitle("Issue Book Page");
        stage.getIcons().add(new Image("/images/ARAMicon.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void goIssueList(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("IssuedList.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/Styles.css");
        Stage stage = new Stage();
        stage.setTitle("Issue List Page");
        stage.getIcons().add(new Image("/images/ARAMicon.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void goRenew(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("Renew.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/Styles.css");
        Stage stage = new Stage();
        stage.setTitle("Renew Issue Page");
        stage.getIcons().add(new Image("/images/ARAMicon.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    private void goLogout(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/Styles.css");
        Stage stage = new Stage();
        stage.setTitle("Add Book Page");
        stage.getIcons().add(new Image("/images/ARAMicon.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
