package org.howard.edu.lsp.assignment6;

/**
 * Exception class for IntegerSet operations that can't be performed on empty sets
 */
public class IntegerSetException extends Exception {
    public IntegerSetException(String message) {
        super(message);
    }
}
