/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagments;


/**
 *
 * @author Admin
 */
public class IssueBookList {

    private int BookID;
    private int UserID;
    private String DateOfIssue;
    private String ReturnDate;
    private int Days;

    public IssueBookList(int BookId, int memberID, String DateOfIssue, String ReturnDate, int days) {
        this.BookID = BookId;
        this.UserID = memberID;
        this.DateOfIssue = DateOfIssue;
        this.ReturnDate = ReturnDate;
        this.Days = days;
    }


    public int getBookID() {
        return BookID;
    }

    public void setBookID(int BookID) {
        this.BookID = BookID;
    }

    public int getMemberID() {
        return UserID;
    }

    public void setMemberID(int MemberID) {
        this.UserID = MemberID;
    }

    public String getDateOfIssue() {
        return DateOfIssue;
    }

    public void setDateOfIssue(String DateOfIssue) {
        this.DateOfIssue = DateOfIssue;
    }

    public String getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(String ReturnDate) {
        this.ReturnDate = ReturnDate;
    }

    public int getDays() {
        return Days;
    }

    public void setDays(int Days) {
        this.Days = Days;
    }

    


    
    
}
