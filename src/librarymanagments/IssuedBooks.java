/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;

/**
 *
 * @author Admin
 */
public class IssuedBooks {

    private Connection connect() throws SQLException {
        Connection con = null;
        String url = "jdbc:sqlite:C:/Users/Admin/Documents/NetBeansProjects/LibraryManagments/src/Database/LibManagSys.db";
        con = DriverManager.getConnection(url);
        System.out.println("Connection Established...");
        return con;
    }

    public void addIssue(int bookID, int memberID, String date, String Return, int days) throws SQLException {

        String sql = "INSERT INTO IssuedBooks(BookID, UserID, DateOfIssue, ReturnDate, Days) VALUES(\"" + bookID + "\",\"" + memberID + "\",\"" + date + "\",\"" + Return + "\",\"" + days + "\")";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("SQL has Issued a Book");
    }

    public void Update(int ID) throws SQLException {
        String sql = "UPDATE Books SET Availability = 'Issued' WHERE BookID =" + ID;
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("SQL has Updated");
    }

    public void IssuedData(ObservableList obList) throws SQLException {
        String sql = "SELECT * FROM IssuedBooks";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            obList.add(new IssueBookList(rs.getInt("BookID"), rs.getInt("UserID"), rs.getString("DateOfIssue"), rs.getString("ReturnDate"), rs.getInt("Days")));
        }
        st.close();
        con.close();
    }

    public String getDate(int BookID) throws SQLException {
        String Date = "";
        String sql = "SELECT * FROM IssuedBooks WHERE BookID = " + BookID;
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            String date = rs.getString("ReturnDate");
            Date = date;
        }
        System.out.println(Date);
        st.close();
        con.close();
        return Date;
    }

    public int getDays(int BookID) throws SQLException {
        int Days = 0;
        String sql = "SELECT * FROM IssuedBooks WHERE BookID = " + BookID;
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            int days = rs.getInt("Days");
            Days = days;
        }
        st.close();
        con.close();
        return Days;
    }

    public void UpdateIssue(int BookID, String Return, int days) throws SQLException {
        String sql = "UPDATE IssuedBooks SET ReturnDate ='" + Return + "', Days = " + days + " WHERE BookID =" + BookID;
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("SQL has Updated");
    }

    public void IssueSearch(ObservableList obList, int ID) throws SQLException {

        String sql = "SELECT * FROM IssuedBooks WHERE BookID =" + ID;
        Connection con;

        con = this.connect();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            obList.add(new IssueBookList(rs.getInt("BookID"), rs.getInt("UserID"), rs.getString("DateOfIssue"), rs.getString("ReturnDate"), rs.getInt("Days")));
        }
        st.close();
        con.close();

    }

    public void deleteIssue(int BookID) throws SQLException {
        String sql = "DELETE FROM IssuedBooks WHERE BookID =" + BookID;
        Connection con;

        con = this.connect();

        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();

    }

}
