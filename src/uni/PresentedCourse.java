package uni;

import java.util.*;

public class PresentedCourse {
    public int id;
    public int courseID;
    public int professorID;
    public int capacity;
    public ArrayList<Integer> studentIds = new ArrayList<>();
    public static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<>();
    private static int idCounter = 1;

    public PresentedCourse(int courseID, int professorID, int capacity) {
        this.id = idCounter++;
        this.courseID = courseID;
        this.professorID = professorID;
        this.capacity = capacity;
        presentedCourseList.add(this);
    }

    public static PresentedCourse findById(int id) {
        for (PresentedCourse pc : presentedCourseList) {
            if (pc.id == id) {
                return pc;
            }
        }
        return null;
    }

    public void addStudent(int studentID) {
        if (studentIds.size() < capacity) {
            studentIds.add(studentID);
        } else {
            System.out.println("This course's cap is reached!");
        }
    }
}

