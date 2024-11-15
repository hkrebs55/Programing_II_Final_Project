import java.util.LinkedList;
import java.util.Scanner;

public class StudentListUpdater {

    LinkedList<Student> studentList = new LinkedList<>();



    public LinkedList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(LinkedList<Student> studentList) {
        this.studentList = studentList;
    }

    public LinkedList<Student> addStudent() {
        Scanner input = new Scanner(System.in);

        String studentName = null;
        String studentAddress= null;
        String studentGPA= null;
        double studentValidGPA = 0;
        String correct;
        String duplicateName;

        boolean retryName = false;
        boolean retryAddress = false;
        boolean retryGPA = false;
        boolean validGPA = false;

        try {
            while (!retryName) {
                System.out.println("Please enter the student's name.");
                studentName = input.nextLine();
                studentName = studentName.substring(0,1).toUpperCase() + studentName.substring(1).toLowerCase();
                System.out.println("You have entered " + studentName + ". If this is not correct please type 'N', otherwise press enter to continue.");
                correct = input.nextLine();

                if (!correct.equals("N")) {
                    retryName = true;
                }

            }

            for (Student student : studentList) {
                if (student.getStudentName().equals(studentName)) {
                    System.out.println("This student's name already exists in the data. Would you like to enter the name again? Type 'Y' for yes or enter to continue without adding name.");
                    duplicateName = input.nextLine();

                    if (!duplicateName.equals("Y")) {
                        return studentList;
                    }
                }
            }

            while (!retryAddress) {
                System.out.println("Please enter the student's address.");
                studentAddress = input.nextLine();
                System.out.println("You have entered " + studentAddress + ". If this is not correct please type 'N', otherwise press enter to continue.");
                correct = input.nextLine();

                if (!correct.equals("N")) {
                    retryAddress = true;
                }

            }

            while (!retryGPA) {
                System.out.println("Please enter the student's GPA with a decimal, even if zero.");

                while (!validGPA) {
                    studentGPA = input.nextLine();

                    if (!studentGPA.matches("\\d+\\.\\d+")) {
                        System.out.println("Entry invalid, please enter a number value.");
                    } else {
                        studentValidGPA = Double.parseDouble(studentGPA);
                        validGPA = true;
                    }

                }

                System.out.println("You have entered " + studentGPA + ". If this is not correct please type 'N', otherwise press enter to continue.");
                correct = input.nextLine();

                if (!correct.equals("N")) {
                    retryGPA = true;
                }

            }

            Student addedStudent = new Student(studentName, studentAddress, studentValidGPA);
            studentList.add(addedStudent);
            System.out.println(studentList);

        } catch (Exception e) {
            System.out.println("Something went wrong with entering the student.");
        }

        System.out.println("The student was added.");
        return studentList;
    }
}
