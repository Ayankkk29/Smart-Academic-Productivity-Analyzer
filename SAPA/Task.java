import java.time.LocalDateTime;
import java.time.Duration;

public class Task {
    private String id;
    private String title;
    private String subject;
    private int priority;
    private boolean isCompleted;
    private LocalDateTime createdTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long duration; // in minutes
    
    public Task(String id, String title, String subject, int priority) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.priority = priority;
        this.isCompleted = false;
        this.createdTime = LocalDateTime.now();
        this.duration = 0;
    }

    // Constructor for loading from file
    public Task(String id, String title, String subject, int priority, boolean isCompleted, 
                LocalDateTime createdTime, LocalDateTime startTime, LocalDateTime endTime, long duration) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.priority = priority;
        this.isCompleted = isCompleted;
        this.createdTime = createdTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
    }

    public void startSession() {
        if (!isCompleted && startTime == null) {
            this.startTime = LocalDateTime.now();
            System.out.println("Started session for task: " + title);
        } else {
            System.out.println("Session already started or task is completed.");
        }
    }

    public void stopSession() {
        if (startTime != null && endTime == null) {
            this.endTime = LocalDateTime.now();
            this.duration += Duration.between(startTime, endTime).toMinutes();
            this.startTime = null; // reset for multiple sessions mapping
            this.endTime = null;
            System.out.println("Stopped session for task: " + title + ". Duration added.");
        } else {
            System.out.println("No active session to stop.");
        }
    }

    public void markCompleted() {
        this.isCompleted = true;
        if (startTime != null) {
            stopSession();
        }
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getSubject() { return subject; }
    public int getPriority() { return priority; }
    public boolean isCompleted() { return isCompleted; }
    public LocalDateTime getCreatedTime() { return createdTime; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public long getDuration() { return duration; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setSubject(String subject) { this.subject = subject; }
    public void setPriority(int priority) { this.priority = priority; }
    
    @Override
    public String toString() {
        return String.format("[%s] %s | Subject: %s | Priority: %d | Status: %s | Time Spent: %d mins",
                id, title, subject, priority, (isCompleted ? "Completed" : "In Progress"), duration);
    }
}
