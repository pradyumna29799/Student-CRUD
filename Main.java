
import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();

        OUTER:
        while (true) {
            System.out.println("================= Student Management System ================");
            System.out.println("1. Add Student");
            System.out.println("2. fetch By ID");
            System.out.println("3. Delete Student By ID");
            System.out.println("4. Update Student By ID");
            System.out.println("5. Display all student");
            System.out.println("6. Exit");

            int choice =  sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Student ID: ");
                    String id =  sc.nextLine();
                    System.out.println("Enter Student name: ");
                    String name =  sc.nextLine();
                    System.out.println("Enter Student Department: ");
                    String department =  sc.nextLine();
                    System.out.println("Enter Student Age: ");
                    int age =  sc.nextInt();
                    sc.nextLine();
                    // create Student object and add to service
                    Student s = new Student(name, id, department, age);
                    studentService.AddStudent(s);
                    break;
                case 2:
                    System.out.println("Enter student ID to fetch: ");
                    String fetchId = sc.nextLine();
                    sc.nextLine();
                    if (fetchId != null && !fetchId.isEmpty()) {
                        studentService.displayStudentById(fetchId);
                    }   break;
                case 3:
                    System.out.println("Enter student ID to delete: ");
                    String deleteId = sc.nextLine();
                    //sc.nextLine();
                    studentService.DeleteById(deleteId);
                    break;
                case 4:
                    System.out.println("Enter student ID to update: ");
                    String updateId = sc.nextLine();
                    if (studentService.getStudentById(updateId) == null) {
                        System.out.println("Student with ID " + updateId + " not found.");
                        break;
                    }
                    System.out.println("Enter new Student name: ");
                    String newName =  sc.nextLine();
                    System.out.println("Enter new Student Department: ");
                    String newDepartment =  sc.nextLine();
                    System.out.println("Enter new Student Age: ");
                    int newAge =  sc.nextInt();
                    sc.nextLine();
                    Student newstudent = new Student(newName, updateId, newDepartment, newAge);
                    Student updatedStudent = studentService.UpdateById(updateId, newstudent);
                    if (updatedStudent != null) {
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student with ID " + updateId + " not found.");
                    }   break;
                case 5:
                    studentService.display_all();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break OUTER;
                default:
                    break OUTER;
            }
        }       
        sc.close();
        
    }
    
}


