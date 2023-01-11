package sample;

import java.lang.reflect.Array;
import java.util.*;

public class Group {
    private String groupName;
    private final int FINAL_INT = 10;
    private List<Student> students = new ArrayList<>(FINAL_INT);

    public  Group(String groupName, List<Student> students){
        super();
        this.students = students;
        this.groupName = groupName;
    }

    public Group(){
        super();
    }

    // Get
    public String getGroupName(){
        return  groupName;
    }
    public List<Student> getStudents(){
        return students;
    }

    // Set

    public  void setGroupName(String groupName){
        this.groupName = groupName;
    }

    public void setStudent(List<Student> students){
        this.students = students;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        if(!(studentInGroup(student))) {
            if (students.size() < FINAL_INT) {
                students.add(student);
                return;
            }
            throw new GroupOverflowException();
        }
    }

    public Student  searchStudentByLastName(String lastName) throws StudentNotFoundException{
        for(int i = 0; i < students.size(); i++){
            if(students.get(i) != null){
                if(students.get(i).getLastName().equals(lastName)){
                    return students.get(i);
                }
            }
        }
        throw new StudentNotFoundException();
    }

    public boolean removeStudentByID(int id){
        for(int i = 0; i < students.size(); i++){
            if(students.get(i) != null){
                if(students.get(i).getId() == id){
                    students.add(i,null);
                    return  true;
                }
            }
        }
        return  false;
    }

    public void sortStudentsByLastName(){
        students.sort(Comparator.nullsLast(new SortStudentsByLastName()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return Objects.equals(groupName, group.groupName) && Objects.equals(students, group.students);
    }

    public boolean studentInGroup(Student student){
        for(Student std : students){
            if(std != null && std.equals(student)){
                System.out.println("Student = " + student.getName() + "." + student.getLastName() + ", Already added to the group!");
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, students);
    }

    @Override
    public String toString() {
        return "Group{" + "groupName='" + groupName + '\'' + ", students=" + students + '}';
    }
}