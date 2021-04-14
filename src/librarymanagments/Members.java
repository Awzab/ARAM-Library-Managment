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
public class Members {

    private Connection connect() throws SQLException {
        Connection con = null;
        String url = "jdbc:sqlite:C:/Users/Admin/Documents/NetBeansProjects/LibraryManagments/src/Database/LibManagSys.db";
        con = DriverManager.getConnection(url);
        System.out.println("Connection Established...");
        return con;
    }

    public void addMemeber(String name, String pass, String address, String email, String num) throws SQLException {
        String type = "User";
        String sql = "INSERT INTO Members(Name, Password, Address, Email, PhoneNumber, Type) VALUES(\"" + name + "\",\"" + pass + "\",\"" + address + "\",\"" + email + "\",\"" + num + "\",\"" + type + "\")";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("SQL has added User");
    }

    public void addAdmin(String name, String pass, String address, String email, String num) throws SQLException {
        String type = "Admin";
        String sql = "INSERT INTO Members(Name, Password, Address, Email, PhoneNumber, Type) VALUES(\"" + name + "\",\"" + pass + "\",\"" + address + "\",\"" + email + "\",\"" + num + "\",\"" + type + "\")";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("SQL has added User");
    }

    public void MembersData(ObservableList obList) throws SQLException {
        String sql = "SELECT * FROM Members";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            obList.add(new AllMembers(rs.getInt("id"), rs.getString("Name"), rs.getString("Address"), rs.getString("Email"), rs.getString("PhoneNumber"), rs.getString("Type")));
        }
        st.close();
        con.close();
    }

    public boolean mLogin(String user, String pass) throws SQLException {

        boolean temp = false;
        String admin = "Admin";
        String sql = "SELECT * FROM Members  WHERE Type ='" + admin + "'";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            String User = rs.getString("Name");
            String Pass = rs.getString("Password");
            if (User.equals(user) && Pass.equals(pass)) {
                temp = true;
                break;
            }
        }
        st.close();
        con.close();
        return temp;
    }

    public String[] MemebrSearch(int ID) throws SQLException {

        String sql = "SELECT * FROM Members WHERE id ='" + ID + "'";
        Connection con;

        con = this.connect();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        String info[] = new String[3];

        info[0] = rs.getString("Name");
        info[1] = rs.getString("Email");
        info[2] = rs.getString("PhoneNumber");

        st.close();
        con.close();

        return info;
    }

    public void deleteMember(int ID) throws SQLException {
        String sql = "DELETE FROM Members WHERE id = " + ID + ";";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);

        st.close();
        con.close();

    }

    public void updateMember(int ID, String Name, String Address, String Email, String PhoneNumber) throws SQLException {
        String sql = "UPDATE Members set Name = \"" + Name + "\", Address=\"" + Address + "\", Email=\"" + Email + "\" , PhoneNumber=\"" + PhoneNumber + "\""
                + "WHERE id=" + ID ;
        
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();

    }
}
