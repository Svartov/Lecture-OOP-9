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

        Student student6 = new Student("Faha", "Bjornsok", Gender.Man, 5, "231");

        Group group = new Group("GroupEn", students);

        group.addStudent(student6);

        System.out.println(group.getStudents());

        System.out.println();

        GroupFileStorage gfs = new GroupFileStorage();
        gfs.saveGroupToCSV(group);


        System.out.println();

        File search = gfs.findFileByGroupName("GroupEn.csv",new File("C:\\Jtesten"));

    }




}