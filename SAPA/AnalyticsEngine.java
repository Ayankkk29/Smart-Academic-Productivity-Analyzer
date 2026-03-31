import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;

public class AnalyticsEngine {
    private TaskManager taskManager;

    public AnalyticsEngine(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    public void showAnalytics() {
        List<Task> tasks = taskManager.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("No data available for analytics.");
            return;
        }

        System.out.println("--- Productivity Analytics ---");
        
        // 1. Productivity Score
        long completedTasks = tasks.stream().filter(Task::isCompleted).count();
        double productivityScore = (double) completedTasks / tasks.size() * 100;
        System.out.printf("Productivity Score: %.2f%%\n", productivityScore);

        // 2 & 3. Most and Least studied subject
        Map<String, Long> subjectTimeMap = new HashMap<>();
        for (Task t : tasks) {
            subjectTimeMap.put(t.getSubject(), subjectTimeMap.getOrDefault(t.getSubject(), 0L) + t.getDuration());
        }
        
        String mostStudied = null;
        String leastStudied = null;
        long maxTime = -1;
        long minTime = Long.MAX_VALUE;

        for (Map.Entry<String, Long> entry : subjectTimeMap.entrySet()) {
            if (entry.getValue() > maxTime) {
                maxTime = entry.getValue();
                mostStudied = entry.getKey();
            }
            if (entry.getValue() < minTime) {
                minTime = entry.getValue();
                leastStudied = entry.getKey();
            }
        }
        
        System.out.println("Most studied subject: " + (mostStudied != null ? mostStudied : "N/A"));
        System.out.println("Least studied subject: " + (leastStudied != null ? leastStudied : "N/A"));
        
        // 4. Longest duration task
        Task longestTask = null;
        for (Task t : tasks) {
            if (longestTask == null || t.getDuration() > longestTask.getDuration()) {
                longestTask = t;
            }
        }
        if (longestTask != null && longestTask.getDuration() > 0) {
            System.out.println("Longest duration task: " + longestTask.getTitle() + " (" + longestTask.getDuration() + " mins)");
        } else {
            System.out.println("Longest duration task: N/A");
        }

        // 5. Average study time per task
        long totalDuration = tasks.stream().mapToLong(Task::getDuration).sum();
        double avgDuration = (double) totalDuration / tasks.size();
        System.out.printf("Average study time per task: %.2f mins\n", avgDuration);

        // 6. Time-of-day productivity analysis
        Map<String, Integer> timeOfDayCount = new HashMap<>();
        timeOfDayCount.put("Morning (5-12)", 0);
        timeOfDayCount.put("Afternoon (12-17)", 0);
        timeOfDayCount.put("Evening (17-21)", 0);
        timeOfDayCount.put("Night (21-5)", 0);

        for (Task t : tasks) {
            LocalDateTime st = t.getStartTime();
            if (st != null) {
                int hour = st.getHour();
                if (hour >= 5 && hour < 12) timeOfDayCount.put("Morning (5-12)", timeOfDayCount.get("Morning (5-12)") + 1);
                else if (hour >= 12 && hour < 17) timeOfDayCount.put("Afternoon (12-17)", timeOfDayCount.get("Afternoon (12-17)") + 1);
                else if (hour >= 17 && hour < 21) timeOfDayCount.put("Evening (17-21)", timeOfDayCount.get("Evening (17-21)") + 1);
                else timeOfDayCount.put("Night (21-5)", timeOfDayCount.get("Night (21-5)") + 1);
            }
        }

        System.out.println("Time-of-day productivity analysis (based on session start times):");
        String mostProductiveTime = "";
        int maxSessions = -1;
        for (Map.Entry<String, Integer> entry : timeOfDayCount.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue() + " sessions");
            if (entry.getValue() > maxSessions) {
                maxSessions = entry.getValue();
                mostProductiveTime = entry.getKey();
            }
        }

        System.out.println("\nInsights:");
        if (maxSessions > 0) {
            System.out.println(" - You are most productive in the " + mostProductiveTime.split(" ")[0].toLowerCase() + ".");
        }
        if (mostStudied != null && maxTime > 0) {
            System.out.println(" - You spend most time on " + mostStudied + ".");
        }
        if (productivityScore >= 80) {
            System.out.println(" - Great job! Your task completion rate is excellent.");
        } else if (productivityScore < 50 && completedTasks > 0) {
            System.out.println(" - Try to focus more on completing started tasks.");
        }
    }
}
