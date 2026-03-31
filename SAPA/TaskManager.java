import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public Optional<Task> getTaskById(String id) {
        return tasks.stream().filter(t -> t.getId().equals(id)).findFirst();
    }

    public void updateTask(String id, String title, String subject, int priority) {
        Optional<Task> taskOpt = getTaskById(id);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            task.setTitle(title);
            task.setSubject(subject);
            task.setPriority(priority);
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void deleteTask(String id) {
        boolean removed = tasks.removeIf(t -> t.getId().equals(id));
        if (removed) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void markTaskCompleted(String id) {
        Optional<Task> taskOpt = getTaskById(id);
        if (taskOpt.isPresent()) {
            taskOpt.get().markCompleted();
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void startSession(String id) {
        Optional<Task> taskOpt = getTaskById(id);
        if (taskOpt.isPresent()) {
            taskOpt.get().startSession();
        } else {
            System.out.println("Task not found.");
        }
    }

    public void stopSession(String id) {
        Optional<Task> taskOpt = getTaskById(id);
        if (taskOpt.isPresent()) {
            taskOpt.get().stopSession();
        } else {
            System.out.println("Task not found.");
        }
    }

    public void sortTasksByPriority() {
        tasks.sort((t1, t2) -> Integer.compare(t1.getPriority(), t2.getPriority()));
        System.out.println("Tasks sorted by priority.");
        viewTasks();
    }

    public void sortTasksByDuration() {
        tasks.sort((t1, t2) -> Long.compare(t2.getDuration(), t1.getDuration()));
        System.out.println("Tasks sorted by duration (descending).");
        viewTasks();
    }
}
