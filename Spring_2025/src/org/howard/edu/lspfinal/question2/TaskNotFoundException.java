package org.howard.edu.lspfinal.question2;

/**
 * Custom exception thrown when a task with a given name is not found.
 */
public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String message) {
        super(message);
    }
}
