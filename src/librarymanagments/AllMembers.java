/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagments;

import com.jfoenix.controls.JFXButton;

/**
 *
 * @author Admin
 */
public class AllMembers {

    private int id;
    private String Name;
    private String Address;
    private String Email;
    private String PhoneNumber;
    private String Type;
    
    JFXButton update;

    public AllMembers(int id, String name, String address, String email, String phone, String type) {
        this.id = id;
        this.Name = name;
        this.Address = address;
        this.Email = email;
        this.PhoneNumber = phone;
        this.Type = type;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    
    
}
