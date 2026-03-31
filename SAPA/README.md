# Smart Academic Productivity Analyzer (SAPA)

SAPA is a CLI-based Java application designed to help students track and analyze their academic productivity. It allows you to manage tasks, log study sessions, and generate insightful analytics to understand your study habits better.

## Features

- **Task Management**: Add, view, update, and delete academic tasks.
- **Session Tracking**: Start and stop study sessions for individual tasks to accurately record time spent.
- **Productivity Analytics**:
  - Calculate overall productivity score based on task completion.
  - Identify your most and least studied subjects.
  - Find your longest duration task and average study time per task.
  - **Time-of-day Analysis**: Determine whether you are an early bird or a night owl by analyzing when you start your study sessions (Morning, Afternoon, Evening, or Night).
- **Sorting**: Organize your task list by priority or duration.
- **Persistent Storage**: Automatically saves and loads your data using a CSV file (`tasks.csv`), ensuring no progress is lost between sessions.

## Prerequisites

To run this application, you must have the following installed on your system:
- **Java Development Kit (JDK) 8 or higher**

## Setup and Installation

1. **Clone or Download the Repository**
   Download the source code to your local machine:
   ```bash
   git clone <your-repository-url>
   cd SAPA
   ```
   *(If you downloaded a ZIP file, extract it and navigate into the folder containing the `.java` files).*

2. **Compile the Java Files**
   Open your terminal/command prompt in the `SAPA` directory and compile all Java source files:
   ```bash
   javac *.java
   ```

3. **Run the Application**
   Start the application by running the `Main` class:
   ```bash
   java Main
   ```

## How to Use

When you run the application, you'll be presented with a menu-driven interface:

```
--- Smart Academic Productivity Analyzer (SAPA) ---
1. Add Task
2. View Tasks
3. Update Task
4. Delete Task
5. Mark Task Completed
6. Start Study Session
7. Stop Study Session
8. View Analytics
9. Sort Tasks
10. Exit
Choose an option: 
```

### Typical Workflow

1. **Add a Task (Option 1)**: Enter the task title, subject, and priority (1-High, 2-Medium, 3-Low). The system will assign an ID to your task.
2. **Start a Session (Option 6)**: When you begin studying for a task, select this option and enter the task ID. SAPA will begin tracking your time.
3. **Stop a Session (Option 7)**: Once you are done studying, stop the session using the same task ID. The duration is calculated and added to the total time spent on that task.
4. **Mark Completed (Option 5)**: When the task is fully finished, mark it as completed.
5. **View Analytics (Option 8)**: Periodically check your productivity analytics to see your completion rate, favorite subjects, and your most productive times of the day!
6. **Exit (Option 10)**: Safely closes the application and saves all your data to `tasks.csv` so it is ready for your next session.

## Code Structure

- `Main.java`: The entry point for the application handling the interactive CLI.
- `Task.java`: The core model representing an academic task with session tracking capabilities.
- `TaskManager.java`: Manages all CRUD operations and coordinates task sorting.
- `AnalyticsEngine.java`: Analyzes stored tasks to provide insightful productivity statistics.
- `FileHandler.java`: Responsible for reading and writing task data to a persistent CSV file.
