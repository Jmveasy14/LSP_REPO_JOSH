package org.howard.edu.lspfinal.question2;

/**
 * Custom exception for when a task isn't found.
 */
public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String msg) {
        super(msg);
    }
}
