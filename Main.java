public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new SimpleTaskManager();

        taskManager.addTask(new Task(1, "Write a report"));
        taskManager.addTask(new Task(2, "Prepare for the meeting"));

        System.out.println("\nAll tasks:");
        taskManager.getAllTasks();
    }
}

