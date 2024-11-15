import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StudentListUpdater studentList = new StudentListUpdater();
        StudentDataFile studentDataFile = new StudentDataFile();
        LinkedList<Student> students = new LinkedList<>();

        boolean continueProgram= false;
        String howToProceed;

        students = studentDataFile.readStudentDataFile();

        studentList.setStudentList(students);

        while (!continueProgram) {
            System.out.println("Type 'A' to add another student or 'E' to exit.");
            howToProceed = input.nextLine();
            howToProceed = howToProceed.toUpperCase();

            if (howToProceed.equals("A")) {
                students = studentList.addStudent();
            } else if (howToProceed.equals("E")) {
                continueProgram = true;
            } else {
                System.out.println("You entered an invalid key, please try again");
            }
        }

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentName().compareTo(o2.getStudentName());
            }
        });

        studentDataFile.writeToStudentDataFile(students);

    }
}
