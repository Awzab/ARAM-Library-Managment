/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagments;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class AddBookController implements Initializable {

    ObservableList list = FXCollections.observableArrayList();
    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane mainContainer;
    @FXML
    private JFXButton backbtn;
    @FXML
    private JFXTextField txtBookName;
    @FXML
    private JFXTextField txtBookISBN;
    @FXML
    private JFXTextField txtAuthor;
    @FXML
    private JFXTextField txtPublisher;
    @FXML
    private JFXComboBox<String> comboCategory;
    @FXML
    private JFXButton btnSave;
    @FXML
    private Label lblOut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }

    private void loadData() {
        list.removeAll(list);
        String a1 = "Health";
        String a2 = "Sport";
        String a3 = "Computer Science";
        String a4 = "Engineering";
        String a5 = "Business Administration";
        String a6 = "Cooking";
        String a7 = "History";
        String a8 = "Economics";
        String a9 = "Finance";
        String a10 = "Novels";
        String a11 = "Entertaiment";
        String a12 = "Science";
        String a13 = "Medical";

        list.addAll(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13);
        comboCategory.getItems().addAll(list);
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
    private void AddBook(ActionEvent event) throws SQLException {

        Books book = new Books();

        String bookName = txtBookName.getText();
        long bookISBN = Long.parseLong(txtBookISBN.getText());
        String author = txtAuthor.getText();
        String publisher = txtPublisher.getText();
        String category = comboCategory.getValue();
        if (txtBookName.getText().isEmpty() && txtBookISBN.getText().isEmpty() && txtAuthor.getText().isEmpty() && txtPublisher.getText().isEmpty() && comboCategory.getValue().isEmpty()) {
            lblOut.setText("Please Enter Information*");
        } else if (txtBookName.getText().isEmpty()) {
            lblOut.setText("Please Enter Book Name*");
        } else if (txtBookISBN.getText().isEmpty()) {
            lblOut.setText("Please Enter Book ISBN*");
        } else if (txtAuthor.getText().isEmpty()) {
            lblOut.setText("Please Enter Author*");
        } else if (txtPublisher.getText().isEmpty()) {
            lblOut.setText("Please Enter Publisher*");
        } else if (comboCategory.getValue().isEmpty()) {
            lblOut.setText("Please Enter Category*");
        } else {
            book.addBook(bookName, bookISBN, author, publisher, category);
            lblOut.setText("Added Successfully");
            txtBookName.setText(null);
            txtBookISBN.setText(null);
            txtAuthor.setText(null);
            txtPublisher.setText(null);
            comboCategory.setPromptText("Category...");
        }

    }

}
