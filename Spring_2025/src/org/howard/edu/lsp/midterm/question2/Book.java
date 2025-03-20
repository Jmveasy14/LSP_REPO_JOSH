package org.howard.edu.lsp.midterm.question2;

/**
 * Represents a book in a library
 */
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;
    
    /**
     * Constructor for Book class
     */
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }
    
    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    
    public String getISBN() { return ISBN; }
    public void setISBN(String ISBN) { this.ISBN = ISBN; }
    
    public int getYearPublished() { return yearPublished; }
    public void setYearPublished(int yearPublished) { this.yearPublished = yearPublished; }
    
    /**
     * Compares two Book objects for equality based on ISBN and author
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;
        
        Book book = (Book) obj;
        return ISBN.equals(book.ISBN) && author.equals(book.author);
    }
    
    /**
     * Returns string representation of a Book
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + 
               ", ISBN: " + ISBN + ", Year Published: " + yearPublished;