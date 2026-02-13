# Attendance Management System

A Java-based desktop application designed to manage and track attendance records efficiently. This project utilizes a Graphical User Interface (GUI) and connects to a SQL database using JDBC to store and retrieve user data.

## 📂 Project Structure

The project is organized into the following components:

* [cite_start]**`AttendanceApp.java`**: The main entry point of the application[cite: 4].
* [cite_start]**`MainFrame.java`**: Handles the Graphical User Interface (GUI) and user interactions[cite: 6].
* [cite_start]**`db/DBConnection.java`**: Manages the connection to the SQL database using JDBC[cite: 5].
* [cite_start]**`procedures/AttendanceProcedures.sql`**: Contains the SQL scripts and stored procedures required to set up the database logic[cite: 20].

## 🚀 Technologies Used

* **Language:** Java
* **GUI:** Java Swing / AWT
* **Database:** SQL (Relational Database)
* **Connectivity:** JDBC (Java Database Connectivity)
* **IDE:** IntelliJ IDEA (Recommended)

## ⚙️ Setup & Installation

Follow these steps to get the project running on your local machine:

### 1. Prerequisites
* Java Development Kit (JDK) installed.
* A SQL Database server (e.g., MySQL, SQL Server).
* An IDE like IntelliJ IDEA or Eclipse.

### 2. Database Configuration
Before running the application, you must set up the database:
1.  Open your database management tool.
2.  [cite_start]Run the script located at `AttendenceApp/procedures/AttendanceProcedures.sql` to create the necessary tables and stored procedures[cite: 20].
3.  [cite_start]Open `AttendenceApp/db/DBConnection.java` and update the connection string, username, and password to match your local database credentials[cite: 5].

### 3. Running the App
1.  Clone this repository or download the source code.
2.  Open the project in your IDE.
3.  Run `AttendanceApp.java` to start the application.

## 📝 Features

* [cite_start]**User Interface:** A user-friendly `MainFrame` for easy navigation[cite: 6].
* [cite_start]**Database Integration:** specific stored procedures to handle complex attendance logic efficiently[cite: 20].
* **Scalable Design:** Separated database logic (`db` package) from the UI code.

---
*Created by [Your Name]*
