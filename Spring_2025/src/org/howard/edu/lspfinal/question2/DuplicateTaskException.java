package org.howard.edu.lspfinal.question2;

/**
 * Custom exception for duplicate tasks.
 */
public class DuplicateTaskException extends Exception {
    public DuplicateTaskException(String msg) {
        super(msg);
    }
}
