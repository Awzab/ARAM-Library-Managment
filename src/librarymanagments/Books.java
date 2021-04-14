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
public class Books {

    private Connection connect() throws SQLException {
        Connection con = null;
        String url = "jdbc:sqlite:C:/Users/Admin/Documents/NetBeansProjects/LibraryManagments/src/Database/LibManagSys.db";
        con = DriverManager.getConnection(url);
        System.out.println("Connection Established...");
        return con;
    }

    public void addBook(String name, long ISBN, String author, String publisher, String category) throws SQLException {
        String Status = "Available";
        String sql = "INSERT INTO Books(BookName, BookISBN, Author, Publisher, Category, Availability) VALUES(\"" + name + "\",\"" + ISBN + "\",\"" + author + "\",\"" + publisher + "\",\"" + category + "\",\"" + Status + "\")";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("SQL has added Book");
    }

    public void BooksData(ObservableList obList) throws SQLException {
        String sql = "SELECT * FROM Books";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            obList.add(new AllBooks(rs.getInt("BookID"), rs.getString("BookName"), rs.getLong("BookISBN"), rs.getString("Author"), rs.getString("Publisher"), rs.getString("Category"), rs.getString("Availability")));
        }
        st.close();
        con.close();
    }

    public String[] BookSearch(String ID) throws SQLException {

        String sql = "SELECT * FROM Books WHERE BookID LIKE \"%" + Integer.parseInt(ID) + "%\" OR BookISBN LIKE \"%"+ Long.parseLong(ID) + "%\" ";
        Connection con;

        con = this.connect();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        String info[] = new String[6];

        info[0] = rs.getString("BookName");
        info[1] = rs.getString("BookISBN");
        info[2] = rs.getString("Author");
        info[3] = rs.getString("Publisher");
        info[4] = rs.getString("Category");
        info[5] = rs.getString("Availability");

        st.close();
        con.close();

        return info;
    }

    public void SubmitIssue(int BookID) throws SQLException {

        String sql = "UPDATE Books SET Availability = 'Available' WHERE BookID =" + BookID;
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("SQL has Updated Books");
    }

    public void deleteBook(int ID) throws SQLException {
        String sql = "DELETE FROM Books WHERE BookID = " + ID + ";";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);

        st.close();
        con.close();

    }

    public void updateBook(int ID, String Name, long ISBN, String Author, String Publisher, String Category) throws SQLException {
        String sql = "UPDATE Books set BookName = \"" + Name + "\", BookISBN=\"" + ISBN + "\", Author=\"" + Author + "\" , Publisher=\"" + Publisher + "\" , Category=\""+Category+"\""
                + "WHERE BookID =" + ID;

        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();

    }
}
