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
import javafx.event.EventHandler;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author AceGa
 */
public class AllBookController implements Initializable {

    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane contentPane;
    @FXML
    private JFXButton backbtn;
    @FXML
    private TableView<AllBooks> tblBooks;
    @FXML
    private TableColumn<AllBooks, Integer> colID;
    @FXML
    private TableColumn<AllBooks, String> colTitle;
    @FXML
    private TableColumn<AllBooks, Long> colISBN;
    @FXML
    private TableColumn<AllBooks, String> colAuthor;
    @FXML
    private TableColumn<AllBooks, String> colPublisher;
    @FXML
    private TableColumn<AllBooks, String> colCategory;
    @FXML
    private TableColumn<AllBooks, String> colStatus;

    public static ObservableList BooksList = FXCollections.observableArrayList();

    public static ObservableList BooksSelected = FXCollections.observableArrayList();

    @FXML
    private JFXButton btnDelete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fillTable();

        tblBooks.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("BookUpdate.fxml"));

                try {
                    Loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }

                BookUpdateController Update = Loader.getController();
                Update.setData(tblBooks.getSelectionModel().getSelectedItem().getBookID(), tblBooks.getSelectionModel().getSelectedItem().getBookName(), tblBooks.getSelectionModel().getSelectedItem().getBookISBN(), tblBooks.getSelectionModel().getSelectedItem().getAuthor(), tblBooks.getSelectionModel().getSelectedItem().getPublisher(), tblBooks.getSelectionModel().getSelectedItem().getCategory());
                Parent p = Loader.getRoot();
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(tblBooks.getScene().getWindow());
                stage.setScene(new Scene(p));
                stage.setResizable(false);
                stage.getIcons().add(new Image("/images/ARAMicon.png"));
                stage.setTitle("Update Book Form");
                stage.show();
            }

        });
    }

    public void fillTable() {
        tblBooks.getItems().clear();
        BooksList.removeAll(BooksList);

        Books con = new Books();
        try {
            con.BooksData(BooksList);
        } catch (SQLException ex) {
            Logger.getLogger(AllBookController.class.getName()).log(Level.SEVERE, null, ex);
        }

        colID.setCellValueFactory(new PropertyValueFactory<>("BookID"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("BookName"));
        colISBN.setCellValueFactory(new PropertyValueFactory<>("BookISBN"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("Author"));
        colPublisher.setCellValueFactory(new PropertyValueFactory<>("Publisher"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("Category"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("Availability"));
        tblBooks.setItems(BooksList);
    }

    @FXML
    private void handleRefresh(ActionEvent event) {
    }

    @FXML
    private void handleBookEditOption(ActionEvent event) {
    }

    @FXML
    private void handleBookDeleteOption(ActionEvent event) {
    }

    @FXML
    private void exportAsPDF(ActionEvent event) {
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
    private void deleteBook(ActionEvent event) throws SQLException {

        Books con = new Books();
        int des = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Book?", "Delete Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (des == 0) {
            AllBooks selectedBook = tblBooks.getSelectionModel().getSelectedItem();
            con.deleteBook(selectedBook.getBookID());

            con.BooksData(BooksSelected);
            tblBooks.setItems(BooksSelected);
        }
    }

}
