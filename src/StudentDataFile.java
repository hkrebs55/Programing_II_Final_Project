import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class StudentDataFile {

    LinkedList<Student> studentList = new LinkedList<>();

    String studentName;
    String studentAddress;
    double studentGPA;

    public LinkedList<Student> readStudentDataFile() {
        try {
            Scanner readFile = new Scanner(new FileInputStream("C:\\Users\\hkreb\\Desktop\\School\\CSC372-1\\Module 8\\Student_Data_File.txt"));
            while (readFile.hasNext()) {
                String listedStudents = readFile.nextLine();
                String [] filed = listedStudents.replaceAll("\\s", " ").split(":");
                studentName = filed[0];
                studentAddress = filed[1];
                studentGPA = Double.parseDouble(filed[2]);
                studentList.add(new Student(studentName, studentAddress, studentGPA));
            }
        } catch (Exception e) {
            System.out.println("Something went wrong with the importing of the student file.");
        }
        return studentList;
    }

    public void writeToStudentDataFile(LinkedList<Student> students) {
        try {
            PrintWriter writeFile = new PrintWriter(new FileOutputStream("C:\\Users\\hkreb\\Desktop\\School\\CSC372-1\\Module 8\\Student_Data_File.txt"));
            ListIterator studentIterator = students.listIterator();
            while (studentIterator.hasNext()) {
                writeFile.write(studentIterator.next().toString());
                writeFile.write(System.getProperty("line.separator"));
            }
            writeFile.close();
        } catch(Exception e) {
            System.out.println("Something went wrong with the writing of the student file.");
        }
    }
}
