package sample;

import java.io.*;
import java.util.*;


public class Program {


    public static void main(String[] args) throws IOException {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Davyd", "Svartov", Gender.Man, 0, "231"));
        students.add(new Student("Vasya", "Velkons", Gender.Man, 1, "231"));
        students.add(new Student("Alex", "Zikelson", Gender.Man, 2, "231"));
        students.add(new Student("Dima", "Visko", Gender.Man, 3, "231"));
        students.add(new Student("Harald", "Bjornsok", Gender.Man, 4, "231"));

        Student student6 = new Student("Alex", "Vakson", Gender.Man, 5, "231");
        Student student7 = new Student("Mil", "Sandor", Gender.Man, 6, "231");
        Student student8 = new Student("Sem", "Deffo", Gender.Man, 7, "231");
        Student student9 = new Student("Masar", "Kydrav", Gender.Man, 8, "231");
        Student student10 = new Student("Masar", "Kydrav", Gender.Man, 9, "231");

        Group group = new Group("GroupEn", students);

        try {
            group.addStudent(student6);
            group.addStudent(student7);
            group.addStudent(student8);
            group.addStudent(student9);
            group.addStudent(student10);
        } catch (GroupOverflowException e) {
            e.printStackTrace();
        }

        System.out.println(group.getStudents());

        System.out.println();

        GroupFileStorage gfs = new GroupFileStorage();
        gfs.saveGroupToCSV(group);


        System.out.println();

        File search = gfs.findFileByGroupName("GroupEn.csv",new File("C:\\Jtesten"));

    }




}