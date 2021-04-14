/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagments;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AceGa
 */
public class IssuedListController implements Initializable {

    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane contentPane;
    @FXML
    private TableView<IssueBookList> tblIssueList;
    @FXML
    private TableColumn<IssueBookList, Integer> bookIDCol;
    @FXML
    private TableColumn<IssueBookList, Integer> MemeberIDCol;
    @FXML
    private TableColumn<IssueBookList, String> issueCol;
    @FXML
    private TableColumn<IssueBookList, String> ReturnCol;
    @FXML
    private TableColumn<IssueBookList, Integer> daysCol;
    @FXML
    private JFXButton backbtn;

    ObservableList IssuedBooks = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        IssuedBooks issued = new IssuedBooks();

        try {
            issued.IssuedData(IssuedBooks);
        } catch (SQLException ex) {
            Logger.getLogger(IssuedListController.class.getName()).log(Level.SEVERE, null, ex);
        }

        bookIDCol.setCellValueFactory(new PropertyValueFactory<>("BookID"));
        MemeberIDCol.setCellValueFactory(new PropertyValueFactory<>("MemberID"));
        issueCol.setCellValueFactory(new PropertyValueFactory<>("DateOfIssue"));
        ReturnCol.setCellValueFactory(new PropertyValueFactory<>("ReturnDate"));
        daysCol.setCellValueFactory(new PropertyValueFactory<>("Days"));
        tblIssueList.setItems(IssuedBooks);

    }

    @FXML
    private void handleReturn(ActionEvent event) {
    }

    @FXML
    private void handleRefresh(ActionEvent event) {
    }

    @FXML
    private void exportAsPDF(ActionEvent event) {
    }

    @FXML
    private void closeStage(ActionEvent event) {
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

}
