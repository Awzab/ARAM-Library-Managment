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
public class AllMembersController implements Initializable {

    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane contentPane;
    @FXML
    private JFXButton backbtn;
    @FXML
    private TableView<AllMembers> tblMembers;

    @FXML
    private TableColumn<AllMembers, Integer> colID;
    @FXML
    private TableColumn<AllMembers, String> colName;
    @FXML
    private TableColumn<AllMembers, String> colAddress;
    @FXML
    private TableColumn<AllMembers, String> colEmail;
    @FXML
    private TableColumn<AllMembers, String> colMobile;
    @FXML
    private TableColumn<AllMembers, String> colType;

    public static ObservableList MembersList = FXCollections.observableArrayList();
    public static ObservableList MembersSelected = FXCollections.observableArrayList();
    @FXML
    private JFXButton btnDelete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fillTable();

        tblMembers.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("MemberUpdate.fxml"));

                try {
                    Loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }

                MemberUpdateController Update = Loader.getController();
                Update.setData(tblMembers.getSelectionModel().getSelectedItem().getId(), tblMembers.getSelectionModel().getSelectedItem().getName(), tblMembers.getSelectionModel().getSelectedItem().getAddress(), tblMembers.getSelectionModel().getSelectedItem().getEmail(), tblMembers.getSelectionModel().getSelectedItem().getPhoneNumber());
                Parent p = Loader.getRoot();
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(tblMembers.getScene().getWindow());
                stage.setScene(new Scene(p));
                stage.setResizable(false);
                stage.getIcons().add(new Image("/images/ARAMicon.png"));
                stage.setTitle("Update Member Form");
                stage.show();
            }

        });

    }

    public void fillTable() {
        tblMembers.getItems().clear();
        MembersList.removeAll(MembersList);
        Members con = new Members();

        try {
            con.MembersData(MembersList);
        } catch (SQLException ex) {
            Logger.getLogger(AllMembersController.class.getName()).log(Level.SEVERE, null, ex);
        }

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        colType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        tblMembers.setItems(MembersList);
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


    @FXML
    private void deleteMember(ActionEvent event) throws SQLException {
        Members con = new Members();
        int des = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Member?", "Delete Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (des == 0) {
            AllMembers selectedMember = tblMembers.getSelectionModel().getSelectedItem();
            con.deleteMember(selectedMember.getId());

            con.MembersData(MembersSelected);
            tblMembers.setItems(MembersSelected);
        }
    }

}
