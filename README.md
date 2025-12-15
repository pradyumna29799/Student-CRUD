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
- `javac` and `java` available on PATH, or `JAVA_HOME` set to a JDK 21 installation

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

From the project root (`c:\Pradyumna\Java\Student-CRUD`) run:

```powershell
javac Main.java Student.java StudentService.java
java Main
```

This compiles the three `.java` files and runs the `Main` menu-driven program.

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

- `Student` fields: `name` (String), `id` (String), `department` (String), `age` (int)
- `StudentService` methods include `AddStudent`, `display_all`, `getStudentById`, `displayStudentById`, `UpdateById`, and `DeleteById`.

## Next steps / Improvements

- Persist students to a file or simple database for durability.
- Add input validation (numeric age, non-empty fields).
- Add unit tests and a build tool (Maven/Gradle) for easier dependency and Java version management.

## Contributing

Feel free to open issues or submit pull requests. Small code style improvements, better input validation, and persistence features are welcome.

## License

This repository has no license file by default. Add one if you plan to share the project publicly.
