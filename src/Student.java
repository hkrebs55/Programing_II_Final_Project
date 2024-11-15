public class Student {

    private String studentName;
    private String studentAddress;
    private double studentGPA;

    public Student(String studentName, String studentAddress, double studentGPA) {
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentGPA = studentGPA;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentGPA(double studentGPA) {
        this.studentGPA = studentGPA;
    }

    public double getStudentGPA() {
        return studentGPA;
    }

    @Override
    public String toString() {
        return studentName + ": " + studentAddress + ": " + studentGPA;
    }
}
