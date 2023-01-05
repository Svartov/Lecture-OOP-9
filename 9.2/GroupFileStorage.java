package sample;

import java.io.*;
import java.util.*;

public class GroupFileStorage {

    public void saveGroupToCSV(Group group) throws IOException{
        List<Student> students = group.getStudents();
        if(students != null) {
            try (PrintWriter pw = new PrintWriter(new File(group.getGroupName() + ".csv"))) {
                for (int i = 0; i < students.size(); i++) {
                    pw.println(students.get(i).getName() + ";" + students.get(i).getLastName() + ";" + students.get(i).getGender() + ";"
                            + students.get(i).getId() + ";" + students.get(i).getGroupName());
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    public File findFileByGroupName(String groupName, File workFolder) throws IOException{
        File[] findFile = workFolder.listFiles(); // Create a new array of files
        if (findFile != null) { // Checking if a file is not 0
            for (int i = 0; i < findFile.length; i++) {
                if (findFile[i].isFile() && findFile[i].getName().equals(groupName)) { //  Checking that this is a file and its name is equal to the name of the group
                    System.out.println("File: " + groupName + " is found: " + workFolder);
                    return findFile[i];
                }
            }
        }
        System.out.println("File: " + groupName + " has not found: " + workFolder);
        return null;
    }


}
