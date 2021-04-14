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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AceGa
 */
public class BookIssueController implements Initializable {

    @FXML
    private TextField bookID;
    @FXML
    private TextField memberID;
    @FXML
    private JFXButton backbtn;
    @FXML
    private JFXButton issuebtn;
    @FXML
    private Button btnBSearch;
    @FXML
    private Text lblBName;
    @FXML
    private Text lblISBN;
    @FXML
    private Text lblAuthor;
    @FXML
    private Text lblCategory;
    @FXML
    private Text lblStatus;
    @FXML
    private Button btnMSearch;
    @FXML
    private Text lblMName;
    @FXML
    private Text lblEmail;
    @FXML
    private Text lblPhone;
    @FXML
    private Text lblPublisher;
    @FXML
    private Text lblOut;
    @FXML
    private Text lblOut2;

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
    private void Issue(ActionEvent event) throws SQLException {

        IssuedBooks issue = new IssuedBooks();

        int Days = 20;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, Days);
        Date currentDate1 = c.getTime();

        int ID = Integer.parseInt(bookID.getText());
        int UID = Integer.parseInt(memberID.getText());
        String currentDate = formatter.format(date);
        String ReturnDate = formatter.format(currentDate1);
        if (bookID.getText().isEmpty() && memberID.getText().isEmpty()) {
            lblOut.setText("Please Enter Book ID*");
            lblOut2.setText("Please Member Book ID*");
        } else if (bookID.getText().isEmpty()) {
            lblOut.setText("Please Enter Book ID*");
            lblOut2.setText(null);
        } else if (memberID.getText().isEmpty()) {
            lblOut.setText(null);
            lblOut2.setText("Please Member Book ID*");
        } else if (!lblStatus.getText().contains("Issued")) {
            issue.addIssue(ID, UID, currentDate, ReturnDate, Days);
            issue.Update(ID);
            lblOut.setText("Book is now Issued");
            lblOut2.setText(null);

            bookID.setText(null);
            memberID.setText(null);
            lblBName.setText("Book Name: ");
            lblAuthor.setText("Author: ");
            lblPublisher.setText("Publisher: ");
            lblCategory.setText("Category: ");
            lblStatus.setText("Availability: ");
            lblMName.setText("Member Name: ");
            lblEmail.setText("Email: ");
            lblPhone.setText("Phone Number: ");
        } else {
            lblOut.setText("Book is Issued");
            lblOut2.setText("Select Another");
        }

    }

    @FXML
    private void SearchBook(ActionEvent event) throws SQLException {
       String ID = bookID.getText();
//       String ISBN = bookID.getText();
//        String name = bookID.getText();
        Books book = new Books();
        String Info[] = book.BookSearch(ID);

        lblBName.setText("Book Name: " + Info[0]);
        lblISBN.setText("Book ISBN: "+Info[1]);
        lblAuthor.setText("Author: " + Info[2]);
        lblPublisher.setText("Publisher: " + Info[3]);
        lblCategory.setText("Category: " + Info[4]);
        lblStatus.setText("Availability: " + Info[5]);
    }

    @FXML
    private void MemebrSearch(ActionEvent event) throws SQLException {

        Members member = new Members();
        int UID = Integer.parseInt(memberID.getText());
        String Info[] = member.MemebrSearch(UID);

        lblMName.setText("Member Name: " + Info[0]);
        lblEmail.setText("Email: " + Info[1]);
        lblPhone.setText("Phone Number: " + Info[2]);
    }


}
