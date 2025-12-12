
import java.util.Scanner;



public class Main {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();

        System.out.println("How many stuents: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Please Enter Student "+(i+1)+" Information");

            System.out.println("Enter Student ID: ");
            int id =  sc.nextInt();
            sc.nextLine();

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
        }
        studentService.display_all();

        // prompt for fetching a student by ID
        System.out.println("Enter student ID to fetch (or -1 to skip): ");
        int fetchId = sc.nextInt();
        if (fetchId >= 0) {
            studentService.displayStudentById(fetchId);
        }
        sc.close();
        
    }
    
}


