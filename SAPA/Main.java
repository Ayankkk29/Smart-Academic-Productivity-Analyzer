import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        AnalyticsEngine analyticsEngine = new AnalyticsEngine(taskManager);

        System.out.println("Loading data...");
        taskManager.setTasks(FileHandler.loadTasks());
        System.out.println("Data loaded successfully.");

        boolean running = true;

        while (running) {
            System.out.println("\n--- Smart Academic Productivity Analyzer (SAPA) ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Mark Task Completed");
            System.out.println("6. Start Study Session");
            System.out.println("7. Stop Study Session");
            System.out.println("8. View Analytics");
            System.out.println("9. Sort Tasks");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");

            String choiceStr = scanner.nextLine();
            int choice = -1;
            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Subject: ");
                        String subject = scanner.nextLine();
                        System.out.print("Enter Priority (1-High, 2-Medium, 3-Low): ");
                        int priority = Integer.parseInt(scanner.nextLine());
                        String id = String.valueOf(taskManager.getTasks().size() + 1);
                        taskManager.addTask(new Task(id, title, subject, priority));
                        break;
                    case 2:
                        taskManager.viewTasks();
                        break;
                    case 3:
                        System.out.print("Enter Task ID to update: ");
                        String uId = scanner.nextLine();
                        System.out.print("Enter New Title: ");
                        String uTitle = scanner.nextLine();
                        System.out.print("Enter New Subject: ");
                        String uSubject = scanner.nextLine();
                        System.out.print("Enter New Priority: ");
                        int uPriority = Integer.parseInt(scanner.nextLine());
                        taskManager.updateTask(uId, uTitle, uSubject, uPriority);
                        break;
                    case 4:
                        System.out.print("Enter Task ID to delete: ");
                        String dId = scanner.nextLine();
                        taskManager.deleteTask(dId);
                        break;
                    case 5:
                        System.out.print("Enter Task ID to complete: ");
                        String cId = scanner.nextLine();
                        taskManager.markTaskCompleted(cId);
                        break;
                    case 6:
                        System.out.print("Enter Task ID to start session: ");
                        String startId = scanner.nextLine();
                        taskManager.startSession(startId);
                        break;
                    case 7:
                        System.out.print("Enter Task ID to stop session: ");
                        String stopId = scanner.nextLine();
                        taskManager.stopSession(stopId);
                        break;
                    case 8:
                        analyticsEngine.showAnalytics();
                        break;
                    case 9:
                        System.out.println("1. By Priority");
                        System.out.println("2. By Duration");
                        System.out.print("Choose sorting method: ");
                        int sortChoice = Integer.parseInt(scanner.nextLine());
                        if (sortChoice == 1) {
                            taskManager.sortTasksByPriority();
                        } else if (sortChoice == 2) {
                            taskManager.sortTasksByDuration();
                        } else {
                            System.out.println("Invalid sorting choice.");
                        }
                        break;
                    case 10:
                        System.out.println("Saving data...");
                        FileHandler.saveTasks(taskManager.getTasks());
                        System.out.println("Data saved. Exiting... Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please choose between 1 and 10.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
