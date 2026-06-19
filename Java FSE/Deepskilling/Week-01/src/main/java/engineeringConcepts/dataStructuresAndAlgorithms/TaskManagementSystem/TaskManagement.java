package engineeringConcepts.dataStructuresAndAlgorithms.TaskManagementSystem;

public class TaskManagement {
    // Internal Node structure wrapping our domain object and our pointer reference
    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head; // Point of entry for the list pointer

    /**
     * 1. Add Task (Append to Tail)
     * Inserts a new task node at the absolute end of the linked list.
     */
    public void addTask(Task newTask) {
        Node newNode = new Node(newTask);
        
        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
            return;
        }

        // Otherwise, traverse to the last node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    /**
     * 2. Search Task
     * Linearly scans nodes tracking forward references until a matching taskId is found.
     */
    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equalsIgnoreCase(taskId)) {
                return current.task; // Node found
            }
            current = current.next; // Move pointer forward
        }
        return null; // Not found
    }

    /**
     * 3. Traverse Tasks
     * Walks the entire sequence of memory node blocks from head to tail to print values.
     */
    public void traverseTasks() {
        if (head == null) {
            System.out.println("The task tracker is currently empty.");
            return;
        }
        System.out.println("--- Active Task Tracker ---");
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    /**
     * 4. Delete Task
     * Locates the node, changes pointer values to jump over it, and removes it from sequence.
     */
    public boolean deleteTask(String taskId) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return false;
        }

        // Case A: The node to delete is the root head node
        if (head.task.getTaskId().equalsIgnoreCase(taskId)) {
            head = head.next; // Shift entry head forward
            return true;
        }

        // Case B: Search for the node while tracking the immediate preceding 'prev' node
        Node current = head;
        Node prev = null;
        
        while (current != null && !current.task.getTaskId().equalsIgnoreCase(taskId)) {
            prev = current;
            current = current.next;
        }

        // If the task wasn't located in the list paths
        if (current == null) {
            System.out.println("Delete failed: Task ID " + taskId + " not found.");
            return false;
        }

        // Reroute pointers around the target node to isolate and drop it
        prev.next = current.next;
        return true;
    }
}
