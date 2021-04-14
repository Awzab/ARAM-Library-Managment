/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagments;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
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
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class RenewPopUpController implements Initializable {

    @FXML
    private Button btnSubmit;
    @FXML
    private JFXTextField txtDays;
    @FXML
    private JFXTextField txtBookID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void SubmitDays(ActionEvent event) throws SQLException, ParseException, IOException {
        IssuedBooks issue = new IssuedBooks();
        int days = Integer.parseInt(txtDays.getText());
        int getDate = Integer.parseInt(txtBookID.getText());
        days = days + issue.getDays(getDate);
        String Date = issue.getDate(getDate);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = formatter.parse(Date);

        Calendar c = Calendar.getInstance();
        c.setTime(date1);
        c.add(Calendar.DATE, days);
        Date currentDate1 = c.getTime();
        String ReturnDate = formatter.format(currentDate1);
        System.out.println(ReturnDate);
        issue.UpdateIssue(getDate, ReturnDate, days);
        System.out.println("Issue Has Been Updated");
        
        IssuedBooks issued = new IssuedBooks();

        ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Renew.fxml"));
        Parent root = (Parent) loader.load();

        RenewController RC = loader.getController();
    }

    public void setData(int ID) {
        String BookID = Integer.toString(ID);
        txtBookID.setText(BookID);
    }

}
