import base.Person;
import uni.Course;
import uni.Major;
import uni.PresentedCourse;
import uni.Professor;
import uni.Student;
import uni.Transcript;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Ava", "1");
        Person person2 = new Person("Hana", "2");
        Person person3 = new Person("Bahar", "3");
        Person person4 = new Person("Erika", "4");
        Person person5 = new Person("Yasi", "5");

        Major cs = new Major("Computer Science", 5);
        Major ce = new Major("Computer Engineering", 4);

        Student student1 = new Student(person1.id, 1403, cs.id);
        Student student2 = new Student(person2.id, 1403, cs.id);
        Student student3 = new Student(person3.id, 1403, ce.id);

        Professor prof1 = new Professor(person4.id, cs.id);
        Professor prof2 = new Professor(person5.id, ce.id);

        Course course1 = new Course("Java", 5);
        Course course2 = new Course("cpp", 7);
        Course course3 = new Course("C", 10);

        PresentedCourse presentedCourse1 = new PresentedCourse(course1.id, prof1.id, 3);
        PresentedCourse presentedCourse2 = new PresentedCourse(course2.id, prof1.id, 5);
        PresentedCourse presentedCourse3 = new PresentedCourse(course3.id, prof2.id, 9);

        presentedCourse1.addStudent(student1.id);
        presentedCourse1.addStudent(student2.id);
        presentedCourse2.addStudent(student1.id);
        presentedCourse2.addStudent(student2.id);
        presentedCourse2.addStudent(student3.id);
        presentedCourse3.addStudent(student3.id);

        Transcript transcript1 = new Transcript(student1.id);
        Transcript transcript2 = new Transcript(student2.id);
        Transcript transcript3 = new Transcript(student3.id);

        transcript1.setGrade(presentedCourse1.id, 18.5);
        transcript1.setGrade(presentedCourse2.id, 18.3);
        transcript2.setGrade(presentedCourse1.id, 18.0);
        transcript2.setGrade(presentedCourse2.id, 19.0);
        transcript3.setGrade(presentedCourse2.id, 17.5);
        transcript3.setGrade(presentedCourse3.id, 19.7);

        System.out.println("STUDENT LIST :");
        for (Student s : Student.studentList) {
            System.out.println(s);
        }

        System.out.println("PROFESSOR LIST :");
        for (Professor p : Professor.professorList) {
            System.out.println(p);
        }

        System.out.println("TRANSCRIPT LIST :");
        transcript1.printTranscript();
        System.out.println("GPA :" + transcript1.getGPA());

        transcript2.printTranscript();
        System.out.println("GPA :" + transcript2.getGPA());
    }
}
