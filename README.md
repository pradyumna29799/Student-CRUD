# Student-CRUD

A minimal command-line Student Management System implemented in Java.

## Project Structure

- [Main.java](Main.java) — program entrypoint; displays a menu and drives interactions.
- [Student.java](Student.java) — simple model class for student data (`name`, `id`, `department`, `age`).
- [StudentService.java](StudentService.java) — in-memory service managing a `List<Student>` with add, fetch, update, delete, and display methods.

## Features

- Add a student
- Fetch/display student by ID
- Delete student by ID
- Update student by ID
- Display all students

## Requirements

- Java 21 LTS installed (JDK 21)
- MySQL Server installed and running
- MySQL JDBC Driver (`mysql-connector-java-8.0.33.jar` or similar)

### Why Java 21

This project targets Java 21 (LTS). If the runtime is older than Java 21 you may see compatibility warnings or unexpected behavior. The code uses standard language features and should run fine on Java 21.

## Installing Java 21 on Windows (short)

1. Download JDK 21 from an OpenJDK provider (Adoptium / Azul / Oracle) and install.
2. Set `JAVA_HOME` to the JDK installation directory and add `%JAVA_HOME%\bin` to your `PATH`.

Example PowerShell commands (adapt paths to your install):

```powershell
setx JAVA_HOME "C:\Program Files\Eclipse Adoptium\jdk-21"
$env:PATH = [System.Environment]::GetEnvironmentVariable('PATH','User') + ";$env:JAVA_HOME\bin"
```

After installing, verify with:

```powershell
java -version
javac -version
```

Both should report a `21` version.

## Build and Run (Windows)

### 1. Set up MySQL Database

1. Open MySQL command line or MySQL Workbench.
2. Run the SQL commands in [schema.sql](schema.sql) to create the database and table:

```sql
CREATE DATABASE IF NOT EXISTS student_crud;
USE student_crud;
CREATE TABLE IF NOT EXISTS students (
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

3. Verify the database is created:

```sql
SHOW DATABASES;
USE student_crud;
SHOW TABLES;
```

### 2. Download and Add MySQL JDBC Driver

1. Download `mysql-connector-java-8.0.33.jar` (or later) from [MySQL official site](https://dev.mysql.com/downloads/connector/j/).
2. Place the JAR file in your project directory or add it to your classpath.

### 3. Configure Database Connection

Edit [DatabaseConfig.java](DatabaseConfig.java) to match your MySQL setup:

```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/student_crud";
private static final String DB_USER = "root";
private static final String DB_PASSWORD = "";  // Add your password if set
```

### 4. Compile and Run

From the project root, compile with the MySQL JDBC driver in the classpath:

```powershell
javac -cp "mysql-connector-java-8.0.33.jar" Main.java Student.java StudentService.java DatabaseConfig.java
java -cp ".;mysql-connector-java-8.0.33.jar" Main
```

Or if you have the MySQL driver in your classpath, simply:

```powershell
javac *.java
java Main
```

## Usage

When you run `java Main` a text menu is shown with options:

1. Add Student — prompts for ID, name, department, age
2. fetch By ID — displays a student matching the provided ID
3. Delete Student By ID — removes a student matching the provided ID
4. Update Student By ID — prompts for new values and updates student if the ID exists
5. Display all student — prints all students currently stored in memory
6. Exit — quit the program

Notes:
- IDs are treated as strings in the current implementation (so `123` and `"123"` are equivalent as user input strings). Ensure consistent input when searching/updating/deleting.
- The service stores students in memory (`ArrayList`) and is not persisted to disk.

## Troubleshooting

- display_all prints nothing:
  - Ensure you add students first using the menu option 1.
  - Confirm `StudentService` is created once and reused across menu iterations. See [Main.java](Main.java) — the `StudentService` instance should be declared outside the menu loop, otherwise previously added students will be lost.

- Update/delete returns "not found":
  - Make sure you enter the exact ID string used when adding the student.
  - The program currently compares IDs using `String.equals()` in `StudentService.getStudentById`.

- Java version errors:
  - Run `java -version` and ensure it reports `21`. If not, update `JAVA_HOME` and PATH to point to Java 21.

## Implementation Notes

- `Student` class: data model with `name`, `id`, `department`, `age` fields.
- `StudentService` class: uses JDBC to interact with MySQL database. Methods: `AddStudent`, `display_all`, `getStudentById`, `displayStudentById`, `UpdateById`, `DeleteById`.
- `DatabaseConfig` class: manages MySQL connections and loads the JDBC driver.
- Data is persisted in MySQL; no in-memory loss between sessions.

## Contributing

Feel free to open issues or submit pull requests. Small code style improvements, better input validation, and persistence features are welcome.

## License

This repository has no license file by default. Add one if you plan to share the project publicly.
