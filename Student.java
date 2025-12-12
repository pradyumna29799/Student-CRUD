public class Student {
    
    private String name;
    private int id;
    private String department;
    private int age;
    
    public Student(String name, int id, String department, int age) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
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