import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_NAME = "tasks.csv";

    public static void saveTasks(List<Task> tasks) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Task t : tasks) {
                writer.println(
                    t.getId() + "," +
                    t.getTitle().replace(",", ";") + "," +
                    t.getSubject().replace(",", ";") + "," +
                    t.getPriority() + "," +
                    t.isCompleted() + "," +
                    (t.getCreatedTime() != null ? t.getCreatedTime().toString() : "null") + "," +
                    (t.getStartTime() != null ? t.getStartTime().toString() : "null") + "," +
                    (t.getEndTime() != null ? t.getEndTime().toString() : "null") + "," +
                    t.getDuration()
                );
            }
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return tasks; // Return empty list if no file exists yet
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length >= 9) {
                    String id = parts[0];
                    String title = parts[1];
                    String subject = parts[2];
                    int priority = Integer.parseInt(parts[3]);
                    boolean isCompleted = Boolean.parseBoolean(parts[4]);
                    
                    LocalDateTime createdTime = parts[5].equals("null") ? null : LocalDateTime.parse(parts[5]);
                    LocalDateTime startTime = parts[6].equals("null") ? null : LocalDateTime.parse(parts[6]);
                    LocalDateTime endTime = parts[7].equals("null") ? null : LocalDateTime.parse(parts[7]);
                    long duration = Long.parseLong(parts[8]);

                    Task t = new Task(id, title, subject, priority, isCompleted, createdTime, startTime, endTime, duration);
                    tasks.add(t);
                }
            }
        } catch (IOException | RuntimeException e) {
            System.err.println("Error loading tasks: " + e.getMessage());
        }
        return tasks;
    }
}
