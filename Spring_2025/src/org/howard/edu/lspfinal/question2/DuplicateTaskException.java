package org.howard.edu.lspfinal.question2;

/**
 * Custom exception thrown when trying to add a task with a duplicate name.
 */
public class DuplicateTaskException extends Exception {
    public DuplicateTaskException(String message) {
        super(message);
    }
}
