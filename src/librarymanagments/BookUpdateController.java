/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagments;

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
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class BookUpdateController implements Initializable {

    @FXML
    private Button btnSubmit;
    @FXML
    private JFXTextField txtBName;
    @FXML
    private JFXTextField txtBookID;
    @FXML
    private JFXTextField txtISBN;
    @FXML
    private JFXTextField txtAuthor;
    @FXML
    private JFXTextField txtPublisher;
    @FXML
    private JFXComboBox<String> combCategory;

    ObservableList list = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        combCategory.getItems().addAll(list);
    }

    @FXML
    private void SubmitUpdate(ActionEvent event) throws SQLException, IOException {
        Books con = new Books();
        int bookId = Integer.parseInt(txtBookID.getText());
        String name = txtBName.getText();
        long bISBN = Long.parseLong(txtISBN.getText());
        String author = txtAuthor.getText();
        String publisher = txtPublisher.getText();
        String category = combCategory.getValue();

        con.updateBook(bookId, name, bISBN, author, publisher, category);

        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("AllBook.fxml"));

        Scene scene = new Scene(root);
    }

    public void setData(int ID, String name, long ISBN, String author, String publisher, String category) {
        String id = Integer.toString(ID);
        txtBookID.setText(id);
        txtBName.setText(name);
        String bISBN = Long.toString(ISBN);
        txtISBN.setText(bISBN);
        txtAuthor.setText(author);
        txtPublisher.setText(publisher);
        combCategory.setValue(category);

    }
}
