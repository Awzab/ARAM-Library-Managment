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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AceGa
 */
public class RenewController implements Initializable {

    @FXML
    private Button backbtn;
    @FXML
    private JFXButton subbtn;
    @FXML
    private Button btnSearch;

    @FXML
    private TableView<IssueBookList> tblRenew;
    @FXML
    private TableColumn<IssueBookList, Integer> BIDcol;
    @FXML
    private TableColumn<IssueBookList, Integer> MIDcol;
    @FXML
    private TableColumn<IssueBookList, String> DateCol;
    @FXML
    private TableColumn<IssueBookList, String> ReturnCol;
    @FXML
    private TableColumn<IssueBookList, Integer> DaysCol;

    ObservableList RenewIssuedBooks = FXCollections.observableArrayList();
    @FXML
    private JFXTextField txtBID;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
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
    private void Submission(ActionEvent event) throws SQLException {
        Books submit = new Books();
        IssuedBooks delete = new IssuedBooks();
        int BookID = Integer.parseInt(txtBID.getText());
        submit.SubmitIssue(BookID);
        tblRenew.getItems().clear();
        submit.SubmitIssue(BookID);
        delete.deleteIssue(BookID);
        BIDcol.setCellValueFactory(new PropertyValueFactory<>("BookID"));
        MIDcol.setCellValueFactory(new PropertyValueFactory<>("MemberID"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("DateOfIssue"));
        ReturnCol.setCellValueFactory(new PropertyValueFactory<>("ReturnDate"));
        DaysCol.setCellValueFactory(new PropertyValueFactory<>("Days"));
        tblRenew.setItems(RenewIssuedBooks);

    }

    @FXML
    public void searchBookID(ActionEvent event) throws SQLException {

        IssuedBooks issued = new IssuedBooks();
        int BookID = Integer.parseInt(txtBID.getText());

        fillTable();
        issued.IssueSearch(RenewIssuedBooks, BookID);

        tblRenew.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("RenewPopUp.fxml"));

                try {
                    Loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }

                RenewPopUpController Renew = Loader.getController();
                Renew.setData(tblRenew.getSelectionModel().getSelectedItem().getBookID());

                Parent p = Loader.getRoot();
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(tblRenew.getScene().getWindow());
                stage.setScene(new Scene(p));
                stage.setResizable(false);
                stage.getIcons().add(new Image("/images/ARAMicon.png"));
                stage.setTitle("Renew Form");
                stage.show();
            }

        });
    }

    public void fillTable() {
        tblRenew.getItems().clear();
        RenewIssuedBooks.removeAll(RenewIssuedBooks);
        BIDcol.setCellValueFactory(new PropertyValueFactory<>("BookID"));
        MIDcol.setCellValueFactory(new PropertyValueFactory<>("MemberID"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("DateOfIssue"));
        ReturnCol.setCellValueFactory(new PropertyValueFactory<>("ReturnDate"));
        DaysCol.setCellValueFactory(new PropertyValueFactory<>("Days"));
        tblRenew.setItems(RenewIssuedBooks);
    }

}
