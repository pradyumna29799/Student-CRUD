
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    
    // Method to display student details
    private List<Student> students = new ArrayList<>();

    public void AddStudent(Student student){
        students.add(student);
        System.out.println("Student added sucessfully "+student.getId());
    }
    public void display_all(){
        for (Student s : students) {
            System.out.println("================ student ID: "+ s.getId()+" ================");
            System.out.println("student name: "+ s.getName());
            System.out.println("student Department: "+ s.getDepartment());
            System.out.println("student Age: "+ s.getAge());
            
        }
    }
    
    // Fetch a student by their ID. Returns null if not found.
    public Student getStudentById(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    // Convenience method to print a single student's details by id
    public void displayStudentById(String id) {
        Student s = getStudentById(id);
        if (s == null) {
            System.out.println("Student with ID " + id + " not found.");
            return;
        }
        System.out.println("================ student ID: "+ s.getId()+"================");
        System.out.println("student name: "+ s.getName());
        System.out.println("student Department: "+ s.getDepartment());
        System.out.println("student Age: "+ s.getAge());
    }

    public Student UpdateById(String id,Student newstudent){
        Student oldstudent = getStudentById(id);
        if(oldstudent != null){
            oldstudent.setName(newstudent.getName());
            oldstudent.setDepartment(newstudent.getDepartment());
            oldstudent.setAge(newstudent.getAge());
            return oldstudent;
        }
        else{
            return null;
        }

    }
    public void DeleteById(String id){
        Student student = getStudentById(id);
        if(student != null){
            students.remove(student);
            System.out.println("Student with ID "+id+" deleted successfully.");
        }
        else{
            System.out.println("Student with ID "+id+" not found.");
        }

    }

}