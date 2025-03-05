package uni;

import java.util.*;

public class Transcript {
    public int studentID;
    public HashMap<Integer, Double> transcript = new HashMap<>();
    public static ArrayList<Transcript> transcriptList = new ArrayList<>();

    public Transcript(int studentID) {
        this.studentID = studentID;
        transcriptList.add(this);
    }

    public void setGrade(int presentedCourseID, double grade) {
        PresentedCourse pc = PresentedCourse.findById(presentedCourseID);
        if (pc != null && pc.studentIds.contains(studentID)) {
            transcript.put(presentedCourseID, grade);
        } else {
            System.out.println("Student didnt sign up for this course!");
        }
    }

    public void printTranscript() {
        System.out.println("Transcript for Student ID: " + studentID);
        for (int courseID : transcript.keySet()) {
            Course course = Course.findById(PresentedCourse.findById(courseID).courseID);
            System.out.println(course.title + ": " + transcript.get(courseID));
        }
    }

    public double getGPA() {
        double totalPoints = 0;
        int totalUnits = 0;
        for (int courseID : transcript.keySet()) {
            PresentedCourse pc = PresentedCourse.findById(courseID);
            Course course = Course.findById(pc.courseID);
            totalPoints += transcript.get(courseID) * course.units;
            totalUnits += course.units;
        }
        if(totalUnits == 0)
            return 0 ;
        else
            return totalPoints/totalUnits;
    }
}
