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
public class AllBooks {

    private int BookID;
    private String BookName;
    private long BookISBN;
    private String Author;
    private String Publisher;
    private String Category;
    private String Availability;

    public AllBooks(int id, String title, long isbn, String author, String publisher, String category, String status) {
        this.BookID = id;
        this.BookName = title;
        this.BookISBN = isbn;
        this.Author = author;
        this.Publisher = publisher;
        this.Category = category;
        this.Availability = status;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int BookID) {
        this.BookID = BookID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public long getBookISBN() {
        return BookISBN;
    }

    public void setBookISBN(long BookISBN) {
        this.BookISBN = BookISBN;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getAvailability() {
        return Availability;
    }

    public void setAvailability(String Availability) {
        this.Availability = Availability;
    }


}
