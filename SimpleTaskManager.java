import java.util.ArrayList;

public class SimpleTaskManager implements TaskManager {
    private ArrayList<Task> taskList;

    public SimpleTaskManager() {
        taskList = new ArrayList<>();
    }

    @Override
    public void addTask(Task task) {
        taskList.add(task);
        System.out.println("Task added: " + task.showInfo());
    }

    @Override
    public void getAllTasks() {
        if (taskList.isEmpty()) {
            System.out.println("Error: task list is empty");
            return;
        }
        for (Task task : taskList) {
            System.out.println(task.showInfo());
        }
    }
}
