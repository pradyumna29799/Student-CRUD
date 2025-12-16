// Student.java
public class Student {
    
    private String name;
    private String id;
    private String department;
    private int age;
    
    
    // Constructor without ID (for new students, ID will be auto-generated)
    public Student(String id, String name, String department, int age) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public int getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setAge(int age) {
        this.age = age;
    }

}