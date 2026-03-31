# 📊 Smart Academic Productivity Analyzer (SAPA)

## 🚀 Overview

**Smart Academic Productivity Analyzer (SAPA)** is a Java-based command-line application designed to help students manage their academic tasks while analyzing their productivity patterns.

Unlike traditional task managers that only organize tasks, SAPA goes a step further by tracking time spent on each task and generating meaningful insights such as productivity score, subject-wise effort distribution, and time-based performance trends.

---

## 🎯 Problem Statement

Students often create study plans but fail to track how effectively they use their time. This leads to:

* Poor time management
* Lack of awareness of study patterns
* Inefficient allocation of effort across subjects

SAPA addresses this problem by combining **task management + time tracking + productivity analysis** into a single system.

---

## ✨ Features

### 📝 Task Management

* Add new academic tasks
* View all tasks
* Delete tasks
* Mark tasks as completed

---

### ⏱️ Time Tracking

* Start and stop study sessions
* Automatically calculate time spent on tasks

---

### 📊 Productivity Analytics

* Productivity Score calculation
* Most studied subject
* Least studied subject
* Longest duration task
* Average study time

---

### 🕒 Time-Based Analysis

Categorizes productivity into:

* Morning (5 AM – 12 PM)
* Afternoon (12 PM – 5 PM)
* Evening (5 PM – 9 PM)
* Night (9 PM – 5 AM)

---

### 💾 Data Persistence

* Saves task data to a file
* Loads data automatically on startup

---

## 🛠️ Technologies Used

* **Java (Core)**
* Object-Oriented Programming (OOP)
* Java Collections Framework (ArrayList, HashMap)
* File Handling
* Exception Handling

---

## 🧠 System Design

The project follows a modular architecture:

* **Task Class** → Represents task data
* **TaskManager** → Handles task operations
* **AnalyticsEngine** → Generates insights
* **FileHandler** → Manages data storage
* **Main Class** → CLI interface

---

## ⚙️ How to Run

### 📌 Prerequisites

* Java JDK installed (version 8 or above)

---

### ▶️ Steps

1. Clone the repository:

```bash
git clone https://github.com/your-username/SAPA.git
```

2. Navigate to project folder:

```bash
cd SAPA
```

3. Compile the program:

```bash
javac Main.java
```

4. Run the application:

```bash
java Main
```

---

## 🖥️ How to Use

1. Run the application
2. Choose options from the menu
3. Add tasks with subject and priority
4. Start and stop study sessions
5. View analytics to understand your productivity

---

## 🖥️ Sample Menu

```
1. Add Task
2. View Tasks
3. Start Study Session
4. Stop Study Session
5. View Analytics
6. Delete Task
7. Exit
```

---

## 📈 Sample Output

```
Productivity Score: 75%
Most Studied Subject: DSA
Most Productive Time: Evening
Average Study Time: 2.5 hours
```

---

## 📌 Key Concepts Demonstrated

* Object-Oriented Programming (Encapsulation, Modularity)
* Data Structures and Collections
* File Handling for persistent storage
* Exception Handling for robust execution
* Real-world problem modeling

---

## 🚧 Challenges Faced

* Implementing accurate time tracking
* Managing file-based data persistence
* Designing meaningful productivity insights
* Handling invalid user inputs

---

## 🔮 Future Enhancements

* GUI using Java Swing or JavaFX
* AI-based productivity recommendations
* Mobile or web-based version
* Cloud storage integration

---

## 👨‍💻 Author

**Ayank Kumar Giri**
**Registration Number:** 24BAI10030
Course: Programming in Java
Institution: VIT

---

## 📄 License

This project is for academic purposes only.

---

## ⭐ Contribution

Feel free to fork, modify, and improve this project.

---

# 🔥 If you found this project useful, consider giving it a star!
