package org.howard.edu.lspfinal.question2;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages a collection of tasks, allowing to add, retrieve, update, and group tasks by status.
 */
public class TaskManager {
    private Map<String, Task> tasks;

    public TaskManager() {
        tasks = new HashMap<>();
    }

    /**
     * Adds a new task to the manager.
     * Throws DuplicateTaskException if the task already exists.
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by its name.
     * Throws TaskNotFoundException if the task is not found.
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task task = tasks.get(name);
        if (task == null) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return task;
    }

    /**
     * Updates the status of an existing task.
     * Throws TaskNotFoundException if the task does not exist.
     */
    public void updateStatus(String name, String newStatus) throws TaskNotFoundException {
        Task task = getTaskByName(name);
        task.setStatus(newStatus);
    }

    /**
     * Prints all tasks grouped by their status.
     */
    public void printTasksGroupedByStatus() {
        System.out.println("Tasks grouped by status:");
        for (String status : new String[]{"TODO", "IN_PROGRESS", "DONE"}) {
            System.out.println(status + ":");
            for (Task task : tasks.values()) {
                if (task.getStatus().equals(status)) {
                    System.out.println("  " + task);
                }
            }
        }
    }
}
