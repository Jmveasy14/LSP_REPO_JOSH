package org.howard.edu.lsp.midterm.question2;

public class BookDriver {
    public static void main(String[] args) {
        // Creates Books as objects
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book3 = new Book("A Promised Land", "Barack Obama", "9780593239681", 2020);

        // Check if books are the same based on ISBN and author
        System.out.println(book1.equals(book2)); // true
        System.out.println(book1.equals(book3)); // false

        // Print book1 details
        System.out.println(book1); // String representation of book1
    }
}
