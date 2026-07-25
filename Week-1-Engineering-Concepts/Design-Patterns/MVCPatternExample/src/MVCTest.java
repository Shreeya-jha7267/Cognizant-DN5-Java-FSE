public class MVCTest {

    public static void main(String[] args) {

        Student student = new Student("Shreeya", 101, "A");

        StudentView view = new StudentView();

        StudentController controller =
                new StudentController(student, view);

        controller.displayStudent();

        System.out.println();

        controller.updateStudent("Shreeya", "A+");

        controller.displayStudent();
    }
}